package com.example.terod.kotlin_test_empty

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : Activity(), SensorEventListener {

    private var mAcc: FloatArray ?= null
    private var mGrav: FloatArray ?= null
    private var mMag: FloatArray ?= null
    private var mGyro: FloatArray ?= null

    lateinit var value_xacc: TextView
    lateinit var value_yacc: TextView
    lateinit var value_zacc: TextView
    lateinit var value_xgrav: TextView
    lateinit var value_ygrav: TextView
    lateinit var value_zgrav: TextView
    lateinit var value_xmag: TextView
    lateinit var value_ymag: TextView
    lateinit var value_zmag: TextView
    lateinit var value_xgyro: TextView
    lateinit var value_ygyro: TextView
    lateinit var value_zgyro: TextView

    lateinit var sensorAcc: Sensor
    lateinit var sensorGravity: Sensor
    lateinit var sensorMag: Sensor
    lateinit var sensorGyro: Sensor

    lateinit var button: Button
    var collapsed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        value_xacc = findViewById(R.id.TextView_value_xacc)
        value_yacc = findViewById(R.id.TextView_value_yacc)
        value_zacc = findViewById(R.id.TextView_value_zacc)
        value_xgrav = findViewById(R.id.TextView_value_xgrav)
        value_ygrav = findViewById(R.id.TextView_value_ygrav)
        value_zgrav = findViewById(R.id.TextView_value_zgrav)
        value_xmag = findViewById(R.id.TextView_value_xmag)
        value_ymag = findViewById(R.id.TextView_value_ymag)
        value_zmag = findViewById(R.id.TextView_value_zmag)
        value_xgyro = findViewById(R.id.TextView_value_xgyro)
        value_ygyro = findViewById(R.id.TextView_value_ygyro)
        value_zgyro = findViewById(R.id.TextView_value_zgyro)

        button = findViewById(R.id.button)

        sensorManager();
    }


    fun sensorManager() {
        val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        sensorMag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        sensorGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        sensorManager.registerListener(this, sensorAcc, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorGravity, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorMag, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorGyro, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        print("do nothing")
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(collapsed) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                mAcc = event.values.clone()
            }
            if (event.sensor.type == Sensor.TYPE_GRAVITY) {
                mGrav = event.values.clone()
            }
            if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                mMag = event.values.clone()
            }
            if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                mGyro = event.values.clone()
            }
            setTextView()
        }
    }

    fun setTextView() {
        val xacc: String = mAcc?.get(0).toString();
        value_xacc.setText(xacc.substring(0, Math.min(xacc.length, 6)))
        val yacc: String = mAcc?.get(1).toString();
        value_yacc.setText(yacc.substring(0, Math.min(yacc.length, 6)))
        val zacc: String = mAcc?.get(2).toString();
        value_zacc.setText(zacc.substring(0, Math.min(zacc.length, 6)))
        val xgrav: String = mGrav?.get(0).toString();
        value_xgrav.setText(xgrav.substring(0, Math.min(xgrav.length, 6)))
        val ygrav: String = mGrav?.get(1).toString();
        value_ygrav.setText(ygrav.substring(0, Math.min(ygrav.length, 6)))
        val zgrav: String = mGrav?.get(2).toString();
        value_zgrav.setText(zgrav.substring(0, Math.min(zgrav.length, 6)))
        val xmag: String = mMag?.get(0).toString();
        value_xmag.setText(xmag.substring(0, Math.min(xmag.length, 6)))
        val ymag: String = mMag?.get(1).toString();
        value_ymag.setText(ymag.substring(0, Math.min(ymag.length, 6)))
        val zmag: String = mMag?.get(2).toString();
        value_zmag.setText(zmag.substring(0, Math.min(zmag.length, 6)))
        val xgyro: String = mGyro?.get(0).toString();
        value_xgyro.setText(xgyro.substring(0, Math.min(xgyro.length, 6)))
        val ygyro: String = mGyro?.get(1).toString();
        value_ygyro.setText(ygyro.substring(0, Math.min(ygyro.length, 6)))
        val zgyro: String = mGyro?.get(2).toString();
        value_zgyro.setText(zgyro.substring(0, Math.min(zgyro.length, 6)))
    }

    fun clickStartStop(view: View) {
        if (collapsed == false) {
            collapsed = true
        } else {
            collapsed = false
        }
    }
}
