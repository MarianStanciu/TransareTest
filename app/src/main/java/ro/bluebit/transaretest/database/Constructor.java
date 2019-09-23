package ro.bluebit.transaretest.database;

import android.provider.BaseColumns;

public class Constructor {
    private Constructor() {
    }

    //definitie baza de date
    public static final String DATABASE_NAME = "TransCarne.db";

    // tipuri de date - inspirat din programul lui Traian
//date locale
    public static abstract class Tip {
        public static final String INTREG = " integer not null default 0 ";
        public static final String PRIMARY = " integer primary key ";
        public static final String PRIMARY_AUTO = " integer primary key autoincrement ";
        public static final String TEXT = " text not null default \'\' ";
        public static final String DATA = " date not null default current_date ";
        public static final String VALOARE = " numeric not null default 0.000000 ";
        public static final String TIMESTAMP = " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ";
//        public static final String USER = "text not null ";
//        public static final String PASSWORD = "text not null ";
    }

    // tipuri de date pt server-----------
    public static abstract class STypes {
        public static final String INTREG = "INTREG";
        public static final String STRING = "STRING";
        public static final String VALOARE = "VALOARE";
        public static final String DATA = "DATA";
        public static final String DTOS = "DTOS"; // data in format aaaallzz
    }

    //TABELA SERVER - ESTE IDENTICA CU CEA LOCALA DOAR CA PRIMESTE PREFIXUL S LA TOATE DENUMIRILE
//tabel 1 ARTICOLE
    public static final class TabArticole implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "articole";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "cod_int";
        public static final String COL_3 = "denumire";
        public static final String COL_4 = "id_tip";
        //TABELA SERVER
        public static final String SNUME_TABEL = "articole";
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "cod_int";
        public static final String SCOL_3 = "denumire";
        public static final String SCOL_4 = "id_tip";

        //SQL CREARE TABEL
        public static final String SQL_CREAZA_TABEL_ARTICOLE = ("create table if not exists " +
                TabArticole.NUME_TABEL + "(" +
                TabArticole.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabArticole.COL_2 + Tip.INTREG + " , " +
                TabArticole.COL_3 + Tip.TEXT + " , " +
                TabArticole.COL_4 + Tip.INTREG + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabArticole.SCOL_1 + " , " +
                        TabArticole.SCOL_2 + " , " +
                        TabArticole.SCOL_3 + " , " +
                        TabArticole.SCOL_4;/* daca este nevoie sa adaugam si timestamp o vom face ulterior*/

    }
//tabel 2 - ANTET LEGATURI

    public static final class TabAntetLegaturi implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "antet_legaturi";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "cod_int";
        public static final String COL_3 = "id_articol";
        public static final String COL_4 = "Id_tip";
        //TABELA SERVER
        public static final String SNUME_TABEL = "antet_legaturi";
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "cod_int";
        public static final String SCOL_3 = "id_articol";
        public static final String SCOL_4 = "Id_tip";
        //SQL CREARE TABEL
        public static final String SQL_CREZA_TABEL_ANTET_LEGATURI = ("create table if not exists " +
                TabAntetLegaturi.NUME_TABEL + "(" +
                TabAntetLegaturi.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabAntetLegaturi.COL_2 + Tip.INTREG + " , " +
                TabAntetLegaturi.COL_3 + Tip.INTREG + " , " +
                TabAntetLegaturi.COL_4 + Tip.INTREG + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabAntetLegaturi.SCOL_1 + " , " +
                        TabAntetLegaturi.SCOL_2 + " , " +
                        TabAntetLegaturi.SCOL_3 + " , " +
                        TabAntetLegaturi.SCOL_4;
    }

