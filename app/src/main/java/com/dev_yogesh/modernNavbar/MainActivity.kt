package com.dev_yogesh.modernNavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dev_yogesh.modernNavbar.databinding.ActivityMainBinding
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(HomeFragment.newInstance())
        binding.bottomNavigation.show(0)
        binding.bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_home))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_explore))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_chat))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_notification))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(4,R.drawable.ic_user))

        binding.bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    replaceFragment(ExploreFragment.newInstance())
                }
                2 -> {
                    replaceFragment(ChatFragment.newInstance())
                }
                3 -> {
                    replaceFragment(NotificationFragment.newInstance())
                }
                4 -> {
                    replaceFragment(UserFragment.newInstance())
                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}
