package com.example.palace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFilter1 extends AppCompatActivity {
    RadioGroup rG1, rG2, rG3;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_filter1);
        rG1 = findViewById(R.id.rd1);
        rG2 = findViewById(R.id.rd2);
        rG3 = findViewById(R.id.rd3);
        EditText month = findViewById(R.id.edit_month);
        EditText day = findViewById(R.id.edit_day);
        TextView total = findViewById(R.id.res);
        ImageView back = findViewById(R.id.btn_back);

        //규모 선택
        rG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.small:
                        result += "규모 : 25~30명";
                        break;
                    case R.id.middle:
                        result += "규모 : 30~50명";
                        break;
                    case R.id.big:
                        result += "규모 : 50명~80명";
                        break;
                    case R.id.bigbig:
                        result += "규모 : 80명 이상";
                        break;
                }
            }
        });

        //날짜 합치기
        result = result + (", 날짜는 " +month.getText().toString() + "월 "+ day.getText().toString() + "일, ");

        //지역 선택
        rG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.book:
                        result += "지역은 강북이며, ";
                        break;
                    case R.id.west:
                        result += "지역은 강서이며, ";
                        break;
                    case R.id.dong:
                        result += "지역은 강동이며, ";
                        break;
                    case R.id.nam:
                        result += "지역은 강남이며, ";
                        break;
                }
            }
        });

        // 공간의 종류
        result += "희망하는 공간은";

        rG3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.seminar:
                        result += "세미나실입니다.";
                        break;
                    case R.id.gym:
                        result += "체육관입니다.";
                        break;
                    case R.id.multi:
                        result += "멀티미디어실입니다.";
                        break;
                }
            }
        });

        total.setText(result);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "필터가 성공적으로 적용되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
            }
        });
    }
}