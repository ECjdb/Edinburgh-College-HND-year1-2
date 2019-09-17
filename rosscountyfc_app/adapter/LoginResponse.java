package uk.ac.edinburghcollege.rosscountyfc_app.adapter;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

// the loginResponse class is a special class that handles errors, messages, and user account
//related objects. This class is responsible for handling the data in the various API calls made.
public class LoginResponse
{

    private boolean error;
    private String message;
    private UserAccount user;

    public LoginResponse(boolean error, String message, UserAccount user)
    {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError()
    {
        return error;
    }

    public String getMessage()
    {
        return message;
    }

    public UserAccount getUser()
    {
        return user;
    }
}
