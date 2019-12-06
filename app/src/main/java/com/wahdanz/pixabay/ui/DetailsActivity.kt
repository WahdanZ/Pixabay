package com.wahdanz.pixabay.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.wahdanz.pixabay.R
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.extensions.*
import com.wahdanz.pixabay.presentation.details.DetailsViewModel
import com.wahdanz.pixabay.presentation.details.PixbayDetailsState
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {
    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        if (intent.extras == null || (!intent.hasExtra(ITEM_ID)))
            finish()
        viewModel.getAllPixbays(intent.getIntExtra(ITEM_ID,0))
        viewModel.state.observe(this, Observer {
            handelState(it)
        })

    }

    private fun handelState(it: PixbayDetailsState) {

        when (it) {
            is PixbayDetailsState.PixbayData -> {
                progressBar.visibility = View.GONE

                handelData(it.data)
            }
            is PixbayDetailsState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is PixbayDetailsState.Error -> {
                Toast.makeText(this, it.errorMsg, Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        }

    }

    private fun handelData(data: PixbayEntity) {
        imageView.load(data.largeImageUrl)
        user_text.coloredText = "User:".bold with data.user.redColor
        number_comments.coloredText = "Comments:".bold with data.comments.toString().redColor
        number_favorites.coloredText = "Favorites:".bold with data.favorites.toString().redColor
        number_likes.coloredText = "Likes:".bold with data.likes.toString().redColor
        list_tags.coloredText = data.tags.joinToString (",".greenColor).redColor


    }

    companion object {

        private const val ITEM_ID = "item_id"
        fun startActivity(context: Context?, id: Int) : Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(ITEM_ID, id)
            return intent
        }
    }
}
