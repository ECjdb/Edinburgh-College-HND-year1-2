package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class Newsletter
{
    /*
     * An object constructor class, the Newsletter class has specific data-type variables
     * for handling Newsletter objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("newsletter_id")
    private int newsletterID;
    @SerializedName("news_title")
    private String newsTitle;
    @SerializedName("news_date")
    private String newsDate;
    @SerializedName("news_image")
    private String newsImage;
    @SerializedName("news_text")
    private String newsText;

    public Newsletter(int newsletterID, String newsTitle, String newsDate, String newsImage, String newsText)
    {
        this.newsletterID = newsletterID;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsImage = newsImage;
        this.newsText = newsText;
    }

    public int getNewsletterID() {
        return newsletterID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsletterID(int newsletterID) {
        this.newsletterID = newsletterID;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }
}
