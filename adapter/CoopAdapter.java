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

public class CoopAdapter extends RecyclerView.Adapter<CoopAdapter.CoopViewHolder>
{
    private Context mContext;
    private ArrayList<CoopEvent> mCoopList;

    //Constructor that is passed 2 parameters, a Context object used to refer to the current
    //instance, and an ArrayList of CoopEvent objects. This is used to create an instance
    //of the CoopAdapter class.
    public CoopAdapter(Context context,ArrayList<CoopEvent> coopList)
    {
        mContext = context;
        mCoopList = coopList;
    }

    //The CoopViewHolder class extends the RecyclerView.ViewHolder abstract class.
    public static class CoopViewHolder extends RecyclerView.ViewHolder
    {

        //The CoopViewHolder constructor creates several widget TextView objects and an ImageView
        //object. The objects are then each passed a reference to an XML String id tag.
        public TextView coopTitleView;
        public TextView coopDateView;
        public ImageView coopImageView;
        public TextView coopTextView;

        public CoopViewHolder(@NonNull View itemView)
        {
            super(itemView);
            coopTitleView = itemView.findViewById(R.id.card_title);
            coopDateView = itemView.findViewById(R.id.card_date);
            coopImageView = itemView.findViewById(R.id.card_Image);
            coopTextView = itemView.findViewById(R.id.card_paragraph);
        }
    }

    //The onCreateViewHolder method is used to create the layout, in this case the card_item layout.
    //The layout is returned to the CoopViewHolder class in terms of the current Context or instance.
    @NonNull
    @Override
    public CoopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        return new CoopAdapter.CoopViewHolder(v);
    }

    //The onBindViewHolder method is used to create card objects and insert them into the Recycler
    //view on the CoopActivity screen. The data is retrieved from each of the objects contained
    //within the ArrayList and stored into temporary variables. The values stored in these
    //temporary variable are then passed to the widget objects declared in the CoopViewHolder class
    //to bind the data to the widget objects, which are then applied to the specified layout in the
    //onCreateViewHolder method.
    @Override
    public void onBindViewHolder(@NonNull CoopViewHolder coopViewHolder, int position)
    {
        CoopEvent currentCoopEvent = mCoopList.get(position);

        String title = currentCoopEvent.getCoopTitle();
        String date = currentCoopEvent.getCoopDate();
        String imageUrl = currentCoopEvent.getCoopImage();
        String text = currentCoopEvent.getCoopText();

        coopViewHolder.coopTitleView.setText(title);
        coopViewHolder.coopDateView.setText(date);
        coopViewHolder.coopTextView.setText(text);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(coopViewHolder.coopImageView);
    }

    @Override
    public int getItemCount()
    {
        return mCoopList.size();
    }

}
