package com.tomawesome.menumore03a.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tomawesome.menumore03a.R;

public class HeaderParentActivity extends AppCompatActivity {

    TextView bannerTV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_parent);
        bannerTV = findViewById( R.id.title_textView);

    }

    protected void setBanner(String banner){
        bannerTV.setText(banner);
    }


}