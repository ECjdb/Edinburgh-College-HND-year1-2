package uk.ac.edinburghcollege.coffeeshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import uk.ac.edinburghcollege.coffeeshop.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CoffeeViewHolder>
{
    private Context mContext;
    private ArrayList<Product> productList;

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTitle;
        public TextView mPrice;
        public ImageView mImage;
        public TextView mPId;

        public CoffeeViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mPrice = itemView.findViewById(R.id.price);
            mImage = itemView.findViewById(R.id.imageView3);
            mPId = itemView.findViewById(R.id.product_id);
        }
    }

    public ProductAdapter(ArrayList<Product> productList)
    {
        this.productList = productList;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_card, viewGroup, false);
        CoffeeViewHolder cvh = new CoffeeViewHolder(v);

        return cvh;
    }
    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder coffeeViewHolder, int position)
    {
        Product currentProduct = productList.get(position);

        coffeeViewHolder.mTitle.setText(currentProduct.getpTitle());
        coffeeViewHolder.mPrice.setText(String.valueOf(currentProduct.getpPrice()));
        coffeeViewHolder.mImage.setImageResource(currentProduct.getpThumbnail());
        coffeeViewHolder.mPId.setText("Product No. "+String.valueOf(currentProduct.getpID()));
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }
}
