package ru.alexkesh.leroymerlin.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.alexkesh.leroymerlin.data.models.Product
import ru.alexkesh.leroymerlin.databinding.ProductItemBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    class ProductHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.ivProduct.setImageResource(product.imgRes)
            binding.tvProductTitle.text = product.title

            var priceIntPart = product.pricePerUnit.toInt().toString()

            val penny = product.pricePerUnit - product.pricePerUnit.toInt()
            var pennyStr = ""
            if (penny > 0.0) {
                pennyStr = String.format("%.2f", penny).takeLast(2)
                priceIntPart = "$priceIntPart,"
            }
            binding.tvProductPriceFirstPart.text = priceIntPart
            binding.tvProductPriceSecondPart.text =
                pennyStr + " ${product.currency}/${product.unitName}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(productList: List<Product>) = differ.submitList(productList)


    companion object DiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
            oldItem == newItem
    }
}