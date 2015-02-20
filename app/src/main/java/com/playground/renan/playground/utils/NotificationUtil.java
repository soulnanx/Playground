package com.playground.renan.playground.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by renan on 2/20/15.
 */
public class NotificationUtil {

    public static void sendNotification(String action, Context context){
        Intent intent = new Intent();
        intent.setAction("newUser");
        context.sendBroadcast(intent);
    }
}
