package com.playground.renan.playground.pojo;

import com.playground.renan.playground.R;
import com.playground.renan.playground.ui.fragment.CallbackFragment;
import com.playground.renan.playground.ui.fragment.NotificationFragment;

import java.util.ArrayList;


public class MenuItem {

    private String fragmentName;
    private int label;
    private int icon;

    private MenuItem(Class fragment) {
        this.fragmentName =  fragment.getName();
        try {
            this.label = fragment.getDeclaredField("NAME_ITEM").getInt(Integer.class);
            this.icon = fragment.getDeclaredField("ICON_ITEM").getInt(Integer.class);
        } catch (Exception e) {
            this.label = R.string.default_item_menu;
            this.icon = android.R.drawable.ic_media_play;
        }
    }

    public static ArrayList<MenuItem> getItemsMenu(){
        ArrayList<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(CallbackFragment.class));
        list.add(new MenuItem(NotificationFragment.class));
        list.add(new MenuItem(CallbackFragment.class));

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
