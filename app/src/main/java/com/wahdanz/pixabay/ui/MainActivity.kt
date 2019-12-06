package com.wahdanz.pixabay.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.wahdanz.pixabay.R
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.extensions.*
import com.wahdanz.pixabay.presentation.home.HomeViewModel
import com.wahdanz.pixabay.presentation.home.PixbayHomeState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_item.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()
    lateinit var homeAdapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        viewModel.state.observe(this, Observer {
            handelState(it)
        })
        search_button.setOnClickListener {
            viewModel.getAllPixbays(editText.text.toString(), 0)
        }
    }

    private fun handelState(it: PixbayHomeState) {

        when (it) {
            is PixbayHomeState.PixbayData -> {
                homeAdapter.addAndReplaceAll(it.data)
                progressBar.visibility = View.GONE
            }
            is PixbayHomeState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is PixbayHomeState.Error -> {
                Toast.makeText(this, it.errorMsg, Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)
        homeAdapter = HomeAdapter(
            itemList = listOf(),
            layoutResIds = arrayOf(R.layout.home_item),
            bindHolder = { item ->
                item_image.load(item.thumbnailImage)
                user_text.coloredText =
                    context.getString(R.string.user_title).bold with item.user.redColor
                list_tags.coloredText = item.tags.joinToString(",".greenColor).redColor
            }, itemClick = {
                showDilaog(this)
            }
        )

        recyclerView_Dogs.adapter = homeAdapter
        recyclerView_Dogs.layoutManager = layoutManager
    }

    private fun showDilaog(pixbayEntity: PixbayEntity) {
        showAlertDialog {
            setTitle(getString(R.string.dialog_title))
            setMessage(getString(R.string.dialog_show_details))
            positiveButton("Yes") {
                startActivity(
                    DetailsActivity.startActivity(
                        context = applicationContext,
                        id = pixbayEntity.id
                    )
                )
            }

            negativeButton {
            }
        }
    }
}
