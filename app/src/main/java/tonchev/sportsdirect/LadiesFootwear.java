package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import shops.FootWear;
import shops.Product;

public class LadiesFootwear extends AppCompatActivity {

    private Button football;
    private Button flips;
    private Button sandals;
    private Button running;
    private Button boots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies_footwear);

        football = (Button) findViewById(R.id.ladies_football);
        flips = (Button) findViewById(R.id.ladies_flipflops);
        sandals = (Button) findViewById(R.id.ladies_sandals);
        running = (Button) findViewById(R.id.ladies_running);
        boots = (Button) findViewById(R.id.ladies_boots);

        View.OnClickListener takeMeToProd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.ladies_football:

                        Intent intent = new Intent(LadiesFootwear.this, ProductsActivity.class);
                        intent.putExtra("gender", Product.Gender.LADIES);
                        intent.putExtra("productType", Product.ProductType.FOOTWEAR);
                        intent.putExtra("specType", FootWear.ShoesType.FOOTBALL);
                        startActivity(intent);
                        break;
                    case R.id.ladies_flipflops:
                        Intent intent2 = new Intent(LadiesFootwear.this, ProductsActivity.class);
                        intent2.putExtra("gender", Product.Gender.LADIES);
                        intent2.putExtra("productType", Product.ProductType.FOOTWEAR);
                        intent2.putExtra("specType", FootWear.ShoesType.FLIPFLOPS);
                        startActivity(intent2);
                        break;
                    case R.id.ladies_sandals:
                        Intent intent3 = new Intent(LadiesFootwear.this, ProductsActivity.class);
                        intent3.putExtra("gender", Product.Gender.LADIES);
                        intent3.putExtra("productType", Product.ProductType.FOOTWEAR);
                        intent3.putExtra("specType", FootWear.ShoesType.SANDALS);
                        startActivity(intent3);
                        break;
                    case R.id.ladies_running:
                        Intent intent4 = new Intent(LadiesFootwear.this, ProductsActivity.class);
                        intent4.putExtra("gender", Product.Gender.LADIES);
                        intent4.putExtra("productType", Product.ProductType.FOOTWEAR);
                        intent4.putExtra("specType", FootWear.ShoesType.RUNNIG);
                        startActivity(intent4);
                        break;
                    case R.id.ladies_boots:
                        Intent intent5 = new Intent(LadiesFootwear.this, ProductsActivity.class);
                        intent5.putExtra("gender", Product.Gender.LADIES);
                        intent5.putExtra("productType", Product.ProductType.FOOTWEAR);
                        intent5.putExtra("specType", FootWear.ShoesType.BOOTS);
                        startActivity(intent5);
                        break;
                }
            }
        };
        football.setOnClickListener(takeMeToProd);
        flips.setOnClickListener(takeMeToProd);
        sandals.setOnClickListener(takeMeToProd);
        running.setOnClickListener(takeMeToProd);
        boots.setOnClickListener(takeMeToProd);

    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(LadiesFootwear.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(LadiesFootwear.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
