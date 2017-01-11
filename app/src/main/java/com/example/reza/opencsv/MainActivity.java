package com.example.reza.opencsv;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //initialize ListView and its item
    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup ListView, put items on the list
        listView = (ListView) findViewById(R.id.list_view);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.single_list_item);


        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.stolpersteine);
        CSVReader csvReader = new CSVReader(inputStream);
        List<String[]> stolpersteineList = csvReader.read();

        for (String [] stolpersteineData : stolpersteineList){
            itemArrayAdapter.add(stolpersteineData);
        }
    }


}
