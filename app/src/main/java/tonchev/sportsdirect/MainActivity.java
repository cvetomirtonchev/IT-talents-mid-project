package tonchev.sportsdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import shops.Accessories;
import shops.Clothing;
import shops.FootWear;
import shops.Product;
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
        //add some users
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
        //add some products
        String [] colors = {"Green", "Red", "Blue", "Black", "White", "Yellow"};
        int col = colors.length;
        for (int i = 0; i < 1000; i++) {
            Random r = new Random();
            int type = r.nextInt(3);
            if (type == 0) {
                int sizeL = Product.menFootSizes.length;
                store.addToCatalog(new FootWear("Air", Product.Brand.values()[r.nextInt(Product.Brand.values().length)], Product.Gender.values()[r.nextInt(Product.Gender.values().length)], r.nextDouble()*100 +45, "Leather",
                        FootWear.ShoesType.values()[r.nextInt(FootWear.ShoesType.values().length)], colors[r.nextInt(col)], Product.menFootSizes[r.nextInt(sizeL)], r.nextInt(5)+1));

            }
            if (type == 1) {
                int sizeL = Product.accessSizes.length;
                store.addToCatalog(new Accessories("Mile", Product.Brand.values()[r.nextInt(Product.Brand.values().length)],  Product.Gender.values()[r.nextInt(Product.Gender.values().length)], r.nextDouble()*100 +15, "Cool",
                        Accessories.AccessType.values()[r.nextInt(Accessories.AccessType.values().length)], colors[r.nextInt(col)], Product.accessSizes[r.nextInt(sizeL)], r.nextInt(5)+1));
            }
            if (type == 2) {
                int sizeL = Product.menClothSizes.length;
                store.addToCatalog(new Clothing("Stone", Product.Brand.values()[r.nextInt(Product.Brand.values().length)],  Product.Gender.values()[r.nextInt(Product.Gender.values().length)],  r.nextDouble()*100 +15, "Velur",
                        Clothing.ClothType.values()[r.nextInt(Clothing.ClothType.values().length)], colors[r.nextInt(col)], Product.menClothSizes[r.nextInt(sizeL)], r.nextInt(5)+1));
            }
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
