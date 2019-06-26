package com.example.simreader;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        next_activity();



    }

    private void next_activity(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getSharedPreferences("logged_in",MODE_PRIVATE).getBoolean("state",false)){
                    Intent main=new Intent(splash.this,MainActivity.class);
                    startActivity(main);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

                }else {
                    Intent mobile_authentication=new Intent(splash.this,mobile_authentication.class);
                    startActivity(mobile_authentication);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }

            }
        }, 2500);
    }
}
