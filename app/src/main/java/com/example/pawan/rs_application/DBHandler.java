package com.example.pawan.rs_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pawan on 14-Aug-16.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 7;
    private static final String DB_NAME = "DATABASE";
    private static final String TABLE_NOTES = "NOTES";

    private static final String KEY_NAME = "Name";
    private static final String KEY_TEXT = "Text";
    private static final String KEY_TIME = "Time";
    private static final String KEY_DATE = "Date";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTES_TABLE = "Create Table " + TABLE_NOTES + "("
                + KEY_NAME + " Text,"
                + KEY_TEXT + " Text,"
                + KEY_DATE + " Text,"
                + KEY_TIME + " Text,"
                + "Primary Key( " + KEY_DATE + ", " + KEY_TIME + "))";

        db.execSQL(CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }

    public void new_note(String Name, String Text, String Time, String Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, Name);
        values.put(KEY_TEXT, Text);
        values.put(KEY_TIME, Time);
        values.put(KEY_DATE, Date);

        db.insert(TABLE_NOTES, null, values);
        db.close();
    }

    public void delete_note(String Date, String Time) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "delete from " + TABLE_NOTES + " where " + KEY_DATE + " = " + Date + " AND " + KEY_TIME + " = " + Time;
        Cursor csr = db.rawQuery(query, null);
        csr.close();
        db.close();
    }

    public int get_count(){
        SQLiteDatabase db = this.getReadableDatabase();

        String count_query = "Select * from " + TABLE_NOTES;
        Cursor csr = db.rawQuery(count_query,null);
        int count = csr.getCount();

        db.close();
        csr.close();

        return count;
    }


    public String[][] get_notes() {
        SQLiteDatabase db = this.getReadableDatabase();

        String data[][];
        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        data = new String[4][count];
        int i = 0;
        while (count > 0) {
            data[0][i] = csr.getString(0);
            data[1][i] = csr.getString(1);
            data[2][i] = csr.getString(2);
            data[3][i] = csr.getString(3);
            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return data;
    }

    public String[] get_single_note(int position){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] pos_note = new String[4];
        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        int i = 0;
        while (count > 0) {
            if(i==position){
                pos_note[0] = csr.getString(0);
                pos_note[1] = csr.getString(1);
                pos_note[2] = csr.getString(2);
                pos_note[3] = csr.getString(3);
            }

            i++;
            csr.moveToNext();
            count--;
        }
        csr.close();
        db.close();
        return pos_note;
    }

    public String[] get_name() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String [] name = new String[count];

        int i = 0;
        while (count > 0) {
            name[i] = csr.getString(0);
            i++;
            csr.moveToNext();
            count--;
        }

        csr.close();
        db.close();
        return name;
    }

    public String[] get_text() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String [] text = new String[count];

        int i = 0;
        while (count > 0) {
            text[i] = csr.getString(1);
            i++;
            csr.moveToNext();
            count--;
        }

        csr.close();
        db.close();
        return text;
    }

    public String[] get_date() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String [] date = new String[count];

        int i = 0;
        while (count > 0) {
            date[i] = csr.getString(2);
            i++;
            csr.moveToNext();
            count--;
        }

        csr.close();
        db.close();
        return date;
    }

    public String[] get_time() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NOTES;
        Cursor csr = db.rawQuery(query, null);
        csr.moveToFirst();
        int count = csr.getCount();
        String [] time = new String[count];

        int i = 0;
        while (count > 0) {
            time[i] = csr.getString(3);
            i++;
            csr.moveToNext();
            count--;
        }

        csr.close();
        db.close();
        return time;
    }
}
