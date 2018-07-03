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
 * A simple {@link Fragment} subclass that displays an ArrayList of Sights.
 *
 * All pictures taken by me, except for Yaquina Head Lighthouse picture courtesy of tdfugere on Pixabay:
 * https://pixabay.com/en/yaquina-head-lighthouse-waves-beach-1467656/
 */
public class SightsFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of sights
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.yaquina_bridge_name), getContext().getString(R.string.yaquina_bridge_distance),
                getContext().getString(R.string.yaquina_bridge_details), R.drawable.newport,
                getContext().getString(R.string.yaquina_bridge_description), getContext().getString(R.string.yaquina_bridge_location)));
        info.add(new Info(getContext().getString(R.string.yaquina_head_name), getContext().getString(R.string.yaquina_head_distance),
                getContext().getString(R.string.yaquina_head_detail), R.drawable.yaquinahead,
                getContext().getString(R.string.yaquina_head_description), getContext().getString(R.string.yaquina_head_location)));
        info.add(new Info(getContext().getString(R.string.yaquina_bay_name), getContext().getString(R.string.yaquina_bay_distance),
                getContext().getString(R.string.yaquina_bay_detail), R.drawable.yaquinabay,
                getContext().getString(R.string.yaquina_bay_description), getContext().getString(R.string.yaquina_bay_location)));
        info.add(new Info(getContext().getString(R.string.yaquina_beach_name), getContext().getString(R.string.yaquina_beach_distance),
                getContext().getString(R.string.yaquina_beach_detail), R.drawable.yaquinabeach,
                getContext().getString(R.string.yaquina_beach_description), getContext().getString(R.string.yaquina_beach_location)));
        info.add(new Info(getContext().getString(R.string.foulweather_name), getContext().getString(R.string.foulweather_distance),
                getContext().getString(R.string.foulweater_detail), R.drawable.foulweather,
                getContext().getString(R.string.foulweather_description), getContext().getString(R.string.foulweater_location)));
        info.add(new Info(getContext().getString(R.string.depoe_bay_name), getContext().getString(R.string.depoe_bay_distance),
                getContext().getString(R.string.depoe_bay_detail), R.drawable.depoebay,
                getContext().getString(R.string.depoe_bay_descrption), getContext().getString(R.string.depoe_bay_location)));
        info.add(new Info(getContext().getString(R.string.ocean_shore_name), getContext().getString(R.string.ocean_shore_distance),
                getContext().getString(R.string.ocean_shore_detail), R.drawable.beach,
                getContext().getString(R.string.ocean_shore_description), getContext().getString(R.string.ocean_shore_location)));

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