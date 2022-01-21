package com.example.booklibraryapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ListAdapterView extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;
//    Button btnAdd,btnBuy;

//super class for the array adapter view
    public ListAdapterView(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid) {
        super(context, R.layout.listview_components_layoyt, maintitle);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;
//        this.btnAdd = btnAdd;
//        this.btnBuy = btnBuy;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_components_layoyt, null,true);
        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
//        Button addBook = (Button) rowView.findViewById(R.id.btnAdd) ;
//        Button buyBook = (Button) rowView.findViewById(R.id.buy) ;
        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);
        return rowView;
    };
}
