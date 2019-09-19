package ro.bluebit.transaretest;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.adapters.RecyclerAdapterTP;
import ro.bluebit.transaretest.database.DatabaseHelper;
import ro.bluebit.transaretest.utilitare.ItemDecorator;

public class SelectieTransareProduseActivity extends AppCompatActivity {
    TextView denTV, codTV;

    private RecyclerView recyclerView;
    DatabaseHelper myDb ;
    Context context;


    private RecyclerView.LayoutManager layoutManager;
    public RecyclerAdapterTP recyclerAdapterTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectie_transare_produse);
        denTV=findViewById(R.id.textViewAfisareDenumireTP);
        codTV=findViewById(R.id.textViewAfisareCodIntTP);

//        cod.setText(getIntent().getStringExtra(("retCodInt_id")));
//        imageView=findViewById(R.id.afisareImaginiSelectie);
//        imageView.setImageResource(getIntent().getIntExtra("image_id",  00 ));
        Bundle extras = getIntent().getExtras();
        String cod = String.valueOf(extras.getInt("retCodInt_id"));
        int codCod=extras.getInt("retCodInt_id");
        codTV.setText(cod);
        String denumire=extras.getString("denumire_id");
        denTV.setText(denumire);

        myDb= new DatabaseHelper(this);
        SQLiteDatabase db =myDb.getReadableDatabase();
        List<String> retDenumiriPT = Logica.getDenumiriPT(db,codCod)  ;
        int [] retCodIntPT=Logica.getCodIntPT(db,codCod);
        recyclerView=findViewById(R.id.recyclerviewTP);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ItemDecorator peVerctivala = new ItemDecorator(5);
        recyclerView.addItemDecoration(peVerctivala);
        recyclerAdapterTP = new RecyclerAdapterTP(context, retCodIntPT,  retDenumiriPT);
        recyclerView.setAdapter(recyclerAdapterTP);

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



//        public static int sharedValue  ;{
//        Bundle extras = getIntent().getExtras();
//            int cod = extras.getInt("retCodInt_id");
//            sharedValue= cod;
//    }

}









//        public static String sharedValue = null;
//        You can access within any other class (with in the same package) as follows.
//
//        ClassC.sharedValue = "Some Text";   //set value
//
//        String s = ClassC.sharedValue;   //get value

