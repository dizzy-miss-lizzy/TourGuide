package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass that displays an ArrayList of Events.
 *
 * Whale picture courtesy of Steve Halama on Unsplash: https://unsplash.com/photos/dcijpRyPeHA
 * Farmers Market picture courtesy of Anne Preble on Unsplash: https://unsplash.com/photos/SAPvKo12dQE
 * Sails picture taken by me.
 */
public class EventsFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of events
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.market_name), getContext().getString(R.string.market_distance),
                getContext().getString(R.string.market_detail), R.drawable.market,
                getContext().getString(R.string.market_description), getContext().getString(R.string.market_location)));
        info.add(new Info(getContext().getString(R.string.whale_name), getContext().getString(R.string.whale_distance),
                getContext().getString(R.string.whale_detail), R.drawable.whale,
                getContext().getString(R.string.whale_description), getContext().getString(R.string.whale_location)));
        info.add(new Info(getContext().getString(R.string.washington_name), getContext().getString(R.string.washington_distance),
                getContext().getString(R.string.washington_detail), R.drawable.sails,
                getContext().getString(R.string.washington_description), getContext().getString(R.string.washington_location)));

        // Create an {@link InfoAdapter} and populates with data sourced from {@link Info}.
        InfoAdapter adapter = new InfoAdapter(getActivity(), info);

        // Finds the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There is a view ID called list in the list_view.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Sets the {@link ListView} to use the {@link InfoAdapter} to display list items for each {@link Info} object.
        listView.setAdapter(adapter);

        // Sets an onItemClickListener(), gets the position of clicked item, and calls an explicit intent.
        // Extras sent to the {@link DetailsActivity} include all {@link Info} object data, except for distance.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info item = info.get(position);
                Intent details = new Intent(getContext(), DetailsActivity.class);
                details.putExtra(KEY_NAME, item.getName());
                details.putExtra(KEY_LOCATION, item.getLocation());
                details.putExtra(KEY_DETAILS, item.getDetails());
                details.putExtra(KEY_DESCRIPTION, item.getDescription());
                details.putExtra(KEY_DRAWABLE, item.getImageResourceId());
                startActivity(details);
            }
        });

        return rootView;
    }

}
