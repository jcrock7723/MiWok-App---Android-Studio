package com.example.android.miwok;

import android.media.Image;

public class Word {

    private String defaultTranslation;
    private String miWokTranslation;
    private int resourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = 0;

    private int audioResourceId;

    // Keep this two input constructor for the phrases activity
    public Word(String defaultTranslation, String miWokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miWokTranslation = miWokTranslation;
    }

    // Create the three input constructor for the other three activities
    public Word(String defaultTranslation, String miWokTranslation, int audioResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.miWokTranslation = miWokTranslation;
        this.audioResourceId = audioResourceId;
    }

    // Create the four input constructor for inclusion of the audio
    public Word(String defaultTranslation, String miWokTranslation, int resourceId, int audioResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.miWokTranslation = miWokTranslation;
        this.resourceId = resourceId;
        this.audioResourceId = audioResourceId;
    }


    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiWokTranslation() {
        return miWokTranslation;
    }

    public int getResourceId() {
        return resourceId;
    }


    // return the audio Resource id
    public int getAudioResourceId() {
        return audioResourceId;
    }

    //used to determine if the word has an associated image, i.e. Phrases
    public boolean hasImage() {
        return resourceId != NO_IMAGE_PROVIDED;
    }


    @Override
    public String toString() {
        return "Word{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", miWokTranslation='" + miWokTranslation + '\'' +
                ", resourceId=" + resourceId +
                ", audioResourceId=" + audioResourceId +
                '}';
    }
}


