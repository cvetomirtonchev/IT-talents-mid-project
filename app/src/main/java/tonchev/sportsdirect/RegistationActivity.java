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
import static tonchev.sportsdirect.MainActivity.store;

public class RegistationActivity extends AppCompatActivity {
    private Button registration ;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private EditText email;

    static {
        final Store regStore = store;
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


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    potrebiteli.add(new User(username.getText().toString(),password1.getText().toString(),password2.getText().toString(),email.getText().toString(),store));
                    Toast.makeText(RegistationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("username",username.getText().toString());
                    intent.putExtra("password",password1.getText().toString());

                    setResult(1,intent);
                    finish();

                } catch (User.InvalidEmailException e) {
                    Toast.makeText(RegistationActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                } catch (User.InvalidUsernameException e) {
                    Toast.makeText(RegistationActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
                } catch (User.InvalidPasswordException e) {



                    Toast.makeText(RegistationActivity.this, "Invalid password: password must contain Capital letter and a symbol!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }




}





