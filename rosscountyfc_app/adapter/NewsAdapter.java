package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import uk.ac.edinburghcollege.rosscountyfc_app.R;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
{
    private Context mContext;
    private ArrayList<Newsletter> mNewsList;

    public NewsAdapter(Context context,ArrayList<Newsletter> newsList)
    {
        mContext = context;
        mNewsList = newsList;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public TextView newsTitleView;
        public TextView newsDateView;
        public ImageView newsImageView;
        public TextView newsTextView;

        public NewsViewHolder(View itemView)
        {
            super(itemView);
            newsTitleView=itemView.findViewById(R.id.card_title);
            newsDateView=itemView.findViewById(R.id.card_date);
            newsImageView=itemView.findViewById(R.id.card_Image);
            newsTextView=itemView.findViewById(R.id.card_paragraph);
        }
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position)
    {
        Newsletter currentNewsletter = mNewsList.get(position);

        String imageUrl = currentNewsletter.getNewsImage();
        String title = currentNewsletter.getNewsTitle();
        String date = currentNewsletter.getNewsDate();
        String text = currentNewsletter.getNewsText();

        newsViewHolder.newsTitleView.setText(title);
        newsViewHolder.newsDateView.setText(date);
        newsViewHolder.newsTextView.setText(text);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(newsViewHolder.newsImageView);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
