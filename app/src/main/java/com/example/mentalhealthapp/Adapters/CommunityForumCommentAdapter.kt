package com.example.mentalhealthapp.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentalhealthapp.Comment
import com.example.mentalhealthapp.R
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class CommunityForumCommentAdapter(private var commentArrayList:ArrayList<Comment>) : RecyclerView.Adapter<CommunityForumCommentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item_community_forum,parent,false)

        return MyViewHolder(itemView)

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



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val commentHeading: TextView =itemView.findViewById(R.id.text_view_comment_heading)
        val commentImage:CircleImageView=itemView.findViewById(R.id.image_view_comment_profile_pic)
        val commentMessage:TextView=itemView.findViewById(R.id.text_view_comment_message)
        val commentName:TextView=itemView.findViewById(R.id.text_view_comment_profile_name)
        val commentDateTime:TextView=itemView.findViewById(R.id.text_view_comment_time_and_date)

    }

}