package two.android.com.animations;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    SensorManager sensorManager;
    List<Sensor> sensorList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList1 = sensorManager.getSensorList(Sensor.TYPE_ALL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.clearAnimation();
                Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.wiggle);
               button.startAnimation(a);

            }
        });

        // ---------

        SensorEventListener sv1 = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {



                if(check(event.values)){
                   button.clearAnimation();
                    Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.wiggle);
                    button.startAnimation(a);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(sv1,sensorList1.get(0),SensorManager.SENSOR_DELAY_UI);
        //0 przyspieszenie
        //2 magnetometr
        //3 bezwzgledna orientacja/polozenie na podstawie 3 czujnikow FUSION


    }

    public boolean check(float[] values){
        float x= values[0];
        float y= values[1];
        float z= values[2];
        double decide = (Math.sqrt((x*x)+(y*y)+(z*z)))-9.81;
        if(decide>1.0) return true; else return false;


    }

}

/*
    obrazek
 */
