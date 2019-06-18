package com.moter.newsapp.ui.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moter.newsapp.R
import com.moter.newsapp.model.Article
import com.moter.newsapp.ui.adapter.NewsAdapter
import com.moter.newsapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class NewsFragment : Fragment(), NewsAdapter.Listener {

    private val TAG = NewsFragment::class.java.name
    private val viewModel: NewsViewModel by viewModel()
    private val newsAdapter: NewsAdapter by inject { parametersOf(newsList, this) }
    private var newsList: List<Article>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNews.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        viewModel.getArticles().observe(this, Observer {
            if (it.isNotEmpty()) {
                newsList = it
                rvNews.adapter = newsAdapter
            } else {
                Log.d(TAG, "news is empty")
            }
        })

        viewModel.getError().observe(this, Observer {
            Log.d(TAG, "error: $it")
        })

    }

    override fun onClick(article: Article) {
        val bundle=Bundle()
        bundle.putParcelable("article",article)
        NavHostFragment.findNavController(this).navigate(R.id.action_newsFragment_to_newsDetailFragment,bundle)
    }


}
