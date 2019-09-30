package ro.bluebit.transaretest;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.adapters.RecyclerAdapterTP;
import ro.bluebit.transaretest.database.Constructor;
import ro.bluebit.transaretest.database.DatabaseHelper;
import ro.bluebit.transaretest.utilitare.ItemDecorator;

public class SelectieTransareProduseActivity extends AppCompatActivity {


    TextView denTV, codTV;

    private RecyclerView recyclerView;
    DatabaseHelper myDb ;
    Context context;
    MenuItem butonsalvare;
    String mSgreutateF, mSfacturaF;
    Dialog dialog;
    Button validare_rezultat,mai_verifica;
    EditText testclear;




    private RecyclerView.LayoutManager layoutManager;
    public RecyclerAdapterTP recyclerAdapterTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectie_transare_produse);
        denTV=findViewById(R.id.textViewAfisareDenumireTP);
        codTV=findViewById(R.id.textViewAfisareCodIntTP);
        butonsalvare = findViewById(R.id.action_salvare);
        //buttonx.findViewById(R.id.butonx_id);
        //greutatematerieprimadinfactura=findViewById(R.id.edittext_greutateTotala);
       //cantitate_inserata_tv = cantitate_inserata_tv.findViewById(R.id.cantitate_inserata_tvid);
        dialog = new Dialog(this);
//        cod.setText(getIntent().getStringExtra(("retCodInt_id")));
//        imageView=findViewById(R.id.afisareImaginiSelectie);
//        imageView.setImageResource(getIntent().getIntExtra("image_id",  00 ));
        Bundle extras = getIntent().getExtras();
        String cod = String.valueOf(extras.getInt("retCodInt_id"));
        int codCod=extras.getInt("retCodInt_id");
        codTV.setText(cod);
        String denumire=extras.getString("denumire_id");
        denTV.setText(denumire);
        mSgreutateF=extras.getString("greutate");
        mSfacturaF=extras.getString("factura");






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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





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
// create an action bar button
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_aplicatie, menu);
    return super.onCreateOptionsMenu(menu);
}

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_salvare) {

            displayPopupWindow();
        }

        return super.onOptionsItemSelected(item);
    }
    public void displayPopupWindow() {
        final PopupWindow popup = new PopupWindow(this);
        View layout = getLayoutInflater().inflate(R.layout.popup_verificare_cantitati, null);
        popup.setContentView(layout);
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
        validare_rezultat=layout.findViewById(R.id.validare_rezultat_id);
        mai_verifica=layout.findViewById(R.id.mai_verifica_id);
        validare_rezultat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalveazaInBazaDeDate();
                popup.dismiss();
            }
        });
        mai_verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "AI REVENIT LA VALIDARE REZULTAT!!!!", Toast.LENGTH_LONG).show();
                popup.dismiss();
            }
        });


    }
    public void SalveazaInBazaDeDate(){

            // insert inregistrare pt antet_transare
            SQLiteDatabase db = myDb.getWritableDatabase();
            db.beginTransaction();
            ContentValues cValAT = new ContentValues();
            cValAT.put(Constructor.TabAntetTransare.COL_3,mSfacturaF);
            cValAT.put(Constructor.TabAntetTransare.COL_5,mSgreutateF);
            cValAT.put(Constructor.TabAntetTransare.COL_2,codTV.getText().toString()); // aici trebuie cod_int din antet_legaturi corespunzator idului de mat prima
            long nid = db.insert(Constructor.TabAntetTransare.NUME_TABEL,null,cValAT);
            for ( int i =0 , n= recyclerView.getChildCount(); i<n; i++){
                View view = recyclerView.getChildAt(i);

                RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(view);
                RecyclerAdapterTP.TextViewHolder v = ((RecyclerAdapterTP.TextViewHolder) holder) ;
                String sGreutateS = v.preiaGreutate.getText().toString();
                if(!sGreutateS.isEmpty()) {
                    Double vGreutateS = Double.parseDouble(sGreutateS);

                    ContentValues cValPT = new ContentValues();
                    cValPT.put(Constructor.TabPozitiiTransare.COL_2, nid);
                    cValPT.put(Constructor.TabPozitiiTransare.COL_3, vGreutateS);
                    cValPT.put(Constructor.TabPozitiiTransare.COL_4, Integer.parseInt(v.afisareDenumirePT.getTag(R.string.tagRezultateTransare).toString()));
                    db.insert(Constructor.TabPozitiiTransare.NUME_TABEL, null, cValPT);
                }

            }
            db.setTransactionSuccessful();
            db.endTransaction();
            Toast.makeText(this, "Ai  inserat in Baza de date :", Toast.LENGTH_SHORT).show();
        }


    public void StergeDupaSalvare(){
        testclear = findViewById(R.id.edittext_greutateTotala);
        testclear.getText().clear();
    }
}










//        public static String sharedValue = null;
//        You can access within any other class (with in the same package) as follows.
//
//        ClassC.sharedValue = "Some Text";   //set value
//
//        String s = ClassC.sharedValue;   //get value


//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_salvare:
//                // User chose the "Settings" item, show the app settings UI...
//                return true;
//
//           case R.id.action_favorite:
//              // User chose the "Favorite" action, mark the current item
//                // as a favorite...
//               return true;
//
//            default:
//                // If we got here, the user's action was not recognized.
//                // Invoke the superclass to handle it.
//                return super.onOptionsItemSelected(item);
//
//        }
//    }