package uk.ac.edinburghcollege.coffeeshop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

public class LogoScreenActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_screen);

        //Call the Login Screen Activity
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoScreenActivity.this, LoginScreenActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 5000);
    }
}
