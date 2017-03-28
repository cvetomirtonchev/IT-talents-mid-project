package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LadiesClothing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies_clothing);
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


