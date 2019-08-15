package vn.tiki.app.home.extension.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("isRefreshing")
fun setIsRefreshing(view: SwipeRefreshLayout, isRefreshing: Boolean) {
    if (view.isRefreshing != isRefreshing)
        view.isRefreshing = isRefreshing
}

@BindingAdapter("onRefreshRequested")
fun setOnRefreshRequested(view: SwipeRefreshLayout, isRefreshing: Boolean) {
    if (view.isRefreshing != isRefreshing)
        view.isRefreshing = isRefreshing
}