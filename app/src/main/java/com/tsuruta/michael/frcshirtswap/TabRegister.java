package com.tsuruta.michael.frcshirtswap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class TabRegister extends Fragment implements View.OnClickListener
{
    EditText etUsername;
    EditText etPassword;
    EditText etPasswordConfirm;
    EditText etTeamNumber;
    Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Add the tab to the fragment.
        View v =inflater.inflate(R.layout.account_tab_register,container,false);

        btnRegister = (Button) v.findViewById(R.id.btnRegister);
        etUsername = (EditText) v.findViewById(R.id.etUsername);
        etPassword = (EditText) v.findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) v.findViewById(R.id.etConfirmPassword);
        etTeamNumber = (EditText) v.findViewById(R.id.etTeamNumber);

        btnRegister.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(final View v) //Begin the register process through Parse.
    {
        switch (v.getId())
        {
            case R.id.btnRegister:
                //Makes sure that information has actually been entered in.
                if ((etUsername.getText() == null) || (etPassword.getText() == null) ||
                        etPasswordConfirm.getText() == null)
                {
                    Toast.makeText(getActivity(), "Please enter all required information",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Makes sure that the passwords are the same.
                    if (etPassword.getText().toString()
                            .equals(etPasswordConfirm.getText().toString()))
                    {
                        //Set variables for the account to what was typed.
                        ParseUser user = new ParseUser();
                        user.setUsername(etUsername.getText().toString());
                        user.setPassword(etPassword.getText().toString());
                        user.put("team", etTeamNumber.getText().toString());

                        user.signUpInBackground(new SignUpCallback()
                        {
                            public void done(ParseException e)
                            {
                                //If the registration was successful, show login tab.
                                //TODO: Switch tabs after registration has worked.
                                //TODO: Hide keyboard at this moment.
                                if (e == null)
                                {
                                    Toast.makeText(getActivity(),
                                            "You have been signed up! Please Login",
                                            Toast.LENGTH_SHORT).show();
                                }
                                //Failure.
                                //TODO: Give different error codes based on error.
                                else
                                {
                                    Toast.makeText(getActivity(), "Signup failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Your passwords do not match.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
