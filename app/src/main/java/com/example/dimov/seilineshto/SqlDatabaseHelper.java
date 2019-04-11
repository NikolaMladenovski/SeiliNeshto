package com.example.dimov.seilineshto;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.dimov.seilineshto.Contract.DATABASE_NAME;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_DATE;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_NAME;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_ID;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_SCORE;
import static com.example.dimov.seilineshto.Contract.TodoList.SCORE_TABLE;


public class SqlDatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;


    public SqlDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + SCORE_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SCORE + " TEXT, " +
                COLUMN_DATE + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addItem(ContentValues values){
        SQLiteDatabase writable = getWritableDatabase();
        writable.insert(SCORE_TABLE, null, values);
        writable.close();
    }

    public void deleteItem(String date){

        SQLiteDatabase writable = getWritableDatabase();
        writable.execSQL("DELETE FROM " + SCORE_TABLE + " WHERE " + COLUMN_DATE + "=\"" + date + "\";");
        writable.close();
    }

    public Cursor findAll(){
        //ArrayList<Item> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + SCORE_TABLE;

        return db.rawQuery(query, null);
    }

    public Cursor findOne(int itemId){
        SQLiteDatabase db = getReadableDatabase();
        itemId++;
        String query = "SELECT * FROM " + SCORE_TABLE + " WHERE " + COLUMN_ID + "=\"" + itemId + "\";";
        return db.rawQuery(query, null);
    }

    public Cursor count(){
        SQLiteDatabase db = getReadableDatabase();
        MatrixCursor cursor = new MatrixCursor(new String[]{Contract.CONTENT_PATH});
        int count = (int) DatabaseUtils.queryNumEntries(db, SCORE_TABLE);
        cursor.addRow(new Object[]{count});
        return cursor;
    }



    public void updateName(ContentValues values){
        String oldItemName = values.getAsString("oldvalue");
        String newItemName = values.getAsString("newvalue");
        if(!oldItemName.equals(newItemName)){
            SQLiteDatabase writable = getWritableDatabase();
            String query = "UPDATE " + SCORE_TABLE + " SET " + COLUMN_NAME + "=\"" + newItemName + "\" WHERE " + COLUMN_NAME + "=\"" + oldItemName + "\";";
            writable.execSQL(query);
        }
    }
}
