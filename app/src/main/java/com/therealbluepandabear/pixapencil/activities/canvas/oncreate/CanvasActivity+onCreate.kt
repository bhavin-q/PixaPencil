package com.therealbluepandabear.pixapencil.activities.canvas.oncreate

import android.util.Log
import androidx.core.view.doOnPreDraw
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.activities.canvas.binding

fun CanvasActivity.onCreate() {
    prevOrientation = resources.configuration.orientation
    viewModel.currentBitmapAction = null
    initColorPalettesDBIfNotInitialized()
    getExtras()
    setUpFragment()
    setBindings()
    setUpRecyclerView()
    setOnClickListeners()
    initSharedPreferenceObject()

    binding.activityCanvasColorPickerRecyclerView.doOnPreDraw {
        observeColorPaletteColorPickerData()
    }

    binding.root.post {
        toolsFragmentInstance!!.requireView().doOnPreDraw {
            Log.d("BEPPER", viewModel.currentTool.toString())
            toolsFragmentInstance!!.tapOnToolByName(viewModel.currentTool.toolName)
        }
    }
}