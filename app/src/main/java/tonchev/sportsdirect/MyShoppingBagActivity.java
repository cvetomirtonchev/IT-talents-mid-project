package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import shops.Product;

public class MyShoppingBagActivity extends AppCompatActivity {

    private Button purchase;
    private Button back;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shopping_bag);

        purchase = (Button) findViewById(R.id.purchase_button);
        back = (Button) findViewById(R.id.back_tosel_button);
        lv = (ListView) findViewById(R.id.purchased_products);
        Toast.makeText(this, " " + MainActivity.loggedUser.getShoppingBag().size(), Toast.LENGTH_SHORT).show();
        ShoppingbagAdapter adapter = new ShoppingbagAdapter(MyShoppingBagActivity.this, ((List) MainActivity.loggedUser.getShoppingBag()));
        lv.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyShoppingBagActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Product p : MainActivity.loggedUser.getShoppingBag()) {
                    MainActivity.store.removeFromCatalog(p);
                    MainActivity.loggedUser.getBoughtProducts().add(p);
                }
                Toast.makeText(MyShoppingBagActivity.this, "You have successfully finished your order", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void callMyHistory(View view) {
        Intent intent = new Intent(MyShoppingBagActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(MyShoppingBagActivity.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
