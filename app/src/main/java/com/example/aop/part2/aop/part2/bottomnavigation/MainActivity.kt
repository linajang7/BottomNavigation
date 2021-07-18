package com.example.aop.part2.aop.part2.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.flFragment,
                FirstFragment()
            ).commit()
        }
    }
    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.search -> selectedFragment =
                    FirstFragment()
                R.id.news -> selectedFragment =
                    SecondFragment()
                R.id.archive -> selectedFragment =
                    ThirdFragment()
                R.id.dictionary -> selectedFragment =
                    FourthFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.flFragment,
                selectedFragment!!
            ).commit()
            true
        }
}