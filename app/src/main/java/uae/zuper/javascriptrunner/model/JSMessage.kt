package uae.zuper.javascriptrunner.model

data class JSMessage(val id: String, val message: String, val progress: Int?, val state: String?) {

    override fun equals(other: Any?): Boolean {
        if (other !is JSMessage)
            return false

        return id == other.id
    }

    override fun hashCode() = id.hashCode()

    companion object {
        const val SUCCESS = "success"
        const val ERROR = "error"
    }
}