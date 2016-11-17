package com.example.quickcoding1117;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sm;
    private Sensor sensor_gravity;
    private Sensor sensor_accelerometer;
    private Sensor sensor_gyroscope;
    private Sensor sensor_linear_acceleration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor_gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensor_linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }
    protected void onResume(){
        super.onResume();
        sm.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause(){
        super.onPause();
        sm.unregisterListener(this);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
    int dir_UP=0;
    int dir_DOWN=0;
    double acceleration;
    double gravity;
    int count=0;
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acceleration =Math.sqrt(x*x+y*y+z*z);
        }
        if(event.sensor.getType()==Sensor.TYPE_GRAVITY){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            gravity =Math.sqrt(x*x+y*y+z*z);
        }
        if (acceleration - gravity>5){
            dir_UP = 1;
        }
        if(dir_UP ==1 && gravity - acceleration>5){
            dir_DOWN = 1;
        }
        if(dir_DOWN ==1){
            count++;
            ((TextView) findViewById(R.id.tv_count)).setText(count+" Steps!!!");

            dir_UP = 0;
            dir_DOWN = 0;
        }
    }/*
    public void onSensorChanged(SensorEvent event){
        switch (event.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
                x_gravity.setText("X: "+event.values[0]);
                y_gravity.setText("Y: "+event.values[1]);
                z_gravity.setText("Z: "+event.values[2]);
                break;
            case Sensor.TYPE_ACCELEROMETER:
                x_accelerometer.setText("X: "+event.values[0]);
                y_accelerometer.setText("Y: "+event.values[1]);
                z_accelerometer.setText("Z: "+event.values[2]);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                x_linear_acceleration.setText("X: "+event.values[0]);
                y_linear_acceleration.setText("Y: "+event.values[1]);
                z_linear_acceleration.setText("Z: "+event.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                x_gyroscope.setText("X: "+event.values[0]);
                y_gyroscope.setText("Y: "+event.values[1]);
                z_gyroscope.setText("Z: "+event.values[2]);
                break;
        }
    }*/
}
