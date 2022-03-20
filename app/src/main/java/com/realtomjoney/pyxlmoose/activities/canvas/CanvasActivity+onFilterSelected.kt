package com.realtomjoney.pyxlmoose.activities.canvas

import android.graphics.Color
import com.realtomjoney.pyxlmoose.utility.ColorFilterUtilities
import com.realtomjoney.pyxlmoose.utility.StringConstants

fun extendedOnFilterSelected(filterType: String) {
    when (filterType) {
        StringConstants.ColorFilterIdentifier -> outerCanvasInstance.canvasFragment.myCanvasViewInstance.applyBitmapFilter { ColorFilterUtilities.blendColor(it, getSelectedColor()) }
        StringConstants.DarkenFilterIdentifier -> outerCanvasInstance.canvasFragment.myCanvasViewInstance.applyBitmapFilter { ColorFilterUtilities.blendColor(it, Color.BLACK) }
        StringConstants.LightenFilterIdentifier -> outerCanvasInstance.canvasFragment.myCanvasViewInstance.applyBitmapFilter { ColorFilterUtilities.blendColor(it, Color.WHITE) }
        StringConstants.InvertFilterIdentifier  -> outerCanvasInstance.canvasFragment.myCanvasViewInstance.applyBitmapFilter { ColorFilterUtilities.inverseRGB(it) }
        StringConstants.GrayscaleFilterIdentifier -> outerCanvasInstance.canvasFragment.myCanvasViewInstance.applyBitmapFilter { ColorFilterUtilities.grayScale(it) }
    }
}


