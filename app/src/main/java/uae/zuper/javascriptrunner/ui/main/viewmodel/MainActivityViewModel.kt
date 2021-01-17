package uae.zuper.javascriptrunner.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import uae.zuper.javascriptrunner.model.JSMessage
import uae.zuper.javascriptrunner.utils.addOrUpdate
import uae.zuper.javascriptrunner.utils.notifyObserver
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {
    // live data list once get update from JS will update UI
    val items = MutableLiveData<MutableList<JSMessage>>()

    init {
        items.value = ArrayList()
    }

    fun addItem(data: String) {
        Gson().fromJson(data, JSMessage::class.java).let { jsMessage ->
            items.value?.addOrUpdate(jsMessage)
            items.notifyObserver()
        }

    }

}
