package uk.ac.edinburghcollege.rosscountyfc_app.global;

import android.content.Context;
import android.content.SharedPreferences;

import uk.ac.edinburghcollege.rosscountyfc_app.adapter.UserAccount;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/*
* Shared Preference manager is a way in which Android Studio can manage the storing of data
* in an application. Shared Preferences allows the saving and retrieval of data in the form of a key
* and value pair. To use shared preferences manager an instance of the class must be created.
* The created instance points to a file that contains values of the stored preferences.
* For use of the RCFC app, this stores user related data, to allow various functionality across
* the application.
* */
public class SharedPrefManager
{
    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }

    //the save user method is used to store values to the shared preference manager editor.
    //this method is used to save the user data so that it can be used across the RCFC app.

    public void saveUser(UserAccount user)
    {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("user_id", user.getUserID());
        editor.putString("user_email", user.getUserEmail());
        editor.putString("user_password", user.getUserPassword());
        editor.putInt("subscription_type", user.getIsSubscriber());

        editor.apply();

    }

    //The getUser method is used to retrieve the values stored on the shared preference manager
    //editor.
    //this method is used to create local objects which are then used to get data for the various
    //API calls, as well as on the category menu screen when choosing to display the correct content
    //based on the subscriber value.
    public UserAccount getUser()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserAccount(
                sharedPreferences.getInt("user_id", -1),
                sharedPreferences.getString("user_email", null),
                sharedPreferences.getString("user_password", null),
                sharedPreferences.getInt("subscription_type", -1)
        );
    }

    //The clear method is responsible for removing all values stored in the
    // preference manager editor. This is used in the log out function and the delete function.
    public void clear()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
