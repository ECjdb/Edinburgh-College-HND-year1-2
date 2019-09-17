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

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder>
{
    private Context mContext;
    private ArrayList<ClubInfo> mClubList;


    //Constructor that is passed 2 parameters, a Context object used to refer to the current
    //instance, and an ArrayList of ClubInfo objects. This is used to create an instance
    //of the Club Adapter class.
    public ClubAdapter(Context context,ArrayList<ClubInfo> clubList)
    {
        mContext = context;
        mClubList = clubList;
    }


    //The ClubViewHolder class extends the RecyclerView.ViewHolder abstract class.
    public class ClubViewHolder extends RecyclerView.ViewHolder
    {
        public TextView clubTitleView;
        public TextView clubDateView;
        public ImageView clubImageView;
        public TextView clubTextView;

        //The ClubViewHolder constructor creates several widget TextView objects and an ImageView
        //object. The objects are then each passed a reference to an XML String id tag.
        public ClubViewHolder(View itemView)
        {
            super(itemView);
            clubTitleView=itemView.findViewById(R.id.card_title);
            clubDateView=itemView.findViewById(R.id.card_date);
            clubImageView=itemView.findViewById(R.id.card_Image);
            clubTextView=itemView.findViewById(R.id.card_paragraph);
        }
    }

    //The onCreateViewHolder method is used to create the layout, in this case the card_item layout.
    //The layout is returned to the ClubViewHolder class in terms of the current Context or instance.
    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        return new ClubAdapter.ClubViewHolder(v);
    }

    //The onBindViewHolder method is used to create card objects and insert them into the Recycler
    //view on the ClubActivity screen. The data is retrieved from each of the objects contained
    //within the ArrayList and stored into temporary variables. The values stored in these
    //temporary variable are then passed to the widget objects declared in the ClubViewHolder class
    //to bind the data to the widget objects, which are then applied to the specified layout in the
    //onCreateViewHolder method.
    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder clubViewHolder, int position)
    {
        ClubInfo currentClubInfo = mClubList.get(position);

        String imageUrl = currentClubInfo.getClubImage();
        String title = currentClubInfo.getClubTitle();
        String date = currentClubInfo.getClubDate();
        String text = currentClubInfo.getClubText();

        clubViewHolder.clubTitleView.setText(title);
        clubViewHolder.clubDateView.setText(date);
        clubViewHolder.clubTextView.setText(text);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(clubViewHolder.clubImageView);
    }

    //The getItemCount method is used as a reference to how many card items should be created
    //and inserted into the recycler view based on the size of the ArrayList.
    @Override
    public int getItemCount()
    {
        return mClubList.size();
    }
}
