package com.example.productsroomwithrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productsroomwithrecyclerview.R
import com.example.productsroomwithrecyclerview.entity.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products = emptyList<Product>()

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.txtProductName.text = product.mName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }
}