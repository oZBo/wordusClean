package com.braincollaboration.wordus.presentation.screens.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    private var items = mutableListOf<T>()

    protected fun inflate(parent: ViewGroup, @LayoutRes layoutResId: Int): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutResId, parent, false)
    }

    fun setItems(mutableList: List<T>) {
        items.clear()
        items.addAll(mutableList)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T {
        return items[position]
    }

    protected fun getItems(): List<T> {
        return items
    }

    override fun getItemCount() = items.size
}
