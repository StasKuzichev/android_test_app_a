package com.rdc.androidtestappa;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.rdc.androidtestappa.db.LinkDBHelper;
import com.rdc.androidtestappa.domain.history.HistoryFragment;

public class LinksProvider extends ContentProvider {
    public static final String AUTHORITY = "links.com.rdc.androidtestappa";
    public static final String PATH_LINK_LIST = "LINK_NAME";
    public static final int LINKS_LIST = 1;
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        MATCHER.addURI(AUTHORITY, PATH_LINK_LIST, LINKS_LIST);
    }
    public static final String MIME_TYPE_1 = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + "vnd.com.rdc.androidtestappa.todos";

    private LinkDBHelper linkDBHelper;

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (MATCHER.match(uri)) {
            case LINKS_LIST:
                return MIME_TYPE_1;
        }
        return null;
    }


    @Override
    public boolean onCreate() {
        linkDBHelper = LinkDBHelper.getListDBAdapterInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {

        Cursor cursor = null;
        switch (MATCHER.match(uri)) {
            case LINKS_LIST:
                cursor = linkDBHelper.getCursorsForAllToDos();
                break;
            default:
                cursor = null;
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) throws UnsupportedOperationException {
        Uri returnUri = null;
        switch (MATCHER.match(uri)) {
            case LINKS_LIST:
                returnUri = insertToDo(uri, contentValues);
                break;
            default:
                new UnsupportedOperationException("insert operation not supported");
                break;
        }

        return returnUri;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) throws UnsupportedOperationException {
        int updateCount = -1;
        switch (MATCHER.match(uri)) {
            case LINKS_LIST:
                updateCount = update(contentValues, s, strings);
                break;
            default:
                new UnsupportedOperationException("insert operation not supported");
                break;
        }
        return updateCount;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) throws UnsupportedOperationException {
        int deleteCount = -1;
        switch (MATCHER.match(uri)) {
            case LINKS_LIST:
                deleteCount = delete(s, strings);
                break;
            default:
                new UnsupportedOperationException("delete operation not supported");
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    private int update(ContentValues contentValues, String whereCluase, String[] strings) {
        return linkDBHelper.update(contentValues, whereCluase, strings);
    }


    private Uri insertToDo(Uri uri, ContentValues contentValues) {
        long id = linkDBHelper.insert(contentValues);
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse("content://" + AUTHORITY + "/" + PATH_LINK_LIST + "/" + id);
    }

    private int delete(String whereClause, String[] whereValues) {
        return linkDBHelper.delete(whereClause, whereValues);
    }
}
