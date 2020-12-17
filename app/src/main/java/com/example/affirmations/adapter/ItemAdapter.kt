package com.example.affirmations.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/**
 * Adapter for the [RecyclerView] in [MainActivity].
 * Displayes [Affirmation] data object*/
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide reference to the views of for each data item
    // each data item is just an Affirmation object
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by LayoutManager)*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**Replace the contents of a view (invoked by LayoutManager)*/
    // this method is called by the layout manager in order to replace
    // the contents of the list item view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //affirmation object item in the dataset
        val item = dataset[position]
        //text view text is set to the dataset item text
        holder.textView.text = context.resources.getString(item.stringResourceID)
        holder.imageView.setImageResource(item.imageResourceId)

    }

    /**Return the size of my dataset (invoked by LayoutManager)*/
    override fun getItemCount() = dataset.size
}