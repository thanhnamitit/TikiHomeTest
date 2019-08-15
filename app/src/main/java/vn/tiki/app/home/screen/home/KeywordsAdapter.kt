package vn.tiki.app.home.screen.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.databinding.ItemKeywordBinding

class KeywordsAdapter : RecyclerView.Adapter<KeywordsAdapter.Holder>(){

    private val keywords = mutableListOf<Keyword>()

    fun setNewDatas(keywords : List<Keyword>){
        this.keywords.apply {
            clear()
            addAll(keywords)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemKeywordBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return keywords.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(ItemKeywordViewModel(keywords[position]))
    }

    class Holder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun setData(viewModel : ItemKeywordViewModel){
            binding.setVariable(BR.viewModel, viewModel)
        }
    }
}
