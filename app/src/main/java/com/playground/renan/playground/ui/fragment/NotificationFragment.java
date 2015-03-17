package com.playground.renan.playground.ui.fragment;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.playground.renan.playground.R;
import com.playground.renan.playground.utils.NotificationUtil;

/**
 * Created by renan on 2/26/15.
 */
public class NotificationFragment extends Fragment {

    public static final int NAME_ITEM = R.string.notification_item;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;
    private UIHelper ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_notification, container, false);
        init();
        setEvents();
        return view;
    }

    private void setEvents() {
        ui.img.setOnClickListener(onClickImg());
    }

    private View.OnClickListener onClickImg() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.sendNotification(NotificationUtil.DEFAULT_ACTION, getActivity());
            }
        };
    }

    private void init() {
        ui = new UIHelper();

    }

    class UIHelper{

        ImageView img;

        UIHelper() {
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}
