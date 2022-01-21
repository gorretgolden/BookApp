package com.example.booklibraryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookListActivity extends Activity {

    ListView l;
    String books[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;

        arr   = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                books);
        l.setAdapter(arr);

    }
}
