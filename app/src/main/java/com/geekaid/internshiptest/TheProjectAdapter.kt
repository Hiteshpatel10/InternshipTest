package com.geekaid.internshiptest

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekaid.internshiptest.model.TheProject

class TheProjectAdapter(private val listener: ITheProjectListener) :
    RecyclerView.Adapter<TheProjectAdapter.TheProjectViewHolder>() {

    var allData = listOf<TheProject>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheProjectViewHolder {

        val viewHolder = TheProjectViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.the_project_recycler_view, parent, false)
        )

        viewHolder.deleteIcon.setOnClickListener {
            listener.onItemClicked(allData[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: TheProjectViewHolder, position: Int) {
        val item = allData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        Log.i("TheProjectAdapter", allData.size.toString())
        return allData.size

    }

    inner class TheProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val deleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
        private val code: TextView = itemView.findViewById(R.id.code)
        private val anything: TextView = itemView.findViewById(R.id.anything)

        fun bind(theProject: TheProject) {
            code.text = theProject.code.toString()
            anything.text = theProject.anything.toString()
        }
    }

    interface ITheProjectListener {
        fun onItemClicked(theProject: TheProject)
    }

}