package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenActivity extends AppCompatActivity {
    private Button accesoires;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        accesoires = (Button) findViewById(R.id.acces_men);

        accesoires.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenActivity.this , Accesoaries.class);
                MenActivity.this.startActivity(intent);
            }
        });

    }

    public void callFootwear(View view) {
        Intent intent = new Intent(this, MenFootwearActivity.class);
        startActivity(intent);
    }

    public void callClothing (View view) {
        Intent intent = new Intent(this, MenClothingActivity.class);
        startActivity(intent);
    }
}
