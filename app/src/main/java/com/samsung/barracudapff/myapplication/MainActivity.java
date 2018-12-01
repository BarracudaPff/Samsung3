package com.samsung.barracudapff.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.samsung.barracudapff.myapplication.fragment.DashboardFragment;
import com.samsung.barracudapff.myapplication.fragment.HomeFragment;
import com.samsung.barracudapff.myapplication.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    transaction.replace(R.id.main_frame,homeFragment);

                    transaction.commit();

                    return true;
                case R.id.navigation_dashboard:

                    DashboardFragment homeFragment2 = new DashboardFragment();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();

                    transaction2.replace(R.id.main_frame,homeFragment2);

                    transaction2.commit();
                    return true;
                case R.id.navigation_notifications:

                    NotificationFragment homeFragment3 = new NotificationFragment();
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();

                    transaction3.replace(R.id.main_frame,homeFragment3);

                    transaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
