package ro.bluebit.transaretest;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.adapters.RecyclerAdapterSelectieTransare;
import ro.bluebit.transaretest.database.DatabaseHelper;
import ro.bluebit.transaretest.utilitare.ItemDecorator;

public class SelectieFacturaMateriePrimaActivity extends AppCompatActivity implements RecyclerAdapterSelectieTransare.OnSelctieMPFacturaListener {



    private RecyclerView recyclerView;
    DatabaseHelper myDb ;
    //private int [] images ={ R.drawable.porc, R.drawable.vaca, R.drawable.oaie,R.drawable.curcan};
//    SQLiteDatabase db =myDb.getReadableDatabase();
//    List<String> mDenumiriMateriiPrime = Logica.getDenumiri(db)  ;
//                                    { "PORC",
//                                        "VACA",
//                                        "OAIE",
//                                         "CURCAN"
//                                        };



    public RecyclerAdapterSelectieTransare recyclerAdapterSelectieTransare;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterSelectieTransare.OnSelctieMPFacturaListener monSelctieMPFacturaListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectie_factura_materie_prima);

        myDb= new DatabaseHelper(this);
        SQLiteDatabase db =myDb.getReadableDatabase();
        List<String> mDenumiriMateriiPrime = Logica.getDenumiri(db)  ;
        int [] retCodInt=Logica.getCodInt(db);
        int[] images =Logica.getImagini(db);
        recyclerView=findViewById(R.id.recyclerViewSelectieTransare);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ItemDecorator peVerctivala = new ItemDecorator(5);
        recyclerView.addItemDecoration(peVerctivala);
        recyclerAdapterSelectieTransare = new RecyclerAdapterSelectieTransare(images,mDenumiriMateriiPrime,retCodInt, this, this);
        recyclerView.setAdapter(recyclerAdapterSelectieTransare);

//        recyclerView.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

    }
//    public static void insertgreutatefact(sfactura, sgreutate) {
//        String sqlSirGreutateFact = "Insert into " + Constructor.TabAntetTransare.NUME_TABEL + "." + (Constructor.TabAntetTransare.COL_5 + "," + Constructor.TabAntetTransare.COL_3)
//                + " values " + (sgreutate + sfactura);
//    }


    @Override
    protected void onStart() {
        super.onStart();
        EditText edittext_NrFactura=findViewById(R.id.edittext_NrFactura);
        edittext_NrFactura.getText().clear();
        EditText edittext_greutateTotala= findViewById(R.id.edittext_greutateTotala);
        edittext_greutateTotala.getText().clear();
    }


    public String getGreutate() {
//        cantitate=findViewById(R.id.edittext_greutateTotala);
//        sgreutate=String.valueOf(cantitate);

        return  ((EditText) findViewById(R.id.edittext_greutateTotala)).getText().toString();
}

    public String getFactura(){
        return  ((EditText) findViewById(R.id.edittext_NrFactura)).getText().toString();
    }





//    public boolean insertGreutateFactura(){
//        SQLiteDatabase db =myDb.getWritableDatabase();
//        ContentValues cval = new ContentValues();
//        cval.put(Constructor.TabAntetTransare.COL_5, sgreutate);
//        cval.put(Constructor.TabAntetTransare.COL_3, sfactura);
//        long result = db.insert(Constructor.TabAntetTransare.NUME_TABEL, null, cval);
//        if (result==-1)
//            return false;
//        else
//            return true;
//    }

//    public void AcceseazaRecyclerView(){
//
//        if(EditTextEmptyHold == true)
//        {
//        recyclerView.setFocusable(EditTextEmptyHold);
//
//
//
//
//
//            //Toast.makeText(MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();
//
//        }
//        else {
//            recyclerView.setFocusable(EditTextEmptyHold);
//            Toast.makeText(SelectieFacturaMateriePrimaActivity.this,"Completeaza campurile", Toast.LENGTH_LONG).show();
//
//        }
//
//    }




    @Override
    public void OnSelctieMPFacturaClick(int position) {
//        Toast.makeText(this,"Ai selectat fotografia " +(position) , Toast.LENGTH_SHORT).show();
//          Intent intentDeschideTransareProduse = new Intent(this,  SelectieTransareProduseActivity.class);
//          intentDeschideTransareProduse.putExtra("cantitate ", Integer.parseInt(String.valueOf(cantitate))) ;
//          intentDeschideTransareProduse.putExtra("factura ", String.valueOf(factura)) ;
//        startActivity(intentDeschideTransareProduse);

    }
    //Tastatura dispare la scroll
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

   }