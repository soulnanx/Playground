package com.playground.renan.playground.pojo;

import com.playground.renan.playground.ui.fragment.CartFragment;

import java.util.ArrayList;


public class MenuItem {

    private String fragmentName;
    private int label;
    private int icon;

    public MenuItem() {
    }

    private MenuItem(String fragmentName, int label, int icon) {
        this.fragmentName = fragmentName;
        this.label = label;
        this.icon = icon;
    }

    public ArrayList<MenuItem> getItemsMenu(){
        ArrayList<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(CartFragment.class.getName(), CartFragment.NAME_ITEM, CartFragment.ICON_ITEM));
        list.add(new MenuItem(CartFragment.class.getName(), CartFragment.NAME_ITEM, CartFragment.ICON_ITEM));
        list.add(new MenuItem(CartFragment.class.getName(), CartFragment.NAME_ITEM, CartFragment.ICON_ITEM));

        return list;
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public int getLabel() {
        return label;
    }

    public int getIcon() {
        return icon;
    }


}
