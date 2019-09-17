package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

// The SplashScreenActivity Class/Activity simply displays the splash screen to the user,
// calls the logo screen and closes the splash screen after a 5 second delay.

public class SplashScreenActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Call the Logo Screen Activity
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashScreenActivity.this, LogoScreenActivity.class);
                startActivity(intent);
                finish();
            }
        };

        //sets a timer task for 5 seconds. The screen will be displayed for 5 seconds and the next
        //activity will start.
        Timer timer = new Timer();
        timer.schedule(task, 5000);
    }
}
