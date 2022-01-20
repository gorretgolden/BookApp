package com.example.booklibraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.booklibraryapp.DBHelper;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateBookActivity extends Activity {



    EditText book_title, book_author, book_pages;
    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_book_layout);



        book_title = (EditText) findViewById(R.id.bktitle);
        book_author = (EditText) findViewById(R.id.bkauthor);
        book_pages = (EditText) findViewById(R.id.bkpages);
        addBook = (Button) findViewById(R.id.createbook);


        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper myDB = new DBHelper(CreateBookActivity.this);
                myDB.addBook(book_title.getText().toString().trim(),book_author.getText().toString().trim(),Integer.parseInt(book_pages.getText().toString().trim()));

            }
        });
    }
}