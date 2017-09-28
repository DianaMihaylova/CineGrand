package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.data.DatabaseManager;
import com.example.ittalents.cinegrand.models.User;

public class RegisterActivity extends Activity {

    private ImageView imageView;
    private EditText userName, pass, confirmPass;
    private Button registerBtn;
    private DatabaseManager myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.cine_grand_logo_small);
        userName = (EditText) findViewById(R.id.entered_mail);
        pass = (EditText) findViewById(R.id.entered_pass);
        confirmPass = (EditText) findViewById(R.id.confirmed_pass);
        registerBtn = (Button) findViewById(R.id.button_register);
        myDb = DatabaseManager.getDBManager(this);
        myDb.createDatabase();
        setRegisterBtn();
    }

    private void setRegisterBtn() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = userName.getText().toString();
                String passValue = pass.getText().toString();
                String passConfirmValue = confirmPass.getText().toString();
                if (!(passValue.equals(passConfirmValue))) {
                    Toast.makeText(getBaseContext(), "Passwords are not matching! Try again.", Toast.LENGTH_LONG).show();
                    userName.setText("");
                    pass.setText("");
                    confirmPass.setText("");
                } else {
                    User u = new User(userNameValue, passValue);
                    if (u.isValidMail(userNameValue) && u.isStrongPass(passValue)) {
                        boolean result = myDb.addUser(u);
                        if (result) {
                            Toast.makeText(RegisterActivity.this, "Registration successful! Welcome " + u.getEmail(), Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getBaseContext(), MovieDetailsActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "E-mail already exist!", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "E-mail or password are not valid! Try again.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}