package com.moter.newsapp.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.moter.newsapp.R
import com.moter.newsapp.model.Article


private const val ARG_PARAM1 = "article"
private lateinit var news: Article

/**
 * A simple [Fragment] subclass.
 *
 */
class NewsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<com.moter.newsapp.databinding.FragmentNewsDetailBinding>(view)

        if (arguments != null) {
            news = arguments!!.getParcelable(ARG_PARAM1)
            binding?.news = news
        }
    }
}
