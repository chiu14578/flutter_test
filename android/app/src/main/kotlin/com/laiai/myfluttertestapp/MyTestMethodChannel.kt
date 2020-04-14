package com.laiai.myfluttertestapp

import android.app.Activity
import android.content.Intent
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 *
 *
 * @author : zfz
 * e-mail : 137776369@163.com
 * time   : 2020/04/14
 * desc   :
 */
class MyTestMethodChannel(val activity: Activity) : MethodChannel.MethodCallHandler {

    companion object {
        const val CHANNEL = "my_flutter_test"
    }

    private lateinit var channel: MethodChannel


    fun registerWith(flutterEngine: FlutterEngine): MyTestMethodChannel {
        channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
        // setMethodCallHandler 在此通道上接收方法调用的回调
        channel.setMethodCallHandler(this)
        return this
    }


    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            "startNewActivity" -> {
                activity.startActivity(Intent(activity, NewTestActivity::class.java))
                result.success("suceess")
            }
        }
    }
}