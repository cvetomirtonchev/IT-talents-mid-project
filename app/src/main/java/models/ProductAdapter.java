package models;

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
import tonchev.sportsdirect.R;

/**
 * Created by Цветомир on 27.3.2017 г..
 */

public class ProductAdapter extends ArrayAdapter {
    private Context context;
    private List<Product> products ;



    public ProductAdapter(Context context, List products) {
        super(context, R.layout.products_view, products);
        this.products = products;
        this.context = context;

    }

    class ViewHolder{
        ImageView image;
        TextView name;
        TextView price;
        ViewHolder(View row){
            image = (ImageView) row.findViewById(R.id.prodcut_image);
            name = (TextView) row.findViewById(R.id.product_name);
            price = (TextView) row.findViewById(R.id.product_price);

        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        View row;
        ViewHolder vh;

        if(convertView==null){
            row = li.inflate(R.layout.products_view,parent,false);
            vh = new ViewHolder(row);
            row.setTag(vh);
        }
        else{
            row = convertView;
            vh = (ViewHolder) row.getTag();
        }
        Product prod = products.get(position);
        ImageView image = vh.image;
        TextView name = vh.name;
        TextView price = vh.price;

        image.setImageResource(prod.getImageId());
        name.setText(prod.getName());
        price.setText(prod.getPrice()+"");

        return row;
    }
}
