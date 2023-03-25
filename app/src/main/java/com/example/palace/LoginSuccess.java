package com.example.palace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LoginSuccess extends AppCompatActivity {
    private String strName, strProfileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Intent intent = getIntent();
        strName = intent.getStringExtra("name");
        strProfileImg = intent.getStringExtra("profileImg");

        TextView tv_name = findViewById(R.id.tv_name);
        ImageView iv_profile = findViewById(R.id.iv_profile);

        //이름 set
        tv_name.setText(strName);
        //프로필 이미지 사진 set
        Glide.with(this).load(strProfileImg).into(iv_profile);
    }
}