package com.example.dimov.seilineshto;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.example.dimov.seilineshto.Contract.MULTIPLE_RECORDS_MIME_TYPE;
import static com.example.dimov.seilineshto.Contract.SINGLE_RECORD_MIME_TYPE;

public class sqlContentProvider extends ContentProvider {

    private static final String TAG = "sqlContentProvider";

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private SqlDatabaseHelper db;

    private static final int URI_ALL_ITEMS_CODE = 10;
    private static final int URI_ONE_ITEM_CODE = 20;
    private static final int URI_COUNT_CODE = 30;

    @Override
    public boolean onCreate() {
        db = new SqlDatabaseHelper(getContext());
        initializeUriMatching();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = null;

        switch (uriMatcher.match(uri)){
            case URI_ALL_ITEMS_CODE:
                cursor = db.findAll();
                break;
            case URI_ONE_ITEM_CODE:
                cursor = db.findOne(Integer.parseInt(uri.getLastPathSegment()));
                break;
            case URI_COUNT_CODE:
                cursor = db.count();
                break;
            case UriMatcher.NO_MATCH:
                Log.d(TAG, "URI MATCHING FAILED");
                break;
            default:
                Log.d(TAG, "URI MATCHING FAILED");
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch(uriMatcher.match(uri)){
            case URI_ALL_ITEMS_CODE:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case URI_ONE_ITEM_CODE:
                return SINGLE_RECORD_MIME_TYPE;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        db.addItem(values);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        db.deleteItem(selectionArgs[0]);
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

        if(selection.equals("todoName")){
            db.updateName(values);
        }
        return 0;
    }

    private void initializeUriMatching(){
        uriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH, URI_ALL_ITEMS_CODE);
        uriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH + "/#", URI_ONE_ITEM_CODE);
        uriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH + "/" + Contract.COUNT, URI_COUNT_CODE);
    }
}

