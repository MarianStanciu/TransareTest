package ro.bluebit.transaretest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import ro.bluebit.transaretest.adapters.RecyclerAdapterSelectieTransare;

public class SelectieFacturaMateriePrimaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int [] images ={ R.drawable.porc, R.drawable.vaca, R.drawable.oaie,R.drawable.curcan};
    String [] mDenumiriMateriiPrime = { "PORC",
                                        "VACA",
                                        "OAIE",
                                        "CURCAN"
                                        };


    public RecyclerAdapterSelectieTransare recyclerAdapterSelectieTransare;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectie_factura_materie_prima);
        recyclerView=findViewById(R.id.recyclerViewSelectieTransare);
        layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapterSelectieTransare = new RecyclerAdapterSelectieTransare(images,mDenumiriMateriiPrime);
        recyclerView.setAdapter(recyclerAdapterSelectieTransare);
    }
}
