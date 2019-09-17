package uk.ac.edinburghcollege.rosscountyfc_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LoginResponse;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.UserAccount;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;
import uk.ac.edinburghcollege.rosscountyfc_app.global.SharedPrefManager;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The ManageAccountActivity class/activity allows users to configure their account information
 * Change password, email address etc.*/

public class ManageAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private UserAccount user;
    private EditText accEmail;
    private EditText accPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        setTitle("Account Management");

        accEmail = findViewById(R.id.acc_email);
        accPassword = findViewById(R.id.acc_pass);

        findViewById(R.id.acc_update).setOnClickListener(this);
        findViewById(R.id.acc_delete).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //handles clicks for the two buttons on Manage Account, update account and delete
        //respectively.
        switch (v.getId())
        {
            //calls the update account method.
            case R.id.acc_update:
                updateAccount();
                break;
            //calls the deleteAccount method.
            case R.id.acc_delete:
                deleteAccount();
                break;
        }
    }

    private void updateAccount()
    {
        //storing data the user enters into local string variables that are then passed to
        //the api call.
        String email = accEmail.getText().toString().trim();
        String password = accPassword.getText().toString().trim();

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //if the email string is empty, an error will be displayed.
        if(email.isEmpty())
        {
            accEmail.setError("Email is required");
            accEmail.requestFocus();
            return;
        }
        //if the email string does not contain a username, mail-server name or server location
        //then the user is displayed an error as not a valid email address.
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            accEmail.setError("Please Enter a valid email address");
            accEmail.requestFocus();
            return;
        }
        //if the password string is empty, an error will be displayed.
        if(password.isEmpty())
        {
            accPassword.setError("Password is required");
            accPassword.requestFocus();
            return;
        }
        //if the password string length is less than 6 characters, an error will be displayed.
        if(password.length() < 6)
        {
            accPassword.setError("Password must be at least 6 characters long");
            accPassword.requestFocus();
            return;
        }
        else
        {
            user = SharedPrefManager.getInstance(this).getUser();

            slimapi accUserApi = retrofit.create(slimapi.class);

            //sends a PUT request to the API and passes user Id from shared pref manager user object,
            //and the entered email and password.
            Call<LoginResponse>call = accUserApi.updateUser(user.getUserID(),email,password);

            call.enqueue(new Callback<LoginResponse>()
            {
                //the object will either be updated successfully or returned as unsuccessful.
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                {
                    LoginResponse accResponse = response.body();
                    Toast.makeText(ManageAccountActivity.this, accResponse.getMessage(), Toast.LENGTH_LONG).show();

                    if(!response.body().isError())
                    {
                        SharedPrefManager.getInstance(ManageAccountActivity.this).saveUser(accResponse.getUser());
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t)
                {
                    String noConn = "Error: unknown error has occurred";
                    Toast.makeText(ManageAccountActivity.this, noConn , Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void deleteAccount()
    {
        user = SharedPrefManager.getInstance(this).getUser();
        //sets an alert dialogue object to be places on screen. The user is presented with
        //two options, yes or no, and a message is displayed.
        AlertDialog.Builder builder  = new AlertDialog.Builder(ManageAccountActivity.this);
        builder.setTitle("Are you Sure you want to delete your account?");
        builder.setMessage("This cannot be undone");

        //if the user presses yes.
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Retrofit retrofit  = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                slimapi accUserApi = retrofit.create(slimapi.class);

                //api DELETE call is made and passes in the userId from shared pref manager
                //user object.
                Call<LoginResponse> call = accUserApi.deleteUser(user.getUserID());

                call.enqueue(new Callback<LoginResponse>()
                {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                    {
                        LoginResponse accResponse = response.body();

                        //user is successfully deleted if no error occurs, the user is returned
                        //to the login screen and the Activity Flags are reset.
                        if(!response.body().isError())
                        {
                            SharedPrefManager.getInstance(ManageAccountActivity.this).clear();
                            Intent intent = new Intent (ManageAccountActivity.this, LoginScreenActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent .FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }

                        //toast is sent to the user to display successful delete action.
                        Toast.makeText(ManageAccountActivity.this, accResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        String noConn = "Error: an unknown error has occured";
                        Toast.makeText(ManageAccountActivity.this, noConn, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        //if the user presses no, nothing occurs and the alert dialogue box is closed.
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        //creates the alert dialogue object and displays it to the user.
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
