package com.example.nativeapp


import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint


class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        // Instantiate a FlutterEngine.
        val flutterEngine1 = FlutterEngine(this)
        flutterEngine1.navigationChannel.setInitialRoute("/scndScreen")
        flutterEngine1.dartExecutor.executeDartEntrypoint(
            DartEntrypoint.createDefault()
        )

        val flutterEngine2 = FlutterEngine(this)
        flutterEngine2.navigationChannel.setInitialRoute("/scndScreen")

        flutterEngine2.dartExecutor.executeDartEntrypoint(
            DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put("engine1", flutterEngine1)

        FlutterEngineCache
            .getInstance()
            .put("engine2", flutterEngine2)
    }
}


//object FlutterEngineManager {
//
// fun flutterEngine(context: Context, engineId: String, entryPoint: String): FlutterEngine {
//  // 1. 从缓存中获取FlutterEngine
//  var engine = FlutterEngineCache.getInstance().get(engineId)
//  if (engine == null) {
//   // 如果缓存中没有FlutterEngine
//   // 1. 新建FlutterEngine，执行的入口函数是entryPoint
//   val app = context.applicationContext as MyApplication
//   val dartEntrypoint = DartExecutor.DartEntrypoint(
//    FlutterInjector.instance().flutterLoader().findAppBundlePath(), entryPoint
//   )
//   engine = app.flutterEngine
//    .createAndRunEngine(context, dartEntrypoint)
//   // 2. 存入缓存
//   FlutterEngineCache.getInstance().put(engineId, engine)
//  }
//  return engine!!
// }

//}