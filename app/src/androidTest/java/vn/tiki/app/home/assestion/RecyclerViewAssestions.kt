package vn.tiki.app.home.assestion

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.ViewAssertion
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

fun isEmpty(): ViewAssertion {
    return ViewAssertion { view, noViewFoundException ->
        if (null != noViewFoundException) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        assertEquals(recyclerView.adapter!!.itemCount.toLong(), 0)
    }
}


fun isNotEmpty(): ViewAssertion {
    return ViewAssertion { view, noViewFoundException ->
        if (null != noViewFoundException) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        assertNotEquals(recyclerView.adapter!!.itemCount.toLong(), 0)
    }
}

