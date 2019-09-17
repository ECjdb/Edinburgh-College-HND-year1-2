package uk.ac.edinburghcollege.rosscountyfc_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

// The LogoScreenActivity Class/Activity simply displays the logo screen to the user,
// calls the login screen and closes the Logo screen after a 5 second delay.

public class LogoScreenActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_screen);

        //Call the Login Screen Activity

        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(LogoScreenActivity.this, LoginScreenActivity.class);
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