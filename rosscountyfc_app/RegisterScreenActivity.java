package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The RegisterScreenActivity class/activity allows users to create an account to access
 * the RCFC app. The user will need to provide a valid email address and a password.*/

public class RegisterScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        setTitle("RCFC Account Registration");

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.return_login_button).setOnClickListener(this);
        findViewById(R.id.register_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //handles register screen button clicks.
        switch (v.getId())
        {
            //if return to login is pressed, close the current activity
            case R.id.return_login_button:
                finish();
                break;
                //if regiister button is pressed call userRegister method.
            case R.id.register_button:
                userRegister();
                break;
        }
    }

    private void userRegister()
    {
        //storing data the user enters into local string variables that are then passed to
        //the api call.
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://''/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //if the email string is empty, an error will be displayed.
        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        //if the email string does not contain a username, mail-server name or server location
        //then the user is displayed an error as not a valid email address.
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        //if the password string is empty, an error will be displayed.
        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        //if the password string length is less than 6 characters, an error will be displayed.
        if(password.length() < 6)
        {
            editTextPassword.setError("Password should be at least 6 characters long");
            editTextPassword.requestFocus();
            return;
        }

        else
        {
            slimapi createUserApi = retrofit.create(slimapi.class);

            //a POST call is made to the API passing in the 3 parameters email, password and
            // subscriber value.
            Call<ResponseBody> call = createUserApi.createAccount(email, password, 0);

            call.enqueue(new Callback<ResponseBody>()
            {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
                {
                    //try catch block for handling potential IO errors.
                    try
                    {
                        //if the returned response code is equal to 201 the the user is successfully
                        //created.
                        if(response.code() == 201)
                        {
                            String s = response.body().string();
                            Toast.makeText(RegisterScreenActivity.this, s, Toast.LENGTH_LONG).show();
                        }
                        //if the error code is not 201 then an error has occurred and the appropriate
                        //response will be shown to the user base on the returned code.
                        else
                        {
                            String s = response.errorBody().string();
                            s = s + "Code: "+response.code();
                            Toast.makeText(RegisterScreenActivity.this, s, Toast.LENGTH_LONG).show();
                        }
                    }
                    //prints out an potential IO exceptions.
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t)
                {
                    Toast.makeText(RegisterScreenActivity.this,t.toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
