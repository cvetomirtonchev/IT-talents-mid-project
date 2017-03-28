package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyHistoryActivity extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_history);

        back = (Button) findViewById(R.id.back_selection);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyHistoryActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
    }

    public void callMyHistory(View view) {
        Intent intent = new Intent(MyHistoryActivity.this, MyHistoryActivity.class);
        startActivity(intent);
    }

    public void callShoppingBag(View view) {
        Intent intent = new Intent(MyHistoryActivity.this, MyShoppingBagActivity.class);
        startActivity(intent);
    }
}
