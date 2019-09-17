package uk.ac.edinburghcollege.rosscountyfc_app.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.ClubInfo;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.CoopEvent;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LeagueEntry;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.LoginResponse;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MatchFixture;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.MatchReport;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Newsletter;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.Player;
import uk.ac.edinburghcollege.rosscountyfc_app.adapter.UserAccount;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/*
 * The slimapi interface contains all relative url's.
 * The relative URL is used in conjunction with the base URL to
 * tell the application where to find the JSON, and which object type the JSON should be.
 * Retrofit2 library takes care of all the background functionality.
 */

public interface slimapi
{
    /*
    * Get all functions.
    */
    //GET request retrieves all JSON objects that are sent to the browser at this URL location.
    //There are two types required, List which is a type of array and is the format JSON
    //sends the data to the browser. Secondly the object type, so that Retrofit2 can identify what
    //the objects contained within the list.
    @GET("allnews")
    Call<List<Newsletter>> getNews();

    @GET("allleague")
    Call<List<LeagueEntry>> getLeague();

    @GET("allclub")
    Call<List<ClubInfo>> getClub();

    @GET("allcoop")
    Call<List<CoopEvent>> getCoop();

    @GET("allfixtures")
    Call<List<MatchFixture>> getFixtures();

    @GET("allreports")
    Call<List<MatchReport>> getReports();

    @GET("allplayers")
    Call<List<Player>> getPlayers();

    //POST request with FormUrlEncoded is similar to a regular POST request, but instead of simply
    //passing the entire object, parts are passed to the call instead and are annotated accordingly.
    //The response however will send back the whole object.
    @FormUrlEncoded
    @POST("createUser")
    Call<ResponseBody> createAccount(
            @Field("email") String email,
            @Field(("password")) String password,
            @Field("subscriber") int subscriber
    );

    @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field(("password")) String password
    );

    //PUT request updates and replaces the entire object
    @FormUrlEncoded
    @PUT("updateUser/{id}")
    Call<LoginResponse> updateUser(
            @Path("id") int id,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @PUT("updateSubscription/{id}")
    Call<LoginResponse> updateSubscription(
            @Path("id") int id,
            @Field("subscriber") int subscriber
    );

    //DELETE request is self explanatory, it will delete the object it is given.
    //type is void as response is not required
    @DELETE("deleteUser/{id}")
    Call<LoginResponse> deleteUser (@Path("id")int id);

}
