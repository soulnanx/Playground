package com.playground.renan.playground.reciver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.playground.renan.playground.R;

/**
 * Created by renan on 2/20/15.
 */
public class NewUserReceiver extends BroadcastReceiver {

    private Context context;
    private static final int ID_NEW_USER = 1001;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        sendNotification(createNotification("novo usuario!", "fulano foi cadastrado com sucesso, toque para mais detalhes"));
    }

    private Notification createNotification(String title, String text){
        return new NotificationCompat.Builder(this.context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setDefaults(Notification.DEFAULT_ALL).build();
    }

    private void sendNotification(Notification notification ){
        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(ID_NEW_USER, notification);
    }
}
