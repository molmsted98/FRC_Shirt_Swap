package com.tsuruta.michael.frcshirtswap.tabHelpers;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.tsuruta.michael.frcshirtswap.fragments.MainActivityFragment;
import com.tsuruta.michael.frcshirtswap.R;

public class TabLogin extends Fragment implements View.OnClickListener
{
    Button btnLogin;
    EditText etUsername;
    EditText etPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //Add the tab to the fragment.
        View v =inflater.inflate(R.layout.account_tab_login,container,false);
        btnLogin = (Button) v.findViewById(R.id.btnLogin);
        etUsername = (EditText) v.findViewById(R.id.etUsername);
        etPassword = (EditText) v.findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(final View v) //Begin login process through Parse.
    {
        switch (v.getId())
        {
            case R.id.btnLogin:
                //Makes sure that text was entered.
                if (etUsername.getText() == null || etPassword.getText() == null)
                {
                    Toast.makeText(getActivity(), R.string.error_missing_field,
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Logs the user in.
                    ParseUser.logInInBackground(etUsername.getText().toString(),
                            etPassword.getText().toString(), new LogInCallback()
                            {
                                public void done(ParseUser user, ParseException e)
                                {
                                    //Let them into the app.
                                    //TODO: Hide keyboard at this moment.
                                    if (user != null)
                                    {
                                        FragmentTransaction ft =
                                                getFragmentManager().beginTransaction();
                                        ft.replace(R.id.placeholder, new MainActivityFragment());
                                        ft.commit();
                                    }
                                    else
                                    {
                                        Toast.makeText(getActivity(), R.string.error_login_failure,
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                break;
        }
    }
}
