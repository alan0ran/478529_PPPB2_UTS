package com.example.a478529_pppb2_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Boolean isMainFragmentDisplayed = false;
    private Boolean isSimpleFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isMainFragmentDisplayed && !isSimpleFragmentDisplayed){

                    openMainFragment();
                } else if (isMainFragmentDisplayed && !isSimpleFragmentDisplayed) {
                    closeMainFragment();
                    openSimpleFragment();
                } else if (isSimpleFragmentDisplayed && !isMainFragmentDisplayed) {
                    closeSimpleFragment();
                } else if (isSimpleFragmentDisplayed && isMainFragmentDisplayed) {
                    closeSimpleFragment();
                    closeMainFragment();
                }
            }
        });
    }

    public void openMainFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = MainFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragment, mainFragment).addToBackStack(null).commit();

        isMainFragmentDisplayed = true;
    }
    public void closeMainFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.mainFragment);
        if (mainFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(mainFragment).commit();
        }

        isMainFragmentDisplayed = false;
    }

    public void openSimpleFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        SimpleFragment simpleFragment = SimpleFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.simpleFragment, simpleFragment).addToBackStack(null).commit();

        isSimpleFragmentDisplayed = true;
    }
    public void closeSimpleFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.simpleFragment);
        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        isSimpleFragmentDisplayed = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle options menu item clicks here.
        int id = item.getItemId();
        if (id == R.id.action_sensor) {
            Intent intent = new Intent(this, SensorActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_move) {
            Intent intent = new Intent(this, MoveActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_maps) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_language){
            Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(languageIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}