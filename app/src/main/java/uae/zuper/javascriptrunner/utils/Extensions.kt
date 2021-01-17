package uae.zuper.javascriptrunner.utils

import androidx.lifecycle.MutableLiveData

/**
 * extension to update  list
 */
fun <T> MutableList<T>.addOrUpdate(t: T) {
    indexOf(t).takeIf { it != -1 }?.let {
        this[it] = t
    } ?: if (contains(t).not()) {
        add(t)
    }

}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.postValue(this.value)
}

