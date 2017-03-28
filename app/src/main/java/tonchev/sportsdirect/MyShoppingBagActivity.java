package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import models.ShoppingbagAdapter;
import shops.Product;

public class MyShoppingBagActivity extends AppCompatActivity {

    private Button purchase;
    private Button back;
    private Button clear;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shopping_bag);

        purchase = (Button) findViewById(R.id.purchase_button);
        back = (Button) findViewById(R.id.back_tosel_button);
        clear = (Button) findViewById(R.id.clear_button);
        lv = (ListView) findViewById(R.id.purchased_products);
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
                    MainActivity.loggedUser.getBoughtProducts().add(p);
                }
                MainActivity.loggedUser.getShoppingBag().clear();
                Toast.makeText(MyShoppingBagActivity.this, "You have successfully finished your order", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyShoppingBagActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.loggedUser.getShoppingBag().clear();
                Intent intent = new Intent(MyShoppingBagActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
    }


//    private void quantity (ListView lv, ArrayList<Product> arr) {
//        for (int i = 0; i < lv.getChildCount(); i++) {
//            View v = lv.getChildAt(i);
//            EditText et = (EditText) v.findViewById(R.id.quantity);
//            int qty = Integer.parseInt(et.getText().toString());
//            Product p = arr.get(i);
//            if (qty <= p.getQuantity()) {
//                HashSet<Product> set = MainActivity.store.getCatalog().get(p.getGender()).get(p.getProductType()).get(p.getStock());
//                for (Product product : set) {
//                    if (p == product) {
//                        product.setQuantity(product.getQuantity() - qty);
//                        arr.remove(p);
//                        lv.getChildAt(i).setVisibility(View.GONE);
//                    }
//                }
//            }
//            else {
//                Toast.makeText(this, "Not enough quantity in store for product " + p.getName() + " " + p.getPrice(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


    public void callMyHistory(View view) {
        Intent intent = new Intent(MyShoppingBagActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(MyShoppingBagActivity.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
