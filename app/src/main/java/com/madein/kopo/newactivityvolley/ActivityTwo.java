package com.madein.kopo.newactivityvolley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class ActivityTwo extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tvtitle = findViewById(R.id.txttitle);
        tvdescription = findViewById(R.id.txtDesc);
        tvcategory = findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Category = intent.getExtras().getString("Category");
        int image = intent.getExtras().getInt("Image") ;

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvcategory.setText(Category);
        img.setImageResource(image);
    }
}

