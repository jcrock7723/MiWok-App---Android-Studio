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

public class FamilyMembersActivity extends AppCompatActivity {


    // Create a global variable
    // Handles the playback of all the sound files
    private static MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        //Create an ArrayList for family members
         final ArrayList<Word> familyMembers = new ArrayList<>();

        // Add the family members to the ArrayList
        familyMembers.add(new Word("father", "epe", R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new Word("mother", "eta", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("older sister", "tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        // Instead use a ListView and ArrayAdapter object/ Custom WordAdapter
        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.familyList);

        listView.setAdapter(itemsAdapter);

        // configure the onclick listener for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(NumbersActivity.this, "List Item Clicked", Toast.LENGTH_SHORT).show();

                //get the position of the list item
                Word word = familyMembers.get(position);

                // log the item that is clicked
                Log.v("Family Members Activity", "Current Word: " + word);

                // Create a mediaPlayer
                // pass the resource id
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

    }
}
