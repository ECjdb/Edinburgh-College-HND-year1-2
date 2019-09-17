package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class MatchFixture
{
    /*
     * An object constructor class, the MatchFixture class has specific data-type variables
     * for handling MatchFixture objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("fixture_id")
    private int matchFixtureID;
    @SerializedName("fixture_title")
    private String fixtureTitle;
    @SerializedName("fixture_date")
    private String matchFixDate;
    @SerializedName("fixture_image")
    private String mFixImage;
    @SerializedName("fixture_text")
    private String matchFixType;

    public MatchFixture(int matchFixtureID, String fixtureTitle, String matchFixDate,
                        String mFixImage, String matchFixType) {
        this.matchFixtureID = matchFixtureID;
        this.fixtureTitle = fixtureTitle;
        this.matchFixDate = matchFixDate;
        this.mFixImage = mFixImage;
        this.matchFixType = matchFixType;
    }

    public int getMatchFixtureID() {
        return matchFixtureID;
    }

    public void setMatchFixtureID(int matchFixtureID) {
        this.matchFixtureID = matchFixtureID;
    }

    public String getFixtureTitle() {
        return fixtureTitle;
    }

    public void setFixtureTitle(String fixtureTitle) {
        this.fixtureTitle = fixtureTitle;
    }

    public String getMatchFixDate() {
        return matchFixDate;
    }

    public void setMatchFixDate(String matchFixDate) {
        this.matchFixDate = matchFixDate;
    }

    public String getmFixImage() {
        return mFixImage;
    }

    public void setmFixImage(String mFixImage) {
        this.mFixImage = mFixImage;
    }

    public String getMatchFixType() {
        return matchFixType;
    }

    public void setMatchFixType(String matchFixType) {
        this.matchFixType = matchFixType;
    }
}
