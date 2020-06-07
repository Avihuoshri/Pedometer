package Drawables;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity {

    MapActivity mapLayoutView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapLayoutView = new MapActivity(this) ;
        setContentView(mapLayoutView);
    }
}
