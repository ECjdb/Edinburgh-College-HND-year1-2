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
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Player;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.PlayerAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class PlayerListActivity extends AppCompatActivity
{
    private ArrayList<Player> playerCardList;
    private RecyclerView playerRecyclerView;
    private PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        /*
         * Sets playerRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        setTitle("RCFC Players");

        playerRecyclerView = findViewById(R.id.recyclerView2);
        playerRecyclerView.setHasFixedSize(true);
        playerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        playerCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        slimapi playerApi = retrofit.create(slimapi.class);

        Call<List<Player>> call = playerApi.getPlayers();

        call.enqueue(new Callback<List<Player>>()
        {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response)
            {
                List<Player> play = response.body();

                for(Player pl: play)
                {
                    int playerId = pl.getPlayerID();
                    int playerYear = pl.getYear();
                    String playerRole = pl.getRole();
                    String playerImage = pl.getPlayerImage();
                    String playerTitle= pl.getPlayerName();
                    String playerDate = pl.getPlayerPosition();


                    playerCardList.add(new Player(playerId,playerYear,playerRole,playerImage,
                                                                        playerTitle,playerDate));
                }

                playerAdapter = new PlayerAdapter(PlayerListActivity.this, playerCardList);
                playerRecyclerView.setAdapter(playerAdapter);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t)
            {
                Toast.makeText(PlayerListActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
