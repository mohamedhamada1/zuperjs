

package uae.zuper.javascriptrunner.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * A generic ViewHolder that works with a [ViewDataBinding].
 * @param <T> The type of the ViewDataBinding.
</T> */
class DataBoundViewHolder<T : ViewDataBinding> internal constructor(val binding: T) :
    RecyclerView.ViewHolder(binding.root)
