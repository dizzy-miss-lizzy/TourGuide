package com.example.android.tourguide;

/**
 * {@link Info} represents the information about sights, activities, restaurants,
 * lodging, and events. It contains the name, location, details, description and image for each item.
 */
public class Info {

    /** Name for ListView item object **/
    private String mName;

    /** Distance of object from Newport, OR **/
    private String mDistance;

    /** Quick details for object **/
    private String mDetails;

    /** More detailed description of object, displayed in {@link DetailsActivity} **/
    private String mDescription;

    /** Location of object, usually a hyperlink if object has address **/
    private String mLocation;

    /** Image resource ID for the object **/
    private int mImageResourceId;

    /**
     * Create an Info object
     *
     * @param name is the title or name associated with Info object
     *
     * @param distance is how far the object is in miles from Newport, OR
     *
     * @param details is a short one-line detail about the object to draw interest from the user
     *
     * @param imageResourceId is the resource ID associated with the object
     *
     * @param description is a small paragraph about the object, either fun facts or info about amenities
     *
     * @param location is the address of the object, usually a hyperlink leading to a Maps app
     */
    public Info(String name, String distance, String details, int imageResourceId, String description, String location) {
        mName = name;
        mDistance = distance;
        mDetails = details;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mLocation = location;
    }

    /** Get the Name of the object **/
    public String getName() {
        return mName;
    }

    /** Get the Distance of the object **/
    public String getDistance() {
        return mDistance;
    }

    /** Get the Details of the object **/
    public String getDetails() {
        return mDetails;
    }

    /** Get the Description of the object **/
    public String getDescription() {
        return mDescription;
    }

    /** Get the Location of the object **/
    public String getLocation() {
        return mLocation;
    }

    /** Get the Image resource ID of the object **/
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
