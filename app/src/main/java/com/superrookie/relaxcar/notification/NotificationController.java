package com.superrookie.relaxcar.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import com.superrookie.relaxcar.R;
import com.superrookie.relaxcar.utils.Utils;

/**
 * Created by Hyunsun on 2018. 5. 27..
 */

public class NotificationController {

    private NotificationManager mNotificationManager;
    private static NotificationController mNotificationController;

    private NotificationController(Context context) {
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel();
    }

    public static synchronized NotificationController getController(Context context) {
        if (mNotificationController == null) {
            mNotificationController = new NotificationController(context);
        }
        return mNotificationController;
    }

    private void createChannel() {
        if (Utils.isOOS()) {
            NotificationChannel channelMessage = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);
            channelMessage.setDescription("channel description");
            channelMessage.enableLights(true);
            channelMessage.setLightColor(Color.GREEN);
            mNotificationManager.createNotificationChannel(channelMessage);
        }
    }

    public void showNotification(Context context, String notificationTitle, String notificationText) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (Utils.isOOS()) {
            builder.setChannelId("channel_id");
        }

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
