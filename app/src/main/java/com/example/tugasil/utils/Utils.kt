package com.example.tugasil.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.tugasil.`interface`.navigation.Screen

object Utils {

    val listScreenWithoutBottomBar = listOf(
        Screen.DetailScreen.route
    )


    fun toGithub(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data =  Uri.parse("https://github.com/mayagp")

        }
        context.startActivity(intent)
    }

    fun toInstagram(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data =  Uri.parse("https://www.instagram.com/mayagfptrii/")

        }
        context.startActivity(intent)
    }



}