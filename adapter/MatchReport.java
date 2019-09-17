package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class MatchReport
{
    /*
     * An object constructor class, the MatchReport class has specific data-type variables
     * for handling MatchReport objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("match_report_id")
    private int matchReportID;
    @SerializedName("match_title")
    private String matchRepTitle;
    @SerializedName("match_date")
    private String matchRepDate;
    @SerializedName("match_image")
    private String mRepImage;
    @SerializedName("match_type")
    private String matchRepType;

    public MatchReport(int matchReportID, String matchRepTitle, String matchRepDate,
                       String mRepImage, String matchRepType) {
        this.matchReportID = matchReportID;
        this.matchRepTitle = matchRepTitle;
        this.matchRepDate = matchRepDate;
        this.mRepImage = mRepImage;
        this.matchRepType = matchRepType;
    }

    public int getMatchReportID() {
        return matchReportID;
    }

    public void setMatchReportID(int matchReportID) {
        this.matchReportID = matchReportID;
    }

    public String getMatchRepTitle() {
        return matchRepTitle;
    }

    public void setMatchRepTitle(String matchRepTitle) {
        this.matchRepTitle = matchRepTitle;
    }

    public String getMatchRepDate() {
        return matchRepDate;
    }

    public void setMatchRepDate(String matchRepDate) {
        this.matchRepDate = matchRepDate;
    }

    public String getmRepImage() {
        return mRepImage;
    }

    public void setmRepImage(String mRepImage) {
        this.mRepImage = mRepImage;
    }

    public String getMatchRepType() {
        return matchRepType;
    }

    public void setMatchRepType(String matchRepType) {
        this.matchRepType = matchRepType;
    }
}
