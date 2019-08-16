package vn.tiki.app.home

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.test.espresso.Espresso.onIdle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import vn.tiki.app.home.assestion.isNotEmpty
import vn.tiki.app.home.di.DaggerTestApplicationComponent
import vn.tiki.app.home.matcher.SwipeRefreshLayoutMatchers
import vn.tiki.app.home.screen.MainActivity
import vn.tiki.app.home.test.EspressoIdlingResource

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HandlingServerResponsesInstrumentedTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun injectTestComponent() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource())
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as App
        DaggerTestApplicationComponent.builder().application(app).build().inject(app)
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation()
                .targetContext, MainActivity::class.java
        )
        activityRule.launchActivity(intent)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource())
    }

    fun rotate() {
        activityRule.activity?.let {
            it.requestedOrientation =
                if (it.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) ActivityInfo.SCREEN_ORIENTATION_PORTRAIT else ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }


    @Test
    fun testResponseAndConfigChange() {
        onIdle()
        onView(instanceOf(SwipeRefreshLayout::class.java)).check(matches(not(SwipeRefreshLayoutMatchers.isRefreshing())))
        onView(withText(R.string.home_try_again)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.recycler_view)).check(isNotEmpty())
        rotate()
        Thread.sleep(1000)
        onView(withId(R.id.recycler_view)).check(isNotEmpty())
        onView(instanceOf(SwipeRefreshLayout::class.java)).perform(swipeDown())
        onIdle()
        rotate()
        onView(withId(R.id.recycler_view)).check(isNotEmpty())
    }
}
