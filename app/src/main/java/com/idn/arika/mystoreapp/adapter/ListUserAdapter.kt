package com.idn.arika.mystoreapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idn.arika.mystoreapp.DetailActivity
import com.idn.arika.mystoreapp.databinding.ItemUserBinding
import com.idn.arika.mystoreapp.model.User
import org.jetbrains.anko.intentFor

class ListUserAdapter(private val listUser : ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>(){
    inner class ListViewHolder(var binding: ItemUserBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) {
            with(binding){
                Glide.with(binding.ivProfile.context)
                        .load(user.photo)
                        .apply(RequestOptions().override(60,60))
                        .into(binding.ivProfile)

                binding.tvName.text = user.name
                binding.tvUsername.text = user.username

                itemView.setOnClickListener {
                    itemView.context?.startActivity(
                            itemView.context.intentFor<DetailActivity>(
                               "extra_username" to user
                            )
                    )
                }


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
      val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])

    }

    override fun getItemCount(): Int = listUser.size

    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClick(user: User)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


}