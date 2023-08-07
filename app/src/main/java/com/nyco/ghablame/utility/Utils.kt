package com.nyco.ghablame.utility

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.Lifecycle
import org.imaginativeworld.oopsnointernet.dialogs.signal.NoInternetDialogSignal


class Utils {

    companion object {

        fun noInternetDialog(context: Context, lifecycle: Lifecycle) {
            NoInternetDialogSignal.Builder(
                context as Activity,
                lifecycle
            ).apply {
                dialogProperties.apply {

                    cancelable = false
                    noInternetConnectionTitle = "اینترنت متصل نیست !"
                    noInternetConnectionMessage =
                        "برای استفاده از قابلمه نیاز به اینترنت دارید."
                    showInternetOnButtons = true
                    pleaseTurnOnText = "لطفا اینترنت خود را روشن کنید."
                    wifiOnButtonText = "Wifi"
                    mobileDataOnButtonText = "Mobile data"
                    onAirplaneModeTitle = "حالت هوایپیما فعال است !"
                    onAirplaneModeMessage = "برای استفاده از قابلمه نیاز به اینترنت دارید."
                    pleaseTurnOffText = "لطفا دستگاه خود را از حالت هواپیما خارج کنید."
                    airplaneModeOffButtonText = "حالت هواپیما"
                    showAirplaneModeOffButtons = true
                }
            }.build()
        }
    }
}