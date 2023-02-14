//package com.example.memefy.Model.Getmemes
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import coil.load
////import com.example.memefy.databinding.ItemBinding
//
//class PostsAdapter : ListAdapter<Meme, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
//
//    companion object{
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meme>() {
//
//            override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
//                return oldItem.title == newItem.title && oldItem.url == newItem.url
//            }
//
//        }
//    }
//
//    private lateinit var binding: ItemBinding
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
//            RecyclerView.ViewHolder {
//        binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is ViewHolder){
//            val item = getItem(position)
//            holder.bind(item)
//        }
//    }
//
//    inner class ViewHolder(val itemBinding: ItemBinding):
//        RecyclerView.ViewHolder(itemBinding.root) {
//        fun bind(item: Meme){
//            itemBinding.imageView.load(item.url)
//           itemBinding.tvName.text="hhhh"
//        }
//    }
//}