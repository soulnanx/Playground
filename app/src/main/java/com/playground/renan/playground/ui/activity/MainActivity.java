package com.playground.renan.playground.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.playground.renan.playground.R;
import com.playground.renan.playground.adapter.ItemProductsAdapter;
import com.playground.renan.playground.application.App;
import com.playground.renan.playground.callback.CallBackItemClick;
import com.playground.renan.playground.entity.ItemCart;
import com.playground.renan.playground.utils.CurrencyUtils;


public class MainActivity extends ActionBarActivity {

    private UIHelper ui;
    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ui = new UIHelper();
        app = (App) getApplication();
        CallBackItemClick on = event();


        ui.lstItems.setAdapter(new ItemProductsAdapter(this, R.layout.item_product, ItemCart.getFakeList(), on));
        updateTotalValue();
    }

    private CallBackItemClick event() {
        return new CallBackItemClick() {
            @Override
            public void updateValue() {
                updateTotalValue();
            }
        };
    }

    private void updateTotalValue(){
        ui.txtTotal.setText(CurrencyUtils.format(app.cart.getTotalCartValue()));
    }

    class UIHelper {

        TextView txtTotal;
        ListView lstItems;

        public UIHelper(){
            txtTotal = (TextView) findViewById(R.id.txt_total);
            lstItems = (ListView) findViewById(R.id.lst_items);
        }

    }


}
