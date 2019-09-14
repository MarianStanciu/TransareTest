package ro.bluebit.transaretest.adapters;

import android.content.Context;
import android.content.Intent;
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
import ro.bluebit.transaretest.SelectieTransareProduseActivity;

public class RecyclerAdapterSelectieTransare extends RecyclerView.Adapter<RecyclerAdapterSelectieTransare.ImageViewHolder> {

    private Context context;
    private int[] images;
    List<String>  mDenumiriMateriiPrime  ;
    public static OnSelctieMPFacturaListener mOnSelctieMPFacturaListener;

    public RecyclerAdapterSelectieTransare(int[] images, List mDenumiriMateriiPrime, RecyclerAdapterSelectieTransare.OnSelctieMPFacturaListener mOnSelctieMPFacturaListener, Context context){
        this.images= images;

        this.mDenumiriMateriiPrime=mDenumiriMateriiPrime;

        this.context= context;

        this.mOnSelctieMPFacturaListener=mOnSelctieMPFacturaListener;


    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_selectie_factura_materie_prima,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context, images, mDenumiriMateriiPrime,mOnSelctieMPFacturaListener);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        int image_id = images[position];
        String mDenumiriMateriiPrime_id  = mDenumiriMateriiPrime.get(position);

        holder.selectieImaginiTransare.setImageResource(image_id);
        holder.denumireSelectieImaginiTransare.setText(mDenumiriMateriiPrime_id);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView selectieImaginiTransare;
        TextView denumireSelectieImaginiTransare;
        Context context;
        int [] images;
        List mDenumiriMateriiPrime;
        OnSelctieMPFacturaListener onSelctieMPFacturaListener;

        public ImageViewHolder(@NonNull View itemView, Context context, int[] images, List mDenumiriMateriiPrime,OnSelctieMPFacturaListener onSelctieMPFacturaListener) {
            super(itemView);
            selectieImaginiTransare=itemView.findViewById(R.id.afisareImaginiSelectie);
            denumireSelectieImaginiTransare=itemView.findViewById(R.id.textViewAfisareImaginiSelectie);
            this.context=context;
            this.images= images;
            this.mDenumiriMateriiPrime=mDenumiriMateriiPrime;
            this.onSelctieMPFacturaListener=onSelctieMPFacturaListener;
            itemView.setOnClickListener(this);
        }
        @Override public void onClick(View view){

                    mOnSelctieMPFacturaListener.OnSelctieMPFacturaClick(getAdapterPosition());
                }

//        @Override
//        public void onClick(View view) {
//            Intent intentDeschideTransareProduse = new Intent(context,  SelectieTransareProduseActivity.class);
// //           intentDeschideTransareProduse.putExtra("image_id", images[getAdapterPosition()]);
////            intentDeschideTransareProduse.putExtra("mDenumiriMateriiPrime_id",mDenumiriMateriiPrime[getAdapterPosition()]);
//
//
//            context.startActivity(intentDeschideTransareProduse);
//        }


    }

        public  interface OnSelctieMPFacturaListener {

                        void OnSelctieMPFacturaClick(int position);
        }
}
