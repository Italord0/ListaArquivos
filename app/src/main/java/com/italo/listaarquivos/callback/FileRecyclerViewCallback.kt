package com.italo.listaarquivos.callback

import java.io.File

interface FileRecyclerViewCallback {

    fun onDelete(file: File)

}