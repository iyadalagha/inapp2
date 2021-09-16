package com.supermario.inapp2

import android.R.id
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.inappmessaging.FirebaseInAppMessaging


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseAnalytics.getInstance(this).logEvent("main_screen_opened", null)
        FirebaseInAppMessaging.getInstance().triggerEvent("main_screen_opended")
        FirebaseInAppMessaging.getInstance().addClickListener { inAppMessage, action ->
            var keyCode = inAppMessage.data?.get("keycode")

            Log.d("ttt", "${keyCode.toString()}  ${action.actionUrl}")

            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "234")
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "campaign showen")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "campaign")
            FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        }
    }
}