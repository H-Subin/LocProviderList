package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textOutput);
        mButton = findViewById(R.id.button);
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        locProviders = locMgr.getAllProviders();

        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int i =0;
                String n = "";

                for( String str : locProviders){
                    n += "Loc. Provider: " + locProviders.get(i) + "\n" + "Status: " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                    i++;
                }
                mTextView.setText(n);
            }

        });

    }


}