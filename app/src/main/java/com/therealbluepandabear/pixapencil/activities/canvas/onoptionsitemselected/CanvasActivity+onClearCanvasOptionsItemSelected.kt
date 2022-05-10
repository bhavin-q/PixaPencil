package com.therealbluepandabear.pixapencil.activities.canvas.onoptionsitemselected

import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.activities.canvas.clearCanvas
import com.therealbluepandabear.pixapencil.extensions.showDialog

fun CanvasActivity.onClearCanvasOptionsItemSelected() {
    showDialog(
        getString(R.string.dialog_clear_canvas_title_in_code_str),
        getString(R.string.dialog_clear_canvas_message_in_code_str),
        getString(R.string.dialog_positive_button_text_in_code_str),
        { _, _ ->
            clearCanvas()
        }, getString(R.string.dialog_negative_button_text_in_code_str), { _, _ -> }, null)
}