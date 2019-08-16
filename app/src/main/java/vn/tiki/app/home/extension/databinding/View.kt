package vn.tiki.app.home.extension.databinding

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("goneUnless")
fun setGoneUnless(view: View, condition: Boolean) {
    if (condition) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}