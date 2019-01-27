package hack.sportsapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String DATABASE_NAME = "usersdb";

    SQLiteDatabase mDatabase;
    public ArrayList eventsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);


//        createEventsTable();

    }
    public void readEventOnClick(View view)
    {
        String [] text = readEvent();

        ((TextView) findViewById(R.id.textViewCard)).setText(text[0]);
    }
    public String[] readEvent()
    {
        mDatabase = openOrCreateDatabase("usersdb", MODE_PRIVATE, null);
        String selectQuery = "SELECT * FROM events";
        SQLiteDatabase db = mDatabase;
        Cursor cursor = db.rawQuery(selectQuery, null);
        String [] data = null;

        if(cursor.moveToFirst()){

            do{
                eventsList.add(new Events(cursor.getString(0), cursor.getString(1) ,cursor.getString(2)));

            }while(cursor.moveToNext());
        }
        cursor.close();
        return data;

    }

    public void createEventsTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS events (\n" +
                        " eventName varchar(30) NOT NULL PRIMARY KEY, \n" +
                        " date datetime NOT NULL, \n" +
                        " location varchar(45) NOT NULL \n" + ")" +
                        ";"
        );
    }

}
 class Events
{
    String Event;
    String Date;
    String Location;
    public Events(String eventName, String location, String date) {
        this.Event = eventName;
        this.Location = location;
        this.Date = date;
    }
};