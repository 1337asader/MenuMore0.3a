package com.tomawesome.menumore03a.ui.activity.user;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tomawesome.menumore03a.R;
import com.tomawesome.menumore03a.ui.activity.HeaderParentActivity;
import com.tomawesome.menumore03a.ui.activity.search.SearchActivity;

//import com.example.restaurantdiscovery.R;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class UserLoginActivity extends HeaderParentActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView anonymousTextView;
    private TextView createAccountTextView;


//    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        setBanner("Sign in");


        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        anonymousTextView = findViewById(R.id.anonymous_textView);
        createAccountTextView = findViewById(R.id.create_Account_textView);


        //mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUser(email, password);
                } else {
                    Toast.makeText(UserLoginActivity.this,
                            "Please enter email and password.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        anonymousTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // build link to 'next' activity

                startActivity(SearchActivity.class);

            }
        });

        createAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(DevelopAccountActivity.class);
            }
        });

    }

    private void loginUser(String email, String password) {


        ///needd to get this logg in function working


       // mAuth.signInWithEmailAndPassword(email, password)
               // .addOnCompleteListener(this, task -> {
                    //if (task.isSuccessful()) {
                        //FirebaseUser user = mAuth.getCurrentUser();
//                        // Navigate to the next activity (replace NextActivity.class with your desired activity)
//                        Intent intent = new Intent(UserLoginActivity.this, NextActivity.class);
//                        startActivity(intent);
//                        finish();
                   // } else {
                        Toast.makeText(UserLoginActivity.this,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                        startActivity(SearchActivity.class);

//                    }
//                });
    }

    private void startActivity(Class className){

        Intent intent = new Intent(UserLoginActivity.this, className);
        startActivity(intent);
        finish();


    }




}
