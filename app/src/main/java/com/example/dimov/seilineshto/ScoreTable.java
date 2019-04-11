package com.example.dimov.seilineshto;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_DATE;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_NAME;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_ID;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_SCORE;
import static com.example.dimov.seilineshto.Contract.TodoList.SCORE_TABLE;

public class ScoreTable extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    private EditText addElementEditTextName;

    private ArrayList<Item> databaseItems = new ArrayList<>();

    //private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static boolean showCompleted = false;

    public static int DETAILS_ACTIVITY = 1;

    private String queryUri = Contract.CONTENT_URI.toString();
    private static final String[] projection = new String[]{Contract.CONTENT_PATH};
    private String selectionClause = null;
    private String selectionArgs[] = null;
    private String sortOrder = "ASC";

    String word = "";
    int id=-1;
    Cursor cursor;

    private void initializeElements(){
        recyclerView =  findViewById(R.id.recyclerView1);

    }

    private void initializeRecyclerView(){
        cursor = getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String Name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String Date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
            String score = cursor.getString(cursor.getColumnIndex(COLUMN_SCORE));
            Item item = new Item(Name, Date, score);
            databaseItems.add(item);
            cursor.moveToNext();
        }
        adapter = new RecyclerViewAdapter(this, databaseItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        initializeElements();
        initializeRecyclerView();








}
}
