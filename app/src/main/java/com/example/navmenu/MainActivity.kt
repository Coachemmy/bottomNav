package com.example.navmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navmenu.Fragments.HomeFragment
import com.example.navmenu.Fragments.ProfileFragment
import com.example.navmenu.Fragments.SalesFragment
import com.example.navmenu.Fragments.StoreFragment
import com.example.navmenu.Fragments.ViewFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private fun setCurrentFragment(Fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, Fragment)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        val homeFragment = HomeFragment()
        val storeFragment = StoreFragment()
        val salesFragment = SalesFragment()
        val viewFragment = ViewFragment()
        val profileFragment = ProfileFragment()
        
        setCurrentFragment(homeFragment)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miHome ->  setCurrentFragment(homeFragment)
                R.id.miStore ->  setCurrentFragment(storeFragment)
                R.id.miSale ->  setCurrentFragment(salesFragment)
                R.id.miView ->  setCurrentFragment(viewFragment)
                R.id.miProfile ->  setCurrentFragment(profileFragment)
            }
            true
        }
    }
}


