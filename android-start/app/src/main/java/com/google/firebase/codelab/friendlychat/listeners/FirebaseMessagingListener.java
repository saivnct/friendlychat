package com.google.firebase.codelab.friendlychat.listeners;

import com.google.firebase.messaging.RemoteMessage;

//From Firebase Cloud Messaging Service
public interface FirebaseMessagingListener {
        void onMessageReceived(RemoteMessage remoteMessage);
}
