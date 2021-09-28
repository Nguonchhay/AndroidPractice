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
                "Minion 1",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                R.drawable.minion1
            ),
            MinionCardData(
                "Minion 2",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                R.drawable.minion1
            ),
            MinionCardData(
                "Minion 3",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                R.drawable.minion1
            ),
            MinionCardData(
                "Minion 4",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                R.drawable.minion1
            ),
            MinionCardData(
                "Minion 5",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua",
                R.drawable.minion1
            )
        )

        val adapter = RecyclerCardViewAdapter(minionData)

        binding.rvMinions.adapter = adapter
        binding.rvMinions.layoutManager = LinearLayoutManager(this)
    }
}