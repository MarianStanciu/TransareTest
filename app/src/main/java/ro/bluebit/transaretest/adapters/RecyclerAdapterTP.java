package ro.bluebit.transaretest.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.R;

public class RecyclerAdapterTP extends RecyclerView.Adapter<RecyclerAdapterTP.TextViewHolder> {


    Context context;
    int[] retCodIntPT;
    List<String> retDenumiriPT;
    public String[] mDataset=new String[retDenumiriPT.size()];// am setat dimensiunea sa fie egala cu arrayul de denumiri
    public MyCustomEditTextListener myCustomEditTextListener;


    public RecyclerAdapterTP(Context context, int[] retCodIntPT, List<String> retDenumiriPT) {
        this.context = context;
        this.retCodIntPT = retCodIntPT;
        this.retDenumiriPT = retDenumiriPT;


        //setHasStableIds(true); - id-uri stabile
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produse_transate,parent,false);
        TextViewHolder textViewHolder= new TextViewHolder(view,context,retCodIntPT, retDenumiriPT,myCustomEditTextListener  );
        return textViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {


        int retCodIntPT_id=retCodIntPT[position];
        holder.afisareDenumirePT.setTag(R.string.tagRezultateTransare,retCodIntPT[position]);

        //String retDenumiriPT_id= retDenumiriPT.get(position);
        holder.afisareDenumirePT.setText(retDenumiriPT.get(position));
        holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
        holder.preiaGreutate.getText().toString();

    }

    @Override
    public int getItemCount() {
        return retDenumiriPT.size();
    }
    public static class TextViewHolder extends RecyclerView.ViewHolder {

        public TextView afisareDenumirePT;
        public EditText preiaGreutate;
        Context context;
        int[] retCodIntPT;
        List<String> retDenumiriPT;
        public MyCustomEditTextListener myCustomEditTextListener;



        public TextViewHolder(@NonNull View itemView, Context context, int[] retCodIntPT, List<String> retDenumiriPT, MyCustomEditTextListener myCustomEditTextListener) {
            super(itemView);
            afisareDenumirePT =itemView.findViewById(R.id.rezultat_transare);
            preiaGreutate = itemView.findViewById(R.id.greutate_introd_rezultat_transare);
            this.context = context;
            this.retCodIntPT = retCodIntPT;
            this.retDenumiriPT = retDenumiriPT;
            this.myCustomEditTextListener=myCustomEditTextListener;
            preiaGreutate.addTextChangedListener(myCustomEditTextListener);

        }

    }
    //implementare textwatcher
    public class MyCustomEditTextListener implements TextWatcher {
        public int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            mDataset[position] = charSequence.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }



    // metode pentru a nu da shuffle la datele din edittext
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    //calculare sum elementelor din editText
    public double Adunare(){

        Double suma =0.0;
        int i;
        for (i=0 ; i<mDataset.length ; i++) {
            if (!(null==mDataset[i]) && !mDataset[i].isEmpty()  )
                suma +=Double.parseDouble( mDataset[i]);
        }
        return  suma ;
    }








    }

