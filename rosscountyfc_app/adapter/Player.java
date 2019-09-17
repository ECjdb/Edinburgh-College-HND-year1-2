package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class Player
{
    /*
     * An object constructor class, the Player class has specific data-type variables
     * for handling Player objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("player_id")
    private int playerID;
    @SerializedName("year")
    private int year;
    @SerializedName("player_role")
    private String role;
    @SerializedName("player_image")
    private String playerImage;
    @SerializedName("player_name")
    private String playerName;
    @SerializedName("player_position")
    private String playerPosition;

    public Player(int playerID, int year, String role, String playerImage, String playerName,
                  String playerPosition)
    {
        this.playerID = playerID;
        this.year = year;
        this.role = role;
        this.playerImage = playerImage;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }

    public int getPlayerID()
    {
        return playerID;
    }
    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public String getPlayerImage()
    {
        return playerImage;
    }
    public void setPlayerImage(String playerImage)
    {
        this.playerImage = playerImage;
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public String getPlayerPosition()
    {
        return playerPosition;
    }
    public void setPlayerPosition(String playerPosition)
    {
        this.playerPosition = playerPosition;
    }
}
