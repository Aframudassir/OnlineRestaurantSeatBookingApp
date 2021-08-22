package com.afra.assessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.afra.assessment.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movetofrag(new HomeFragment());
    }

    public void movetofrag(Fragment fragment) {

        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(
                R.id.FragContainer, fragment, null)
                .commit();
    }
}