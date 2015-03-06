package com.playground.renan.playground.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.playground.renan.playground.R;
import com.playground.renan.playground.ui.activity.MainActivity;

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
        Intent intent = new Intent(this.context, MainActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this.context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setContentIntent(pIntent)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setDefaults(Notification.DEFAULT_ALL).build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        return notification;
    }

    private void sendNotification(Notification notification ){
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(ID_NEW_USER, notification);
    }
}
