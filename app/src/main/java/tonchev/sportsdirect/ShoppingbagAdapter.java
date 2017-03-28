package tonchev.sportsdirect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import shops.Product;

/**
 * Created by Vasko on 28.3.2017.
 */

public class ShoppingbagAdapter extends ArrayAdapter {

    private Context context;
    private List<Product> products;

    public ShoppingbagAdapter(@NonNull Context context, @NonNull List prods) {
        super(context, R.layout.shopping_bag_row, prods);
        this.products = prods;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View bagRow = layoutInflater.inflate(R.layout.shopping_bag_row, parent, false);

        ImageView img = (ImageView) bagRow.findViewById(R.id.prod_image);
        TextView name = (TextView) bagRow.findViewById(R.id.prod_name);
        TextView brand = (TextView) bagRow.findViewById(R.id.prod_brand);
        TextView size = (TextView) bagRow.findViewById(R.id.prod_size);
        TextView price = (TextView) bagRow.findViewById(R.id.prod_price);

        Product p = products.get(position);

        img.setImageResource(p.getImageId());
        name.setText(p.getName());
        brand.setText(p.getBrand() + "");
        size.setText("Size: " + p.getSize() );
        price.setText("Price: " + p.getPrice() + "lv.");

        return bagRow;
    }
}
