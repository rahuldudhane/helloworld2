package org.hinduismfacts.www.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Rahul on 29-08-2017.
 */

public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mLight;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent sensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        Log.e("Tuts+", "Accuracy: " + sensorEvent.accuracy );
        Log.e("Tuts+", "Timestamp: " + sensorEvent.timestamp);
        Log.e("Tuts+", "Accelerometer X: " + sensorEvent.values[0]);
        Log.e("Tuts+", "Accelerometer Y: " + sensorEvent.values[1]);
        Log.e("Tuts+", "Accelerometer Z: " + sensorEvent.values[2]);
        // Do something with this sensor value.
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
