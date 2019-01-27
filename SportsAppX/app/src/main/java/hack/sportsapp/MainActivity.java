package hack.sportsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<event> eventList;

        //the recyclerview
        RecyclerView recyclerView;


            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();

        eventList.add(
                new event(
                        1,
                        "Rucker Park",
                        "6:30",
                        "Aggies",
                        R.drawable.baseline_add_circle_black_24dp));
        eventAdapter adapter = new eventAdapter(this, eventList);

        recyclerView.setAdapter(adapter);
    }
}
