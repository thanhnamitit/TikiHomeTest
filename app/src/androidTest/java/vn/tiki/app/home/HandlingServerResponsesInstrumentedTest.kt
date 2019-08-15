package vn.tiki.app.home

import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import vn.tiki.app.home.di.DaggerTestApplicationComponent
import vn.tiki.app.home.screen.MainActivity

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
    fun setup() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as App
        DaggerTestApplicationComponent.builder().application(app).build().inject(app)
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation()
                .targetContext, MainActivity::class.java
        )

        activityRule.launchActivity(intent)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("vn.tiki.app.home", appContext.packageName)
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withText("chiu")).perform(ViewActions.click())

    }
}
