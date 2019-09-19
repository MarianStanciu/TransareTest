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
//                                        "CURCAN"
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
        layoutManager = new GridLayoutManager(this, 6);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ItemDecorator peVerctivala = new ItemDecorator(5);
        recyclerView.addItemDecoration(peVerctivala);
        recyclerAdapterSelectieTransare = new RecyclerAdapterSelectieTransare(images,mDenumiriMateriiPrime,retCodInt, this, this);
        recyclerView.setAdapter(recyclerAdapterSelectieTransare);
//        recyclerView.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

    }



    @Override
    public void OnSelctieMPFacturaClick(int position) {
//        Toast.makeText(this,"Ai selectat fotografia " +(position) , Toast.LENGTH_SHORT).show();
//        Intent intentDeschideTransareProduse = new Intent(this,  SelectieTransareProduseActivity.class);
//        intentDeschideTransareProduse.getIntExtra("retCodInt_id ",retCodInt[getAdapterPosition()]) ;
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
