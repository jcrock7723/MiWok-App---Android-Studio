package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    // Create a global variable
    // Handles the playback of all the sound files
    private static MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create an arrayList of strings/ Word Objects/  for the numbers activity
        final ArrayList<Word> numbersArray = new ArrayList<Word>();

        //numbersArray.add("one");
        numbersArray.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));


        //Use Logging to verify array build
        int count = 0;
        while (count < numbersArray.size()){
            Log.v("NumbersActivity", "Word at index " + count + ": " + numbersArray.get(count));
            count++;
        }

        // Instead use a ListView and Custom ArrayAdapter Class - WordAdapter
        WordAdapter itemsAdapter = new WordAdapter(this, numbersArray, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.numbersList);

        // Pull in the new WordAdapter ArrayAdapter that was created into the listView
        listView.setAdapter(itemsAdapter);

        // configure the onclick listener for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(NumbersActivity.this, "List Item Clicked", Toast.LENGTH_SHORT).show();

                //get the position of the list item
                Word word = numbersArray.get(position);

                // log the item that is clicked
                Log.v("Numbers Activity", "Current Word: " + word);

                // Create a mediaPlayer
                // pass the resource id
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                //start the audio file
                mMediaPlayer.start();
            }
        });


        /*// Store rootView into a variable rootView of LinearLayout data type *Parent*
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootViewNumbers);

        // Use a for loop to add the elements of the array to the view
        for (int i = 0; i < numbersArray.size(); i++) {
            // add a TextView object *Child*
            TextView numbersView = new TextView(this);
            //pass in the number at each index
            numbersView.setText(numbersArray.get(i));
            //Add the child to the parent
            rootView.addView(numbersView);
        }*/

    }




}
