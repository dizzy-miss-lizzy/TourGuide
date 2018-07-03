package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.tourguide.SightsFragment.KEY_DESCRIPTION;
import static com.example.android.tourguide.SightsFragment.KEY_DETAILS;
import static com.example.android.tourguide.SightsFragment.KEY_DRAWABLE;
import static com.example.android.tourguide.SightsFragment.KEY_LOCATION;
import static com.example.android.tourguide.SightsFragment.KEY_NAME;

/**
 * A {@link DetailsActivity} that displays the data of an object from {@link Info}.
 * Data unique to this activity is description and location to provide more details about
 * a particular object.
 *
 * Map pin icon courtesy of Material icons: https://material.io/tools/icons/?icon=place&style=baseline
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String currentName = "";
        String currentLocation = "";
        String currentDetails = "";
        String currentDescription = "";

        // Gets String extras from clicked ListView item
        Intent intent = getIntent();
        if (null != intent) {
            currentName = intent.getStringExtra(KEY_NAME);
            currentLocation = intent.getStringExtra(KEY_LOCATION);
            currentDetails = intent.getStringExtra(KEY_DETAILS);
            currentDescription = intent.getStringExtra(KEY_DESCRIPTION);
        }

        // Gets image resource ID from clicked ListView item and stores in currentDrawable variable
        // Reference: https://stackoverflow.com/questions/1392521/how-can-i-get-image-resource-id-and-send-it-to-other-activity-in-android
        Bundle extras = getIntent().getExtras();
        int currentDrawable = extras.getInt(KEY_DRAWABLE);

        // Finds ImageView and sets the image resource ID to clicked ListView item object
        ImageView imageView = (ImageView) findViewById(R.id.current_drawable);
        imageView.setImageResource(currentDrawable);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentNameText = (TextView) findViewById(R.id.current_name);
        currentNameText.setText(currentName);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentLocationText = (TextView) findViewById(R.id.current_location);
        currentLocationText.setText(currentLocation);
        currentLocationText.setMovementMethod(LinkMovementMethod.getInstance());

        // Finds TextView and sets text to clicked ListView item object
        TextView currentDetailsText = (TextView) findViewById(R.id.current_details);
        currentDetailsText.setText(currentDetails);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentDescriptionText = (TextView) findViewById(R.id.current_description);
        currentDescriptionText.setText(currentDescription);
        }
}
