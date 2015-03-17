package com.playground.renan.playground.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.playground.renan.playground.R;
import com.playground.renan.playground.adapter.ProductsAdapter;
import com.playground.renan.playground.application.App;
import com.playground.renan.playground.callback.CallBackItemClick;
import com.playground.renan.playground.entity.ItemCart;
import com.playground.renan.playground.utils.CurrencyUtils;

/**
 * Created by renan on 2/26/15.
 */
public class CallbackFragment extends Fragment {

    public static final int NAME_ITEM = R.string.callback_item;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;
    private UIHelper ui;
    private App app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_callback, container, false);
        init();
        return view;
    }

    private void init() {
        ui = new UIHelper();
        app = (App) getActivity().getApplication();
        CallBackItemClick on = event();
        ui.lstItems.setAdapter(new ProductsAdapter(getActivity(), R.layout.item_product, ItemCart.getAll(), on));
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
            txtTotal = (TextView) view.findViewById(R.id.txt_total);
            lstItems = (ListView) view.findViewById(R.id.lst_items);
        }

    }

}
