package org.hinduismfacts.www.sensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    TextView mSensorsTot, mSensorAvailables, mMessage;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.layout);

        ll.setBackgroundColor(Color.BLUE);

        // Get the texts fields of the layout and setup to invisible
        mSensorsTot = (TextView) findViewById(R.id.sensoritot);
        mSensorAvailables = (TextView) findViewById(R.id.sensoridisponibili);
        mMessage = (TextView) findViewById(R.id.sensorid);

        // Get the SensorManager
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            // Success! There's a magnetometer.
            mMessage.setText("Hello," + " " + this.getString(R.string.list3));
        }
        else {
            mMessage.setText("Hello," + " " + this.getString(R.string.list4));
        }

        // List of Sensors Available
        List<Sensor> msensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);



        // Print how may Sensors are there
        mSensorsTot.setText("\n There are " + msensorList.size() + " " + this.getString(R.string.list2) + "!" + " in your device.\n");

        // Print each Sensor available using sSensList as the String to be printed
        String sSensList = new String("");
        Sensor tmp;
        int x = 1, i;
        for (i = 0; i < msensorList.size(); i++) {
            tmp = msensorList.get(i);
            sSensList = sSensList + x + ". " + tmp.getName() + "\n\n"; // Add the sensor name to the string of sensors available
            x++;

        }
        // if there are sensors available show the list
        if (i > 0) {
            sSensList = getString(R.string.list1) + ":" + "\n\n" + sSensList;
            mSensorAvailables.setText(sSensList);
        }
    }




}
