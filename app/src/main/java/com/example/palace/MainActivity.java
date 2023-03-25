package com.example.palace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {
    public static String strName, strProfile, accessToken;
    ListFragment listFragment;
    HomeFragment homeFragment;
    MyFragment myFragment;

    public void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

//        fragmentTransaction.replace(R.id.container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        BottomNavigationView bottom_menu = findViewById(R.id.bottomMenu);

        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reservationButton:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, listFragment).commit();
                        Log.d("LOG", "예약리스트화면");
                        return true;
                    case R.id.homeButton:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        Log.d("LOG", "홈화면");
                        return true;
                    case R.id.setButton:
                        // 로그인 정보 받기
                        Intent intent = getIntent();
                        strName = intent.getStringExtra("name");
                        strProfile = intent.getStringExtra("profileImg");
                        accessToken = intent.getStringExtra("accessToken");

                        Bundle bundle = new Bundle();
                        bundle.putString("name", strName);
                        bundle.putString("profile", strProfile);
                        myFragment.setArguments(bundle);
                        // MyFragment로 본인 정보 전달
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).commit();
                        Log.d("LOG", "마이페이지화면");
                        return true;
                    //Intent intent = new Intent(getApplicationContext(), OrderList.class);
                    //startActivity(intent);
                    //return true;
                }
                return false;
            }
        });
    }
}