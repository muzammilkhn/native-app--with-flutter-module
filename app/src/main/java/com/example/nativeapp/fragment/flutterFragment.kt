package com.example.nativeapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.nativeapp.R
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.FlutterEngine


class flutterFragment : Fragment(){
    private lateinit var engine: FlutterEngine
    private var engineId="engine1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val flutterFragment = FlutterFragment.withCachedEngine(engineId).build<FlutterFragment>()
        val flutterFragment = FlutterFragment.withCachedEngine(engineId)
            .build<FlutterFragment>()

        // 4. 显示FlutterFragment
        parentFragmentManager.beginTransaction().replace(R.id.fragmentNew, flutterFragment).commit()


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flutter, container, false)
    }

}