package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList of Mountain objects from the created class "Mountain"
        final List<Mountain> mountains = new ArrayList<>();

        //Populates list with 10 different mountain objects
        mountains.add(new Mountain("Matterhorn", 4478, "Alps"));
        mountains.add(new Mountain("Mont Blanc", 4808, "Alps"));
        mountains.add(new Mountain("Denali", 6190, "Alaska"));
        mountains.add(new Mountain("Mount Everest", 8848, "Himalayas"));
        mountains.add(new Mountain("K2", 8611, "Karakoram"));
        mountains.add(new Mountain("Kangchenjunga", 8586, "Himalayas"));
        mountains.add(new Mountain("Lhotse", 8516, "Himalayas"));
        mountains.add(new Mountain("Makalu", 8485, "Himalayas"));
        mountains.add(new Mountain("Cho Oyu", 8201, "Himalayas"));
        mountains.add(new Mountain("Dhaulagiri", 8167, "Himalayas"));

        //New ArrayList containing only the name of each mountain as a string
        List<String> mountainNames = new ArrayList<>();

        //Iterates through each mountian object and adds the name to the ArrayList representing names
        for(int i = 0; i < mountains.size(); i++) {
            mountainNames.add(mountains.get(i).getName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listitem_textview, R.id.item_textview, mountainNames);

        ListView listView = (ListView) findViewById(R.id.my_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Uses the functions in the created class "Mountain to get information about the clicked mountain
                String message =
                    "Name: " + mountains.get(i).getName() + "\n" +
                    "Height: " + mountains.get(i).getHeight() +
                    "m\nLocation: " + mountains.get(i).getLocation()
                ;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
