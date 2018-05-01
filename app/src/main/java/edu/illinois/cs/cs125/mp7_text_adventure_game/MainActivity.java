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
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Mp7:Main";
    MediaPlayer mySong;
    Button enter;
    Switch musicOnOff;
    String command;
    EditText commandInput;
    int oldRandomValue;
    Random rand = new Random();
    String leftPool[]={"For some unknown compelling reason, you turn left and just start walking. A couple fellas just walking by you, their face stern yet lifeless. You are heading towards Union and you are not sure whether you want to go downstairs to grab a snack.",
            "gucci",
            "ok",
            "sdadasd",
            "sd",
            "ffw",
            "czx",
            "ere",
            "qq",
            "wwrg",};
    String rightPool[]={"For some unknown compelling reason, you turn left and just start walking. A couple fellas just walking by you, their face stern yet lifeless. You are heading towards Union and you are not sure whether you want to go downstairs to grab a snack.",
            "gucci",
            "ok",
            "sdadasd",
            "sd",
            "ffw",
            "czx",
            "ere",
            "qq",
            "wwrg"};
    String forwardPool[]={"For some unknown compelling reason, you turn left and just start walking. A couple fellas just walking by you, their face stern yet lifeless. You are heading towards Union and you are not sure whether you want to go downstairs to grab a snack.",
            "gucci",
            "ok",
            "sdadasd",
            "sd",
            "ffw",
            "czx",
            "ere",
            "qq",
            "wwrg"};
    String backPool[]={"For some unknown compelling reason, you turn left and just start walking. A couple fellas just walking by you, their face stern yet lifeless. You are heading towards Union and you are not sure whether you want to go downstairs to grab a snack.",
            "gucci",
            "ok",
            "sdadasd",
            "sd",
            "ffw",
            "czx",
            "ere",
            "qq",
            "wwrg"};
    String standPool[]={"For some unknown compelling reason, you turn left and just start walking. A couple fellas just walking by you, their face stern yet lifeless. You are heading towards Union and you are not sure whether you want to go downstairs to grab a snack.",
            "gucci",
            "ok",
            "sdadasd",
            "sd",
            "ffw",
            "czx",
            "ere",
            "qq",
            "wwrg"};
    String errorPool[]={"try again boi",
            "ya need to try again",
            "on my, have you been pay attention",
            "seriously, someone is not paying attention",
            "get outta here",
            "you entered the wrong text, try again",
            "have you not seen the toast message? ",
            "ummm",
            "you need to stop pressing me before you can GET THE TEXT RIGHT DAMMIT",
            "nope."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView story = (TextView) findViewById(R.id.storyline);

        mySong = MediaPlayer.create(MainActivity.this, R.raw.goodbyemoonmen);

        commandInput = (EditText) findViewById(R.id.commandInput);

        enter = (Button) findViewById(R.id.enterText);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int outcome = rand.nextInt(10);
                Log.d(TAG,"text enter button clicked");
                command = commandInput.getText().toString();
                if (command.equals("left")){
                    showToast(v);
                    story.setText(leftPool[outcome]);
                } else if (command.equals("right")){
                    showToast(v);
                    story.setText(rightPool[outcome]);
                } else if (command.equals("forward")) {
                    showToast(v);
                    story.setText(forwardPool[outcome]);
                } else if (command.equals("back")) {
                    showToast(v);
                    story.setText(backPool[outcome]);
                } else if (command.equals("stand")){
                    showToast(v);
                    story.setText(standPool[outcome]);
                } else {
                    showToast2(v);
                    story.setText(errorPool[outcome]);
                }
                commandInput.setText("");
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
    public void showToast2(View view) {
        Toast.makeText(this,"you must enter left, right, forward, back, or stand", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
}
