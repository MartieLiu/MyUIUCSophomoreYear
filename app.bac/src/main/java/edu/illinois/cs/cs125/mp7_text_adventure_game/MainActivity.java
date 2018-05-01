package edu.illinois.cs.cs125.mp7_text_adventure_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /** Default tag for mp7. */
    private static final String TAG = "Mp7:Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button enter = findViewById(R.id.enterText);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"text enter button clicked");
            }
        });
        //sdasdsad

    }










}
