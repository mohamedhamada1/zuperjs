

package uae.zuper.javascriptrunner.ui.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A generic ViewHolder that works with a {@link ViewDataBinding}.
 * @param <T> The type of the ViewDataBinding.
 */
public class DataBoundPageViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public final T binding;
    public DataBoundPageViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
