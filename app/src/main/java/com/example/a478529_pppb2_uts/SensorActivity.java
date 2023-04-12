package com.example.a478529_pppb2_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;

    private Sensor mSensorLight;
    private TextView mTextSensorLight;

    private Sensor mSensorProximity;
    private TextView mTextSensorProximity;

    private Sensor mSensorAmbient;
    private TextView mTextSensorAmbient;

    private Sensor mSensorPressure;
    private TextView mTextSensorPressure;

    private Sensor mSensorHumidity;
    private TextView mTextSensorHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mTextSensorLight = findViewById(R.id.label_light);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mTextSensorProximity = findViewById(R.id.label_proximity);
        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        mTextSensorAmbient = findViewById(R.id.label_ambient);
        mSensorAmbient = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        mTextSensorPressure = findViewById(R.id.label_pressure);
        mSensorPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        mTextSensorHumidity = findViewById(R.id.label_humidity);
        mSensorHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        String sensor_error = "No sensor";
        if (mSensorLight == null){
            mTextSensorLight.setText(sensor_error);
        }
        if (mSensorProximity == null){
            mTextSensorProximity.setText(sensor_error);
        }
        if (mSensorAmbient == null){
            mTextSensorAmbient.setText(sensor_error);
        }
        if (mSensorPressure == null){
            mTextSensorPressure.setText(sensor_error);
        }
        if (mSensorHumidity == null){
            mTextSensorHumidity.setText(sensor_error);
        }

    }

    private void changeBackgroundColor(float currentValue){
        ConstraintLayout layout = findViewById(R.id.layout_constraint);
        if ((currentValue <= 40000) && (currentValue >= 35000)) {
            layout.setBackgroundColor(Color.RED);
        }
        else if ((currentValue < 35000) && (currentValue >= 30000)) {
            layout.setBackgroundColor(Color.GREEN);
        }
        else if ((currentValue < 30000) && (currentValue >= 25000)) {
            layout.setBackgroundColor(Color.BLUE);
        }
        else if ((currentValue < 25000) && (currentValue >= 20000)) {
            layout.setBackgroundColor(Color.YELLOW);
        }
        else if ((currentValue < 20000) && (currentValue >= 15000)) {
            layout.setBackgroundColor(Color.CYAN);
        }
        else if ((currentValue < 15000) && (currentValue >= 10000)) {
            layout.setBackgroundColor(Color.MAGENTA);
        }
        else if ((currentValue <= 10000) && (currentValue >= 5000)) {
            layout.setBackgroundColor(Color.GRAY);
        }
        else{
            layout.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mSensorLight != null){
            mSensorManager.registerListener(this, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorProximity != null){
            mSensorManager.registerListener(this, mSensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorAmbient != null){
            mSensorManager.registerListener(this, mSensorAmbient,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorPressure != null){
            mSensorManager.registerListener(this, mSensorPressure,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorHumidity != null){
            mSensorManager.registerListener(this, mSensorHumidity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        switch (sensorType){
            case Sensor.TYPE_LIGHT:
                mTextSensorLight.setText(
                        String.format("Light sensor : %1$.2f", currentValue));
                changeBackgroundColor(currentValue);
                break;
            case Sensor.TYPE_PROXIMITY:
                mTextSensorProximity.setText(
                        String.format("Proximity sensor : %1$.2f", currentValue));
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                mTextSensorAmbient.setText(
                        String.format("Ambient sensor : %1$.2f", currentValue));
                break;
            case Sensor.TYPE_PRESSURE:
                mTextSensorPressure.setText(
                        String.format("Pressure sensor : %1$.2f", currentValue));
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                mTextSensorHumidity.setText(
                        String.format("Humidity sensor : %1$.2f", currentValue));
                break;
            default:
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}