package com.example.testapp.ui.splash
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivitySplashScreenBinding
import com.example.testapp.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    //var handler: Handler? = null

    val activityScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().getDecorView().setBackgroundColor(Color.BLUE)

        activityScope.launch {
            delay(2000)

            var intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*
        handler = Handler()
        handler?.postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        */
    }
}