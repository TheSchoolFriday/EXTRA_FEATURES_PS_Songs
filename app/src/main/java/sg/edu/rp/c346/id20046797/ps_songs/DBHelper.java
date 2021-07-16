package sg.edu.rp.c346.id20046797.ps_songs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "Songs";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SONG_TITLE = "title";
    private static final String COLUMN_SONG_SINGERS = "singers";
    private static final String COLUMN_SONG_YEAR = "year";
    private static final String COLUMN_SONG_STARS = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_TITLE + " TEXT,"
                + COLUMN_SONG_SINGERS + " TEXT,"
                + COLUMN_SONG_YEAR + " INTEGER, "
                + COLUMN_SONG_STARS + " INTEGER ) ";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");

//         Dummy records, to be inserted when the database is created
//        for (int i = 0; i< 4; i++) {
//            ContentValues values = new ContentValues();
//            values.put(COLUMN_NOTE_CONTENT, "Data number " + i);
//            db.insert(TABLE_NAME, null, values);
//        }
//        Log.i("info", "dummy records inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN  module_name TEXT ");
    }


    public long insertSongs (String title, String singer, int year, int stars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_TITLE, title);
        values.put(COLUMN_SONG_SINGERS, singer);
        values.put(COLUMN_SONG_YEAR, year);
        values.put(COLUMN_SONG_STARS, stars);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> Songs = new ArrayList<Song>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singers = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                Song song = new Song(id, title, singers, year, star);
                Songs.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return Songs;
    }

//    public ArrayList<Note> getAllNotes(String keyword) {
//        ArrayList<Note> notes = new ArrayList<Note>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns= {COLUMN_ID, COLUMN_NOTE_CONTENT};
//        String condition = COLUMN_NOTE_CONTENT + " Like ?";
//        String[] args = { "%" +  keyword + "%"};
//        Cursor cursor = db.query(TABLE_NAME, columns, condition, args,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String noteContent = cursor.getString(1);
//                Note note = new Note(id, noteContent);
//                notes.add(note);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return notes;
//    }
//
//
//    public int updateNote(Note data){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NOTE_CONTENT, data.getNoteContent());
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(data.getId())};
//        int result = db.update(TABLE_NAME, values, condition, args);
//        db.close();
//        return result;
//    }
//
//    public int deleteNote(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(id)};
//        int result = db.delete(TABLE_NAME, condition, args);
//        db.close();
//        return result;
//    }
}
