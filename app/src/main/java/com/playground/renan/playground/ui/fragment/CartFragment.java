package com.playground.renan.playground.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playground.renan.playground.R;

/**
 * Created by renan on 2/26/15.
 */
public class CartFragment extends Fragment {

    public static final int NAME_ITEM = R.string.cart_item;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cart, container, false);
        init();
        return view;
    }

    private void init() {

    }
}
