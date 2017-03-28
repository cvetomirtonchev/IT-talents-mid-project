package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LadiesFootwear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies_footwear);
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
