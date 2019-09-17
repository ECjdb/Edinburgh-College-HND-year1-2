package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class LeagueEntry
{
    /*
     * An object constructor class, the LeagueEntry class has specific data-type variables
     * for handling LeagueEntry objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */
    @SerializedName("league_entry_id")
    private int leagueEntryID;
    @SerializedName("team")
    private String team;
    @SerializedName("position")
    private int position;
    @SerializedName("games_played")
    private int gamesPlayed;
    @SerializedName("games_won")
    private int gamesWon;
    @SerializedName("games_drawn")
    private int gamesDrawn;
    @SerializedName("games_lost")
    private int gamesLost;
    @SerializedName("games_for")
    private int gamesFor;
    @SerializedName("against")
    private int gamesAgainst;
    @SerializedName("goal_difference")
    private int goalDifference;
    @SerializedName("total_points")
    private int totalPoints;

    public LeagueEntry(int leagueEntryID, String team, int position, int gamesPlayed, int gamesWon,
                       int gamesDrawn, int gamesLost, int gamesFor, int gamesAgainst,
                       int goalDifference, int totalPoints)
    {
        this.leagueEntryID = leagueEntryID;
        this.team = team;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesDrawn = gamesDrawn;
        this.gamesLost = gamesLost;
        this.gamesFor = gamesFor;
        this.gamesAgainst = gamesAgainst;
        this.goalDifference = goalDifference;
        this.totalPoints = totalPoints;
    }

    public int getLeagueEntryID()
    {
        return leagueEntryID;
    }

    public void setLeagueEntryID(int leagueEntryID)
    {
        this.leagueEntryID = leagueEntryID;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon()
    {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon)
    {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost()
    {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost)
    {
        this.gamesLost = gamesLost;
    }

    public int getGamesFor()
    {
        return gamesFor;
    }

    public void setGamesFor(int gamesFor)
    {
        this.gamesFor = gamesFor;
    }

    public int getGamesAgainst()
    {
        return gamesAgainst;
    }

    public void setGamesAgainst(int gamesAgainst)
    {
        this.gamesAgainst = gamesAgainst;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints)
    {
        this.totalPoints = totalPoints;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }
}
