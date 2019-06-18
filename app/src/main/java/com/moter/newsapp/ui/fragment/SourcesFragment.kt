package com.moter.newsapp.ui.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moter.newsapp.R
import com.moter.newsapp.model.Source
import com.moter.newsapp.ui.adapter.SourceAdapter
import com.moter.newsapp.viewmodel.SourcesViewModel
import kotlinx.android.synthetic.main.fragment_sources.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class SourcesFragment : Fragment(), SourceAdapter.Listener {

    private val TAG = SourcesFragment::class.java.name

    private val viewModel: SourcesViewModel by viewModel()
    private val sourceAdapter: SourceAdapter by inject { parametersOf(sourceList, this) }
    private var sourceList: List<Source>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sources, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSources.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        viewModel.getSources().observe(this, Observer {
            if (it.isNotEmpty()) {
                sourceList = it
                rvSources.adapter = sourceAdapter
            } else {
                Log.d(TAG, "source is empty")
            }
        })

        viewModel.getError().observe(this, Observer {
            Log.d(TAG, "error: $it")
        })
    }

    override fun onClick(source: Source) {
        val bundle = Bundle()
        bundle.putParcelable("source", source)
        findNavController(this).navigate(R.id.action_sourcesFragment_to_sourceDetailFragment, bundle)
    }
}
