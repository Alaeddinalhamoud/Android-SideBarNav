package com.a_hamoud.sidebanav;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
private NavigationView mNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mNavView=(NavigationView)findViewById(R.id.NavView) ;

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                if(item.getItemId()==R.id.nav_account){
                    Toast.makeText(MainActivity.this, "Nav Account", Toast.LENGTH_SHORT).show();
                    return  true;
                } else if(item.getItemId()==R.id.nav_logout){
                    Toast.makeText(MainActivity.this, "Nav Logout", Toast.LENGTH_SHORT).show();
                    return  true;
                }else{

                    Toast.makeText(MainActivity.this, "Nav Setting", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
