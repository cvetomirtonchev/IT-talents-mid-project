package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import shops.Product;

public class ProductViewActivity extends AppCompatActivity {
    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView discription;
    private RadioButton color;
    private RadioButton size;
    private Button addToBag;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        product = (Product) getIntent().getSerializableExtra("product");
        image = (ImageView) findViewById(R.id.product_image_view);
        name = (TextView) findViewById(R.id.product_name_view);
        price = (TextView) findViewById(R.id.product_price_view);
        discription = (TextView) findViewById(R.id.product_info_view);
        color = (RadioButton) findViewById(R.id.product_color_view);
        size = (RadioButton) findViewById(R.id.product_size_view);
        addToBag = (Button) findViewById(R.id.product_add_to_bag);

        color.setChecked(true);
        size.setChecked(true);
        image.setImageResource(product.getImageId());
        name.setText(product.getName());
        price.setText(product.getPrice()+"" +"$");
        discription.setText(product.getProductInfo());
        color.setText(product.getColor());
        size.setText(product.getSize());

        addToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.loggedUser.getShoppingBag().add(product);
                Intent intent = new Intent(ProductViewActivity.this, MyShoppingBagActivity.class);
                startActivity(intent);
            }
        });

    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(ProductViewActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(ProductViewActivity.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
