package com.example.mentalhealthapp.community

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentalhealthapp.adapters.CommunityForumCommentAdapter
import com.example.mentalhealthapp.dataClasses.Comment
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.FragmentCommunityForumBinding

class CommunityForumFragment : Fragment() {

    private lateinit var binding:FragmentCommunityForumBinding
    private lateinit var commentArrayList: ArrayList<Comment>

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

        myAdapter.setOnItemClickListener(object : CommunityForumCommentAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                val intent=Intent(context,CommentDetailActivity::class.java)
                intent.putExtra("heading",commentArrayList[position].heading)
                intent.putExtra("name",commentArrayList[position].name)
                intent.putExtra("message",commentArrayList[position].message)
                intent.putExtra("dateTime",commentArrayList[position].dateTime)
                intent.putExtra("profileImage",commentArrayList[position].profileImage)

                startActivity(intent)
            }

        })


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

            "When I was grappling with debilitating anxiety, every day felt like a battle against my own mind. Simple tasks seemed insurmountable, and social interactions became sources of intense fear. It was a draining cycle that left me feeling exhausted and hopeless.However, through the practice of mindfulness, particularly meditation and deep breathing exercises, I began to experience a shift in my perspective. Instead of being consumed by worries about the future or regrets about the past, I learned to focus on the present moment. This newfound awareness allowed me to observe my anxious thoughts without being swept away by them.Over time, mindfulness became a powerful tool in my arsenal against anxiety. I developed a sense of inner calm and resilience that I hadn't thought possible. By practicing mindfulness regularly, I gained control over my racing thoughts and learned to respond to challenges with greater clarity and composure. While anxiety still visits me from time to time, it no longer dominates my life. Mindfulness has given me the strength and confidence to face my fears head-on and live a more fulfilling, balanced life.",
            "Depression cast a dark shadow over every aspect of my life, draining me of energy and joy. It felt like I was constantly swimming against a tide of negative emotions, struggling to find even a glimmer of hope amidst the darkness.The turning point came when I decided to seek professional help. Opening up to a therapist about my struggles was a daunting but ultimately liberating experience. Through therapy, I gained insights into the root causes of my depression and learned coping strategies to navigate the stormy waters of my emotions. Support from loved ones also played a crucial role in my journey. Their patience, understanding, and encouragement provided a lifeline when I felt like I was drowning in despair. Slowly but steadily, I began to rebuild my sense of self-worth and rediscover moments of joy in everyday life. One of the most impactful lessons I learned was the importance of self-care. Prioritizing my mental and emotional well-being became a non-negotiable part of my routine. Whether it's taking time for hobbies I enjoy, practicing gratitude, or setting boundaries to protect my mental health, self-care has been instrumental in my healing process. While depression may always be a part of my story, it no longer defines me. I've found strength in vulnerability, resilience in adversity, and a renewed sense of purpose in helping others navigate their own mental health journeys.",
            "Living with post-traumatic stress disorder (PTSD) was like carrying a heavy burden that never seemed to lighten. Flashbacks, nightmares, and hypervigilance were constant companions, making it challenging to feel safe in the world. The road to recovery began with acknowledging the impact of trauma on my mental health. It took courage to confront painful memories and emotions, but therapy, particularly Eye Movement Desensitization and Reprocessing (EMDR), provided a transformative space for healing. EMDR helped me process traumatic experiences in a safe and structured way, gradually reducing the intensity of my symptoms. Building a support network was another crucial step in my journey. Connecting with fellow survivors who understood the complexities of PTSD offered validation and solidarity. Peer support groups provided a sense of belonging and reminded me that I wasn't alone in my struggles. Self-care became a cornerstone of my recovery. Engaging in activities that brought me joy, practicing mindfulness, and prioritizing restorative sleep helped regulate my nervous system and improve my overall well-being. While PTSD is a part of my story, it no longer defines my future. I've reclaimed my sense of agency and resilience, learning to navigate life's challenges with courage and compassion.",
            "Social anxiety was like a constant shadow looming over my interactions with others. Simple tasks like making phone calls or attending social gatherings filled me with dread and self-doubt. It felt like I was trapped in a cycle of fear and avoidance, missing out on opportunities for connection and growth. My journey towards overcoming social anxiety began with small, manageable steps. I started by challenging negative thoughts and beliefs about myself, gradually exposing myself to social situations that triggered anxiety. Cognitive-behavioral techniques taught me to reframe my thinking patterns and develop coping strategies for managing anxious feelings. Therapy played a pivotal role in my progress. Working with a compassionate therapist allowed me to explore the root causes of my social anxiety and develop personalized tools for navigating social interactions. Role-playing exercises, social skills training, and gradual exposure helped me build confidence and reduce avoidance behaviors. Supportive friendships and understanding from loved ones were invaluable sources of encouragement. Their patience and empathy created a safe space for me to practice social skills without fear of judgment. Over time, I began to challenge my comfort zones and embrace opportunities for social connection. While social anxiety still lingers at times, it no longer controls my life. I've learned to acknowledge my strengths, accept imperfections, and celebrate progress, however small. Each step forward reinforces my confidence and reminds me of the resilience within me.",
            "Struggling with an eating disorder was a harrowing experience that consumed my thoughts and behaviors. The constant cycle of restrictive eating, bingeing, and purging took a toll on both my physical and mental health. It felt like I was trapped in a destructive pattern with no way out. Seeking professional help was a pivotal moment in my recovery journey. Working with a team of healthcare professionals, including therapists, dietitians, and medical providers, I received comprehensive treatment tailored to my unique needs. Therapy sessions allowed me to explore underlying emotional triggers and develop healthier coping mechanisms. Nutritional counseling played a crucial role in rebuilding a positive relationship with food. Learning about balanced nutrition, intuitive eating, and practicing mindful eating helped me break free from rigid food rules and obsessive thoughts about food and weight. Support from family and friends was instrumental in my recovery. Their unwavering encouragement, empathy, and understanding created a supportive environment where I felt safe to be vulnerable and seek help when needed. Building a strong support network became a cornerstone of my healing process. Recovery from an eating disorder is an ongoing journey, marked by both challenges and victories. Each day, I strive to prioritize self-care, practice self-compassion, and engage in activities that nurture my physical, emotional, and spiritual well-being. While there may be setbacks along the way, I remain committed to my recovery and embracing a life of freedom and authenticity.",
            "Living with attention-deficit/hyperactivity disorder (ADHD) presented unique challenges in both my personal and professional life. Impulsivity, difficulty focusing, and disorganization often left me feeling overwhelmed and frustrated. It was like trying to navigate a world that operated at a different pace. Diagnosis and treatment were crucial steps in my journey toward managing ADHD effectively. Seeking evaluation from a qualified healthcare provider helped me understand my symptoms and develop a personalized treatment plan. Medication, combined with behavioral strategies and accommodations, significantly improved my ability to focus and regulate impulses. Therapy, particularly cognitive-behavioral therapy (CBT), provided valuable tools for managing ADHD-related challenges. I learned practical skills such as time management techniques, organizational strategies, and goal setting, which helped me thrive in academic and work settings. Creating a structured environment became essential in managing ADHD symptoms. Establishing routines, utilizing visual aids, and breaking tasks into manageable steps reduced overwhelm and increased productivity. Building a support network of understanding colleagues and friends also provided encouragement and accountability. While living with ADHD has its complexities, it has also gifted me with creativity, resilience, and a unique perspective. Embracing my strengths, seeking support when needed, and practicing self-compassion have been key pillars in my journey toward thriving with ADHD.",
            "Obsessive-compulsive disorder (OCD) created a constant state of anxiety and distress in my life. Intrusive thoughts and compulsive rituals consumed hours of my day, leaving me exhausted and trapped in a cycle of fear and uncertainty. It was like having a relentless inner critic that never allowed me to rest. Acknowledging my OCD symptoms and seeking professional help was a turning point in my journey. Working with a therapist trained in exposure and response prevention (ERP) therapy, I gradually confronted my fears and reduced reliance on compulsive behaviors. ERP exposed me to anxiety-provoking situations in a controlled manner, allowing me to build resilience and tolerance to uncertainty. Mindfulness practices played a significant role in finding peace amidst OCD. Mindful awareness helped me observe obsessive thoughts without judgment and develop a sense of detachment from them. Incorporating mindfulness into daily life cultivated a sense of calm and acceptance, even in moments of distress. Challenging perfectionism and embracing imperfection was a transformative mindset shift. Accepting that uncertainty is a natural part of life and letting go of the need for absolute control allowed me to experience greater freedom and authenticity. Self-compassion became a guiding principle, reminding me to be kind to myself in moments of struggle. While OCD remains a part of my reality, it no longer dictates my actions or defines my worth. I've learned to coexist with uncertainty, embrace flexibility, and prioritize mental well-being. Each step forward in my recovery reaffirms the strength and resilience within me."


            )

        val commentHeadingArray= arrayOf(

            "Overcoming Anxiety Through Mindfulness",
            "Finding Strength in Depression",
            "Coping with PTSD",
            "Overcoming Social Anxiety",
            "Overcoming Eating Disorders",
            "Managing ADHD as an Adult",
            "Finding Peace Amidst OCD",


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

            val comment= Comment(commentHeadingArray[index],commentMessageArray[index],commentProfileImageArray[index],commentNameArray[index],commentDateTimeArray[index])
            commentArrayList.add(comment)
        }
    }
}