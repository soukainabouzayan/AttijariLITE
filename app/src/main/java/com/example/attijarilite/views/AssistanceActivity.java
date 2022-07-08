package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityAssistanceBinding;

public class AssistanceActivity extends AppCompatActivity {
    ActivityAssistanceBinding activityAssistanceBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAssistanceBinding = DataBindingUtil.setContentView(this,R.layout.activity_assistance);
        activityAssistanceBinding.phoneAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+212 5 22 58 88 88"));
                startActivity(intent);
            }
        });
        activityAssistanceBinding.assistantWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.attijariwafabank.com/fr/contact-groupe");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}