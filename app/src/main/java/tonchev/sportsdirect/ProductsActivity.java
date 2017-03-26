package tonchev.sportsdirect;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

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
        color.check(R.id.rad_color_all);
        brand.check(R.id.rad_brand_all);
        size.check(R.id.rad_size_all);
        price.check(R.id.rad_price_all);
        // display made selection without sorting
        if (!MainActivity.store.getCatalog().isEmpty()) {
            for (Product p : displayed) {
                LinearLayout lL = (LinearLayout) findViewById(R.id.product_layout);
                ImageView iv = new ImageView(this);
                switch (productType) {
                    case FOOTWEAR:
                        iv.setMaxWidth(50);
                        iv.setMaxHeight(50);
                        iv.setImageResource(R.drawable.football);
                        break;
                    case CLOTHING:
                        iv.setImageResource(R.drawable.tshirt);
                        break;
                    case ACCESSORIES:
                        iv.setImageResource(R.drawable.watches);
                        break;
                }
                TextView name = new TextView(this);
                name.setText(p.getBrand() + " " + p.getName() + " " +p.getGender() + " " + p.getProductType() + " " + p.getStock() + " " + p.getColor() + " " + p.getSize());
                name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TextView price = new TextView(this);
                price.setText(p.getPrice() + " lv.");
                price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                lL.addView(iv);
                lL.addView(name);
                lL.addView(price);
            }

        }

    }
    // check each radiogroup for pressed button -> set visibility to GONE for each of the non-selected
//    private void sort (RadioGroup color, RadioGroup brand, RadioGroup size, RadioGroup price) {
//        RadioButton col = (RadioButton) findViewById(color.getCheckedRadioButtonId());
//        for (Product p : displayed) {
//            if (p.getColor().equals(col.getText()))
//        }
//    }
}
