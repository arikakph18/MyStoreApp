package com.idn.arika.mystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.arika.mystoreapp.adapter.ListUserAdapter
import com.idn.arika.mystoreapp.databinding.ActivityMainBinding
import com.idn.arika.mystoreapp.model.User

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()

        list.addAll(getDataUser())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        mainBinding.rvUser.layoutManager = LinearLayoutManager(this)
        var listUserAdapter = ListUserAdapter(list)
        mainBinding.rvUser.setHasFixedSize(true)
        mainBinding.rvUser.adapter = listUserAdapter
    }

    private fun getDataUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataLike = resources.getStringArray(R.array.like)
        val dataFollow = resources.getStringArray(R.array.follow)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataLocation = resources.getStringArray(R.array.location)
        val listUsers = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                    dataName[position],
                    dataUsername[position],
                    dataPhoto.getResourceId(position, -1),
                    dataLike[position].toInt().toString(),
                    dataFollow[position].toInt().toString(),
                    dataCompany[position],
                    dataRepository[position].toInt().toString(),
                    dataLocation[position],
            )
            listUsers.add(user)
        }
        return listUsers
    }
}