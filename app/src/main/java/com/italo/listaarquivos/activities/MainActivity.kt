package com.italo.listaarquivos.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.italo.listaarquivos.adapter.FileAdapter
import com.italo.listaarquivos.databinding.ActivityMainBinding
import com.italo.listaarquivos.enum.DirectoryEnum
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var files: MutableList<File>
    private lateinit var mFileAdapter: FileAdapter
    private lateinit var mDirectoryEnum: DirectoryEnum


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        mDirectoryEnum = DirectoryEnum.INTERNAL

        val view = binding.root
        setContentView(view)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = mFileAdapter
    }


    fun onInternal(view: View) {
        mDirectoryEnum = DirectoryEnum.INTERNAL
    }

    fun onExternal(view: View) {
        mDirectoryEnum = DirectoryEnum.EXTERNAL
    }

    fun onCreate(view: View) {
        File(filesDir, "")
    }
}