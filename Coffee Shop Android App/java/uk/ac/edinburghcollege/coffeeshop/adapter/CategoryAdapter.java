package uk.ac.edinburghcollege.coffeeshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecyclerViewHolder>
{

    private Context mContext;
    private ArrayList<Category> categoryList;


    public CategoryAdapter(Context context, ArrayList<Category> cList){
        this.mContext = context;
        this.categoryList = cList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}