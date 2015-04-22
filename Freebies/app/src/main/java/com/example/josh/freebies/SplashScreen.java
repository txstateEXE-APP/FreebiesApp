package com.example.josh.freebies;

/**
 * Created by splitix on 4/17/15.
 * added randomizes the image on splashscreen by Christopher 4/21/2015
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import java.util.Random;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);//randomizes the image
        Random rand = new Random();
        int rndInt = rand.nextInt(3) + 1;
        String imgName = "splash" + rndInt;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        ImageView imageView = (ImageView) findViewById(R.id.imgLogo);//stops here
        imageView.setImageResource(id);
        new Handler().postDelayed(new Runnable() {

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
