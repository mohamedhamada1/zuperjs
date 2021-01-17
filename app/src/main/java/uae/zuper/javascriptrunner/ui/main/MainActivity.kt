package uae.zuper.javascriptrunner.ui.main

import android.content.pm.ApplicationInfo
import android.os.Build
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uae.zuper.javascriptrunner.BR
import uae.zuper.javascriptrunner.R
import uae.zuper.javascriptrunner.databinding.ActivityMainBinding
import uae.zuper.javascriptrunner.ui.base.BaseActivity
import uae.zuper.javascriptrunner.ui.main.viewmodel.MainActivityViewModel
import uae.zuper.javascriptrunner.utils.AppExecutors
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    lateinit var webView: WebView

    @Inject
    lateinit var appExecutors: AppExecutors

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this)
        initView()
    }

    private fun initView() = viewDataBinding?.run {
        initRV()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE)) {
                WebView.setWebContentsDebuggingEnabled(true)
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(AndroidWebInterface(viewModel), "jumbo")
        webView.loadUrl(BASE_URL)
        btnSend.setOnClickListener {
            hideKeyboard()
            ETInput.text.toString().split(",").forEach {
                webView.evaluateJavascript(
                    "javascript: " +
                            "startOperation(${it})", null
                )
            }
        }

        viewModel.items.observe(this@MainActivity) {
            (RVMessages.adapter as MessagesAdapter).submitList(it)
            (RVMessages.adapter as MessagesAdapter).notifyDataSetChanged()
        }
    }

    /**
     * init Recycler view
     */
    private fun initRV() = viewDataBinding?.apply {
        RVMessages.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = MessagesAdapter(appExecutors)
        }
    }

    /**
     * remote JS interface onDestroy
     */
    override fun onDestroy() {
        webView.removeJavascriptInterface("jumbo")
        super.onDestroy()
    }

    /**
     * interface between native and JS
     */
    internal class AndroidWebInterface(val viewModel: MainActivityViewModel) {
        @JavascriptInterface
        fun postMessage(data: String) {
            viewModel.addItem(data)
        }

    }

    companion object {
        // we should embedded JS file to be able to access it
        private const val BASE_URL = "file:///android_asset/webview.html"
    }

    override val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this, mViewModelFactory).get(MainActivityViewModel::class.java)
    }
    override val bindingVariable: Int
        get() = BR._all
    override val layoutId: Int
        get() = R.layout.activity_main

}
