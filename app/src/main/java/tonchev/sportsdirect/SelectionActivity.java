package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {
    private Button ladiesChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        ladiesChoice = (Button) findViewById(R.id.ladiesButton);
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this,LadiesActivity2.class);
                SelectionActivity.this.startActivity(intent);
            }
        };
        ladiesChoice.setOnClickListener(listener);
    }

    public void menChoice(View view) {
        Intent intent = new Intent(this, MenActivity.class);
        startActivity(intent);
    }
}
