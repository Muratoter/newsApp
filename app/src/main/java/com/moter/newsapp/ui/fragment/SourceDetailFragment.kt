package com.moter.newsapp.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moter.newsapp.R
import com.moter.newsapp.databinding.FragmentSourceDetailBinding
import com.moter.newsapp.model.Article
import com.moter.newsapp.model.Source
import com.moter.newsapp.ui.adapter.NewsAdapter
import com.moter.newsapp.viewmodel.SourcesViewModel
import kotlinx.android.synthetic.main.fragment_source_detail.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


private const val ARG_PARAM1 = "source"
private lateinit var source: Source

class SourceDetailFragment : Fragment(), NewsAdapter.Listener {


    private val viewModel: SourcesViewModel by viewModel()
    private val newsAdapter: NewsAdapter by inject { parametersOf(newsList, this) }
    private var newsList: List<Article>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_source_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentSourceDetailBinding>(view)

        rvSourceNews.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        if (arguments != null) {
            source = arguments!!.getParcelable(ARG_PARAM1)
            binding?.source = source

            viewModel.getSourceNews(source.id)
        }

        viewModel.getSourceNewsList().observe(this, Observer {
            newsList = it
            rvSourceNews.adapter = newsAdapter

        })

    }

    override fun onClick(article: Article) {
        val bundle = Bundle()
        bundle.putParcelable("article", article)
        NavHostFragment.findNavController(this).navigate(R.id.action_sourceDetailFragment_to_newsDetailFragment, bundle)
    }

}
