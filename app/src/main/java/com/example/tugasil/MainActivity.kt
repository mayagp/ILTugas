package com.example.tugasil
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tugasil.`interface`.navigation.Screen
import com.example.tugasil.`interface`.screen.grup.GrupScreen
import com.example.tugasil.`interface`.screen.home.HomeScreen
import com.example.tugasil.`interface`.screen.profile.ProfileScreen
import com.example.tugasil.`interface`.theme.TugasILTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasILTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                   ArtisKpopApp()
                }
            }
        }
    }
}
