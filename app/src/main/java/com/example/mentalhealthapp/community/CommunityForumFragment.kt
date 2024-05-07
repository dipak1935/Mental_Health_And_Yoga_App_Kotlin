package com.example.mentalhealthapp.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentalhealthapp.Adapters.CommunityForumCommentAdapter
import com.example.mentalhealthapp.Comment
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.FragmentCommunityForumBinding

class CommunityForumFragment : Fragment() {

    private lateinit var binding:FragmentCommunityForumBinding
    lateinit var commentArrayList: ArrayList<Comment>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentCommunityForumBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initializeData()



        binding.recyclerView.layoutManager=LinearLayoutManager(context)

        val myAdapter= CommunityForumCommentAdapter(commentArrayList)

        binding.recyclerView.adapter=myAdapter



    }

    private fun initializeData(){

        val commentProfileImageArray= arrayOf(


            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pics0

        )

        val commentMessageArray= arrayOf(

            "Hello friends,Lately, I've been struggling with a deep sense of sadness and hopelessness that just won't seem to go away. It's like a heavy cloud hanging over me, making it hard to find joy in anything. But I'm trying to remind myself that it's okay not to be okay all the time.I'm curious, what are some coping mechanisms that have worked for you when dealing with depression? I'm open to any suggestions or insights you might have.Sending love and strength to you all.",
            "Hi everyone,I wanted to share a small victory with you all. Today, I attended a social gathering that I was really anxious about, but I pushed myself to go anyway. And you know what? It wasn't as scary as I thought it would be. I still felt nervous, but I survived, and I even managed to have a few conversations.For those of you struggling with social anxiety like me, what are some techniques you use to navigate social situations? I'm always looking for new ways to challenge myself and grow.Remember, progress comes in small steps. We've got this!",
            "Hi folks,It's been a rough few weeks since I lost my beloved pet. The grief feels overwhelming at times, and it's hard to imagine ever feeling okay again. But I'm trying to honor their memory by allowing myself to feel whatever comes up, whether it's sadness, anger, or even moments of peace.If any of you have experienced the loss of a pet or a loved one, how do you cope with the grief? I could use some guidance on how to navigate this journey of healing.Thank you for listening, and please take care of yourselves.",
            "Hey everyone,Work has been incredibly stressful lately, and I feel like I'm on the verge of burning out. No matter how much I try to stay organized and prioritize my tasks, it feels like there's always more to do and never enough time.What are some effective ways you've found to manage stress in the workplace? I'm open to any tips or tricks that might help me find some balance and regain my sanity.Let's support each other through these challenging times.",
            "Hi there,Living with ADHD can be a daily struggle, from managing impulsivity to staying focused on tasks. Some days, it feels like my mind is in constant chaos, and it's exhausting trying to keep up with everything.If you're also navigating life with ADHD, how do you cope with the challenges it presents? Whether it's practical strategies or emotional support, I'd love to hear what works for you.Remember, you're not alone in this journey.",
            "Hello friends,Sleep has been eluding me lately, and it's starting to take a toll on my mental and physical well-being. No matter how tired I am, I find myself tossing and turning for hours before finally falling asleep, only to wake up feeling exhausted.If you've struggled with insomnia, what techniques have you found helpful for improving sleep quality? I'm willing to try anything at this point to get some much-needed rest.Wishing you all peaceful nights and restful sleep.",
            "Hi everyone,I'm currently on the road to recovery from an eating disorder, and it's been one of the most challenging journeys of my life. Every day is a battle against negative thoughts and harmful behaviors, but I'm determined to reclaim my relationship with food and my body.For those of you who have walked this path before, what strategies or resources have been instrumental in your recovery journey? I'm grateful for any guidance or support you can offer as I continue to navigate this process.Remember, you are worthy of love and healing.",


            )

        val commentHeadingArray= arrayOf(

            "Dealing with Depression",
            "Overcoming Social Anxiety",
            "Coping with Grief",
            "Managing Stress at Work",
            "Living with ADHD",
            "Battling Insomnia",
            "Overcoming Eating Disorders"

        )

        val commentNameArray= arrayOf(

            "Sarah Johnson", "Michael Smith", "Ava Martinez", "Daniel Brown", "Olivia Taylor", "Ethan Wilson", "Isabella Thompson"
        )

        val commentDateTimeArray= arrayOf(
            "4:20 pm | 22 March 2023",
            "9:45 am | 15 May 2023",
            "7:30 pm | 8 August 2023",
            "12:00 pm | 10 October 2023",
            "6:15 pm | 5 December 2023",
            "3:00 pm | 18 January 2024",
            "10:30 am | 20 April 2024"
        )





        commentArrayList= arrayListOf<Comment>()


        for(index in commentProfileImageArray.indices){

            val comment=Comment(commentHeadingArray[index],commentMessageArray[index],commentProfileImageArray[index],commentNameArray[index],commentDateTimeArray[index])
            commentArrayList.add(comment)
        }
    }
}