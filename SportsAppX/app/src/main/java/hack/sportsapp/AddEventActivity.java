package hack.sportsapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {

    EditText editTextEventName, eventLocation;
    Calendar eventDate;
    SQLiteDatabase mDatabase;

    public void addEvent(View view)
    {
        editTextEventName = (EditText) findViewById(R.id.EventName);
        eventLocation = (EditText) findViewById(R.id.editTextLocation);
        String eventName = editTextEventName.getText().toString();
        String location = eventLocation.getText().toString();
//        Calendar cal = eventDate.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
        String date = "2019-01-10";

        mDatabase = openOrCreateDatabase("usersdb", MODE_PRIVATE, null);
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS events (\n" +
                        " eventName varchar, date datetime, location varchar\n" + ")" +
                        ";"
        );
        String insertSQL = "INSERT INTO events \n" +
               // "(eventName, date, location)\n" +
                //"VALUES(eventName,date,location);";
                "VALUES\n" + "('" + eventName + "','" + date + "','" + location + "');";
        mDatabase.execSQL(insertSQL);

        //Toast.makeText(this, "Event Added Successfully!", Toast.LENGTH_SHORT);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        //editTextEventName = "Event";
        //eventLocation = "Event";
    }
}