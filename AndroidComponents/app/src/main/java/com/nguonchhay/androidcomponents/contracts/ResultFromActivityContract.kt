package com.nguonchhay.androidcomponents.contracts

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.nguonchhay.androidcomponents.activities.ResultFromStartActivity

class ResultFromActivityContract : ActivityResultContract<Unit, String>() {

    companion object {
        val MESSAGE = "MESSAGE_CONTRACT"
    }


    override fun createIntent(context: Context, input: Unit): Intent {
        return Intent(context, ResultFromStartActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val message = intent?.getStringExtra(MESSAGE)
        return if (message.isNullOrBlank()) {
            "EMPTY STRING"
        } else {
            message
        }
    }
}