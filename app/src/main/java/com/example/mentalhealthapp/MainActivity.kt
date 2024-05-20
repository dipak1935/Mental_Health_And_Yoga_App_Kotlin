package com.example.mentalhealthapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.mentalhealthapp.community.CommunityForumFragment
import com.example.mentalhealthapp.databinding.ActivityMainBinding
import com.example.mentalhealthapp.home.HomeFragment
import com.example.mentalhealthapp.therapy.TherapyFragment
import com.example.mentalhealthapp.yoga.YogaFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNav.setOnItemSelectedListener(this)


//        binding.bottomNav.setOnItemSelectedListener {
//
//            here we can also write the code of bottom nav clicking
//        }








    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if(item.itemId== R.id.nav_home){
            supportFragmentManager.commit {
                replace(R.id.frame_content,HomeFragment())
            }

            return true
        }
        else if(item.itemId== R.id.nav_yoga){

            supportFragmentManager.commit {
                replace(R.id.frame_content,YogaFragment())
            }

            return true
        }
        else if(item.itemId== R.id.nav_therapy){
            supportFragmentManager.commit {
                replace(R.id.frame_content, TherapyFragment())
            }
            return true
        }
        else if(item.itemId== R.id.nav_community){
            supportFragmentManager.commit {
                replace(R.id.frame_content,CommunityForumFragment())
            }
            return true
        }
        else return false;

    }
}