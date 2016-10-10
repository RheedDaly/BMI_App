package com.rheedkhadaly.familyweightmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_GENDER = "persons_gender";
    public static final String KEY_AGE = "persons_age";
    public static final String KEY_HEIGHT = "persons_height";
    public static final String KEY_WEIGHT = "persons_weight";
    public static final String KEY_BMI = "body_mass_index";

    private static final String DATABASE_NAME = "person";
    private static final String DATABASE_TABLE = "person_table";
    private static final int DATABASE_VERSION = 3;

    private DbHelper ourHelper;
    private final Context ourContext;
    private  SQLiteDatabase ourDatabase;

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String query = "CREATE TABLE " + DATABASE_TABLE + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_GENDER + " TEXT NOT NULL, " +
                    KEY_AGE + " INTEGER NOT NULL, " +
                    KEY_HEIGHT + " DOUBLE NOT NULL, " +
                    KEY_WEIGHT + " DOUBLE NOT NULL, " +
                    KEY_BMI + " DOUBLE NOT NULL " + ");";

            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            String query = "DROP TABLE IF EXISTS " + DATABASE_TABLE;

            db.execSQL(query);
            onCreate(db);
        }
    }

    public MyDatabase(Context context) {
        ourContext = context;
    }

    public MyDatabase open() {

        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long addPerson(Person person) {

        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, person.getPersonName());
        cv.put(KEY_GENDER, person.getPersonGender());
        cv.put(KEY_AGE, person.getPersonAge());
        cv.put(KEY_HEIGHT, person.getPersonHeight());
        cv.put(KEY_WEIGHT, person.getPersonWeight());
        cv.put(KEY_BMI, person.getPersonBMI());

        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String getPersonData() {
        String[] columns = new String[] {KEY_ROWID, KEY_NAME, KEY_GENDER, KEY_AGE, KEY_HEIGHT, KEY_WEIGHT, KEY_BMI};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

        int iRow_id = c.getColumnIndex(KEY_ROWID);
        int iRow_name = c.getColumnIndex(KEY_NAME);
        int iRow_gender = c.getColumnIndex(KEY_GENDER);
        int iRow_age = c.getColumnIndex(KEY_AGE);
        int iRow_height = c.getColumnIndex(KEY_HEIGHT);
        int iRow_weight = c.getColumnIndex(KEY_WEIGHT);
        int iRow_BMI = c.getColumnIndex(KEY_BMI);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iRow_id) + " " + c.getString(iRow_name) + " " + c.getString(iRow_gender) + " " + c.getString(iRow_age) +
                    " " + c.getString(iRow_height) + " " + c.getString(iRow_weight) + " " + c.getString(iRow_BMI) + "\n";

        }

        return result;
    }


}
