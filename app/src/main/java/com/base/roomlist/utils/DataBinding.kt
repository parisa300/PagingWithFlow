package com.base.roomlist.utils


import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.base.roomlist.R
import com.base.roomlist.model.FakeData
import com.base.roomlist.model.Listfake


@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}



@BindingAdapter("visibility")
fun bindRecyclerViewVisibility(recyclerView: RecyclerView, state: LoadState) {
    when (state) {
        is LoadState.Loading -> recyclerView.isGone = true
        is LoadState.Error -> recyclerView.isGone = true
        else -> recyclerView.isVisible = true
    }
}

@BindingAdapter("visibility")
fun bindProgressBarVisibility(progressBar: ProgressBar, state: LoadState) {
    when (state) {
        is LoadState.Loading -> progressBar.isVisible = true
        is LoadState.Error -> progressBar.isGone = true
        else -> progressBar.isGone = true
    }
}

@BindingAdapter("visibility")
fun bindErrorTextViewVisibility(tvError: TextView, state: LoadState) {
    when (state) {
        is LoadState.Loading -> tvError.isGone = true
        is LoadState.Error -> {
            tvError.setText(R.string.error_cant_load_data)
            state.error.printStackTrace()
            tvError.isVisible = true
        }
        else -> tvError.isGone = true
    }
}

@BindingAdapter("isVisibile")
fun bindVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@SuppressLint("StringFormatInvalid")
@BindingAdapter("firstname", "desc")
fun bindCharacterBiography(
    firstname: TextView,
    desc :TextView,
    listfake: Listfake

){

    val context = firstname.context
   // val context1 = desc.context
    var Text = ""
    firstname.text= listfake.name.toString()
    desc.text= R.string.label_name.toString()


        Text += context.getString(R.string.label_name, listfake.name)

}



