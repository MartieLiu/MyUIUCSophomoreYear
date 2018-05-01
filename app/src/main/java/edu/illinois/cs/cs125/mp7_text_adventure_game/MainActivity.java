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
            "You have turned left, but at what cost? Your left shoulder just detached from your body and blood starts to ooze out. With a mysterious smile, you did not panic, but start to crawl on the floor. You just kept crawling. Until you bleed out",
            "ok, I have made the right choice. 'By turning left, I have made a good life choice', you start to comfort yourself. 'remember boi, just like the right choice you have made yesterday, when you eat only 5 mcNuggets when you actually ordered 6'",
            "You start running towards left. the earth behind you seems to be shaking vigorously. Earthshaker seems to be chasing after you, with that magnificent golden 6 million echo slam. You start to remember that you have the invisible cloak, but all is too late, you fell",
            "Ah, a beam of sunlight seems to pierce through the cloudy sky and hit upon a golden chest. Now it is more radiant than ever. That chest on the left side. You must obtain, you run and discovered that you are actually handicapped, too bad",
            "You have pooped your pants when trying to move your head towards the left",
            "There's an elephant in the room. You always want to turn left in your whole life. 'Now is the chance to do it!' you think to yourself. A swift, shocking thunder suddenly strikes you. Apparently you are not supposed to turn left. just turn right 3 times then ",
            "An airplane crushed on the left side, you are determined to check it out. As you arrived , a group of dwarfs suddenly appears out of the plane, some of them lost their limbs and appears to be lost. You decided to help them out, so you gave them a shoe",
            "You walked to the Burill Hall located on your left side. A crazy researcher busted out of the door. 'Why is he in such a hurry?' you wonder. Then you saw Geoffrey handing a machine gun, walking out of the hallway. Well, isn't that what happened in CS125, you sighed",
            "You decide to jump. Wait that is not what you are supposed to do. You are supposed to turn left. screw that. I ain't gonna do it. Nope boi. Not today. I have might will, which is not doing what you command me to do, nope",};
    String rightPool[]={"keep your filthy hand out of dat keyboard. I ain't gonna turn right",
            "gucci gang",
            "You decided to turn right. There is a child crying helplessly over yonder. You decide you check it out. As you approach, you found out that child's face resembles one of the person in the hall of fame poster hanging in the Grainger 2nd floor. Disgusted, you left",
            "You are tired, you don't wanna turn right. You decide to hear a joke. 'A pirates walks into a bar with a ship's steering wheel hanging from his crotch. Bartender says, what the hell is that? Pirates says, I dunno, but it's drivin' me nuts'",
            "You turned right and walk into the groove. A wolf stares at you and you dare not to move. A drop of salty sweet is leaking from ya cheek, you want to wipe if off but who cares what you did. You realized that you just made yourself the worst poem ever in history",
            "You start to walk right and found out your own grave. It has your name on it. You think it is some sort of joke, so you start digging it. Finally, you saw your face when you opened up the coffin. You have convinced yourself that you just died ",
            "Right, I have to walk it out. Let's go for a walk. My heart is broken but let's go for a walk. The sunshine is raining but let's go for a walk anyway. The 18 flowers will wither in darkness forever my friend.",
            "Elon musk is driving by on his all mighty Tesla. You decided to chase after him on the right side to ask one important question. But the car is fast, real fast. yet you did not gave up and kept chasing. Finally you got him and asked 'Why is my pasta dry?'",
            "You want to go to Green Street for lunch but then you realized that is dinner time. Too sad. You walk into Panera and have your breakfast. You drank your soup peacefully while the waiter kept slapping your face. You did not feel a thing and never will",
            "You want to become a monster. You suppressed the urge for such transformation. Yet this is absurd. How can you just turn into a monster and not get freaked out or how is it even possible? You took a deep breath. You took another deep breath. you changed into a chuwawa"};
    String forwardPool[]={"Charging forward",
            "typing is really tiresome",
            "you decide that instead of walking forward, you want to hear another joke: ' And God said to John, come forth and you shall be granted eternal life. But John came fifth and won a toaster.' I mean still, a toaster is better than a pickle.",
            "You have decided to turn into a ninja. You start to poke around and jump forward, until you have reached the Ikneberery Dining Hall. You stole all the bananas and start to throw them at people from the bushes. They have no idea",
            "Spoil Alert, half of the universe died in Avenger 3",
            "There is a dog running in front of you, you start to chase after it and become lost in Brazil. But who cares. I mean you are in Brazil, so enjoy it. You start to play soccer with the local and one of them tell you that he is 89 years old. You laughed so hard and died",
            "Suddenly, you want to run like Forest Gump. You just feel like running and you start to run. You run past the quad and you run past the arc. You run into a maze and you are being cursed to run forever until you die",
            "You walk one step forward, but then you start to remember that pirate joke and you laughed to death",
            "You start walking forward and you couldn't figure out why the baseball kept getting larger, until it hits you.",
            "There is an ester egg"};
    String backPool[]={"'I have lost the battle against minotaurs and I shall go back to where I belong.' you thought to your self. A poopy man suddenly appears in front of your face out of no where. He wants to get your attention but you kept ignoring him, until he left.",
            "Once you go CS 125 you never go back",
            "Backa doodle do",
            "You want to go back to where you were originally. Then you realized that you forgot where you came from and you start to get very depressed. You decide to go to Grainger instead. But then you realized that it is at the end of final and it is closed. You are all alone ",
            "Life is no turning back boi",
            "You start to walk backwards with your eyes looking forward. life is strange. People start to cast their eyes on you but you ignored them and kept walking backwards, until you hit bumps into some dude. He fled out of terror and left his bike. You then ate it ",
            "You saw Professor Challen's dog chuchu and you decide to say hi. He ran away. You got depressed and start to fade away. You want to fade back into your dorm and eat ramens with two pencils acting like a pair of chopsticks ",
            "This is madness. I mean out of the five options why would you choose to walk back. Shame on you.",
            "Kayne West is standing right in front of you. You don't know what to do. He spoke and his words are so confusing that you decide that you need to back up a lil",
            "You walk backwards until you have reached the park. He appears and gave you the first key. You stand there, watching the Kingkong in front to be pounding his chest angrily at you. You smirks."};
    String standPool[]={"I mean what ya stand there for boi?.",
            "Standing still, you just discovered yourself to be a tree. You wonder how many children you have, and where is your root. Does the leaves seem to be bountiful? The binary philosophy starts to fill into your inner tranquility",
            "you stood there like an idiot",
            "Some one throw a frisbee at you. You stand there and did not try to catch. It hit your face and you start to cry",
            "you stand there and squeezed out a fart",
            "You stand there and wonder 'Am I talking to me'?",
            "Standing up straight is the way to go. You try to stand as straight as possible untill you crushed your backbone and collapsed on the floor like a floppy human jelly ",
            "I can't stand it. I mean why would I stand here? This is insane.",
            "You are trying the best you can to move your toes inch along, towards some direction. but they got chopped off immediately",
            "Standing there, you are pondering the phrase 'Swag money'"};
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
                } else if (command.equals("mp7")) {
                    showToast3(v);
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
    public void showToast3(View view) {
        Toast.makeText(this,"CONGRATS, YOU FOUND THE EGG", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
}
