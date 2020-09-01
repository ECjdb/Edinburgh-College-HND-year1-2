package uk.ac.edinburghcollege.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import uk.ac.edinburghcollege.coffeeshop.adapter.Product;
import uk.ac.edinburghcollege.coffeeshop.adapter.ProductAdapter;

public class ProductScreenActivity extends AppCompatActivity
{
    private ArrayList<Product> productList;
    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager recLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);

        createProductList();
        buildRecyclerView();
    }
    public void createProductList()
    {
        productList = new ArrayList<>();

        productList.add(new Product("americano",1.99,1,1, R.drawable.amer));
        productList.add(new Product("latte",2.49,2,2, R.drawable.latte));
        productList.add(new Product("espresso",1.49,3,3, R.drawable.esp));
        productList.add(new Product("cappuccino",2.49,4,4, R.drawable.capp));

    }

    public void buildRecyclerView()
    {
        productRecyclerView = findViewById(R.id.recyclerView);
        productRecyclerView.setHasFixedSize(true);
        recLayoutManager = new LinearLayoutManager(this);
        productAdapter = new ProductAdapter(productList);
        productRecyclerView.setLayoutManager(recLayoutManager);
        productRecyclerView.setAdapter(productAdapter);
    }
}
