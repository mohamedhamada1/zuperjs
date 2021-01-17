
package uae.zuper.javascriptrunner.ui.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import uae.zuper.javascriptrunner.utils.AppExecutors

/**
 * A generic RecyclerView adapter that uses Data Binding & DiffUtil.
 *
 * @param <T> Type of the items in the list
 * @param <V> The of the ViewDataBinding
</V></T> */
abstract class DataBoundListAdapter<T, V : ViewDataBinding>(
    appExecutors: AppExecutors,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBoundViewHolder<V>>(
    AsyncDifferConfig.Builder<T>(diffCallback)
        .setBackgroundThreadExecutor(appExecutors.diskIO())
        .build()
) {
    var currentPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
        val binding = createBinding(parent,viewType)
        return DataBoundViewHolder(binding)
    }

    protected abstract fun createBinding(parent: ViewGroup,viewType: Int = 0): V

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        currentPosition = position
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T)


    public fun getItemPosition(): Int {
        return currentPosition
    }


}