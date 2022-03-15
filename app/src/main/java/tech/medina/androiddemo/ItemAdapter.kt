package tech.medina.androiddemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.medina.androiddemo.databinding.ItemRecyclerviewBinding

class ItemAdapter : ListAdapter<SingleActivity.ListItem, ItemAdapter.ViewHolder>(Diff()) {

    class ViewHolder(
        private val binding: ItemRecyclerviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SingleActivity.ListItem, position: Int) {
            binding.container.setBackgroundColor(ContextCompat.getColor(binding.root.context, item.color))
            binding.text.text = "Item #${position + 1}"
            binding.image.setImageResource(item.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    class Diff : DiffUtil.ItemCallback<SingleActivity.ListItem>() {
        override fun areItemsTheSame(
            oldItem: SingleActivity.ListItem,
            newItem: SingleActivity.ListItem
        ): Boolean {
            return oldItem.color == newItem.color && oldItem.icon == newItem.icon
        }

        override fun areContentsTheSame(
            oldItem: SingleActivity.ListItem,
            newItem: SingleActivity.ListItem
        ): Boolean {
            return oldItem.icon == oldItem.icon
        }

    }

}