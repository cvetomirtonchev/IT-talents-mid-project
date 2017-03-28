package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import shops.Clothing;
import shops.Product;

public class MenClothingActivity extends AppCompatActivity {

    private Button tshirts;
    private Button jeans;
    private Button jackets;
    private Button swimwear;
    private Button hoodies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_clothing);

        tshirts = (Button) findViewById(R.id.cl_tshirts);
        jeans = (Button) findViewById(R.id.cl_jeans);
        jackets = (Button) findViewById(R.id.cl_jackets);
        swimwear = (Button) findViewById(R.id.cl_swimwear);
        hoodies = (Button) findViewById(R.id.cl_hoodies);

        View.OnClickListener takeMeToProd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.cl_tshirts:
                        // tretoto trqbva da e specType navsqkyde za da moje activitito da obraboti pravilno dannite
                        Intent intent = new Intent(MenClothingActivity.this, ProductsActivity.class);
                        intent.putExtra("gender", Product.Gender.MEN);
                        intent.putExtra("productType", Product.ProductType.CLOTHING);
                        intent.putExtra("specType", Clothing.ClothType.TSHIRTS);
                        startActivity(intent);
                    case R.id.cl_jeans:
                        Intent intent2 = new Intent(MenClothingActivity.this, ProductsActivity.class);
                        intent2.putExtra("gender", Product.Gender.MEN);
                        intent2.putExtra("productType", Product.ProductType.CLOTHING);
                        intent2.putExtra("specType", Clothing.ClothType.JEANS);
                        startActivity(intent2);
                    case R.id.cl_jackets:
                        Intent intent3 = new Intent(MenClothingActivity.this, ProductsActivity.class);
                        intent3.putExtra("gender", Product.Gender.MEN);
                        intent3.putExtra("productType", Product.ProductType.CLOTHING);
                        intent3.putExtra("specType", Clothing.ClothType.JACKETS);
                        startActivity(intent3);
                    case R.id.cl_swimwear:
                        Intent intent4 = new Intent(MenClothingActivity.this, ProductsActivity.class);
                        intent4.putExtra("gender", Product.Gender.MEN);
                        intent4.putExtra("productType", Product.ProductType.CLOTHING);
                        intent4.putExtra("specType", Clothing.ClothType.SWIMWEAR);
                        startActivity(intent4);
                    case R.id.cl_hoodies:
                        Intent intent5 = new Intent(MenClothingActivity.this, ProductsActivity.class);
                        intent5.putExtra("gender", Product.Gender.MEN);
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
        Intent intent = new Intent(MenClothingActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(MenClothingActivity.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
