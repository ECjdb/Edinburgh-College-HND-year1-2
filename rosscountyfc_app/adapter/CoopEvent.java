package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class CoopEvent
{
    /*
     * An object constructor class, the CoopEvent class has specific data-type variables
     * for handling CoopEvent objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("coop_event_id")
    private int coopID;
    @SerializedName("coop_title")
    private String coopTitle;
    @SerializedName("coop_date")
    private String coopDate;
    @SerializedName("coop_image")
    private String coopImage;
    @SerializedName("coop_text")
    private String coopText;

    public CoopEvent(int coopID, String coopTitle, String coopDate, String coopImage,
                     String coopText)
    {
        this.coopID = coopID;
        this.coopTitle = coopTitle;
        this.coopDate = coopDate;
        this.coopImage = coopImage;
        this.coopText = coopText;
    }

    public int getCoopID() {
        return coopID;
    }

    public void setCoopID(int coopID) {
        this.coopID = coopID;
    }

    public String getCoopTitle() {
        return coopTitle;
    }

    public void setCoopTitle(String coopTitle) {
        this.coopTitle = coopTitle;
    }

    public String getCoopDate() {
        return coopDate;
    }

    public void setCoopDate(String coopDate) {
        this.coopDate = coopDate;
    }

    public String getCoopImage() {
        return coopImage;
    }

    public void setCoopImage(String coopImage) {
        this.coopImage = coopImage;
    }

    public String getCoopText() {
        return coopText;
    }

    public void setCoopText(String coopText) {
        this.coopText = coopText;
    }
}
