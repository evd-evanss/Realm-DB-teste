package com.sayhitoiot.realmdatabase.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sayhitoiot.realmdatabase.R
import com.sayhitoiot.realmdatabase.ui.fragments.HomeFragment
import com.sayhitoiot.realmdatabase.ui.fragments.ProfileFragment
import com.sayhitoiot.realmdatabase.ui.fragments.SettingsFragment
import kotlinx.android.synthetic.main.content_view.*
import kotlinx.android.synthetic.main.menu_bottom.*

class TesteActivity : AppCompatActivity() {

    private val homeFragment: HomeFragment by lazy { HomeFragment.newInstance() }
    private val settingsFragment: SettingsFragment by lazy { SettingsFragment.newInstance() }
    private val profileFragment: ProfileFragment by lazy { ProfileFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_view)
        startFragment(homeFragment)
    }

    open fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    open fun startFragmentR() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, profileFragment)
            .commit()
    }

    fun bottomAppBarClick(view: View){
        when(view){
            item_home ->{homeItemPressed()}
            item_lesson ->{lessonItemPressed()}
            item_setting ->{settingItemPressed()}
            fab -> {}
        }
    }

    private fun homeItemPressed() {
        item_home.setImageDrawable(resources.getDrawable(R.drawable.ic_home_pressed))
        tv_home.setTextColor(resources.getColor(R.color.appiaPrimary))
        item_lesson.setImageDrawable(resources.getDrawable(R.drawable.ic_lessons))
        tv_lessons.setTextColor(resources.getColor(R.color.grayText))
        item_setting.setImageDrawable(resources.getDrawable(R.drawable.ic_settings))
        tv_setting.setTextColor(resources.getColor(R.color.grayText))
        startFragment(homeFragment)
    }

    private fun lessonItemPressed() {
        item_home.setImageDrawable(resources.getDrawable(R.drawable.ic_home))
        tv_home.setTextColor(resources.getColor(R.color.grayText))
        item_lesson.setImageDrawable(resources.getDrawable(R.drawable.ic_lesson_pressed))
        tv_lessons.setTextColor(resources.getColor(R.color.appiaPrimary))
        item_setting.setImageDrawable(resources.getDrawable(R.drawable.ic_settings))
        tv_setting.setTextColor(resources.getColor(R.color.grayText))
    }

    private fun settingItemPressed() {
        item_home.setImageDrawable(resources.getDrawable(R.drawable.ic_home))
        tv_home.setTextColor(resources.getColor(R.color.grayText))
        item_lesson.setImageDrawable(resources.getDrawable(R.drawable.ic_lessons))
        tv_lessons.setTextColor(resources.getColor(R.color.grayText))
        item_setting.setImageDrawable(resources.getDrawable(R.drawable.ic_settings_pressed))
        tv_setting.setTextColor(resources.getColor(R.color.appiaPrimary))
        startFragment(settingsFragment)
    }

}
