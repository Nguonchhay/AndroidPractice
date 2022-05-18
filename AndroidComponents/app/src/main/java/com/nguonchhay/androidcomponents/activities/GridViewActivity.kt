package com.nguonchhay.androidcomponents.activities

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.GridViewAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityGridViewBinding
import com.nguonchhay.androidcomponents.dataclasses.GridViewData

class GridViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityGridViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        //binding.gridViewToolbar.title = ""
        //setActionBar(binding.gridViewToolbar)
        setSupportActionBar(binding.gridViewToolbar)

        val gridViewData = mutableListOf<GridViewData>(
            GridViewData(R.drawable.minion1, "Minion 1"),
            GridViewData(R.drawable.minion2, "Minion 2"),
            GridViewData(R.drawable.minion3, "Minion 3"),
            GridViewData(R.drawable.minion4, "Minion 4"),
            GridViewData(R.drawable.minion5, "Minion 5")
        )

        val gridViewAdapter = GridViewAdapter(gridViewData, this)
        binding.gridView.adapter = gridViewAdapter

        binding.imgGridViewBack.setOnClickListener {
            finish()
        }

    }

//    fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.grid_view_menu, menu)
//
//        val search = menu?.findItem(R.id.menuGridViewSearch)
//        val searchView = search?.actionView as SearchView
//        searchView.queryHint = "Search"
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                Toast.makeText(this@GridViewActivity, "Submit: $query", Toast.LENGTH_SHORT).show()
//                // Apply full text search
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Toast.makeText(this@GridViewActivity, "Typing: $newText", Toast.LENGTH_SHORT).show()
//                // Apply LIVE searching
//                return true
//            }
//        })
//
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
//
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuGridViewSearch -> Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            R.id.menuGridViewSetting -> Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}