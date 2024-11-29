package com.example.teamproject
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var drawerLayout: androidx.drawerlayout.widget.DrawerLayout? = null

    fun onMenuButtonClicked() {
        drawerLayout?.let {
            if(!it.isDrawerOpen(GravityCompat.END)) {
                it.openDrawer(GravityCompat.END)
            }
            else {
                it.closeDrawer(GravityCompat.END)
            }
        }
    }
}