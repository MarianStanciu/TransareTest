package ro.bluebit.transaretest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.R;

import static androidx.recyclerview.widget.RecyclerView.*;

public class RecyclerAdapterTP extends RecyclerView.Adapter<RecyclerAdapterTP.TextViewHolder> {

    Context context;
    int[] retCodIntPT;
    List<String> retDenumiriPT;

    public RecyclerAdapterTP(Context context, int[] retCodIntPT, List<String> retDenumiriPT) {
        this.context = context;
        this.retCodIntPT = retCodIntPT;
        this.retDenumiriPT = retDenumiriPT;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produse_transate,parent,false);
        TextViewHolder textViewHolder= new TextViewHolder(view,context,retCodIntPT, retDenumiriPT );
        return textViewHolder ;
    }


    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {

        int retCodIntPT_id=retCodIntPT[position];
        String retDenumiriPT_id= retDenumiriPT.get(position);

        holder.afisareDenumirePT.setText(retDenumiriPT_id);


//        holder.denumireCodInt.setText(""+(retCodInt_id));
//        holder.denumireSelectieImaginiTransare.setText(mDenumiriMateriiPrime_id);
    }

    @Override
    public int getItemCount() {
        return retDenumiriPT.size();
    }
    public static class TextViewHolder extends RecyclerView.ViewHolder {

        TextView afisareDenumirePT;
        EditText preiaGreutate;
        Context context;
        int[] retCodIntPT;
        List<String> retDenumiriPT;


        public TextViewHolder(@NonNull View itemView, Context context, int[] retCodIntPT, List<String> retDenumiriPT) {
            super(itemView);
            afisareDenumirePT =itemView.findViewById(R.id.rezultat_transare);
            preiaGreutate =itemView.findViewById(R.id.greutate_introd_rezultat_transare);
            this.context = context;
            this.retCodIntPT = retCodIntPT;
            this.retDenumiriPT = retDenumiriPT;
        }
    }
}
