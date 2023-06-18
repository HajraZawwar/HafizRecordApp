package com.hajra.hafizrecordapp;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class dbhandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class1";
    private static final String COLUMN_SABAQ = "sabaq";

    private static final String COLUMN_SABAQI = "sabaqi";
    private static final String COLUMN_FINAL = "manzil";


    private static final String COLUMN_YESNO = "yes";

    private Context mycontext;
    public dbhandler(Context context) {

        super(context, DATABASE_NAME, null, 1);
        mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " INTEGER,"
                +COLUMN_SABAQ + "INTEGER,"
                +COLUMN_SABAQI+ "INTEGER,"
                +COLUMN_FINAL + "INTEGER,"
                +COLUMN_YESNO + "BOOLEAN"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(student s) {
        Toast.makeText(mycontext,"Hello World",Toast.LENGTH_LONG).show();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, s.getID());
        values.put(COLUMN_NAME, s.getName());
        values.put(COLUMN_AGE, s.getage());
        values.put(COLUMN_CLASS, s.getClass1());
        values.put(COLUMN_SABAQ, s.getSabaq());
        values.put(COLUMN_SABAQI, s.getSabaqi());
        values.put(COLUMN_FINAL, s.getManzil());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateStudent(student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, s.getID());
        values.put(COLUMN_NAME, s.getName());
        values.put(COLUMN_AGE, s.getage());
        values.put(COLUMN_CLASS, s.getClass1());
        values.put(COLUMN_SABAQ, s.getSabaq());
        values.put(COLUMN_SABAQI, s.getSabaqi());
        values.put(COLUMN_FINAL, s.getManzil());


        db.update(TABLE_NAME, values, COLUMN_ID+ " = ?", new String [] {String.valueOf(s.getID())});
        db.close();
    }

    public void deleteStudent(student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String [] {String.valueOf(s.getID())});
        db.close();
    }


    public List<student> selectAllStudents() {
        List<student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")  int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range")  String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  int age = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_AGE)) );
                @SuppressLint("Range")   int class1 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CLASS)));
                @SuppressLint("Range")  int sabaq = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_SABAQ)));
                @SuppressLint("Range")  int sabaqi = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_SABAQI)));
                @SuppressLint("Range")  int manzil = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_FINAL)));
                @SuppressLint("Range") boolean yes = cursor.getInt(cursor.getColumnIndex(COLUMN_YESNO))>0;

                students.add(new student(id, name, age, class1, sabaq, sabaqi, manzil, yes));
            } while (cursor.moveToNext());
        }



        cursor.close();
        db.close();

        return students;
    }

    public student selectStudent(int id) {

        student s;
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + String.valueOf(id);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        * */


            cursor.moveToFirst();
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            @SuppressLint("Range") int age = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_AGE)));
            @SuppressLint("Range") int class1 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CLASS)));
            @SuppressLint("Range") int sabaq = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_SABAQ)));
            @SuppressLint("Range") int sabaqi = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_SABAQI)));
            @SuppressLint("Range") int manzil = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_FINAL)));
            @SuppressLint("Range") boolean yes = cursor.getInt(cursor.getColumnIndex(COLUMN_YESNO)) > 0;

            cursor.close();
            db.close();

            s = new student(id, name, age, class1, sabaq, sabaqi, manzil, yes);

            return s;



    }
}
