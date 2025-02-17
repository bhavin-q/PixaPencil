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

package com.therealbluepandabear.pixapencil.models

import kotlin.math.floor

data class Coordinate(val x: Int, val y: Int) {
    fun convertToCoordinatesDouble(): CoordinatesDouble {
        return CoordinatesDouble(x.toDouble(), y.toDouble())
    }

    fun getHorizontallyReflectedCoordinates(bitmapHeight: Int): Coordinate {
        return Coordinate(x, (bitmapHeight - y) - 1)
    }

    fun getVerticallyReflectedCoordinates(bitmapWidth: Int): Coordinate {
        return Coordinate((bitmapWidth - x) - 1, y)
    }

    fun getQuadReflectedCoordinateSet(bitmapWidth: Int, bitmapHeight: Int): List<Coordinate> {
        val horizontallyReflectedCoordinates = getHorizontallyReflectedCoordinates(bitmapHeight)
        val verticallyReflectedCoordinates = getVerticallyReflectedCoordinates(bitmapWidth)

        return listOf(
            horizontallyReflectedCoordinates,
            verticallyReflectedCoordinates,
            Coordinate(verticallyReflectedCoordinates.x, horizontallyReflectedCoordinates.y)
        )
    }

    fun getOctalReflectedCoordinateSet(bitmapWidth: Int, bitmapHeight: Int): List<Coordinate> {
        val octalReflectedCoordinateSet = mutableListOf<Coordinate>()

        octalReflectedCoordinateSet.addAll(getQuadReflectedCoordinateSet(bitmapWidth, bitmapHeight))

        val coordinate1 = Coordinate(y, getVerticallyReflectedCoordinates(bitmapWidth).x)
        val coordinate2 = Coordinate(getHorizontallyReflectedCoordinates(bitmapHeight).y, x)

        octalReflectedCoordinateSet.add(Coordinate(coordinate1.y, coordinate1.x))
        octalReflectedCoordinateSet.add(Coordinate(coordinate2.y, coordinate2.x))

        val coordinates3 = getVerticallyReflectedCoordinates(bitmapWidth)
        val coordinates4 = coordinate2.getVerticallyReflectedCoordinates(bitmapWidth)

        octalReflectedCoordinateSet.add(coordinates3)
        octalReflectedCoordinateSet.add(coordinates4)

        val coordinates5 = coordinates3.getHorizontallyReflectedCoordinates(bitmapHeight)
        val coordinates6 = coordinates4.getHorizontallyReflectedCoordinates(bitmapHeight)

        octalReflectedCoordinateSet.add(coordinates5)
        octalReflectedCoordinateSet.add(coordinates6)

        octalReflectedCoordinateSet.add(coordinates5.getHorizontallyReflectedCoordinates(bitmapHeight))
        octalReflectedCoordinateSet.add(coordinates6.getHorizontallyReflectedCoordinates(bitmapHeight))

        octalReflectedCoordinateSet.add(coordinates5.getHorizontallyReflectedCoordinates(bitmapHeight).getVerticallyReflectedCoordinates(bitmapWidth))
        octalReflectedCoordinateSet.add(coordinates6.getHorizontallyReflectedCoordinates(bitmapHeight).getVerticallyReflectedCoordinates(bitmapWidth))
        octalReflectedCoordinateSet.add(coordinates4.getHorizontallyReflectedCoordinates(bitmapHeight).getVerticallyReflectedCoordinates(bitmapWidth))

        return octalReflectedCoordinateSet
    }

    companion object {
        fun staticSet(x: Int, y: Int): Coordinate {
            return Coordinate(x, y)
        }

        fun fromIndex(index: Int, bitmapWidth: Int): Coordinate {
            return Coordinate(
                x = (index.toDouble() % bitmapWidth.toDouble()).toInt(),
                y = floor(index.toDouble() / bitmapWidth).toInt()
            )
        }
    }
}
