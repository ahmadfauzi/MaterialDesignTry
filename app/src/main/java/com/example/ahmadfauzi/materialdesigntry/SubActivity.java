package com.example.ahmadfauzi.materialdesigntry;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;


public class SubActivity extends ActionBarActivity {
    public static final String TAG = "MaterialDesign";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "SubAcivity dispatchTouchEvent: DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "SubAcivity dispatchTouchEvent: MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "SubAcivity dispatchTouchEvent: UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "SubAcivity dispatchTouchEvent: CANCEL");
                break;

        }
        boolean b = super.dispatchTouchEvent(event);
        Log.d(TAG, "SubAcivity dispatchTouchEvent: RETURN " + b);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "SubAcivity onTouchEvent: DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "SubAcivity onTouchEvent: MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "SubAcivity onTouchEvent: UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "SubAcivity onTouchEvent: CANCEL");
                break;

        }
        boolean b = super.onTouchEvent(event);
        Log.d(TAG, "SubAcivity onTouchEvent: RETURN "+ b);
        return b;
    }
}
