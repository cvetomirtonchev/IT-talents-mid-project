package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LadiesActivity2 extends AppCompatActivity {
    private Button clothing ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladies2);

        clothing = (Button) findViewById(R.id.ladies_clothing);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LadiesActivity2.this,LadiesClothing.class);
                LadiesActivity2.this.startActivity(intent);

            }
        };
        clothing.setOnClickListener(listener2);

    }
}
