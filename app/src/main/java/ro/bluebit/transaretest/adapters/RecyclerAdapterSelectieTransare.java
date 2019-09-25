package ro.bluebit.transaretest.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.bluebit.transaretest.R;
import ro.bluebit.transaretest.SelectieFacturaMateriePrimaActivity;
import ro.bluebit.transaretest.SelectieTransareProduseActivity;

public class RecyclerAdapterSelectieTransare extends RecyclerView.Adapter<RecyclerAdapterSelectieTransare.ImageViewHolder> {

    private Context context;
    private int[] images;
    int[] retCodInt;
    List<String>  mDenumiriMateriiPrime;
    public static OnSelctieMPFacturaListener mOnSelctieMPFacturaListener;


    public RecyclerAdapterSelectieTransare(int[] images, List mDenumiriMateriiPrime,int[] retCodInt, RecyclerAdapterSelectieTransare.OnSelctieMPFacturaListener mOnSelctieMPFacturaListener, Context context){
        this.images= images;

        this.mDenumiriMateriiPrime=mDenumiriMateriiPrime;

        this.context= context;

        this.mOnSelctieMPFacturaListener=mOnSelctieMPFacturaListener;

        this.retCodInt=retCodInt;


    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_selectie_factura_materie_prima,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context, images, mDenumiriMateriiPrime,retCodInt,mOnSelctieMPFacturaListener);

        return imageViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        int image_id = images[position];
        int retCodInt_id = retCodInt[position];
        String mDenumiriMateriiPrime_id  = mDenumiriMateriiPrime.get(position);


        holder.selectieImaginiTransare.setImageResource(image_id);
        holder.denumireSelectieImaginiTransare.setText(mDenumiriMateriiPrime_id);
//        holder.denumireCodInt.setText(String.valueOf(retCodInt_id));
        holder.denumireCodInt.setText(""+(retCodInt_id));

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView selectieImaginiTransare;
        TextView denumireSelectieImaginiTransare;
        TextView denumireCodInt;
        Context context;
        int [] images;
        int [] retCodInt;
        List mDenumiriMateriiPrime;
        OnSelctieMPFacturaListener onSelctieMPFacturaListener;

        private ImageViewHolder(@NonNull View itemView, final Context context, int[] images, final List mDenumiriMateriiPrime, final int[] retCodInt, OnSelctieMPFacturaListener onSelctieMPFacturaListener) {
            super(itemView);
            selectieImaginiTransare=itemView.findViewById(R.id.afisareImaginiSelectie);
            denumireSelectieImaginiTransare=itemView.findViewById(R.id.textViewAfisareImaginiSelectie);
            denumireCodInt=itemView.findViewById(R.id.textViewCod_Int);
            this.context=context;
            this.images= images;
            this.mDenumiriMateriiPrime=mDenumiriMateriiPrime;
            this.onSelctieMPFacturaListener=onSelctieMPFacturaListener;
            this.retCodInt=retCodInt;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        Intent intentcdInt = new Intent(context, SelectieTransareProduseActivity.class);
                        intentcdInt.putExtra("retCodInt_id",retCodInt[getAdapterPosition()] );
                        intentcdInt.putExtra("denumire_id", mDenumiriMateriiPrime.get(position).toString());
                        SelectieFacturaMateriePrimaActivity aaa = (SelectieFacturaMateriePrimaActivity) context;
                        String cGreutate=aaa.getGreutate();

                        String cFactura = aaa.getFactura();
                        intentcdInt.putExtra("greutate", cGreutate);
                        intentcdInt.putExtra("factura", cFactura);

                        if (cGreutate.isEmpty()&& cFactura.isEmpty()){
                            Toast.makeText(aaa, "Completeaza GREUTATE SI NUMAR FACTURA!!!!!!", Toast.LENGTH_SHORT).show();
                        }
                        else


                        context.startActivity(intentcdInt);
//                        Toast.makeText(v.getContext(), "Ai selectat Cod INT : " +retCodInt[getAdapterPosition()], Toast.LENGTH_LONG).show();
//                        Toast.makeText(v.getContext(), "Ai selectat: " + mDenumiriMateriiPrime.get(getAdapterPosition()), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        @Override public void onClick(View view){

                    mOnSelctieMPFacturaListener.OnSelctieMPFacturaClick(getAdapterPosition() );

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
