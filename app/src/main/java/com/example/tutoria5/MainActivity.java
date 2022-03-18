package com.example.tutoria5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        FirstFragment.DatapassLitener {

    BottomNavigationView bottomNavigationView;
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.person);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Bundle bundle = new Bundle();
        bundle.putString("key","abc");
        firstFragment.setArguments(bundle);
        secondFragment.setArguments(bundle);
        thirdFragment.setArguments(bundle);

        switch (item.getItemId()) {
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,firstFragment).commit();
                return true;

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,secondFragment).commit();
                return true;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,thirdFragment).commit();
                return true;
        }

        return false;
    }
    @Override
    public void passDatafromFirst2Second(String data) {
        Log.d("Louis","arrived passDatafromFirst2Second");
        Bundle bundle = new Bundle();

        bundle.putString(SecondFragment.DATA_RECEIVE,data);

        secondFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,secondFragment).commit();


    }

}