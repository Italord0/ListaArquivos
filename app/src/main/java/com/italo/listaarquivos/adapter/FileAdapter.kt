package com.italo.listaarquivos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.italo.listaarquivos.R
import com.italo.listaarquivos.databinding.ItemFileBinding
import java.io.File

class FileAdapter(
    private val context: Context,
    private val files: List<File>,
    private val callback: (File) -> Unit
) : RecyclerView.Adapter<FileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_file, parent, false)
        val binding = ItemFileBinding.bind(view)
        val vh = ViewHolder(binding)
        vh.itemView.setOnClickListener {
            val file = files[vh.adapterPosition]
            callback(file)
        }
        return vh
    }

    override fun getItemCount() = files.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val file = files[position]
        holder.tvfileName.text = file.name

        holder.btnDelete.setOnClickListener {
            //TODO: DELETAR ARQUIVO
        }

    }

    class ViewHolder(itemView: ItemFileBinding) : RecyclerView.ViewHolder(itemView.root) {
        val tvfileName: TextView = itemView.tvFileName
        val btnDelete: ImageButton = itemView.ibDeletar
    }
}