package com.example.josh.freebies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/*
      Todo: Add a guard to prevent submitting without appropriate fields filled
      Todo: Default radio group button selection
      Todo: Add GPS/Maps integration
      Todo: Pretty up the time/date pickers
      Todo: Change the time/date recording formats to something useful
      Todo: Write the EventInfo somewhere.
 */

public class EventSubmission extends MainActivity {

    String event_type = "default";
    EventInfo new_event = new EventInfo();
    public static final String TAG = "MyActivity"; // Debug

    String event_time; //Global to pass selected time from picker to submission function
    String event_date;

    RadioGroup radioType;        //Holds reference to radio Type group

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_submission);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioType);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_event_type_merch:
                        // do operations specific to this selection
                        event_type = "merch";
                        break;

                    case R.id.radio_event_type_food:
                        // do operations specific to this selection
                        event_type = "food";
                        break;
                }


            }
        });
    }

    // TIME PICKER
    public class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Save the time. Feel free to change this into a useable format.
            event_time = hourOfDay + ":" + minute;
            // Update the text on the time picker button.
            Button button = (Button)findViewById(R.id.timePickerButton);
            button.setText(event_time);
        }
    }


    // DATE PICKER
    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Save the date. Feel free to change this to a useable format.
            event_date = "" + year + "/" + month + "/" + day;
            // Update the text on the date picker button.
            Button button = (Button)findViewById(R.id.datePickerButton);
            button.setText(event_date);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Event data should be collected and written here
        /* Notes: Need to add in guard to prevent submission before required fields filled or
                  radio button has been selected.
        */

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void submit_event(View view) {
        // Grab the text field input
        EditText locationEdit;
        EditText titleEdit;

        locationEdit = (EditText) findViewById(R.id.event_location_text);
        titleEdit = (EditText) findViewById(R.id.event_title_text);

        Log.v("EditText", locationEdit.getText().toString());
        Log.v("EditText", titleEdit.getText().toString());

        //Grab the selected radio button
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioType);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_event_type_merch:
                        // do operations specific to this selection
                        event_type = "merch";
                        break;

                    case R.id.radio_event_type_food:
                        // do operations specific to this selection
                        event_type = "food";
                        break;
                }


            }
        });

        // Put input into Event class
        new_event.setEvent_location(locationEdit.toString());
        new_event.setEvent_title(titleEdit.toString());
        new_event.setEvent_time(event_time);
        new_event.setEvent_date(event_date);
        new_event.setEvent_type(event_type);

        // Pass that object.... somewhere.

        // Testing
        TextView typeTest = (TextView) findViewById(R.id.textViewType);
        typeTest.setText("Type: " + event_type);

        TextView titleTest = (TextView) findViewById(R.id.textViewTitle);
        titleTest.setText("Title: " + titleEdit.getText().toString());

        TextView locationTest = (TextView) findViewById(R.id.textViewLocation);
        locationTest.setText("Location: " + locationEdit.getText().toString());

        TextView timeTest = (TextView) findViewById(R.id.textViewTime);
        timeTest.setText("Time: " + event_time + " Date: " + event_date);


    }

}
