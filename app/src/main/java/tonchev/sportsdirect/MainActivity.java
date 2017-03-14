package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import store.Store;
import users.User;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText username;
    private EditText password;

    private static ArrayList<User> users = new ArrayList<>();

    static {
        Store store = new Store("Sofia");
        User pesho;
        User gosho;
        User atanas;

        try {
            pesho = new User("pesho","Pesho123", "Pesho123", "pesho@tuk.com", store);
            users.add(pesho);
        } catch (User.InvalidEmailException e) {
            e.printStackTrace();
        } catch (User.InvalidUsernameException e) {
            e.printStackTrace();
        } catch (User.InvalidPasswordException e) {
            e.printStackTrace();
        }
        try {
            gosho = new User("gosho","Gosho123", "Gosho123", "gosho@tuk.com", store);
            users.add(gosho);
        } catch (User.InvalidEmailException e) {
            e.printStackTrace();
        } catch (User.InvalidUsernameException e) {
            e.printStackTrace();
        } catch (User.InvalidPasswordException e) {
            e.printStackTrace();

        }
        try {
            atanas = new User("atanas","Atanas123", "Atanas123", "atanas@tuk.com", store);
            users.add(atanas);
        } catch (User.InvalidEmailException e) {
            e.printStackTrace();
        } catch (User.InvalidUsernameException e) {
            e.printStackTrace();
        } catch (User.InvalidPasswordException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.login);
        registerButton = (Button) findViewById(R.id.register) ;
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                boolean inDatabase = false;
                for (User u : users) {
                    if (user.equals(u.getUsername()) && pass.equals(u.getPassword())) {
                        Toast.makeText(MainActivity.this, "Successful Log-in!", Toast.LENGTH_SHORT).show();
                        inDatabase = true;
                        Intent intent = new Intent(MainActivity.this,SelectionActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    }
                }
                if (!inDatabase) {
                    Toast.makeText(MainActivity.this, "You are not in the database! Please register first!", Toast.LENGTH_SHORT).show();
                }


            }
        };
        View.OnClickListener registerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistationActivity.class);
                MainActivity.this.startActivity(intent);

            }
        };
        registerButton.setOnClickListener(registerListener);
        loginButton.setOnClickListener(listener);



    }
}
