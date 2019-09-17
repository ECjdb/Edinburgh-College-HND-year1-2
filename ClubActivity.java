package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.ClubAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.ClubInfo;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The ClubActivity class/activity is the content page where users can view information about the
 * RCFC club itself. e.g. Contact information, opening times etc.*/

public class ClubActivity extends AppCompatActivity
{
    private ArrayList<ClubInfo> clubCardList;
    private RecyclerView clubRecyclerView;
    private ClubAdapter clubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        setTitle("RCFC Club Info");

        /*
        * Sets clubRecyclerView to fixed size, sets a linearLayoutManager
        * Refers to the recycler view to insert the card objects into.
        * */

        clubRecyclerView = findViewById(R.id.recyclerView2);
        clubRecyclerView.setHasFixedSize(true);
        clubRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        clubCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        //creates a new retrofit2 object, sets the base URL and adds the GSON convertor
        //factory which is responsible for parsing the JSON response.
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //creates an instance of slimapi interface
        slimapi clubapi = retrofit.create(slimapi.class);

        //calls interface method .getClub
        Call<List<ClubInfo>> call = clubapi.getClub();

        //the call enqueue method, takes the retrieved parsed JSON List, and based on
        //whether or not the callback was successfully made will call onResponse and handle the data
        //or will call onFailure and supply an error message in the form of a Toast.
        call.enqueue(new Callback<List<ClubInfo>>()
        {
            //similar to a file reader, the onResponse method takes the response data from the api
            //call.
            @Override
            public void onResponse(Call<List<ClubInfo>> call, Response<List<ClubInfo>> response)
            {
                //creates a local List and sets it to handle the response body from the API call.
                List<ClubInfo> club = response.body();

                //for each object in the List, the key values will be retrieved and stored into
                //temp variables.
                for(ClubInfo cl: club)
                {
                    int clubId = cl.getClubID();
                    String clubTitle= cl.getClubTitle();
                    String clubDate = cl.getClubDate();
                    String clubImage = cl.getClubImage();
                    String clubText = cl.getClubText();

                    clubCardList.add(new ClubInfo(clubId,clubTitle,clubDate,clubImage,clubText));
                }

                //The ArrayList is then handed to the Adapter class and the view will be created.
                clubAdapter = new ClubAdapter(ClubActivity.this, clubCardList);
                clubRecyclerView.setAdapter(clubAdapter);
            }

            @Override
            public void onFailure(Call<List<ClubInfo>> call, Throwable t)
            {
                //Toast object outputs error message
                Toast.makeText(ClubActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
