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

public class ColorsActivity extends AppCompatActivity {


    // Create a global variable
    // Handles the playback of all the sound files
    private static MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // Create an ArrayList for the colors
        final ArrayList<Word> colorsArray = new ArrayList<>();

        // Add the colors to the array
        colorsArray.add(new Word("red", "wetetti", R.drawable.color_red, R.raw.color_red));
        colorsArray.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colorsArray.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        colorsArray.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        colorsArray.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colorsArray.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colorsArray.add(new Word("dusty yellow", "topiise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArray.add(new Word("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));



        // Instead use a ListView and ArrayAdapter object/ Custom WordAdapter
        WordAdapter itemsAdapter = new WordAdapter(this, colorsArray, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colorsList);

        listView.setAdapter(itemsAdapter);

        // configure the onclick listener for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(NumbersActivity.this, "List Item Clicked", Toast.LENGTH_SHORT).show();

                //get the position of the list item
                Word word = colorsArray.get(position);

                // log the item that is clicked
                Log.v("Colors Activity", "Current Word: " + word.toString());

                // Create a mediaPlayer
                // pass the resource id
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });


    }
}
