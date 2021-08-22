package com.afra.assessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.afra.assessment.Fragment.HomeFragment;
import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    AppBarLayout mAppBar;
    Toolbar mToolBar;
    TextView title;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppBar = findViewById(R.id.mappbar);
        mToolBar = mAppBar.findViewById(R.id.mtoolbar);
        title = mToolBar.findViewById(R.id.title);
        backbtn = mToolBar.findViewById(R.id.backbtn);

        movetofrag(new HomeFragment());

    }

    public void movetofrag(Fragment fragment) {

        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(
                R.id.FragContainer, fragment, null)
                .addToBackStack(null)
                .commit();
    }

    public  void hideBackbtn() {
        backbtn.setVisibility(View.GONE);
        title.setText(getString(R.string.app_name));

    }

    public  void showBackbtn(String text) {
        backbtn.setVisibility(View.VISIBLE);
        title.setText(text);
        getSupportFragmentManager().popBackStack();

    }
}