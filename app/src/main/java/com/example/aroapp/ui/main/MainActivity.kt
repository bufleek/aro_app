package com.example.aroapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aroapp.data.repos.MainRepo
import com.example.aroapp.ui.auth.AuthActivity
import com.example.aroapp.ui.theme.AROAPPTheme
import com.example.aroapp.utils.AuthManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AuthManager.isLoggedIn == null){
            AuthManager.configure(this)
        }
        setContent {
            AROAPPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (AuthManager.isLoggedIn != null) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        if(!AuthManager.isLoggedIn!!) {
                            startActivity(Intent(this@MainActivity, AuthActivity::class.java))
                            finish()
                        }
                        true
                    } else {
                        false
                    }
                }
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AROAPPTheme {
    }
}