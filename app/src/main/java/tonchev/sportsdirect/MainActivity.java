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
    public static Store store;
    public static ArrayList<User> potrebiteli = new ArrayList<>();

    static {
        store = new Store("Sofia");
        User pesho;
        User gosho;
        User atanas;
        try {
            gosho = new User("gosho","Gosho123", "Gosho123", "gosho@tuk.com", store);
            potrebiteli.add(gosho);
            atanas = new User("atanas","Atanas123", "Atanas123", "atanas@tuk.com", store);
            potrebiteli.add(atanas);
            pesho = new User("pesho","Pesho123", "Pesho123", "pesho@tuk.com", store);
            potrebiteli.add(pesho);
        }
        catch (User.InvalidEmailException e) {
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
        username = (EditText) findViewById(R.id.loginusername);
        password = (EditText) findViewById(R.id.password);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                boolean inDatabase = false;
                for (User u : potrebiteli) {
                    if (user.equals(u.getUsername().toString()) && pass.equals(u.getPassword().toString())) {
                        Toast.makeText(MainActivity.this, "Successful Log-in!", Toast.LENGTH_SHORT).show();
                        inDatabase = true;
                        Intent intent1 = new Intent(MainActivity.this,SelectionActivity.class);
                        MainActivity.this.startActivity(intent1);
                        break;
                    }
                }
                if (!inDatabase) {
                    Toast.makeText(MainActivity.this, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
                }
            }
        };
        View.OnClickListener registerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistationActivity.class);
                MainActivity.this.startActivityForResult(intent,1);

            }
        };
        registerButton.setOnClickListener(registerListener);
        loginButton.setOnClickListener(listener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if (data !=null){
                username.setText(data.getStringExtra("username"));
                password.setText(data.getStringExtra("password"));
            }
        }
    }
}
