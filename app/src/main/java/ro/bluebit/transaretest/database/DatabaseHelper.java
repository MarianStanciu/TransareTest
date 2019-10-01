package ro.bluebit.transaretest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

        public final static int VERSIUNE_BAZA_DE_DATE = 14;

        public DatabaseHelper(Context context) {
            super(context, Constructor.DATABASE_NAME, null, VERSIUNE_BAZA_DE_DATE);
  //          SQLiteDatabase db = this.getWritableDatabase();
            Log.e("Baza de date", "baza de date " + getDatabaseName() + " a fost creata/deschisa");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Constructor.TabArticole.SQL_CREAZA_TABEL_ARTICOLE);
            Log.e("tabele" , "tabel Articole creat");
            db.execSQL(Constructor.TabAntetLegaturi.SQL_CREZA_TABEL_ANTET_LEGATURI);
            Log.e("tabele" , "tabel Antet legaturi creat");
            db.execSQL(Constructor.TabPozitiiLegaturi.SQL_CREZA_TABEL_POZITII_LEGATURI);
            Log.e("tabele" , "tabel pozitii legaturi creat");
            db.execSQL(Constructor.TabAntetTransare.SQL_CREAZA_TABEL_ANTET_TRANSARE);
            Log.e("tabele" , "tabel antet transare creat");
            db.execSQL(Constructor.TabPozitiiTransare.SQL_CREAZA_TABEL_POZITII_TRANSARE);
            Log.e("tabele" , "tabel pozitii transare creat");
            db.execSQL(Constructor.TabTip.SQL_CREAZA_TABEL_TIP);
            Log.e("tabele", "tabel tip a fost creat");
            db.execSQL(Constructor.SQL_CREAZA_TABEL_REGISTER_USER);
            Log.e("tabele", "tabel REGISTER USER a fost creat");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabArticole.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabAntetLegaturi.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabPozitiiLegaturi.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabArticole.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabAntetTransare.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabPozitiiTransare.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabTip.NUME_TABEL);
            db.execSQL("DROP TABLE IF EXISTS " + Constructor.TabUserPassword.NUME_TABEL );
            onCreate(db);

            Log.e("Baza de date", "baza de date :"  + " au fost inserate date pentru test");
            // introducere date pentru test
            String sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200012546, 'CARCASA OVINA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200024255, 'CARCASA PORC', 1)";
            db.execSQL(sqlSir);
            sqlSir= "INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200058509, 'CARCASA VITA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200296684, 'CAP DE PORC', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200296686, 'PUI INTREG', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200296688, 'PULPA PUI CU OS MATERIE PRIMA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200296690, 'PIEPT PUI CU OS MATERIE PRIMA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200296692, 'PULPE SUPERIOARE CURCA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200428368, 'CARNE VITA', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200661580, 'ORGANE VITA', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200804028, 'COSTITA PORC', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200809260, 'PULPA SUPERIOARA CURCAN CU OS SI PIELE', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200819098, 'PUI GRILL MATERIE PRIMA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200823530, 'SFERT PULPA PC', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200855445, 'SFERT PULPA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200855447, 'SFERT PULPA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200864198, 'SFERT ANTERIOR', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200871783, 'COTLET PORC DEZOSAT CU SORIC', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200914948, 'PULPA OAIE FARA OS', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200915224, 'PULPA OAIE MATERIE PRIMA', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200930920, 'CARCASA MIEL', 1)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200996625, 'PULPA LUCRU MISTRET', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200996629, 'PULPA LUCRU CERB', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200996649, 'PULPA LUCRU CURCA', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200996878, 'VANAT CALIT I', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200997015, 'ORGANE PUI', 2)";
            db.execSQL(sqlSir);
            sqlSir="INSERT INTO articole (cod_int, denumire, id_tip) VALUES   (200997185, 'PULMO', 2)";
            db.execSQL(sqlSir);



        }
         public long addUser (String user, String password){
            SQLiteDatabase db = this.getWritableDatabase();
             ContentValues cv = new ContentValues();
             cv.put("username", user);
             cv.put("password", password);
            long res =db.insert(Constructor.TabUserPassword.NUME_TABEL,null,cv);
            db.close();
            return res;
         }
         public boolean checkUser (String username, String password){
            String [] columns ={Constructor.TabUserPassword.COL_1};
            SQLiteDatabase db = getReadableDatabase();
            String selection = (Constructor.TabUserPassword.COL_2 + "=?" + " and " + Constructor.TabUserPassword.COL_3 + "=?");
            String [] selectionArgs = {username, password};
             Cursor cursor = db.query(Constructor.TabUserPassword.NUME_TABEL, columns, selection, selectionArgs,null,null,null);
             int count = cursor.getCount();
             cursor.close();
             db.close();
             if (count>0)
                 return true;
             else
                 return false;
         }

//    public List<String> getDenumiri() {
//        List<String> retDenumiri = new ArrayList<String>();
//        String selectQuery = Constructor.SQL_QUERY_OBTI_DENUMIRE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                retDenumiri.add(cursor.getString(cursor.getColumnIndexOrThrow(Constructor.TabArticole.COL_3)));
//            } while (cursor.moveToNext());
//        }
//        return retDenumiri;
//    }

        public List<String> getCodInt() {
            List<String> retCodInt = new ArrayList<String>();
            String selectQuery = Constructor.SQL_QUERY_OBTI_COD_INT;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    retCodInt.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            return retCodInt;


        }
//        String[] denumiri;
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            String selectQuery = Constructor.SQL_QUERY_OBTI_DENUMIRE;
//             Cursor cursor = db.rawQuery(selectQuery, null);
//            if (cursor.moveToFirst()) {
//                    denumiri = new String[cursor.getCount()];
//                    int colIndex = cursor.getColumnIndex("denumiri");
//                    do {
//                        denumiri[cursor.getPosition()] = cursor.getString(colIndex);
//                    } while (cursor.moveToNext());
//                }



}


