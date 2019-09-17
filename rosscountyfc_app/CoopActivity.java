package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.CoopAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.CoopEvent;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The CoopActivity class/activity is the content page where users can view the various charities and
 * associations of the RCFC.*/

public class CoopActivity extends AppCompatActivity
{

    private ArrayList<CoopEvent> coopCardList;
    private RecyclerView coopRecyclerView;
    private CoopAdapter coopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
        setTitle("RCFC Coop Events");

        /*
         * Sets coopRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        coopRecyclerView = findViewById(R.id.recyclerView2);
        coopRecyclerView.setHasFixedSize(true);
        coopRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        coopCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        //creates a new retrofit2 object, sets the base URL and adds the GSON convertor
        //factory which is responsible for parsing the JSON response.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //creates an instance of slimapi interface
        slimapi coopapi = retrofit.create(slimapi.class);

        //calls interface method .getCoop
        Call<List<CoopEvent>> call = coopapi.getCoop();

        //the call enqueue method, takes the retrieved parsed JSON List, and based on
        //whether or not the callback was successfully made will call onResponse and handle the data
        //or will call onFailure and supply an error message in the form of a Toast.
        call.enqueue(new Callback<List<CoopEvent>>()
        {
            //similar to a file reader, the onResponse method takes the response data from the api
            //call.
            @Override
            public void onResponse(Call<List<CoopEvent>> call, Response<List<CoopEvent>> response)
            {
                //creates a local List and sets it to handle the response body from the API call.
                List<CoopEvent> coop = response.body();

                //for each object in the List, the key values will be retrieved and stored into
                //temp variables.
                for (CoopEvent cpe : coop)
                {
                    int coopId = cpe.getCoopID();
                    String coopTitle = cpe.getCoopTitle();
                    String coopDate = cpe.getCoopDate();
                    String coopImage = cpe.getCoopImage();
                    String coopText = cpe.getCoopText();

                    //A new local object will then be created using the temp variables
                    //and stored into an ArrayList.
                    coopCardList.add(new CoopEvent(coopId, coopTitle, coopDate, coopImage, coopText));
                }

                //The ArrayList is then handed to the Adapter class and the view will be created.
                coopAdapter = new CoopAdapter(CoopActivity.this, coopCardList);
                coopRecyclerView.setAdapter(coopAdapter);
            }

            @Override
            public void onFailure(Call<List<CoopEvent>> call, Throwable t)
            {
                //Toast object outputs error message
                Toast.makeText(CoopActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
