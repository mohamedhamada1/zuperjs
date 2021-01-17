package uae.zuper.javascriptrunner.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import uae.zuper.javascriptrunner.ui.base.DataBoundListAdapter
import uae.zuper.javascriptrunner.R
import uae.zuper.javascriptrunner.databinding.ItemLoadingBinding
import uae.zuper.javascriptrunner.model.JSMessage
import uae.zuper.javascriptrunner.utils.AppExecutors

class MessagesAdapter(
    appExecutors: AppExecutors
) : DataBoundListAdapter<JSMessage, ItemLoadingBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<JSMessage>() {
        override fun areItemsTheSame(oldItem: JSMessage, newItem: JSMessage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JSMessage, newItem: JSMessage): Boolean {
            return oldItem.id == newItem.id && oldItem.message == newItem.message && oldItem.state == newItem.state && oldItem.progress == newItem.progress
        }
    }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemLoadingBinding {
        return DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_loading,
                parent,
                false
            )

    }

    override fun bind(binding: ItemLoadingBinding, item: JSMessage) {
        binding.item = item
    }

}