package ro.bluebit.transaretest.utilitare;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemDecorator extends RecyclerView.ItemDecoration {
    public final int verticalSpaceHeight;

    public ItemDecorator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom=verticalSpaceHeight;
    }
}
