package com.playground.renan.playground.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.playground.renan.playground.R;
import com.playground.renan.playground.application.App;
import com.playground.renan.playground.callback.CallBackItemClick;
import com.playground.renan.playground.entity.ItemCart;
import com.playground.renan.playground.utils.CurrencyUtils;

import java.util.List;

/**
 * Created by renan on 2/9/15.
 */
public class ProductsAdapter extends ArrayAdapter<ItemCart> {

    private int resource;
    private CallBackItemClick callBackItemClick;
    private App app;

    public ProductsAdapter(Context context, int resource, List<ItemCart> objects) {
        super(context, resource, objects);
    }

    public ProductsAdapter(Context context, int resource, List<ItemCart> objects, CallBackItemClick callBackItemClick) {
        super(context, resource, objects);
        this.resource = resource;
        this.callBackItemClick = callBackItemClick;
        this.app = (App)getContext().getApplicationContext();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        ItemCart itemCart = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name.setText(itemCart.getProduct().getName());
        holder.description.setText(itemCart.getProduct().getDescription());
        holder.value.setText(CurrencyUtils.format(itemCart.getProduct().getValue()));
        holder.quantity.setText(String.valueOf(itemCart.getQuantity()));

        holder.imgAdd.setOnClickListener(onClickAddBtn(itemCart));
        holder.imgRemove.setOnClickListener(onClickRemoveBtn(itemCart));

        return convertView;
    }

    private View.OnClickListener onClickRemoveBtn(final ItemCart itemCart) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.cart.removeItemOnCart(itemCart);
                callBackItemClick.updateValue();
                notifyDataSetChanged();
            }
        };
    }

    private View.OnClickListener onClickAddBtn(final ItemCart itemCart) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.cart.addItemOnCart(itemCart);
                callBackItemClick.updateValue();
                notifyDataSetChanged();
            }
        };
    }


    class Holder {
        TextView name;
        TextView value;
        TextView description;
        TextView quantity;
        View imgAdd;
        View imgRemove;

        public Holder(View v){
            name = (TextView) v.findViewById(R.id.txt_name);
            value = (TextView) v.findViewById(R.id.txt_value);
            description = (TextView) v.findViewById(R.id.txt_description);
            quantity = (TextView) v.findViewById(R.id.txt_quantity);
            imgAdd = v.findViewById(R.id.img_add);
            imgRemove = v.findViewById(R.id.img_remove);

        }

    }
}
