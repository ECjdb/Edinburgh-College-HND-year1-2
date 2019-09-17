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
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MFixtureAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MatchFixture;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MatchReport;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.NewsAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Newsletter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MReportAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The MatchReportActivity class/activity is the content page where users can view
 * information and details of match results from games/fixtures etc.*/

public class MatchReportActivity extends AppCompatActivity
{
    private ArrayList<MatchReport> mRepCardList;
    private RecyclerView mRepRecyclerView;
    private MReportAdapter mRepAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        setTitle("RCFC Match Reports");

        /*
         * Sets mRepRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        mRepRecyclerView = findViewById(R.id.recyclerView2);
        mRepRecyclerView.setHasFixedSize(true);
        mRepRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRepCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        slimapi mRepApi = retrofit.create(slimapi.class);

        Call<List<MatchReport>> call = mRepApi.getReports();

        call.enqueue(new Callback<List<MatchReport>>()
        {
            @Override
            public void onResponse(Call<List<MatchReport>> call, Response<List<MatchReport>> response)
            {
                List<MatchReport> mRep = response.body();

                for(MatchReport mr: mRep)
                {
                    int mRepId = mr.getMatchReportID();
                    String mRepTitle= mr.getMatchRepTitle();
                    String mRepDate = mr.getMatchRepDate();
                    String mRepImage = mr.getmRepImage();
                    String mRepType = mr.getMatchRepType();

                    mRepCardList.add(new MatchReport(mRepId,mRepTitle,mRepDate,mRepImage,mRepType));
                }

                mRepAdapter = new MReportAdapter(MatchReportActivity.this, mRepCardList);
                mRepRecyclerView.setAdapter(mRepAdapter);
            }

            @Override
            public void onFailure(Call<List<MatchReport>> call, Throwable t)
            {
                Toast.makeText(MatchReportActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
