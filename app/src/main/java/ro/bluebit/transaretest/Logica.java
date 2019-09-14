package ro.bluebit.transaretest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import ro.bluebit.transaretest.database.Constructor;
import ro.bluebit.transaretest.database.DatabaseHelper;

public class Logica {
    public Logica() {
    }
//obtinere array cu denumirea materiilor prime
    public static List<String> getDenumiri(SQLiteDatabase db) {
        List<String> retDenumiri = new ArrayList<String>();
        String selectQuery = Constructor.SQL_QUERY_OBTI_DENUMIRE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                retDenumiri.add(cursor.getString(cursor.getColumnIndexOrThrow(Constructor.TabArticole.COL_3)));
            } while (cursor.moveToNext());
        }
        return retDenumiri;
    }
    public static int[] getImagini(SQLiteDatabase db) {
        String selectQuery = Constructor.SQL_QUERY_OBTI_DENUMIRE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int[] retArr = new int[cursor.getCount() ];
        if (cursor.moveToFirst()) {
            do {
                retArr[cursor.getPosition()]=R.drawable.porc;
            } while (cursor.moveToNext());
        }
        return retArr;
    }

    //obtinere array cu nr Cod_Int pentru materii prime
    public static int [] getCodInt(SQLiteDatabase db) {
        String selectQuery = Constructor.SQL_QUERY_OBTI_COD_INT;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int [] retCodInt= new int[cursor.getCount()];
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                //cursor.getInt(0)
                retCodInt[i] = cursor.getInt(0);
                cursor.moveToNext();

        }
//            do {
//                retCodInt[cursor.getCount()]= cursor.getInt(cursor.getColumnIndex("cod_int"));
//            }
//            while (cursor.moveToNext());
        }
        return retCodInt;


    }





}
