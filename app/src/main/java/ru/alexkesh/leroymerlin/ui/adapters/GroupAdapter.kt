package ru.alexkesh.leroymerlin.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.alexkesh.leroymerlin.R
import ru.alexkesh.leroymerlin.data.models.Group

private const val TYPE_CATALOG = 1
private const val TYPE_DEPARTMENT = 2
private const val TYPE_WATCH_ALL = 3

class GroupAdapter : RecyclerView.Adapter<GroupAdapter.GroupHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    class GroupHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvGroupTitle: TextView = itemView.findViewById(R.id.tv_group_title)
        private val ivGroup: ImageView = itemView.findViewById(R.id.iv_group)

        fun bind(group: Group) {
            tvGroupTitle.text = group.title
            ivGroup.setImageResource(group.imgRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val resource = when (viewType) {
            TYPE_CATALOG -> R.layout.group_first_item
            TYPE_WATCH_ALL -> R.layout.group_watch_all
            else -> R.layout.group_item
        }
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return GroupHolder(view)
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        val group = differ.currentList[position]
        holder.bind(group)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> TYPE_CATALOG
            differ.currentList.lastIndex -> TYPE_WATCH_ALL
            else -> TYPE_DEPARTMENT
        }

    fun submitList(groupList: List<Group>) = differ.submitList(groupList)


    companion object DiffCallback : DiffUtil.ItemCallback<Group>() {

        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean =
            oldItem.imgRes == newItem.imgRes
    }
}