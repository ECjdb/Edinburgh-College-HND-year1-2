package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import uk.ac.edinburghcollege.rosscountyfc_app.R;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>
{
    private Context mContext;
    private ArrayList<LeagueEntry> mLeagueList;

    //Constructor that is passed 2 parameters, a Context object used to refer to the current
    //instance, and an ArrayList of CoopEvent objects. This is used to create an instance
    //of the LeagueAdapter class.
    public LeagueAdapter(Context context,ArrayList<LeagueEntry> leagueList)
    {
        mContext = context;
        mLeagueList = leagueList;
    }

    //The LeagueViewHolder class extends the RecyclerView.ViewHolder abstract class.
    public class LeagueViewHolder extends RecyclerView.ViewHolder
    {
        //The LeagueViewHolder constructor creates several widget TextView objects and an ImageView
        //object. The objects are then each passed a reference to an XML String id tag.
        public TextView teamView;
        public TextView positionView;
        public TextView gpView;
        public TextView gwView;
        public TextView gdView;
        public TextView glView;
        public TextView gfView;
        public TextView gaView;
        public TextView goalDView;
        public TextView tpView;

        public LeagueViewHolder(View itemView)
        {
            super(itemView);
            teamView=itemView.findViewById(R.id.league_team);
            positionView=itemView.findViewById(R.id.league_pos);
            gpView=itemView.findViewById(R.id.league_pl);
            gwView=itemView.findViewById(R.id.league_w);
            gdView=itemView.findViewById(R.id.league_d);
            glView=itemView.findViewById(R.id.league_l);
            gfView=itemView.findViewById(R.id.league_f);
            gaView=itemView.findViewById(R.id.league_a);
            goalDView=itemView.findViewById(R.id.league_gd);
            tpView=itemView.findViewById(R.id.league_pts);
        }
    }

    //The onCreateViewHolder method is used to create the layout, in this case the card_item layout.
    //The layout is returned to the LeagueViewHolder class in terms of the current Context or instance.
    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.league_table_row,viewGroup,false);
        return new LeagueViewHolder(v);
    }

    //The onBindViewHolder method is used to create card objects and insert them into the Recycler
    //view on the LeagueScreenActivity screen. The data is retrieved from each of the objects contained
    //within the ArrayList and stored into temporary variables. The values stored in these
    //temporary variable are then passed to the widget objects declared in the LeagueViewHolder class
    //to bind the data to the widget objects, which are then applied to the specified layout in the
    //onCreateViewHolder method.
    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder leagueViewHolder, int position)
    {
        LeagueEntry currentLeagueEntry = mLeagueList.get(position);

        String team = currentLeagueEntry.getTeam();
        int pos = currentLeagueEntry.getPosition();
        int gp = currentLeagueEntry.getGamesPlayed();
        int gw = currentLeagueEntry.getGamesWon();
        int gd = currentLeagueEntry.getGamesDrawn();
        int gl = currentLeagueEntry.getGamesLost();
        int gf = currentLeagueEntry.getGamesFor();
        int ga = currentLeagueEntry.getGamesAgainst();
        int goalD = currentLeagueEntry.getGoalDifference();
        int totalPts = currentLeagueEntry.getTotalPoints();

        leagueViewHolder.teamView.setText(team);
        leagueViewHolder.positionView.setText(String.valueOf(pos));
        leagueViewHolder.gpView.setText(String.valueOf(gp));
        leagueViewHolder.gwView.setText(String.valueOf(gw));
        leagueViewHolder.gdView.setText(String.valueOf(gd));
        leagueViewHolder.glView.setText(String.valueOf(gl));
        leagueViewHolder.gfView.setText(String.valueOf(gf));
        leagueViewHolder.gaView.setText(String.valueOf(ga));
        leagueViewHolder.goalDView.setText(String.valueOf(goalD));
        leagueViewHolder.tpView.setText(String.valueOf(totalPts));
    }

    @Override
    public int getItemCount()
    {
       return mLeagueList.size();
    }
}
