package ci.ahmadfauzirahman.hrm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import ci.ahmadfauzirahman.hrm.Activity.IntroSlider.BoardingActivity;
import ci.ahmadfauzirahman.hrm.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);        //deklarasi objek handler
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //  SplashActivity.this.finish();
            }
        }, 3000L);//3000L = 3 detik
    }
}
