package com.tsuruta.michael.frcshirtswap;

import android.support.v4.app.FragmentActivity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.tsuruta.michael.frcshirtswap.fragments.AccountFragment;
import com.tsuruta.michael.frcshirtswap.fragments.MainActivityFragment;


public class MainActivity extends FragmentActivity
{
    //Makes it possible to return to the previous fragment you were in.
    //TODO: Make the back button not cause a crash after back on Account Fragment and open.
    @Override
    public void onBackPressed()
    {
        /*if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().popBackStack();
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); //Resume the screen if something was left open.
        setContentView(R.layout.activity_main); //Start the fragment holder.

        //Enable Parse for Users and Push
        Parse.enableLocalDatastore(this);// Enable Local Datastore.
        Parse.initialize(this, "QmFqDL3bPLAo3peYU9cyt7pQ47KzJHf2sRS3QZAM", "3ly3zV3CV3PTTomIVo2uGyn4enTg73vbkL1IjlR6");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        //Bring up the account management screen if not logged in, otherwise go to app.
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            ft.replace(R.id.placeholder, new MainActivityFragment());
            ft.commit();
        }
        else
        {
            ft.replace(R.id.placeholder, new AccountFragment());
            ft.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
