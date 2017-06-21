package com.globalpaysolutions.topping.utils;

import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.globalpaysolutions.topping.R;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

/**
 * Created by Josué Chávez on 20/06/2017.
 */

public class OneSignalNotificationExtender extends NotificationExtenderService
{
    final static String TAG = OneSignalNotificationExtender.class.getSimpleName();

    final static String GROUP_KEY_NOTIF = "topping_default_notification";

    @Override
    protected boolean onNotificationProcessing(final OSNotificationReceivedResult notification)
    {
        OverrideSettings overrideSettings = new OverrideSettings();

        overrideSettings.extender = new NotificationCompat.Extender()
        {
            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder)
            {
                return builder.setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                        .setAutoCancel(true)
                        .setGroupSummary(true)
                        .setGroup(GROUP_KEY_NOTIF)
                        .setContentText(notification.payload.body);
            }
        };

        OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        Log.d(TAG, "Notification displayed with id: " + displayedResult.androidNotificationId);

        return true;
    }
}
