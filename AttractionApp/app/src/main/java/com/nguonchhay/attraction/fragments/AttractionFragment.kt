package com.nguonchhay.attraction.fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.adapters.AttractionListAdapter
import com.nguonchhay.attraction.databases.data.AttractionItem

class AttractionFragment(val context: Activity) : Fragment(R.layout.fragment_attraction) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val attractions = mutableListOf<AttractionItem>(
            AttractionItem("https://i.picsum.photos/id/512/200/200.webp?hmac=5QTOrcZZMKka3p5dLwe1bcEC12KpvIXSx2cKJGXnXwE", "Phnom Penh", "The capital city of Cambodia"),
            AttractionItem("https://i.picsum.photos/id/201/200/200.webp?hmac=8386aq-zEbGla41KQFNBPS1L_rt9nS92LjL3qqrK_Xo", "Kap", "Beautiful sea"),
            AttractionItem("https://i.picsum.photos/id/925/200/200.webp?hmac=JKpe0yjl7_Ggc1k2eoMlDlSHsR349VwxhH8Q0XhN5HY", "Siem Reap", "World heritage"),
            AttractionItem("https://i.picsum.photos/id/512/200/200.webp?hmac=5QTOrcZZMKka3p5dLwe1bcEC12KpvIXSx2cKJGXnXwE", "Phnom Penh", "The capital city of Cambodia"),
            AttractionItem("https://i.picsum.photos/id/201/200/200.webp?hmac=8386aq-zEbGla41KQFNBPS1L_rt9nS92LjL3qqrK_Xo", "Kap", "Beautiful sea"),
            AttractionItem("https://i.picsum.photos/id/925/200/200.webp?hmac=JKpe0yjl7_Ggc1k2eoMlDlSHsR349VwxhH8Q0XhN5HY", "Siem Reap", "World heritage"),
            AttractionItem("https://i.picsum.photos/id/512/200/200.webp?hmac=5QTOrcZZMKka3p5dLwe1bcEC12KpvIXSx2cKJGXnXwE", "Phnom Penh", "The capital city of Cambodia"),
            AttractionItem("https://i.picsum.photos/id/201/200/200.webp?hmac=8386aq-zEbGla41KQFNBPS1L_rt9nS92LjL3qqrK_Xo", "Kap", "Beautiful sea"),
            AttractionItem("https://i.picsum.photos/id/925/200/200.webp?hmac=JKpe0yjl7_Ggc1k2eoMlDlSHsR349VwxhH8Q0XhN5HY", "Siem Reap", "World heritage"),
        )
        val adapter = AttractionListAdapter(context, attractions)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleAttraction)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(context)
    }

}