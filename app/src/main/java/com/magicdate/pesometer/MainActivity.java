package com.magicdate.pesometer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.magicdate.pesometer.interfaces.StepListener;
import com.magicdate.pesometer.navigation.Route;
import com.magicdate.pesometer.navigation.RouteTracker;
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

    RouteTracker tracker;

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


    }


    private void initSenssors(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManagerComp = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        compass = sensorManagerComp.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        simpleStepDetector = new stepDetector();
        simpleStepDetector.registerListener(this);

        tracker = new RouteTracker();
        tracker.initList();

    }

    private void initButtons(){
        TvSteps = findViewById(R.id.tv_steps);
        BtnNext = findViewById(R.id.btn_start);
        BtnTake = findViewById(R.id.btn_stop);
        BtnShowRoute = findViewById(R.id.button_show_route);
        BtnShowProducts = findViewById(R.id.button_Show_products);
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

    /*
    public void save(View v) {
        String text = simpleStepDetector.getDegrees();

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void load(View v) {

        FileInputStream fis = null;

        try {

            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        mEditText.setText(tracker.toString() + System.lineSeparator());
    }
      */


}
