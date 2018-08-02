package com.rdc.androidtestappa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.domain.history.HistoryPresenter;

import java.util.LinkedList;
import java.util.List;


public class LinkDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "links.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Link";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LINK_URL = "url";
    public static final String COLUMN_LINK_STATUS = "status";
    public static final String COLUMN_LINK_DATE = "date";

    private SQLiteDatabase sqLliteDatabase;
    private static LinkDBHelper toDoListDBAdapterInstance;
    Context context;

    public LinkDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sqLliteDatabase = this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LINK_URL + " TEXT NOT NULL, " +
                COLUMN_LINK_STATUS + " NUMBER NOT NULL, " +
                COLUMN_LINK_DATE + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public static LinkDBHelper getListDBAdapterInstance(Context context) {
        if (toDoListDBAdapterInstance == null) {
            toDoListDBAdapterInstance = new LinkDBHelper(context);
        }
        return toDoListDBAdapterInstance;
    }


    //content provider's methods
    public Cursor getCursorsForAllToDos() {
        Cursor cursor = sqLliteDatabase.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_LINK_URL, COLUMN_LINK_STATUS, COLUMN_LINK_DATE}, null, null, null, null, null, null);
        return cursor;
    }


    public long insert(ContentValues contentValues) {
        return sqLliteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public int delete(String whereClause, String[] whereValues) {
        return sqLliteDatabase.delete(TABLE_NAME, whereClause, whereValues);
    }

    public int update(ContentValues contentValues, String s, String[] strings) {
        return sqLliteDatabase.update(TABLE_NAME, contentValues, s, strings);
    }


    /**
     * Query records, give options to filter results
     **/
    public List<Link> linksList(String filter) {
        String query;
        if (filter.equals("")) {
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        } else {
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + filter;
        }

        List<Link> urlsLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Link link;

        if (cursor.moveToFirst()) {
            do {
                link = new Link();

                link.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                link.setUrl(cursor.getString(cursor.getColumnIndex(COLUMN_LINK_URL)));
                link.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_LINK_STATUS)));
                link.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_LINK_DATE)));
                urlsLinkedList.add(link);
            } while (cursor.moveToNext());
        }


        return urlsLinkedList;
    }


    public Link getLink(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id=" + id;
        Cursor cursor = db.rawQuery(query, null);

        Link receivedLink = new Link();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedLink.setUrl(cursor.getString(cursor.getColumnIndex(COLUMN_LINK_URL)));
            receivedLink.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_LINK_STATUS)));
            receivedLink.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_LINK_DATE)));

        }
        return receivedLink;

    }


    /**
     * delete record
     **/
    public void deleteLinkRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE _id='" + id + "'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**
     * update record
     **/
    public void updateLinkRecord(long personId, Context context, Link updatedLink) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        db.execSQL("UPDATE  " + TABLE_NAME + " SET url ='" + updatedLink.getUrl() + "', status ='" + updatedLink.getStatus() + "'  WHERE _id='" + personId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }


}
