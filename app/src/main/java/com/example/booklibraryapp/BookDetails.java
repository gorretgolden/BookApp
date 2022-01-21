package com.example.booklibraryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class BookDetails extends Activity {


    String[] mainTitle = {"Android Java", "Python", "Graphics Design", "    Data Science", "Web Development"};
    String[] subtitle = {"Beginners' book", "Database and APIs ", "Beginners' crash course", "Pandas and Machine Learning", "HTML, CSS basics and JS "};
    Integer[] imageId = {R.drawable.book2, R.drawable.book2, R.drawable.book2, R.drawable.book2, R.drawable.book2};
    ListView lv;
//    Button btn,btnBuy,addFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details_layout);



       ListAdapterView adapter = new ListAdapterView(this, mainTitle, subtitle, imageId);
        lv = (ListView) findViewById(R.id.list2);
        lv.setAdapter(adapter);




        //selecting each list item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub
            if(position == 0) {

                Toast.makeText(getApplicationContext(),"Choose book 1",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),BookOneActivity.class);
                startActivity(intent);
            }
            else if(position == 1) {

                Toast.makeText(getApplicationContext(),"Choose book 2",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(), BookTwoActivtity.class);
                startActivity(intent1);
            }
            else if(position == 2) {
                Toast.makeText(getApplicationContext(),"Choose book 3",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(),BookThreeActivity.class);
                startActivity(intent2);
            }
            else if(position == 3) {
                Toast.makeText(getApplicationContext(),"Choose book 4",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getApplicationContext(),BookFourActivity.class);
                startActivity(intent3);
            }
            else if(position == 4) {
                Toast.makeText(getApplicationContext(),"Choose book 5",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(getApplicationContext(),BookFiveActivity.class);
                startActivity(intent4);
            }
        }
    });

    }
}
