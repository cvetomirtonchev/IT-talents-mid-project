package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
    }

    public void callFootwaer(View view) {
        Intent intent = new Intent(this, MenFootwearActivity.class);
        startActivity(intent);
    }
}
