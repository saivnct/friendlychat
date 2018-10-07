/**
 * Copyright Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.firebase.codelab.friendlychat.services;

import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.codelab.friendlychat.helper.ListenerHelper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


//FirebaseMessagingService which is provided by the firebase-fcm library added earlier.
//It automatically handles notification messages, which are messages that the server specifies should produce a notification.
// To handle data messages (which are passed silently to the app rather than automatically creating a notification) you can override the onMessageReceived method from the FirebaseMessagingService base class
public class MyFirebaseMessagingService extends FirebaseMessagingService{

    private static final String TAG = "MyFMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        ListenerHelper.getInstance().onFirebaseMessageReceived(remoteMessage);

        Log.d(TAG, "FCM Message Id: " + remoteMessage.getMessageId());

        Log.d(TAG, "FCM Data Message: " + remoteMessage.getData().toString());
        if (!TextUtils.isEmpty(remoteMessage.getNotification().getBody())){
            Log.d(TAG, "FCM Notification body Message: " + remoteMessage.getNotification().getBody());
        }
        if (!TextUtils.isEmpty(remoteMessage.getNotification().getTitle())){
            Log.d(TAG, "FCM Notification title Message: " + remoteMessage.getNotification().getTitle());
        }
    }

}
