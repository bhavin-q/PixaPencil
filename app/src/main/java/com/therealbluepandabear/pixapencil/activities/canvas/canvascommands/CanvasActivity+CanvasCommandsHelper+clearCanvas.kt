package com.therealbluepandabear.pixapencil.activities.canvas.canvascommands

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.extensions.clear

fun CanvasActivity.CanvasCommandsHelper.clearCanvas() {
    baseReference.binding.activityCanvasPixelGridView.pixelGridViewBitmap.clear()
    baseReference.viewModel.currentBitmap = baseReference.binding.activityCanvasPixelGridView.pixelGridViewBitmap

    baseReference.viewModel.undoStack.clear()
    baseReference.viewModel.redoStack.clear()
}