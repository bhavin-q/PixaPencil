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

package com.therealbluepandabear.pixapencil.activities.canvas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.therealbluepandabear.pixapencil.fragments.brushes.BrushesFragment
import com.therealbluepandabear.pixapencil.fragments.colorpalettes.ColorPalettesFragment
import com.therealbluepandabear.pixapencil.fragments.filters.FiltersFragment
import com.therealbluepandabear.pixapencil.fragments.tools.ToolsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ToolsFragment.newInstance()
            }

            1 -> {
                FiltersFragment.newInstance()
            }

            2 -> {
                ColorPalettesFragment.newInstance()
            }

            3 -> {
                BrushesFragment.newInstance()
            }

            else -> {
                ToolsFragment.newInstance()
            }
        }
    }
}