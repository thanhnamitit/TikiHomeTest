package vn.tiki.app.home.extension.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("isRefreshing")
fun setIsRefreshing(view: SwipeRefreshLayout, isRefreshing: Boolean) {
    if (view.isRefreshing != isRefreshing)
        view.isRefreshing = isRefreshing
}

@BindingAdapter("onRefreshListener")
fun setOnRefreshListener(view: SwipeRefreshLayout, listener: () -> Unit) {
    view.setOnRefreshListener {
        listener.invoke()
    }
}