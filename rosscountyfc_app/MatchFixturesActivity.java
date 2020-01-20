package uk.ac.edinburghcollege.rosscountyfc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.ClubAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.ClubInfo;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MFixtureAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MatchFixture;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The MatchFixturesActivity class/activity is the content page where users can view
 * information and details of upcoming match fixtures.*/

public class MatchFixturesActivity extends AppCompatActivity
{
    private ArrayList<MatchFixture> mFixCardList;
    private RecyclerView mFixRecyclerView;
    private MFixtureAdapter mFixAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        /*
         * Sets mFixRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        setTitle("RCFC Match Fixtures");
        mFixRecyclerView = findViewById(R.id.recyclerView2);
        mFixRecyclerView.setHasFixedSize(true);
        mFixRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFixCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        slimapi mFixApi = retrofit.create(slimapi.class);

        Call<List<MatchFixture>> call = mFixApi.getFixtures();

        call.enqueue(new Callback<List<MatchFixture>>()
        {
            @Override
            public void onResponse(Call<List<MatchFixture>> call, Response<List<MatchFixture>> response)
            {
                List<MatchFixture> mFix = response.body();

                for(MatchFixture fx: mFix)
                {
                    int mFixId = fx.getMatchFixtureID();
                    String mFixTitle= fx.getFixtureTitle();
                    String mFixDate = fx.getMatchFixDate();
                    String mFixImage = fx.getmFixImage();
                    String mFixText = fx.getMatchFixType();

                    mFixCardList.add(new MatchFixture(mFixId,mFixTitle,mFixDate,mFixImage,mFixText));
                }

                mFixAdapter = new MFixtureAdapter(MatchFixturesActivity.this, mFixCardList);
                mFixRecyclerView.setAdapter(mFixAdapter);
            }

            @Override
            public void onFailure(Call<List<MatchFixture>> call, Throwable t)
            {
                Toast.makeText(MatchFixturesActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
