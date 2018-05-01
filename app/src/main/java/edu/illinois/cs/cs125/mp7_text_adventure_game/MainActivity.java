package edu.illinois.cs.cs125.mp7_text_adventure_game;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Mp7:Main";
    MediaPlayer mySong;
    Button enter;
    Switch musicOnOff;
    String command;
    EditText commandInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySong = MediaPlayer.create(MainActivity.this, R.raw.goodbyemoonmen);

        commandInput = (EditText) findViewById(R.id.commandInput);

        enter = (Button) findViewById(R.id.enterText);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"text enter button clicked");
                command = commandInput.getText().toString();
                showToast(v);

            }
        });

        musicOnOff = (Switch) findViewById(R.id.music);
        musicOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(musicOnOff.isChecked()) {
                    mySong.start();
                } else {
                    mySong.release();
                }
            }
        });
    }

    public void showToast(View view) {
             Toast.makeText(this,"good boi", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
}
