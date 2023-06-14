package org.d3if0097.pt2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import org.d3if0097.pt2.databinding.ActivityBerandaBinding
import org.d3if0097.pt2.databinding.FragmentAspirasiBinding
import org.d3if0097.pt2.databinding.FragmentLaporBinding
import org.d3if0097.pt2.ui.home.HomeFragment

class BerandaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBerandaBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController= Navigation.findNavController(this,R.id.nav_host_fragment_activity_beranda)
        setupWithNavController(binding.navView,navController)

//        val navigationView = binding.navView

//        navigationView.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.navigation_home -> {
//                    // Handle home item selection
//                    true
//                }
//                R.id.navigation_history -> {
//                    // Handle dashboard item selection
//                    true
//                }
//                R.id.navigation_profile -> {
//                    // Handle notifications item selection
//                    true
//                }
//                else -> false
//            }
//        }

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_beranda)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

}