package vn.tiki.app.home.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        initView()
        viewModel.fetchKeywords()
    }

    private fun setupObserver() {
        viewModel.keywords.observe(viewLifecycleOwner, Observer {
            it?.let { keywords ->
                onDataFetched(keywords)
            }
        })
    }

    private fun initView(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = KeywordsAdapter()
        }
    }


    private fun onDataFetched(keywords: List<Keyword>) {
        (binding.recyclerView.adapter as? KeywordsAdapter)?.setNewDatas(keywords)
    }


}