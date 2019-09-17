package uk.ac.edinburghcollege.rosscountyfc_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import uk.ac.edinburghcollege.rosscountyfc_app.adapter.UserAccount;
import uk.ac.edinburghcollege.rosscountyfc_app.global.SharedPrefManager;

/*
 * EC1524329
 * Joel Degner-Budd
 * EdinburghCollege
 * 20/05/2019
 */

/* The CategoryMenuScreen class/Activity, represents the home page or, main page of the RCFC app.
 * The user is able to select several options from the drawer, contained in a hamburger menu
 * from this screen, as well as press the subscribe button to be directed to the subscription page.
 * There is also a settings option where the user can adjust app settings to their liking.*/

public class CategoryMenuScreenActivity extends AppCompatActivity
                                        implements NavigationView.OnNavigationItemSelectedListener
{
    private UserAccount user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu_screen);
        setTitle("Ross County FC Home");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //retrieves UserAccount object stored in SharedPrefManager
        //using this object allows for control over which content is available to the user via the
        //getIsSubscribed method call.
        user = SharedPrefManager.getInstance(this).getUser();
        String welcome = "Welcome: "+user.getUserEmail();
        Toast.makeText(CategoryMenuScreenActivity.this, welcome, Toast.LENGTH_LONG).show();

        //Subscriber button
        //The subscriber button creates a new Intent object when  taking the user from the main page
        //to the subscriber page. Upon returning to the main page the object is removed from memory.
        //The object is re-created every time the user selects this option to save memory space.
        Button sub = (Button) findViewById(R.id.subButton);
        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
                checkUser();
            }
        });

        //RCFC Drawer Layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Close Drawer method
    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    //Adds items to the action bar if it is present
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.category_menu_screen, menu);
        return true;
    }

    //Options menu; on item selected method
    // Handles action bar item clicks. The action bar will automatically handle clicks.
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            Intent settings = new Intent(CategoryMenuScreenActivity.this, SettingsActivity.class);
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //using shared preference manager, the user is navigated back to the login screen
    //activity flags are cleared and the user is logged out successfully.
    private void LogOut()
    {
        SharedPrefManager.getInstance(CategoryMenuScreenActivity.this).clear();
        Intent intent = new Intent (CategoryMenuScreenActivity.this, LoginScreenActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent .FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //Activity objects within drawer e.g. news screen, league table etc.
    //When user selects drawer item, a new intent object is created.
    //This takes the user from the main screen to the designated screen selected.
    //Upon returning the object is removed from memory, due to memory limitations and is
    //re-created every time the user selects the option.
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        checkUser();
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        int optionsAvailable = user.getIsSubscriber();
        //if the isSubscriber value is equal to 0 then only basic content will be available.
        if(optionsAvailable == 0)
        {
            if (id == R.id.news)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.league)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.player)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.matchFix)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.matchRep)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.club)
            {
                Intent subscribe = new Intent(CategoryMenuScreenActivity.this,SubscriberActivity.class);
                startActivity(subscribe);
            }
            else if (id == R.id.coop)
            {
                Intent co = new Intent(CategoryMenuScreenActivity.this, CoopActivity.class);
                startActivity(co);
            }
            else if (id == R.id.manAcc)
            {
                Intent acc = new Intent(CategoryMenuScreenActivity.this, ManageAccountActivity.class);
                startActivity(acc);
            }
            else if(id == R.id.logAcc)
            {
                LogOut();
                finish();
            }

        }
        //if the isSubscriber value is equal to 1 then all content will be available.
        else if(optionsAvailable == 1)
        {
            if (id == R.id.news)
            {
                Intent news = new Intent(CategoryMenuScreenActivity.this, NewsListActivity.class);
                startActivity(news);
            }
            else if (id == R.id.league)
            {
                Intent league = new Intent(CategoryMenuScreenActivity.this, LeagueScreenActivity.class);
                startActivity(league);
            }
            else if (id == R.id.player)
            {
                Intent player = new Intent(CategoryMenuScreenActivity.this, PlayerListActivity.class);
                startActivity(player);
            }
            else if (id == R.id.matchFix)
            {
                Intent mf = new Intent(CategoryMenuScreenActivity.this, MatchFixturesActivity.class);
                startActivity(mf);
            }
            else if (id == R.id.matchRep)
            {
                Intent mr = new Intent(CategoryMenuScreenActivity.this, MatchReportActivity.class);
                startActivity(mr);
            }
            else if (id == R.id.club)
            {
                Intent club = new Intent(CategoryMenuScreenActivity.this, ClubActivity.class);
                startActivity(club);
            }
            else if (id == R.id.coop)
            {
                Intent co = new Intent(CategoryMenuScreenActivity.this, CoopActivity.class);
                startActivity(co);
            }
            else if (id == R.id.manAcc)
            {
                Intent acc = new Intent(CategoryMenuScreenActivity.this, ManageAccountActivity.class);
                startActivity(acc);
            }
            else if(id == R.id.logAcc)
            {
                LogOut();
                finish();
            }

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //the check user function updates the local private UserAccount variable user.
    //if a user becomes a subscriber or updates their account these effects will take immediate effect.
    private void checkUser()
    {
        //updates user object
        user = SharedPrefManager.getInstance(this).getUser();
    }
}
