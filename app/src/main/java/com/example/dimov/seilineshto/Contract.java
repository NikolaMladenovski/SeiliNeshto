package com.example.dimov.seilineshto;



import android.net.Uri;
import android.provider.BaseColumns;

public final class Contract {
    private Contract(){}

    public static final String DATABASE_NAME = "score.db";

    public static final int ALL_ITEMS = -2;
    public static final String COUNT = "count";

    public static final String AUTHORITY = "com.example.dimov.seilineshto.provider";
    public static final String CONTENT_PATH = "words";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);
    public static final Uri ROW_COUNT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + COUNT);

    public static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.provider.words";
    public static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.provider.words";

    public static abstract class TodoList implements BaseColumns{
        public static final String SCORE_TABLE = "score_table";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "user_name";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_SCORE = "score";
    }
}
