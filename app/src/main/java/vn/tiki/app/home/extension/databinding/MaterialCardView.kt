package vn.tiki.app.home.extension.databinding

import android.graphics.Color
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView

val colors = arrayOf(
        Color.parseColor("#F44336"),
        Color.parseColor("#C62828"),
        Color.parseColor("#E91E63"),
        Color.parseColor("#AD1457"),
        Color.parseColor("#AB47BC"),
        Color.parseColor("#4A148C"),
        Color.parseColor("#673AB7"),
        Color.parseColor("#4527A0"),
        Color.parseColor("#3F51B5"),
        Color.parseColor("#283593"),
        Color.parseColor("#2196F3"),
        Color.parseColor("#1565C0"),
        Color.parseColor("#03A9F4"),
        Color.parseColor("#0277BD"),
        Color.parseColor("#00BCD4"),
        Color.parseColor("#00838F"),
        Color.parseColor("#009688"),
        Color.parseColor("#00695C"),
        Color.parseColor("#4CAF50"),
        Color.parseColor("#2E7D32"),
        Color.parseColor("#FF9800"),
        Color.parseColor("#EF6C00"),
        Color.parseColor("#FF5722"),
        Color.parseColor("#D84315")
)

@BindingAdapter("cardBackgroundNumber")
fun setCardBackgroundColorByNumber(cardView: MaterialCardView, index: Int) {
    cardView.setCardBackgroundColor(colors[index.let { if (index > 0) index else -index } % colors.size])
}