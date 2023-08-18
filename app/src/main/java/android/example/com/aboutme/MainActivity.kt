package android.example.com.aboutme

import android.content.Context
import android.example.com.aboutme.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(it: View?) {
        binding.apply {
            Log.d("TAG", "addNickname: "+binding.nicknameEdit.text.toString() )
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility  = View.GONE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it?.windowToken, 0)
    }
}
