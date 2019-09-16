package ro.bluebit.transaretest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class SelectieTransareProduseActivity extends AppCompatActivity {
//    ImageView imageView;
 //  int  retCodInt;

    TextView denTV, codTV;

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
        String cod =String.valueOf( extras.getInt("retCodInt_id"));
        codTV.setText(cod);
        String denumire=extras.getString("denumire_id");
        denTV.setText(denumire);
    }
}

