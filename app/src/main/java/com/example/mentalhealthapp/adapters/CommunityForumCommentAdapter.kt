package com.example.mentalhealthapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentalhealthapp.dataClasses.Comment
import com.example.mentalhealthapp.R
import de.hdodenhof.circleimageview.CircleImageView

class CommunityForumCommentAdapter(private var commentArrayList:ArrayList<Comment>) : RecyclerView.Adapter<CommunityForumCommentAdapter.MyViewHolder>() {

    private lateinit var mListener:onItemClickListener
    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item_community_forum,parent,false)

        return MyViewHolder(itemView,mListener)

    }

    override fun getItemCount(): Int {
        return commentArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=commentArrayList[position]

        holder.commentHeading.text=currentItem.heading
        holder.commentImage.setImageResource(currentItem.profileImage)
        holder.commentMessage.text=currentItem.message
        holder.commentName.text=currentItem.name
        holder.commentDateTime.text=currentItem.dateTime

    }



    class MyViewHolder(itemView: View,listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val commentHeading: TextView =itemView.findViewById(R.id.text_view_comment_heading)
        val commentImage:CircleImageView=itemView.findViewById(R.id.image_view_comment_profile_pic)
        val commentMessage:TextView=itemView.findViewById(R.id.text_view_comment_message)
        val commentName:TextView=itemView.findViewById(R.id.text_view_comment_profile_name)
        val commentDateTime:TextView=itemView.findViewById(R.id.text_view_comment_time_and_date)


        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }



    }

}