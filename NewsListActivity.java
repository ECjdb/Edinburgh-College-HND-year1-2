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
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.NewsAdapter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Newsletter;
import uk.ac.edinburghcollege.rosscountyfc_app.api.slimapi;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class NewsListActivity extends AppCompatActivity
{
    //**Variable information
    //newsCardList ArrayList for storing Newsletter objects
    //RecyclerView object contains Recycler view created in activity_news_list.xml
    //The adapter bridges between ArrayList data and recyclerView. The adapter is designed to only
    //provide as many items as currently needed. Loading in the entire arrayList would cause severe
    //performance issues
    //RecyclerView.Layout manager is responsible for determining the layout of the items in the
    //relativeLayout list.

    private ArrayList<Newsletter> newsCardList;
    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
        setTitle("RCFC Newsletters");

        /*
         * Sets newsRecyclerView to fixed size, sets a linearLayoutManager
         * Refers to the recycler view to insert the card objects into.
         * */

        newsRecyclerView = findViewById(R.id.recyclerView2);
        newsRecyclerView.setHasFixedSize(true);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsCardList = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON()
    {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9/rcfcapp/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        slimapi newsapi = retrofit.create(slimapi.class);

        Call<List<Newsletter>> call = newsapi.getNews();

        call.enqueue(new Callback<List<Newsletter>>()
        {
            @Override
            public void onResponse(Call<List<Newsletter>> call, Response<List<Newsletter>> response)
            {
                List<Newsletter> news = response.body();

                for(Newsletter ns: news)
                {

                    int newsId = ns.getNewsletterID();
                    String newsTitle= ns.getNewsTitle();
                    String newsDate = ns.getNewsDate();
                    String newsImage = ns.getNewsImage();
                    String newsText = ns.getNewsText();

                    newsCardList.add(new Newsletter(newsId,newsTitle,newsDate,newsImage,newsText));
                }

                newsAdapter = new NewsAdapter(NewsListActivity.this, newsCardList);
                newsRecyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<List<Newsletter>> call, Throwable t)
            {
                Toast.makeText(NewsListActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
