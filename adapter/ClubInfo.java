package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class ClubInfo
{
    /*
    * An object constructor class, the ClubInfo class has specific data-type variables
    * for handling clubInfo objects retrieved from the back-end of the application.
    * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
    * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
    * local variables, enabling the creating of local Java objects.
    */

     @SerializedName("club_id")
     private int clubID;
     @SerializedName("club_title")
     private String clubTitle;
     @SerializedName("club_date")
     private String clubDate;
     @SerializedName("club_image")
     private String clubImage;
     @SerializedName("club_text")
     private String clubText;

    public ClubInfo(int clubID, String clubTitle, String clubDate, String clubImage, String clubText)
    {
        this.clubID = clubID;
        this.clubTitle = clubTitle;
        this.clubDate = clubDate;
        this.clubImage = clubImage;
        this.clubText = clubText;
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public String getClubTitle() {
        return clubTitle;
    }

    public void setClubTitle(String clubTitle) {
        this.clubTitle = clubTitle;
    }

    public String getClubDate() {
        return clubDate;
    }

    public void setClubDate(String clubDate) {
        this.clubDate = clubDate;
    }

    public String getClubImage() {
        return clubImage;
    }

    public void setClubImage(String clubImage) {
        this.clubImage = clubImage;
    }

    public String getClubText() {
        return clubText;
    }

    public void setClubText(String clubText) {
        this.clubText = clubText;
    }
}
