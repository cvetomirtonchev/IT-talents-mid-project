package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import models.ProductAdapter;

public class MyHistoryActivity extends AppCompatActivity {

    private Button back;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_history);

        lv = (ListView) findViewById(R.id.purchased_products);
        back = (Button) findViewById(R.id.back_selection);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyHistoryActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
        ProductAdapter adapter = new ProductAdapter(this, MainActivity.loggedUser.getBoughtProducts());
        lv.setAdapter(adapter);
    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(MyHistoryActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        if (!MainActivity.loggedUser.getShoppingBag().isEmpty()) {
            Intent intent = new Intent(MyHistoryActivity.this, MyShoppingBagActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Bag empty. Please add some products first!", Toast.LENGTH_SHORT).show();
        }
    }
}
