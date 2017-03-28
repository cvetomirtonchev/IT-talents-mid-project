package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import shops.Clothing;
import shops.Product;

public class LadiesClothing extends AppCompatActivity {
    private Button tshirts;
    private Button jeans;
    private Button jackets;
    private Button swimwear;
    private Button hoodies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies_clothing);


        tshirts = (Button) findViewById(R.id.ladies_tshirt);
        jeans = (Button) findViewById(R.id.ladies_jeans);
        jackets = (Button) findViewById(R.id.ladies_jackets);
        swimwear = (Button) findViewById(R.id.ladies_swimwear);
        hoodies = (Button) findViewById(R.id.ladies_hoodies);

        View.OnClickListener takeMeToProd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.ladies_tshirt:

                        Intent intent = new Intent(LadiesClothing.this, ProductsActivity.class);
                        intent.putExtra("gender", Product.Gender.LADIES);
                        intent.putExtra("productType", Product.ProductType.CLOTHING);
                        intent.putExtra("specType", Clothing.ClothType.TSHIRTS);
                        startActivity(intent);
                    case R.id.ladies_jeans:
                        Intent intent2 = new Intent(LadiesClothing.this, ProductsActivity.class);
                        intent2.putExtra("gender", Product.Gender.LADIES);
                        intent2.putExtra("productType", Product.ProductType.CLOTHING);
                        intent2.putExtra("specType", Clothing.ClothType.JEANS);
                        startActivity(intent2);
                    case R.id.ladies_jackets:
                        Intent intent3 = new Intent(LadiesClothing.this, ProductsActivity.class);
                        intent3.putExtra("gender", Product.Gender.LADIES);
                        intent3.putExtra("productType", Product.ProductType.CLOTHING);
                        intent3.putExtra("specType", Clothing.ClothType.JACKETS);
                        startActivity(intent3);
                    case R.id.ladies_swimwear:
                        Intent intent4 = new Intent(LadiesClothing.this, ProductsActivity.class);
                        intent4.putExtra("gender", Product.Gender.LADIES);
                        intent4.putExtra("productType", Product.ProductType.CLOTHING);
                        intent4.putExtra("specType", Clothing.ClothType.SWIMWEAR);
                        startActivity(intent4);
                    case R.id.ladies_hoodies:
                        Intent intent5 = new Intent(LadiesClothing.this, ProductsActivity.class);
                        intent5.putExtra("gender", Product.Gender.LADIES);
                        intent5.putExtra("productType", Product.ProductType.CLOTHING);
                        intent5.putExtra("specType", Clothing.ClothType.HOODIES);
                        startActivity(intent5);
                }
            }
        };

        tshirts.setOnClickListener(takeMeToProd);
        jeans.setOnClickListener(takeMeToProd);
        jackets.setOnClickListener(takeMeToProd);
        swimwear.setOnClickListener(takeMeToProd);
        hoodies.setOnClickListener(takeMeToProd);
    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(LadiesClothing.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(LadiesClothing.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}


