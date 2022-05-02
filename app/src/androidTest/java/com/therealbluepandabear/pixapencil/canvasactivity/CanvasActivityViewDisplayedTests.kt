package com.therealbluepandabear.pixapencil.canvasactivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.database.AppData
import com.therealbluepandabear.pixapencil.database.ColorPalettesDatabase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CanvasActivityViewDisplayedTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(CanvasActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity {
            AppData.colorPalettesDB = ColorPalettesDatabase.getDatabase(it)
        }
    }

    @Test
    fun checkCanvasToolsScrollView_hIsDisplayed() {
        onView(withId(R.id.activityCanvas_canvasToolsScrollView_h)).check(matches(isDisplayed()))
    }

    @Test
    fun checkColorPickerRecyclerViewIsDisplayed() {
        onView(withId(R.id.activityCanvas_colorPickerRecyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun checkColorPrimaryViewIsDisplayed() {
        onView(withId(R.id.activityCanvas_colorPrimaryView)).check(matches(isDisplayed()))
    }

    @Test
    fun checkColorPrimaryViewIndicatorIsDisplayed() {
        onView(withId(R.id.activityCanvas_colorPrimaryViewIndicator)).check(matches(isDisplayed()))
    }

    @Test
    fun checkColorSecondaryViewIsDisplayed() {
        onView(withId(R.id.activityCanvas_colorSecondaryView)).check(matches(isDisplayed()))
    }

    @Test
    fun checkOuterCanvasFragmentHostIsDisplayed() {
        onView(withId(R.id.activityCanvas_outerCanvasFragmentHost)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPrimaryFragmentHostIsDisplayed() {
        onView(withId(R.id.activityCanvas_primaryFragmentHost)).check(matches(isDisplayed()))
    }

    @Test
    fun checkRootLayoutIsDisplayed() {
        onView(withId(R.id.activityCanvas_rootLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTabLayoutIsDisplayed() {
        onView(withId(R.id.activityCanvas_tabLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTabLayoutFragmentHostIsDisplayed() {
        onView(withId(R.id.activityCanvas_tabLayoutFragmentHost)).check(matches(isDisplayed()))
    }
}