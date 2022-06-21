package de.ern.xsqungngi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
NavigationAdapter.Listener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navHostFragment by lazy{
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    private val navController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       setupViews()
    }

    private fun setupViews() {
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
        with(binding){
            bottomNavigationView.setOnItemSelectedListener { item ->
                navigate(item)
            }

            with(navigation){
                menuItems.layoutManager = LinearLayoutManager(this@MainActivity)
                menuItems.adapter = NavigationAdapter(bottomNavigationView.menu,this@MainActivity)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                binding.title.text = destination.label.toString()
            }
        }
    }

    private fun navigate(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.drawer -> {
                drawerToggle()
                return false
            }
            else -> {
                if(binding.drawer.isDrawerOpen(GravityCompat.START)) binding.drawer.closeDrawer(
                    GravityCompat.START
                )
                if (item.itemId != binding.bottomNavigationView.selectedItemId) NavigationUI.onNavDestinationSelected(
                    item,
                    navController
                )
            }
        }
        return true
    }

    private fun drawerToggle() {
        if(binding.drawer.isDrawerOpen(GravityCompat.START)) binding.drawer.closeDrawer(
            GravityCompat.START
        )
        else binding.drawer.openDrawer(
            GravityCompat.START
        )
    }


    override fun onMenuClick(item: MenuItem) {
        navigate(item)
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

}