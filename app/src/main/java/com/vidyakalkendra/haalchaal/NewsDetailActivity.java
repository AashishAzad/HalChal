package com.vidyakalkendra.haalchaal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title,desc,content,image,url;
    private TextView titleTV,subdescTV,contentTV;
    private Button btnNews;
    private ImageView newsPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(NewsDetailActivity.this, R.color.black));

        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        image = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");

        titleTV = findViewById(R.id.NewsTitle);
        titleTV.setText(title);
        subdescTV = findViewById(R.id.SubDescription);
        subdescTV.setText(desc);
        contentTV = findViewById(R.id.News);
        contentTV.setText(content);
        newsPic = findViewById(R.id.NewsImage);
        Picasso.get().load(image).into(newsPic);

        btnNews = findViewById(R.id.BtnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}