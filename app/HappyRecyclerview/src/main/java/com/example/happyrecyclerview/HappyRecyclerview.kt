package com.example.happyrecyclerview

 
import android.content.Context
import android.os.Parcelable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/*
*Hi! I’m Saeed Mohammed Saleh Alabidi,
* linkedin ==> https:www.linkedin.com/in/saeed-mohammed-al-obidi-289082147/
* portfolio ==>https:saeed-alabidi.b-cdn.net/
*
*
* */

abstract class HappyRecyclerView<T> (private var contxt: Context): RecyclerView(contxt), Parcelable {


    class Adapter<T>(
        private val layout: Int,
        private val context: Context,
        private val bindViewHolderF: (holder: ViewHolder, item: T) -> Unit,
        private val viewHolderF: (itemView: View, context: Context) -> Unit
    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        private var data: ArrayList<T> = arrayListOf()

        fun setData(data: ArrayList<T>) {
            this.data = data
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(layout, parent, false)
            return ViewHolder(view, context, viewHolderF)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            bindViewHolderF(holder, item)


        }

        override fun getItemCount(): Int {
            return data.size
        }

        class ViewHolder(
            itemView: View, context: Context,
            val viewHolderF: (itemView: View, context: Context) -> Unit
        ) : RecyclerView.ViewHolder(itemView) {
            init {
                viewHolderF(itemView, context)

            }
        }

    }

    fun CAdapter(

        layout: Int,
        bindViewHolderF: (holder: Adapter.ViewHolder, item: T) -> Unit,
        viewHolderF: (itemView: View, context: Context) -> Unit
    ): Adapter<T> {

        val adapter = Adapter<T>(layout, this.context, bindViewHolderF, viewHolderF);
        this.adapter = adapter
        return adapter
    }


}
