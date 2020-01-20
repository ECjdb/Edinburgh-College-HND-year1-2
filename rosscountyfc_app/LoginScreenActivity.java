package uk.ac.edinburghcollege.rosscountyfc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LoginResponse;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;
import uk.ac.edinburghcollege.rosscountyfc_app.global.SharedPrefManager;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class LoginScreenActivity extends AppCompatActivity implements OnClickListener
{

    private EditText logEmail;
    private EditText logPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        logEmail =  findViewById(R.id.editTextLogMail);
        logPassword = findViewById(R.id.editTextLogPass);

        findViewById(R.id.log_sign_in).setOnClickListener(this);
        findViewById(R.id.log_register_account).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //switch to handle button clicks
        switch (v.getId())
        {
            //if login button is pressed call userLogin method.
            case R.id.log_sign_in:
                userLogin();
                break;
            //if register button is pressed go to RegisterScreenActivity.
            case R.id.log_register_account:
                Intent regIntent  = new Intent(LoginScreenActivity.this, RegisterScreenActivity.class);
                startActivity(regIntent);
                break;
        }
    }
    private void userLogin()
    {
        //storing data the user enters into local string variables that are then passed to
        //the api call.
        String email = logEmail.getText().toString().trim();
        String password = logPassword.getText().toString().trim();

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //if the email string is empty, an error will be displayed.
        if(email.isEmpty())
        {
            logEmail.setError("Email is required");
            logEmail.requestFocus();
            return;
        }

        //if the email string does not contain a username, mail-server name or server location
        //then the user is displayed an error as not a valid email address.
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            logEmail.setError("Please Enter a valid email address");
            logEmail.requestFocus();
            return;
        }
        //if the password string is empty, an error will be displayed.
        if(password.isEmpty())
        {
            logPassword.setError("Password is required");
            logPassword.requestFocus();
            return;
        }
        //if the password string length is less than 6 characters, an error will be displayed.
        if(password.length() < 6)
        {
            logPassword.setError("Password must be at least 6 characters long");
            logPassword.requestFocus();
            return;
        }

        else {
            slimapi logUserApi = retrofit.create(slimapi.class);

            //a POST call is made to the API passing in the 2 strings email and password.
            Call<LoginResponse>call = logUserApi.userLogin(email,password);

            call.enqueue(new Callback<LoginResponse>()
            {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                {
                    LoginResponse loginResponse = response.body();

                    //if an error has not occured
                    if(!loginResponse.isError())
                    {
                        //saves the user credentials in the Shared Preference Manager
                        SharedPrefManager.getInstance(LoginScreenActivity.this)
                                .saveUser(loginResponse.getUser());
                        Intent mainMenuIntent = new Intent(LoginScreenActivity.this, CategoryMenuScreenActivity.class);
                        mainMenuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainMenuIntent);

                        Toast.makeText(LoginScreenActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    //else an error has occured, displays toast with error message.
                    else
                    {
                        Toast.makeText(LoginScreenActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }

                //if the request and response call fails.
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t)
                {
                    String noConn = "Error: no connectivity";
                    Toast.makeText(LoginScreenActivity.this, noConn, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

