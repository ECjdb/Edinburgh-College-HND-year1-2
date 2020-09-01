package uk.ac.edinburghcollege.coffeeshop.helper;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridItemPadding extends RecyclerView.ItemDecoration {

    private int spanCount, spacing;
    private boolean includeEdge;


    public GridItemPadding(int sCount, int spacing, boolean includeEdge){
        this.spanCount = sCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if(includeEdge){
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * (1f / spanCount)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if(position < spanCount){ // top edge
                outRect.top = spacing;
            }

            outRect.bottom = spacing; // item bottom

        } else {

            outRect.left = column * spacing / spanCount;
            outRect.right = column * spacing - (column + 1) * spacing / spanCount;

            if(position >= spanCount){
                outRect.top = spacing; // item top
            }
        }
    }
}