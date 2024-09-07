package com.example.blue_birds_fc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import adapters.mainViewPager;
import adapters.mainViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new mainViewPager(this));
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:{
                        tab.setText("Squad").toString().toLowerCase();
                        break;
                    }
                    case 1:{
                        tab.setText("fixtures").toString().toLowerCase();
                        break;
                    }

                    case 2:{
                        tab.setText("LineUp").toString().toLowerCase();
                        break;
                    }
                    case 3:{
                        tab.setText("Standings").toString().toLowerCase();
                        break;
                    }
                    case 4:{
                        tab.setText("News").toString().toLowerCase();
                        break;
                    }
                    case 5:{
                        tab.setText("Chats").toString().toLowerCase();
                        break;
                    }

                }

            }
        });
        tabLayoutMediator.attach();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {

                    case R.id.nav_login:
                        startActivity(new Intent(MainActivity.this,Login.class));
                    break;

                    default: return true;
                }

                return true;
            }
        });

    }
}