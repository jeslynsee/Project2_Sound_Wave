package com.example.project2_sound_wave;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class ArtistPage {
    private static final String ARTIST_VALUE_EXTRA_KEY = "Artist_Page";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_page);


    }


        public static Intent artistPageIntentFactory (Context context){
            Intent intent = new Intent(context, ArtistPage.class);
            Intent intent = intent.putExtra(ARTIST_VALUE_EXTRA_KEY);

            return intent;

    }
}
