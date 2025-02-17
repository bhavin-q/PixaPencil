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

package com.therealbluepandabear.pixapencil.database

import android.graphics.Color

object ColorDatabase {
    private val database = mutableListOf<Int>()

    private fun addColor(color: Int) = database.add(color)

    fun toList(): List<Int> {
        return database.toList()
    }

    init {
        val colorData = listOf(
            Color.parseColor("#0048BA"),
            Color.parseColor("#B0BF1A"),
            Color.parseColor("#7CB9E8"),
            Color.parseColor("#C0E8D5"),
            Color.parseColor("#B284BE"),
            Color.parseColor("#0048BA"),
            Color.parseColor("#72A0C1"),
            Color.parseColor("#EDEAE0"),
            Color.parseColor("#F0F8FF"),
            Color.parseColor("#C46210"),
            Color.parseColor("#EFDECD"),
            Color.parseColor("#E52B50"),
            Color.parseColor("#9F2B68"),
            Color.parseColor("#F19CBB"),
            Color.parseColor("#AB274F"),
            Color.parseColor("#D3212D"),
            Color.parseColor("#3B7A57"),
            Color.parseColor("#FFBF00"),
            Color.parseColor("#FF7E00"),
            Color.parseColor("#9966CC"),
            Color.parseColor("#3DDC84"),
            Color.parseColor("#CD9575"),
            Color.parseColor("#665D1E"),
            Color.parseColor("#915C83"),
            Color.parseColor("#841B2D"),
            Color.parseColor("#FAEBD7"),
            Color.parseColor("#008000"),
            Color.parseColor("#8DB600"),
            Color.parseColor("#FBCEB1"),
            Color.parseColor("#00FFFF"),
            Color.parseColor("#7FFFD4"),
            Color.parseColor("#D0FF14"),
            Color.parseColor("#4B5320"),
            Color.parseColor("#8F9779"),
            Color.parseColor("#E9D66B"),
            Color.parseColor("#B2BEB5"),
            Color.parseColor("#87A96B"),
            Color.parseColor("#FF9966"),
            Color.parseColor("#A52A2A"),
            Color.parseColor("#FDEE00"),
            Color.parseColor("#568203"),
            Color.parseColor("#007FFF"),
            Color.parseColor("#F0FFFF"),
            Color.parseColor("#89CFF0"),
            Color.parseColor("#A1CAF1"),
            Color.parseColor("#F4C2C2"),
            Color.parseColor("#FEFEFA"),
            Color.parseColor("#FF91AF"),
            Color.parseColor("#FAE7B5"),
            Color.parseColor("#DA1884"),
            Color.parseColor("#7C0A02"),
            Color.parseColor("#848482"),
            Color.parseColor("#BCD4E6"),
            Color.parseColor("#9F8170"),
            Color.parseColor("#F5F5DC"),
            Color.parseColor("#2E5894"),
            Color.parseColor("#9C2542"),
            Color.parseColor("#FFE4C4"),
            Color.parseColor("#3D2B1F"),
            Color.parseColor("#967117"),
            Color.parseColor("#CAE00D"),
            Color.parseColor("#BFFF00"),
            Color.parseColor("#FE6F5E"),
            Color.parseColor("#BF4F51"),
            Color.parseColor("#000000"),
            Color.parseColor("#3D0C02"),
            Color.parseColor("#1B1811"),
            Color.parseColor("#3B2F2F"),
            Color.parseColor("#54626F"),
            Color.parseColor("#3B3C36"),
            Color.parseColor("#BFAFB2"),
            Color.parseColor("#FFEBCD"),
            Color.parseColor("#A57164"),
            Color.parseColor("#318CE7"),
            Color.parseColor("#ACE5EE"),
            Color.parseColor("#FAF0BE"),
            Color.parseColor("#660000"),
            Color.parseColor("#0000FF"),
            Color.parseColor("#1F75FE"),
            Color.parseColor("#0093AF"),
            Color.parseColor("#0087BD"),
            Color.parseColor("#0018A8"),
            Color.parseColor("#333399"),
            Color.parseColor("#0247FE"),
            Color.parseColor("#A2A2D0"),
            Color.parseColor("#6699CC"),
            Color.parseColor("#0D98BA"),
            Color.parseColor("#064E40"),
            Color.parseColor("#5DADEC"),
            Color.parseColor("#126180"),
            Color.parseColor("#8A2BE2"),
            Color.parseColor("#7366BD"),
            Color.parseColor("#4D1A7F"),
            Color.parseColor("#5072A7"),
            Color.parseColor("#F5F5DC"),
            Color.parseColor("#3C69E7"),
            Color.parseColor("#DE5D83"),
            Color.parseColor("#79443B"),
            Color.parseColor("#E3DAC9"),
            Color.parseColor("#006A4E"),
            Color.parseColor("#87413F"),
            Color.parseColor("#CB4154"),
            Color.parseColor("#66FF00"),
            Color.parseColor("#D891EF"),
            Color.parseColor("#C32148"),
            Color.parseColor("#1974D2"),
            Color.parseColor("#FFAA1D"),
            Color.parseColor("#FF55A3"),
            Color.parseColor("#FB607F"),
            Color.parseColor("#004225"),
            Color.parseColor("#CD7F32"),
            Color.parseColor("#88540B"),
            Color.parseColor("#AF6E4D"),
            Color.parseColor("#1B4D3E"),
            Color.parseColor("#7BB661"),
            Color.parseColor("#FFC680"),
            Color.parseColor("#800020"),
            Color.parseColor("#DEB887"),
            Color.parseColor("#A17A74"),
            Color.parseColor("#CC5500"),
            Color.parseColor("#E97451"),
            Color.parseColor("#8A3324"),
            Color.parseColor("#BD33A4"),
            Color.parseColor("#702963"),
            Color.parseColor("#536872"),
            Color.parseColor("#5F9EA0"),
            Color.parseColor("#A9B2C3"),
            Color.parseColor("#91A3B0"),
            Color.parseColor("#006B3C"),
            Color.parseColor("#ED872D"),
            Color.parseColor("#E30022"),
            Color.parseColor("#FFF600"),
            Color.parseColor("#A67B5B"),
            Color.parseColor("#4B3621"),
            Color.parseColor("#A3C1AD"),
            Color.parseColor("#C19A6B"),
            Color.parseColor("#EFBBCC"),
            Color.parseColor("#FFFF99"),
            Color.parseColor("#FFEF00"),
            Color.parseColor("#FF0800"),
            Color.parseColor("#E4717A"),
            Color.parseColor("#00BFFF"),
            Color.parseColor("#592720"),
            Color.parseColor("#C41E3A"),
            Color.parseColor("#00CC99"),
            Color.parseColor("#960018"),
            Color.parseColor("#D70040"),
            Color.parseColor("#FFA6C9"),
            Color.parseColor("#B31B1B"),
            Color.TRANSPARENT
        )

        for (color in colorData) {
            addColor(color)
        }
    }
}