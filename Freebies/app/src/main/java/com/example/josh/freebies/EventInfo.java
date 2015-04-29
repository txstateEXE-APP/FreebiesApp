package com.example.josh.freebies;

/**
 * Created by Josh Granberry on 4/13/2015.
 * This class stores information for users to submit new events.
 */
public class EventInfo {
    public String event_title;
    public String event_time;
    public String event_date;
    public String event_location;
    public String event_type;

    // Default Constructor
    public EventInfo() {
        event_title = "";
        event_time = "";
        event_location = "";
        event_type = "";
        event_date = "";
    }

    // Overloaded Constructor
    public EventInfo(String _title, String _time, String _location, String _type, String _date) {
        event_title = _title;
        event_time = _time;
        event_location = _location;
        event_type = _type;
        event_date = _date;
    }

    // Setters
    public void setEvent_title(String title) {
        event_title = title;
    }

    public void setEvent_time(String time) {
        event_time = time;
    }

    public void setEvent_date(String date) {
        event_date = date;
    }

    public void setEvent_location(String location) {
        event_location = location;
    }

    public void setEvent_type (String type) {
        event_type = type;
    }

    // Getters
    public String getEvent_title() {
        return event_title;
    }

    public String getEvent_time() {
        return event_time;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getEvent_location() {
        return event_location;
    }

    public String getEvent_type() {
        return event_type;
    }

    /*
    public void write_data()

     */
}