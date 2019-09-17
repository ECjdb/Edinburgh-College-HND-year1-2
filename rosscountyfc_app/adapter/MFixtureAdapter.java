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

public class MFixtureAdapter extends RecyclerView.Adapter<MFixtureAdapter.mFixViewHolder>
{
    private Context mContext;
    private ArrayList<MatchFixture> mFixCardList;

    public MFixtureAdapter(Context context, ArrayList<MatchFixture> fixCardList)
    {
        mContext = context;
        mFixCardList = fixCardList;
    }

    public static class mFixViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mFixTitle;
        public TextView mFixDate;
        public ImageView mFixImageView;
        public TextView mFixText;

        //This constructor references views of the XML file. This is how data is applied to
        //the various sections of the NewsCardItem on the screen.
        public mFixViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mFixTitle = itemView.findViewById(R.id.card_title);
            mFixDate = itemView.findViewById(R.id.card_date);
            mFixImageView = itemView.findViewById(R.id.card_Image);
            mFixText = itemView.findViewById(R.id.card_paragraph);
        }
    }

    @NonNull
    @Override
    public mFixViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        return new MFixtureAdapter.mFixViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mFixViewHolder mFixViewHolder, int position)
    {
        MatchFixture currentmFixture = mFixCardList.get(position);

        String title = currentmFixture.getFixtureTitle();
        String date = currentmFixture.getMatchFixDate();
        String imageUrl = currentmFixture.getmFixImage();
        String text = currentmFixture.getMatchFixType();

        mFixViewHolder.mFixTitle.setText(title);
        mFixViewHolder.mFixDate.setText(date);
        mFixViewHolder.mFixText.setText(text);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(mFixViewHolder.mFixImageView);
    }

    @Override
    public int getItemCount()
    {
        return mFixCardList.size();
    }

}
