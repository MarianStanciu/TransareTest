package ro.bluebit.transaretest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.R;

public class RecyclerAdapterSelectieTransare extends RecyclerView.Adapter<RecyclerAdapterSelectieTransare.ImageViewHolder> {

    private int[] images;
    String [] mDenumiriMateriiPrime ;

    public RecyclerAdapterSelectieTransare (int[]images,String[]mDenumiriMateriiPrime){
        this.images= images;
        this.mDenumiriMateriiPrime=mDenumiriMateriiPrime;



    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_selectie_factura_materie_prima,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        int image_id = images[position];
        String mDenumiriMateriiPrime_id = mDenumiriMateriiPrime[ position];

        holder.selectieImaginiTransare.setImageResource(image_id);
        holder.denumireSelectieImaginiTransare.setText(mDenumiriMateriiPrime_id);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView selectieImaginiTransare;
        TextView denumireSelectieImaginiTransare;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            selectieImaginiTransare=itemView.findViewById(R.id.afisareImaginiSelectie);
            denumireSelectieImaginiTransare=itemView.findViewById(R.id.textViewAfisareImaginiSelectie);
        }
    }
}
