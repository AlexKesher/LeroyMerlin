package ru.alexkesh.leroymerlin.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.databinding.GroupItemBinding


class GroupAdapter : RecyclerView.Adapter<GroupAdapter.GroupHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    class GroupHolder(private val binding: GroupItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(group: Group) {
            binding.tvGroupTitle.text = group.title
            binding.ivGroup.setImageResource(group.imgRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GroupItemBinding.inflate(inflater, parent, false)
        return GroupHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        val group = differ.currentList[position]
        holder.bind(group)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(groupList: List<Group>) = differ.submitList(groupList)


    companion object DiffCallback : DiffUtil.ItemCallback<Group>(){

        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean =
            oldItem.imgRes == newItem.imgRes
    }
}