    //tabel 3  POZITII LEGATURI
    public static final class TabPozitiiLegaturi implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "pozitii_legaturi";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "cod_int";
        public static final String COL_3 = "id_articol";
        public static final String COL_4 = "id_antet";
        //TABELA SERVER
        public static final String SNUME_TABEL = "pozitii_legaturi";
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "cod_int";
        public static final String SCOL_3 = "id_articol";
        public static final String SCOL_4 = "id_antet";
        //SQL CREARE TABEL
        public static final String SQL_CREZA_TABEL_POZITII_LEGATURI = (" create table if not exists " +
                TabPozitiiLegaturi.NUME_TABEL + "(" +
                TabPozitiiLegaturi.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabPozitiiLegaturi.COL_2 + Tip.INTREG + " , " +
                TabPozitiiLegaturi.COL_3 + Tip.INTREG + " , " +
                TabPozitiiLegaturi.COL_4 + Tip.INTREG + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabPozitiiLegaturi.SCOL_1 + " , " +
                        TabPozitiiLegaturi.SCOL_2 + " , " +
                        TabPozitiiLegaturi.SCOL_3 + " , " +
                        TabPozitiiLegaturi.SCOL_4;
    }

    //tabel 4   ANTET TRANSARE
// din aplicatia android - vor fi introduse de utilizator
    public static final class TabAntetTransare implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "antet_transare";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "id_antet_legatura";
        public static final String COL_3 = "nr_factura";
        public static final String COL_4 = "data_ora";
        // de introdus cant de mat prima ca si coloana
        //TABELA SERVER
        public static final String SNUME_TABEL = "antet_transare";
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "id_antet_legatura";
        public static final String SCOL_3 = "nr_factura";
        public static final String SCOL_4 = "data_ora";
        //SQL CREARE TABEL
        public static final String SQL_CREAZA_TABEL_ANTET_TRANSARE = ("create table if not exists " +
                TabAntetTransare.NUME_TABEL + "(" +
                TabAntetTransare.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabAntetTransare.COL_2 + Tip.INTREG + " , " +
                TabAntetTransare.COL_3 + Tip.TEXT + " , " +
                TabAntetTransare.COL_4 + Tip.DATA + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabAntetTransare.SCOL_1 + " , " +
                        TabAntetTransare.SCOL_2 + " , " +
                        TabAntetTransare.SCOL_3 + " , " +
                        TabAntetTransare.SCOL_4;
    }
//tabel 5   POZITII TRANSARE
// din aplicatia android - vor fi introduse de utilizator

    public static final class TabPozitiiTransare implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "pozitii_transare";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "id_pozitii_transare"; // de anulat
        public static final String COL_3 = "cantitate";
        public static final String COL_4 = "id_pozitii_legatura";
        public static final String COL_5 = "Id_antet_transare";
        //TABELA SERVER
        public static final String SNUME_TABEL = "pozitii_transare";
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "id_pozitii_transare";
        public static final String SCOL_3 = "cantitate";
        public static final String SCOL_4 = "id_pozitii_legatura";
        public static final String SCOL_5 = "Id_antet_transare";
        //SQL CREARE TABEL
        public static final String SQL_CREAZA_TABEL_POZITII_TRANSARE = ("create table if not exists " +
                TabPozitiiTransare.NUME_TABEL + "(" +
                TabPozitiiTransare.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabPozitiiTransare.COL_2 + Tip.INTREG + " , " +
                TabPozitiiTransare.COL_3 + Tip.VALOARE + " , " +
                TabPozitiiTransare.COL_4 + Tip.INTREG + " , " +
                TabPozitiiTransare.COL_5 + Tip.INTREG + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabPozitiiTransare.SCOL_1 + " , " +
                        TabPozitiiTransare.SCOL_2 + " , " +
                        TabPozitiiTransare.SCOL_3 + " , " +
                        TabPozitiiTransare.SCOL_4 + " , " +
                        TabPozitiiTransare.SCOL_5;
    }

//tabel 6 TIPURI

