/*
 * PixaPencil
 * Copyright 2022  therealbluepandabear
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.therealbluepandabear.pixapencil.fragments.colorpicker.rgb

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.therealbluepandabear.pixapencil.databinding.FragmentRGBColorPickerBinding
import com.therealbluepandabear.pixapencil.fragments.colorpicker.oldColor_
import com.therealbluepandabear.pixapencil.utility.InputFilterMinMax
import com.therealbluepandabear.pixapencil.utility.constants.IntConstants
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent.registerEventListener
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar

class RGBColorPickerFragment : Fragment() {
    private lateinit var keyboardVisibilityEventListenerRegistrar: Unregistrar

    private var _binding: FragmentRGBColorPickerBinding? = null

    val binding get(): FragmentRGBColorPickerBinding {
        return _binding!!
    }

    private var valueR = 0f
    private var valueG = 0f
    private var valueB = 0f

    fun unregisterKeyboardVisibilityEventListenerRegistrar() {
        if (::keyboardVisibilityEventListenerRegistrar.isInitialized) {
            keyboardVisibilityEventListenerRegistrar.unregister()
        }
    }

    private fun setup() {
        binding.fragmentRGBColorPickerColorPreview.setBackgroundColor(oldColor_)

        val red = Color.red(oldColor_).toFloat()
        val green = Color.green(oldColor_).toFloat()
        val blue = Color.blue(oldColor_).toFloat()

        binding.fragmentRGBColorPickerRedProgressBar.value = red
        binding.fragmentRGBColorPickerGreenProgressBar.value = green
        binding.fragmentRGBColorPickerBlueProgressBar.value = blue

        binding.fragmentRGBColorPickerValueR.setText(red.toInt().toString())
        binding.fragmentRGBColorPickerValueG.setText(green.toInt().toString())
        binding.fragmentRGBColorPickerValueB.setText(blue.toInt().toString())


        binding.fragmentRGBColorPickerValueR.filters = arrayOf(InputFilterMinMax(IntConstants.RGB_MIN, IntConstants.RGB_MAX))
        binding.fragmentRGBColorPickerValueG.filters = arrayOf(InputFilterMinMax(IntConstants.RGB_MIN, IntConstants.RGB_MAX))
        binding.fragmentRGBColorPickerValueB.filters = arrayOf(InputFilterMinMax(IntConstants.RGB_MIN, IntConstants.RGB_MAX))
    }

    private fun updateColorPickerColorPreview() {
        binding.fragmentRGBColorPickerColorPreview.setBackgroundColor(Color.argb(255, valueR.toInt(), valueG.toInt(), valueB.toInt()))
    }

    private fun setOnChangeListeners() {
            binding.fragmentRGBColorPickerRedProgressBar.addOnChangeListener { _, value, _ ->
                valueR = value
                updateColorPickerColorPreview()
                binding.fragmentRGBColorPickerValueR.setText(valueR.toInt().toString())
            }

            binding.fragmentRGBColorPickerGreenProgressBar.addOnChangeListener { _, value, _ ->
                valueG = value
                updateColorPickerColorPreview()
                binding.fragmentRGBColorPickerValueG.setText(valueG.toInt().toString())
            }

            binding.fragmentRGBColorPickerBlueProgressBar.addOnChangeListener { _, value, _ ->
                valueB = value
                updateColorPickerColorPreview()
                binding.fragmentRGBColorPickerValueB.setText(valueB.toInt().toString())
            }


            binding.fragmentRGBColorPickerValueR.doAfterTextChanged {
                try {
                    valueR = binding.fragmentRGBColorPickerValueR.text.toString().toFloat()
                    valueG = binding.fragmentRGBColorPickerValueG.text.toString().toFloat()
                    valueB = binding.fragmentRGBColorPickerValueB.text.toString().toFloat()

                    updateColorPickerColorPreview()
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }

            binding.fragmentRGBColorPickerValueR.setOnFocusChangeListener{ _, hasFocus ->
                if (!hasFocus) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }
                }
            }

            binding.fragmentRGBColorPickerValueR.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }

                    return@setOnEditorActionListener true
                }
                false
            }

            binding.fragmentRGBColorPickerValueG.doAfterTextChanged {
                try {
                    valueR = binding.fragmentRGBColorPickerValueR.text.toString().toFloat()
                    valueG = binding.fragmentRGBColorPickerValueG.text.toString().toFloat()
                    valueB = binding.fragmentRGBColorPickerValueB.text.toString().toFloat()

                    updateColorPickerColorPreview()
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }

            binding.fragmentRGBColorPickerValueG.setOnFocusChangeListener{ _, hasFocus ->
                if (!hasFocus) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }
                }
            }

            binding.fragmentRGBColorPickerValueG.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }

                    return@setOnEditorActionListener true
                }
                false
            }

            binding.fragmentRGBColorPickerValueB.doAfterTextChanged {
                try {
                    valueR = binding.fragmentRGBColorPickerValueR.text.toString().toFloat()
                    valueG = binding.fragmentRGBColorPickerValueG.text.toString().toFloat()
                    valueB = binding.fragmentRGBColorPickerValueB.text.toString().toFloat()

                    updateColorPickerColorPreview()
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }

            binding.fragmentRGBColorPickerValueB.setOnFocusChangeListener{ _, hasFocus ->
                if (!hasFocus) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }
                }
            }

            binding.fragmentRGBColorPickerValueB.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }

                    return@setOnEditorActionListener true
                }
                false
            }


        keyboardVisibilityEventListenerRegistrar = registerEventListener(requireActivity(),
            KeyboardVisibilityEventListener { isOpen ->
                if (!isOpen) {
                    try {
                        binding.fragmentRGBColorPickerRedProgressBar.value = valueR
                        binding.fragmentRGBColorPickerGreenProgressBar.value = valueG
                        binding.fragmentRGBColorPickerBlueProgressBar.value = valueB
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }
                }
            })
    }

    companion object {
        fun newInstance(): RGBColorPickerFragment {
            return RGBColorPickerFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRGBColorPickerBinding.inflate(inflater, container, false)

        setOnClickListeners()
        setup()
        setOnChangeListeners()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}