package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

import com.google.gson.annotations.SerializedName;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

public class UserAccount
{
    /*
     * An object constructor class, the UserAccount class has specific data-type variables
     * for handling UserAccount objects retrieved from the back-end of the application.
     * The variables are Serialized using the Retrofit2 library, so that when the JSON object keys
     * and values are retrieved, Retrofit2 can then apply the key specific values to the correct
     * local variables, enabling the creating of local Java objects.
     */

    @SerializedName("user_id")
    private int userID;
    @SerializedName("user_email")
    private String userEmail;
    @SerializedName("user_password")
    private String userPassword;
    @SerializedName("subscription_type")
    private int isSubscriber;

    public UserAccount(int userID, String userEmail,String userPassword,int isSubscriber)
    {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isSubscriber = isSubscriber;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public int getIsSubscriber()
    {
        return isSubscriber;
    }

    public void setIsSubscriber(short isSubscriber)
    {
        this.isSubscriber = isSubscriber;
    }

}
