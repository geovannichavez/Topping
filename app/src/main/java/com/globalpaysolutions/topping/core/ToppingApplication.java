package com.globalpaysolutions.topping.core;

import android.app.Application;
import android.content.res.Configuration;

import com.globalpaysolutions.topping.utils.OneSignalNotificationOpenedHandler;
import com.globalpaysolutions.topping.utils.OneSignalNotificationReceivedHandler;
import com.onesignal.OneSignal;

/**
 * Created by Josué Chávez on 20/06/2017.
 */

public class ToppingApplication extends Application
{
    private static ToppingApplication appSingleton;

    public static ToppingApplication getInstance()
    {
        return appSingleton;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        appSingleton = this;

        //OneSignal Required Code
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new OneSignalNotificationOpenedHandler(this))
                .setNotificationReceivedHandler(new OneSignalNotificationReceivedHandler())
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effectiveness of OneSignal's "best-time" notification scheduling feature.
        // OneSignal.syncHashedEmail(userEmail);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
    }
}
