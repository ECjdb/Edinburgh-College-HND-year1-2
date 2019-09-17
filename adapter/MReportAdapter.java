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

public class MReportAdapter extends RecyclerView.Adapter<MReportAdapter.mRepViewHolder>
{
    private Context mContext;
    private ArrayList<MatchReport> mRepCardList;

    public MReportAdapter(Context context, ArrayList<MatchReport> repCardList)
    {
        mContext = context;
        mRepCardList = repCardList;
    }

    public static class mRepViewHolder extends RecyclerView.ViewHolder
    {

        public TextView mRepTitle;
        public TextView mRepDate;
        public ImageView mRepImageView;
        public TextView mRepText;

        //This constructor references views of the XML file. This is how data is applied to
        //the various sections of the NewsCardItem on the screen.
        public mRepViewHolder(@NonNull View itemView)
        {
            super(itemView);

            mRepTitle = itemView.findViewById(R.id.card_title);
            mRepDate = itemView.findViewById(R.id.card_date);
            mRepImageView = itemView.findViewById(R.id.card_Image);
            mRepText = itemView.findViewById(R.id.card_paragraph);
        }
    }

    @NonNull
    @Override
    public mRepViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        return new MReportAdapter.mRepViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mRepViewHolder mRepViewHolder, int position)
    {
        MatchReport currentmReport = mRepCardList.get(position);

        String title = currentmReport.getMatchRepTitle();
        String date = currentmReport.getMatchRepDate();
        String imageUrl = currentmReport.getmRepImage();
        String text = currentmReport.getMatchRepType();

        mRepViewHolder.mRepTitle.setText(title);
        mRepViewHolder.mRepDate.setText(date);
        mRepViewHolder.mRepText.setText(text);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(mRepViewHolder.mRepImageView);
    }

    @Override
    public int getItemCount()
    {
        return mRepCardList.size();
    }
}
