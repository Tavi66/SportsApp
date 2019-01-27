package hack.sportsapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddEventActivity extends AppCompatActivity {

    EditText editTextEventName, eventLocation, eventDate;
    SQLiteDatabase mDatabase;

    public void addEvent(View view)
    {
        editTextEventName = (EditText) findViewById(R.id.EventName);
        eventDate = (EditText) findViewById(R.id.editTextDate);
        String eventName = editTextEventName.getText().toString().trim();
        String date = eventDate.getText().toString();
        String insertSQL = "INSERT INTO events \n" +
                "DEFAULT VALUES);";

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }
}
