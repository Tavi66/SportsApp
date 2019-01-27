package hack.sportsapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String DATABASE_NAME = "usersdb";

    EditText EventName;
    EditText event, location;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
    }

    private void addEvent(){}

    private void createEventsTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS events (\n" +
                        " id int NOT NULL PRIMARY KEY, \n" +
                        " eventName varchar(30) NOT NULL, \n" +
                        " date datetime NOT NULL, \n" +
                        " location varchar(45) NOT NULL \n" +
                ");"
        );
    }
}
