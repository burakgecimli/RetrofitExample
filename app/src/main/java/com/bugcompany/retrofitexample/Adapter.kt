package com.bugcompany.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.retrofitexample.databinding.CardDesignBinding

class Adapter(var mContext: Context, var userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<Adapter.CardDesign>() {

    inner class CardDesign(val binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater =LayoutInflater.from(mContext)
        val binding=CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {

        val user=userList[position]
        holder.binding.textView.text=user.userId.toString()
        holder.binding.textView2.text=user.id.toString()
        holder.binding.textView3.text=user.title
        holder.binding.textView4.text=user.subTitle

    }

    override fun getItemCount(): Int {
        return userList.size
    }


}