    public static final class TabTip implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "tip";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "cod_int";
        public static final String COL_3 = "denumire";
        //TABELA SERVER
        public static final String SCOL_1 = "_id";
        public static final String SCOL_2 = "cod_int";
        public static final String SCOL_3 = "denumire";
        //SQL CREARE TABEL
        public static final String SQL_CREAZA_TABEL_TIP = (" create table if not exists " +
                TabTip.NUME_TABEL + " ( " +
                TabTip.COL_1 + Tip.PRIMARY_AUTO + " , " +
                TabTip.COL_2 + Tip.INTREG + " , " +
                TabTip.COL_3 + Tip.TEXT + ")");
        //SQL SINCRONIZARE
        public static final String COL_SINCRO_SERVER =
                TabTip.SCOL_1 + " , " +
                        TabTip.SCOL_2 + " , " +
                        TabTip.SCOL_3;
    }


    //tabela pentru parole si user
    public static final class TabUserPassword implements BaseColumns {
        //TABELA LOCALA
        public static final String NUME_TABEL = "register_user";
        public static final String COL_1 = "_id";
        public static final String COL_2 = "username";
        public static final String COL_3 = "password";
    }
    //sql creare tabel
    public static final String SQL_CREAZA_TABEL_REGISTER_USER = (" create table if not exists " +
            TabUserPassword.NUME_TABEL + " ( " +
            TabUserPassword.COL_1 + Tip.PRIMARY_AUTO + " , " +
            TabUserPassword.COL_2 + Tip.TEXT + " , " +
            TabUserPassword.COL_3 + Tip.TEXT + ")");



    //sql  interogare tabel Articole

    public static  final String SQL_QUERY_OBTI_DENUMIRE = (
            "SELECT "+ TabArticole.COL_3+ " FROM " +TabArticole.NUME_TABEL+ " WHERE " + TabArticole.COL_4 + "=1"    );
    //sql  interogare tabel Articole

    public static  final String SQL_QUERY_OBTI_COD_INT = (
            "SELECT "+ TabArticole.COL_2+ " FROM " +TabArticole.NUME_TABEL+ " WHERE " + TabArticole.COL_4 + "=1"
    );





    public  static String get_SQL_QUERY_OBTINE_ANTET_LEGATURI (int nCodInt){
        return " SELECT " +
                TabAntetLegaturi.NUME_TABEL+"."+TabAntetLegaturi.COL_2 + " as " +TabAntetTransare.COL_2 +" , "+
                TabPozitiiLegaturi.NUME_TABEL+"."+TabPozitiiLegaturi.COL_2+ " as " +TabPozitiiTransare.COL_4 +" , "+
                TabArticole.NUME_TABEL+"."+ TabArticole.COL_3 +
                " FROM "+TabAntetLegaturi.NUME_TABEL +
                " inner join " + TabPozitiiLegaturi.NUME_TABEL + " on "+TabAntetLegaturi.NUME_TABEL+"."+TabAntetLegaturi.COL_2+" = " +TabPozitiiLegaturi.NUME_TABEL+"."+ TabPozitiiLegaturi.COL_4+
                " inner join " + TabArticole.NUME_TABEL+" on " + TabPozitiiLegaturi.NUME_TABEL+"."+ TabPozitiiLegaturi.COL_3+" = "+ TabArticole.NUME_TABEL+"."+TabArticole.COL_2+
                " where " +
                TabAntetLegaturi.NUME_TABEL+"."+TabAntetLegaturi.COL_3+" = "+nCodInt ;

    };

 //   Acum e bine. Lipseste un spatiu inainte de INNER : pozitii_legaturi.id_antetinner . Aici trebuia sa fie pozitii_legaturi.id_antet inner



//    /    select
//    antet_legaturi.cod_int as id_antet_legatura ,
//    pozitii_legaturi.cod_int as id_pozitii_legatura ,
//    articole.denumire
//    from antet_legaturi
//    inner join pozitii_legaturi  on antet_legaturi.cod_int=pozitii_legaturi.id_antet
//    inner join articole on pozitii_legaturi.id_articol=articole.cod_int
//    where antet_legaturi.id_articol=nCodIntDinArticole ( din onclick )
}