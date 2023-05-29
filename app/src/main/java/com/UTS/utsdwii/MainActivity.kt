package com.UTS.utsdwii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.UTS.utsdwii.databinding.ActivityMainBinding
import com.UTS.utsdwii.fragment.AnimalFragment
import com.UTS.utsdwii.fragment.PlantFragment
import com.UTS.utsdwii.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHewan: Fragment = AnimalFragment()
    val fragmentProfil: Fragment = ProfilFragment()
    val fragmentPlant: Fragment = PlantFragment()
    val fm: FragmentManager = supportFragmentManager
    var active : Fragment = fragmentHewan

    private lateinit var bottomNavigationId: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation()
    }

    private fun buttonNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentHewan).show(fragmentHewan).commit()
        fm.beginTransaction().add(R.id.container, fragmentPlant).hide(fragmentPlant).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfil).hide(fragmentProfil).commit()

        bottomNavigationId = binding.navView
        menu = bottomNavigationId.menu

        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationId.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.navigation_hewan -> {
                    callFragment(0, fragmentHewan)
                }

                R.id.navigation_tumbuhan -> {
                    callFragment(1, fragmentPlant)
                }
            }
            false
        }
    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem  = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}