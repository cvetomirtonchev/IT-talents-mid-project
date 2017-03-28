package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import shops.Accessories;
import shops.Product;

public class AccessoriesActivity extends AppCompatActivity {

    private Button watches;
    private Button belts;
    private Button glasses;
    private Button hats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesoaries);

        watches = (Button) findViewById(R.id.acc_watches);
        belts = (Button) findViewById(R.id.acc_belts);
        glasses = (Button) findViewById(R.id.acc_glasses);
        hats = (Button) findViewById(R.id.acc_hats);

        View.OnClickListener takeMeToProd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.acc_watches:
                        // tretoto trqbva da e specType navsqkyde za da moje activitito da obraboti pravilno dannite
                        Intent intent = new Intent(AccessoriesActivity.this, ProductsActivity.class);
                        intent.putExtra("gender", Product.Gender.MEN);
                        intent.putExtra("productType", Product.ProductType.ACCESSORIES);
                        intent.putExtra("specType", Accessories.AccessType.WATCHES);
                        startActivity(intent);
                    case R.id.acc_belts:
                        Intent intent2 = new Intent(AccessoriesActivity.this, ProductsActivity.class);
                        intent2.putExtra("gender", Product.Gender.MEN);
                        intent2.putExtra("productType", Product.ProductType.ACCESSORIES);
                        intent2.putExtra("specType", Accessories.AccessType.BELTS);
                        startActivity(intent2);
                    case R.id.acc_glasses:
                        Intent intent3 = new Intent(AccessoriesActivity.this, ProductsActivity.class);
                        intent3.putExtra("gender", Product.Gender.MEN);
                        intent3.putExtra("productType", Product.ProductType.ACCESSORIES);
                        intent3.putExtra("specType", Accessories.AccessType.GLASSES);
                        startActivity(intent3);
                    case R.id.acc_hats:
                        Intent intent4 = new Intent(AccessoriesActivity.this, ProductsActivity.class);
                        intent4.putExtra("gender", Product.Gender.MEN);
                        intent4.putExtra("productType", Product.ProductType.ACCESSORIES);
                        intent4.putExtra("specType", Accessories.AccessType.HATS);
                        startActivity(intent4);

                }
            }
        };
        watches.setOnClickListener(takeMeToProd);
        belts.setOnClickListener(takeMeToProd);
        glasses.setOnClickListener(takeMeToProd);
        hats.setOnClickListener(takeMeToProd);
    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(AccessoriesActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        if (!MainActivity.loggedUser.getShoppingBag().isEmpty()) {
            Intent intent = new Intent(AccessoriesActivity.this, MyShoppingBagActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Bag empty. Please add some products first!", Toast.LENGTH_SHORT).show();
        }
    }
}
