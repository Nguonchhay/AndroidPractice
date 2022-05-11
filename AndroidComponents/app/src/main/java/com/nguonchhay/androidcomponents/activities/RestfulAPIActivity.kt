package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityRestfulApiactivityBinding
import com.nguonchhay.androidcomponents.dataclasses.MinionCardData
import com.nguonchhay.androidcomponents.dataclasses.MinionData
import com.nguonchhay.androidcomponents.networks.RetrofitInstance
import com.nguonchhay.androidcomponents.networks.api.MinionKtorInterface
import com.nguonchhay.androidcomponents.networks.api.MinionRetrofitApiInterface
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RestfulAPIActivity : AppCompatActivity() {

    lateinit var binding: ActivityRestfulApiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestfulApiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitMinionApi = RetrofitInstance.getInstance().create(MinionRetrofitApiInterface::class.java)
        val ktorMinionApi by lazy {
            MinionKtorInterface.create()
        }

        binding.btnRetrofitGet.setOnClickListener {
            lifecycleScope.launch {
                val result = retrofitMinionApi.list()
                if (result.isSuccessful) {
                    val obj = result.body()!!
                    var titles = "";
                    obj.data.forEach {
                        titles += " ${it.title}"
                    }
                    Toast.makeText(this@RestfulAPIActivity, titles, Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("RestfulAPIActivity", "Error")
                }
            }
        }

        binding.btnRetrofitPost.setOnClickListener {
            lifecycleScope.launch {
                val result = retrofitMinionApi.store(
                    MinionCardData(
                        title = "Minion 6",
                        description = "This is minion 6",
                        image = R.drawable.minion5
                    )
                )
                if (result.isSuccessful) {
                    val obj = result.body()!!
                    Toast.makeText(this@RestfulAPIActivity, obj.data[0].title, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnRetrofitPut.setOnClickListener {
            lifecycleScope.launch {
                val updateMinion = MinionCardData(
                    id = 7,
                    title = "Minion 6",
                    description = "This is minion 6",
                    image = R.drawable.minion5
                )
                updateMinion.id?.let { it1 ->
                    val result = retrofitMinionApi.update(it1, updateMinion)
                    if (result.isSuccessful) {
                        val obj = result.body()!!
                        Toast.makeText(this@RestfulAPIActivity, obj.data[0].title, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnKtorGet.setOnClickListener {
            lifecycleScope.launch {
                val result = ktorMinionApi.list()
                var titles = ""
                result.data.forEach {
                    titles += " ${it.title}"
                }
                Toast.makeText(this@RestfulAPIActivity, titles.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnKtorPost.setOnClickListener {
            lifecycleScope.launch {
                val result = ktorMinionApi.store(
                    MinionData(
                        title = "Minion 10",
                        description = "This is minion 10",
                        image = R.drawable.minion5
                    )
                )
                Toast.makeText(this@RestfulAPIActivity, result.data[0].title, Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnKtorPut.setOnClickListener {
            lifecycleScope.launch {
                val updateMinion = MinionData(
                    id = 7,
                    title = "Minion 11",
                    description = "This is minion 11",
                    image = R.drawable.minion5
                )
                val result = updateMinion.id?.let { it1 ->
                    ktorMinionApi.update(it1, updateMinion)
                }
                Toast.makeText(this@RestfulAPIActivity, result!!.data[0].title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}