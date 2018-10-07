package com.google.firebase.codelab.friendlychat.helper;

import android.util.Log;

import com.google.firebase.codelab.friendlychat.listeners.FirebaseMessagingListener;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListenerHelper {
    private static final String TAG = ListenerHelper.class.getSimpleName();
    private static ListenerHelper mInstance;

    private List<FirebaseMessagingListener> mFirebaseMessagingListeners = new CopyOnWriteArrayList<FirebaseMessagingListener>();

    public static ListenerHelper getInstance() {
        if (mInstance == null)
            mInstance = new ListenerHelper();
        return mInstance;
    }

    private ListenerHelper() {

    }


    //region FirebaseMessagingListener
    public void addFirebaseMessagingListener(FirebaseMessagingListener listener) {
        if (!mFirebaseMessagingListeners.contains(listener)) {
            mFirebaseMessagingListeners.add(listener);
        }
    }

    public void removeFirebaseMessagingListener(FirebaseMessagingListener listener) {
        if (mFirebaseMessagingListeners.contains(listener)) {
            mFirebaseMessagingListeners.remove(listener);
        }
    }

    public void onFirebaseMessageReceived(RemoteMessage remoteMessage) {
        if (mFirebaseMessagingListeners != null && !mFirebaseMessagingListeners.isEmpty()) {
            for (FirebaseMessagingListener listener : mFirebaseMessagingListeners) {
                listener.onMessageReceived(remoteMessage);
            }
        } else {
            Log.d(TAG, "no listener for contacts changed");
        }
    }
    //endregion

}
