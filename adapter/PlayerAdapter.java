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

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.playerViewHolder>
{
    private Context mContext;
    private ArrayList<Player> playerCardList;

    public PlayerAdapter(Context context, ArrayList<Player> pCardList)
    {
        mContext = context;
        playerCardList = pCardList;
    }

    public static class playerViewHolder extends RecyclerView.ViewHolder
    {
        public TextView playerYear;
        public TextView playerRole;
        public ImageView playerImageView;
        public TextView playerName;
        public TextView playerPosition;

        public playerViewHolder(@NonNull View itemView)
        {
            super(itemView);

            playerYear = itemView.findViewById(R.id.player_year);
            playerRole = itemView.findViewById(R.id.player_role);
            playerImageView = itemView.findViewById(R.id.player_image);
            playerName = itemView.findViewById(R.id.player_name);
            playerPosition = itemView.findViewById(R.id.player_position);
        }
    }

    @NonNull
    @Override
    public playerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.player_card,viewGroup,false);
        return new PlayerAdapter.playerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull playerViewHolder playerViewHolder, int position)
    {
        Player currentPlayerItem = playerCardList.get(position);

        int pYear = currentPlayerItem.getYear();
        String pRole = currentPlayerItem.getRole();
        String imageUrl = currentPlayerItem.getPlayerImage();
        String pName = currentPlayerItem.getPlayerName();
        String pPosition = currentPlayerItem.getPlayerPosition();

        playerViewHolder.playerYear.setText(String.valueOf(pYear));
        playerViewHolder.playerRole.setText(pRole);
        playerViewHolder.playerName.setText(pName);
        playerViewHolder.playerPosition.setText(pPosition);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(playerViewHolder.playerImageView);
    }

    @Override
    public int getItemCount()
    {
        return playerCardList.size();
    }

}
