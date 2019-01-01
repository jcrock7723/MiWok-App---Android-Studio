/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MiWokMainActivity extends AppCompatActivity {

    //Create a global audioManager variable
    private AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Sync the audioManager to the device volume
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        // Setup an onclick Listener for the Volume buttons
        // setup the Volume buttons
        Button volumeUpButton = (Button)findViewById(R.id.vol_up_button);
        volumeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MiWokMainActivity.this, "Volume Up", Toast.LENGTH_SHORT).show();
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        // setup the Volume buttons
        Button volumeDownButton = (Button)findViewById(R.id.vol_down_button);
        volumeDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MiWokMainActivity.this, "Volume Down", Toast.LENGTH_SHORT).show();
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });
        
        // **Set on click listeners to all the views to be interacted with**

        // **Numbers**
        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set a click listener on that View
        // to avoid a NULLPointer Exception wrap in an if statement
        if (numbers != null) {
            numbers.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the numbers View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent numbersIntent = new Intent(MiWokMainActivity.this, NumbersActivity.class);
                    startActivity(numbersIntent);
                }
            });
        }

        // **Family**
        TextView family = (TextView) findViewById(R.id.family);

        // Set a click listener on that View
        // to avoid a NULLPointer Exception wrap in an if statement
        if (family != null) {
            family.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the family View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent familyIntent = new Intent(MiWokMainActivity.this, FamilyMembersActivity.class);
                    startActivity(familyIntent);
                }
            });
        }

        // **Colors**
        TextView colors = (TextView) findViewById(R.id.colors);

        // Set a click listener on that View
        // to avoid a NULLPointer Exception wrap in an if statement
        if (colors != null) {
            colors.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the colors View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent colorsIntent = new Intent(MiWokMainActivity.this, ColorsActivity.class);
                    startActivity(colorsIntent);
                }
            });
        }

        // **Phrases**
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set a click listener on that View
        // to avoid a NULLPointer Exception wrap in an if statement
        if (phrases != null) {
            phrases.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the phrases View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent phrasesIntent = new Intent(MiWokMainActivity.this, PhrasesActivity.class);
                    startActivity(phrasesIntent);
                }
            });
        }

    }

}


    //Old way to open views - ie connected with the html
   /* // Methods to open activities when clicked
    public void openNumbersList(View view) {
        // Create new intent to run this package, NumbersActivity class
        // Then Start the Activity
        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }*/

