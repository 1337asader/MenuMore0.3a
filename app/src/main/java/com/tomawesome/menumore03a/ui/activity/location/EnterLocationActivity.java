package com.tomawesome.menumore03a.ui.activity.location;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tomawesome.menumore03a.R;

public class EnterLocationActivity extends AppCompatActivity {

    private EditText latitudeEditText;
    private EditText longitudeEditText;
    private Button submitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_location);

        latitudeEditText = findViewById(R.id.latitude_edit_text);
        longitudeEditText = findViewById(R.id.longitude_edit_text);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latitudeString = latitudeEditText.getText().toString();
                String longitudeString = longitudeEditText.getText().toString();

                if (!latitudeString.isEmpty() && !longitudeString.isEmpty()) {
                    double latitude = Double.parseDouble(latitudeString);
                    double longitude = Double.parseDouble(longitudeString);

                    // Use the latitude and longitude for your app logic
                    // e.g., search for nearby restaurants

                    Toast.makeText(EnterLocationActivity.this,
                            "Latitude: " + latitude + ", Longitude: " + longitude,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EnterLocationActivity.this,
                            "Please enter both latitude and longitude.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
