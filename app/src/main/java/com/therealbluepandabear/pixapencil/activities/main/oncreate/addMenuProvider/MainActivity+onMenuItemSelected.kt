package com.therealbluepandabear.pixapencil.activities.main.oncreate.addMenuProvider

import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.commit
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.main.MainActivity
import com.therealbluepandabear.pixapencil.fragments.appinfo.AppInfoFragment
import com.therealbluepandabear.pixapencil.utility.constants.StringConstants

fun MainActivity.onMenuItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.activityMainTopAppMenu_save_project_item -> {
            supportFragmentManager.commit {
                replace(R.id.activityMain_primaryFragmentHost, AppInfoFragment.newInstance())
                addToBackStack(null)
            }
        }

        R.id.activityMainTopAppMenu_dark_light_mode_item -> {
            darkMode = !darkMode

            with(sharedPreferenceObject.edit()) {
                putBoolean(StringConstants.Identifiers.SHARED_PREFERENCE_DARK_LIGHT_MODE_IDENTIFIER, darkMode)
                putBoolean(StringConstants.Identifiers.SHARED_PREFERENCE_DARK_LIGHT_MODE_CHANGED_IDENTIFIER, true)
                apply()
            }

            if (darkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    return true
}