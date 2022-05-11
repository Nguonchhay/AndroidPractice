package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.RecyclerCardViewAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityRecyclerViewWithCardViewBinding
import com.nguonchhay.androidcomponents.dataclasses.MinionCardData

class RecyclerViewWithCardViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerViewWithCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewWithCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val minionData = mutableListOf<MinionCardData>(
            MinionCardData(
                title ="Minion 1",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                image = R.drawable.minion1
            ),
            MinionCardData(
                title = "Minion 2",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                image = R.drawable.minion1
            ),
            MinionCardData(
                title ="Minion 3",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                image = R.drawable.minion1
            ),
            MinionCardData(
                title ="Minion 4",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                image = R.drawable.minion1
            ),
            MinionCardData(
                title ="Minion 5",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                image = R.drawable.minion1
            )
        )

        val adapter = RecyclerCardViewAdapter(minionData)

        binding.rvMinions.adapter = adapter
        binding.rvMinions.layoutManager = LinearLayoutManager(this)
    }
}