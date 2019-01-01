package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {


    // Create a global variable
    // Handles the playback of all the sound files
    private static MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        //Create and ArrayList of Words for the phrases
        final ArrayList<Word> phrasesArray= new ArrayList<Word>();

        //Add the phrases to the ArrayList
        phrasesArray.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesArray.add(new Word("What is your name?", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phrasesArray.add(new Word("My name is... ", "oyaaset... ", R.raw.phrase_my_name_is));
        phrasesArray.add(new Word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        phrasesArray.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesArray.add(new Word("Are you coming?", "eenes'aa?", R.raw.phrase_are_you_coming));
        phrasesArray.add(new Word("Yes, I'm coming.", "hee' eenem", R.raw.phrase_yes_im_coming));
        phrasesArray.add(new Word("I'm coming.", "eenem", R.raw.phrase_im_coming));
        phrasesArray.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        phrasesArray.add(new Word("Come here.", "enni'nem", R.raw.phrase_come_here));


        //Use Logging to verify array build
        int count = 0;
        while (count < phrasesArray.size()){
            Log.v("PhrasesActivity", "Word at index " + count + ": " + phrasesArray.get(count));
            count++;
        }


        // Instead use a ListView and ArrayAdapter object/ Custom class WordAdapter
        WordAdapter itemsAdapter = new WordAdapter(this, phrasesArray, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrasesList);

        listView.setAdapter(itemsAdapter);

        // configure the onclick listener for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(NumbersActivity.this, "List Item Clicked", Toast.LENGTH_SHORT).show();

                //get the position of the list item
                Word word = phrasesArray.get(position);

                // log the item that is clicked
                Log.v("Phrases Activity", "Current Word: " + word);

                // Create a mediaPlayer
                // pass the resource id
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });




    }
}
