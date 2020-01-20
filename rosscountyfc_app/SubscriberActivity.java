package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

/*The SubscriberActivity class/activity is the content page where users can view the various perks
* provided by a subscription membership. The user will have the option to select to make a payment
* via PayPal to become a subscriber.*/

public class SubscriberActivity extends AppCompatActivity implements View.OnClickListener
{
    private UserAccount user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber);

        setTitle("RCFC Subscriber Registration");

        findViewById(R.id.sub_payment).setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        //handles subscriber button click, calls updateSubscription method.
        switch (v.getId())
        {
            case R.id.sub_payment:
                updateSubscription();
                break;
        }
    }

    private void updateSubscription()
    {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://''/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        user = SharedPrefManager.getInstance(this).getUser();

        slimapi accSubApi = retrofit.create(slimapi.class);

        //the POST api call is passed the user id retrieved from the local SharedPrefManager object
        //and the value of 1 is passed. If the value is 1 the user becomes a subscriber.
        Call<LoginResponse> call = accSubApi.updateSubscription(user.getUserID(),1);

        call.enqueue(new Callback<LoginResponse>()
        {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
            {
                LoginResponse subResponse = response.body();
                Toast.makeText(SubscriberActivity.this, subResponse.getMessage(), Toast.LENGTH_LONG).show();

                if(!response.body().isError())
                {
                    SharedPrefManager.getInstance(SubscriberActivity.this).saveUser(subResponse.getUser());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t)
            {
                String noConn = "Error: unknown error has occurred";
                Toast.makeText(SubscriberActivity.this, noConn , Toast.LENGTH_LONG).show();
            }
        });
    }
}
