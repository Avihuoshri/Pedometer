package com.magicdate.pesometer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.magicdate.pesometer.DataBaseHandlers.DBShoppingPathAppender;
import com.magicdate.pesometer.DataBaseHandlers.DBStoreBranchRegisterer;
import com.magicdate.pesometer.interfaces.StepListener;
import com.magicdate.pesometer.NavigationElements.PathTracker;
import com.magicdate.pesometer.senssors.stepDetector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SensorEventListener, StepListener {
    private TextView TvSteps;
    private  Button BtnNext ;
    private  Button BtnTake ;
    private  Button BtnSave ;
    private  Button BtnDrewPath ;
    private  Button BtnShowRoute ;
    private Button BtnShowProducts;
    private stepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private SensorManager sensorManagerComp;
    private Sensor accel;
    private Sensor compass;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    private static final String FILE_NAME = "degrees.txt";
    EditText mEditText;
    EditText mEditTextProduct;
    private static final String CHOOSEN_BRANCH = "Ron's All Goods Store";

   PathTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSenssors();

        initButtons();

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numSteps = 0;
                sensorManager.registerListener(MainActivity.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
                sensorManagerComp.registerListener(MainActivity.this, compass, SensorManager.SENSOR_DELAY_GAME);
            }
        });


        BtnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.unregisterListener(MainActivity.this);
                ArrayList<Float> degrees = simpleStepDetector.getDegrees();
                String destination = mEditTextProduct.getText().toString();
                tracker.saveRoute(degrees, destination);
            }
        });

        BtnShowRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(tracker.toString() + System.lineSeparator() + System.lineSeparator());
            }
        });

        BtnShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(tracker.ProductsToString() + System.lineSeparator() + System.lineSeparator());
            }
        });

        BtnDrewPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                intent.putExtra("tracker", tracker);
                startActivity(intent);
            }
        });

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBShoppingPathAppender pathAppender = new DBShoppingPathAppender();
                pathAppender.addAllNodesOfShoppingListToDb(tracker);
                DBStoreBranchRegisterer branchRegisterer = new DBStoreBranchRegisterer();
                branchRegisterer.handleBranchStock(tracker);
            }
        });

    }


    private void initSenssors(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManagerComp = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        compass = sensorManagerComp.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        simpleStepDetector = new stepDetector();
        simpleStepDetector.registerListener(this);

        tracker = new PathTracker();
        tracker.initList();

    }

    private void initButtons(){
        BtnSave = findViewById(R.id.button_save);
        TvSteps = findViewById(R.id.tv_steps);
        BtnNext = findViewById(R.id.btn_start);
        BtnTake = findViewById(R.id.btn_stop);
        BtnShowRoute = findViewById(R.id.button_show_route);
        BtnShowProducts = findViewById(R.id.button_Show_products);
        BtnDrewPath = findViewById(R.id.btn_drew);
        mEditText = findViewById(R.id.edit_text);
        mEditTextProduct = findViewById(R.id.edit_text_product);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
        if(event.sensor.getType() == Sensor.TYPE_ORIENTATION){
            simpleStepDetector.setDegree(event.values[0]);
        }

    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }

    }