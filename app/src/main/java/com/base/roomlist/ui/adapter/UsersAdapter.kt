package com.base.roomlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.base.roomlist.databinding.ItemlistBinding
import com.base.roomlist.model.Listfake


class UsersAdapter(function: () -> Unit) : PagingDataAdapter<Listfake, UsersAdapter.CharacterViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemlistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val user = getItem(position)
        user?.let {
            val userItem = UserListItem(
                id = user.id,
                name = user.name,
                description = user.description

            )
           holder.bindTo(userItem)
        }
    }

    class CharacterViewHolder(
        private val binding: ItemlistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(
            items: UserListItem

        ) {
            binding.user ?.id
            binding.name.text ="parisa"
            binding.desc.text="mahmoodi"
            ViewCompat.setTransitionName(binding.root, "${items.id}")

        }
    }


    data class UserListItem(val id: Int,  val name: String,val description :String)

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Listfake>() {
            override fun areItemsTheSame(
                oldItem: Listfake,
                newItem: Listfake
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Listfake,
                newItem: Listfake
            ) = oldItem == newItem
        }
    }
}