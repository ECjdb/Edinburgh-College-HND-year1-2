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
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LeagueAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LeagueEntry;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.NewsAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Newsletter;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The LeagueScreenActivity class/activity is the content page where users can view the current
 * Championship League results.*/

public class LeagueScreenActivity extends AppCompatActivity
{
    private ArrayList<LeagueEntry> LeagueCardList;
    private RecyclerView LeagueRecyclerView;
    private LeagueAdapter LeagueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_screen);
        setTitle("Championship League Table");

        /*
         * Sets LeagueRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        LeagueRecyclerView = findViewById(R.id.league_recycler2);
        LeagueRecyclerView.setHasFixedSize(true);
        LeagueRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        LeagueCardList = new ArrayList<>();

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
        slimapi leagueapi = retrofit.create(slimapi.class);

        //calls interface method .getLeague
        Call<List<LeagueEntry>> call = leagueapi.getLeague();

        //the call enqueue method, takes the retrieved parsed JSON List, and based on
        //whether or not the callback was successfully made will call onResponse and handle the data
        //or will call onFailure and supply an error message in the form of a Toast.
        call.enqueue(new Callback<List<LeagueEntry>>()
        {
            //similar to a file reader, the onResponse method takes the response data from the api
            //call.
            @Override
            public void onResponse(Call<List<LeagueEntry>> call, Response<List<LeagueEntry>> response)
            {
                //creates a local List and sets it to handle the response body from the API call.
                List<LeagueEntry> league = response.body();

                //for each object in the List, the key values will be retrieved and stored into
                //temp variables.
                for(LeagueEntry lg: league)
                {
                    int leagueId = lg.getLeagueEntryID();
                    String leagueTeam= lg.getTeam();
                    int leaguePostion = lg.getPosition();
                    int leagueGP = lg.getGamesPlayed();
                    int leagueGW = lg.getGamesWon();
                    int leagueGD = lg.getGamesDrawn();
                    int leagueGL = lg.getGamesLost();
                    int leagueGF = lg.getGamesFor();
                    int leagueGA = lg.getGamesAgainst();
                    int leagueGoalD = lg.getGoalDifference();
                    int leagueTP = lg.getTotalPoints();

                    //A new local object will then be created using the temp variables
                    //and stored into an ArrayList.
                    LeagueCardList.add(new LeagueEntry(leagueId,leagueTeam,leaguePostion,leagueGP,
                            leagueGW,leagueGD,leagueGL,leagueGF,leagueGA,leagueGoalD,leagueTP));
                }

                //The ArrayList is then handed to the Adapter class and the view will be created.
                LeagueAdapter = new LeagueAdapter(LeagueScreenActivity.this, LeagueCardList);
                LeagueRecyclerView.setAdapter(LeagueAdapter);
            }

            @Override
            public void onFailure(Call<List<LeagueEntry>> call, Throwable t)
            {
                //Toast object outputs error message
                Toast.makeText(LeagueScreenActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
