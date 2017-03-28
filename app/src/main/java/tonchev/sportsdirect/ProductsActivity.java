package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import models.ProductAdapter;
import shops.Product;

public class ProductsActivity extends AppCompatActivity {

    private Product.Gender gender;
    private Product.ProductType productType;
    private Enum specProd;
    private RadioGroup color;
    private RadioGroup brand;
    private RadioGroup size;
    private RadioGroup price;
    private ArrayList<Product> displayed;
    private ListView listView;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        gender = (Product.Gender) getIntent().getSerializableExtra("gender");
        productType = (Product.ProductType) getIntent().getSerializableExtra("productType");
        specProd = (Enum) getIntent().getSerializableExtra("specType");

        displayed = new ArrayList<Product>(MainActivity.store.getCatalog().get(gender).get(productType).get(specProd));

        color = (RadioGroup) findViewById(R.id.color_radio);
        brand = (RadioGroup) findViewById(R.id.brand_radio);
        size = (RadioGroup) findViewById(R.id.size_radio);
        price = (RadioGroup) findViewById(R.id.price_radio);
        listView = (ListView) findViewById(R.id.product_list);

        if (gender == Product.Gender.MEN) {
            switch (productType) {
                case FOOTWEAR:
                    for (int i = 0; i < Product.menFootSizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.menFootSizes[i]);
                        size.addView(rb);
                    }
                    break;
                case CLOTHING:
                    for (int i = 0; i < Product.menClothSizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.menClothSizes[i]);
                        size.addView(rb);
                    }
                    break;
                case ACCESSORIES:
                    for (int i = 0; i < Product.accessSizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.accessSizes[i]);
                        size.addView(rb);
                    }
                    break;
            }
        }
        else{
            switch (productType){
                case FOOTWEAR:
                    for (int i = 0; i < Product.ladiesFootsizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.ladiesFootsizes[i]);
                        size.addView(rb);
                    }
                    break;
                case CLOTHING:
                    for (int i = 0; i < Product.ladiesClothSizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.ladiesClothSizes[i]);
                        size.addView(rb);
                    }
                    break;
                case ACCESSORIES:
                    for (int i = 0; i < Product.accessSizes.length; i++) {
                        RadioButton rb = new RadioButton(this);
                        rb.setText(Product.accessSizes[i]);
                        size.addView(rb);
                    }
                    break;

            }
        }
        color.check(R.id.rad_color_all);
        brand.check(R.id.rad_brand_all);
        size.check(R.id.rad_size_all);
        price.check(R.id.rad_price_all);

        ProductAdapter adapter = new ProductAdapter(this,displayed);
        listView.setAdapter(adapter);



    }
    // check each radiogroup for pressed button -> set visibility to GONE for each of the non-selected
//    private void sort (RadioGroup color, RadioGroup brand, RadioGroup size, RadioGroup price) {
//        RadioButton col = (RadioButton) findViewById(color.getCheckedRadioButtonId());
//        for (Product p : displayed) {
//            if (p.getColor().equals(col.getText()))
//        }
//    }
    public void callMyHistory(View view) {
        Intent intent = new Intent(ProductsActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        if (!MainActivity.loggedUser.getShoppingBag().isEmpty()) {
            Intent intent = new Intent(ProductsActivity.this, MyShoppingBagActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Bag empty. Please add some products first!", Toast.LENGTH_SHORT).show();
        }
    }

}
