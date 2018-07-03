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
 * A simple {@link Fragment} subclass that displays an ArrayList of Activities.
 * All pictures are taken by me.
 */
public class ActivitiesFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of activities
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.aquarium_name), getContext().getString(R.string.aquarium_distance),
                getContext().getString(R.string.aquarium_detail), R.drawable.aquarium,
                getContext().getString(R.string.aquarium_description), getContext().getString(R.string.aquarium_location)));
        info.add(new Info(getContext().getString(R.string.marine_tours_name), getContext().getString(R.string.marine_tours_distance),
                getContext().getString(R.string.marine_tours_detail), R.drawable.boat,
                getContext().getString(R.string.marine_tours_description), getContext().getString(R.string.marine_tours_location)));
        info.add(new Info(getContext().getString(R.string.tradewinds_name), getContext().getString(R.string.tradewinds_distance),
                getContext().getString(R.string.tradewinds_detail), R.drawable.depoeharbor,
                getContext().getString(R.string.tradewinds_description), getContext().getString(R.string.tradewinds_location)));
        info.add(new Info(getContext().getString(R.string.winery_name), getContext().getString(R.string.winery_distance),
                getContext().getString(R.string.winery_detail), R.drawable.winery,
                getContext().getString(R.string.winery_description), getContext().getString(R.string.winery_location)));
        info.add(new Info(getContext().getString(R.string.dockside_name), getContext().getString(R.string.dockside_distance),
                getContext().getString(R.string.dockside_detail), R.drawable.depoeharbor,
                getContext().getString(R.string.dockside_description), getContext().getString(R.string.dockside_location)));

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
