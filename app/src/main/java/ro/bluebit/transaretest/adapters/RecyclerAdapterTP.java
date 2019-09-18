package ro.bluebit.transaretest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.R;

import static androidx.recyclerview.widget.RecyclerView.*;

public class RecyclerAdapterTP extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    int[] retCodIntPT;
    List<String> retDenumiriPT;

    public RecyclerAdapterTP(Context context, int[] retCodIntPT, List<String> retDenumiriPT) {
        this.context = context;
        this.retCodIntPT = retCodIntPT;
        this.retDenumiriPT = retDenumiriPT;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produse_transate,parent,false);
                return new ViewHolder(view) ;
    }

//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notes_list_item, parent, false);
//        return new ViewHolder(view);
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class TextViewHolder extends RecyclerView.ViewHolder {

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
