package tonchev.sportsdirect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import store.Store;
import users.User;

import static tonchev.sportsdirect.MainActivity.potrebiteli;

public class RegistationActivity extends AppCompatActivity {
    private Button registration ;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private EditText email;

    static {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        registration = (Button) findViewById(R.id.register_button);
        username = (EditText) findViewById(R.id.username_register);
        password1 = (EditText) findViewById(R.id.pass1_register);
        password2= (EditText) findViewById(R.id.pass2_register);
        email = (EditText) findViewById(R.id.email_register);
        final Store store = new Store("Sofia");

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    potrebiteli.add(new User(username.toString(),password1.toString(),password2.toString(),email.toString(),store));
                    Intent intent = new Intent(RegistationActivity.this,MainActivity.class);
                    RegistationActivity.this.startActivity(intent);



                } catch (User.InvalidEmailException e) {
                    Toast.makeText(RegistationActivity.this, "Invalid email adress", Toast.LENGTH_SHORT).show();
                } catch (User.InvalidUsernameException e) {
                    Toast.makeText(RegistationActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
                } catch (User.InvalidPasswordException e) {
                    Toast.makeText(RegistationActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegistationActivity.this, "Password"+password1.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegistationActivity.this, "Password"+password2.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
