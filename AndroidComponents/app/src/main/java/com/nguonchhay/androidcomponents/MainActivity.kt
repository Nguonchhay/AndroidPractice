package com.nguonchhay.androidcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.activities.*
import com.nguonchhay.androidcomponents.databinding.ActivityMainBinding
import com.nguonchhay.androidcomponents.jetpack_composes.MainComposeActivity
import com.nguonchhay.androidcomponents.mvvm_minion.view.CalculatorActivity
import com.nguonchhay.androidcomponents.mvvm_minion.view.CountLiveDataActivity
import com.nguonchhay.androidcomponents.mvvm_minion.view.MinionActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterActivity.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewComponent.setOnClickListener {
            val intent = Intent(this, ViewComponentActivity::class.java)
            startActivity(intent)
        }

        binding.btnGridView.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnGridViewColor.setOnClickListener {
            startActivity(Intent(this, GridViewColorActivity::class.java))
        }

        binding.btnFragmentStyle1.setOnClickListener {
            val intent = Intent(this, FragmentStyle1Activity::class.java)
            startActivity(intent)
        }

        binding.btnCardView.setOnClickListener {
            val intent = Intent(this, CardViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecycleview.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnListView.setOnClickListener {
            val intent = Intent(this, ListviewActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecycleviewWithCardView.setOnClickListener {
            val intent = Intent(this, RecyclerViewWithCardViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewPager2.setOnClickListener {
            val intent = Intent(this, ViewPager2Activity::class.java)
            startActivity(intent)
        }

        binding.btnViewPagerWithTab.setOnClickListener {
            val intent = Intent(this, ViewPagerWithTabActivity::class.java)
            startActivity(intent)
        }

        binding.btnTabLayout.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnBottomNav.setOnClickListener {
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }

        binding.btnActivityForResult.setOnClickListener {
            val intent = Intent(this, StartForResultActivity::class.java)
            intent.putExtra("msg", "Cool it works")
            startActivity(intent)
        }

        binding.btnMVVMMinion.setOnClickListener {
            val intent = Intent(this, MinionActivity::class.java)
            startActivity(intent)
        }

        binding.btnMVVMLiveData.setOnClickListener {
            startActivity(Intent(this, CountLiveDataActivity::class.java))
        }

        binding.btnMVVMStateFlow.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        binding.btnTextInputAndDialog.setOnClickListener {
            val intent = Intent(this, TextInputAndDialogActivity::class.java)
            startActivity(intent)
        }

        binding.btnCalculatorCompose.setOnClickListener {
            startActivity(Intent(this, MainComposeActivity::class.java))
        }
    }
}