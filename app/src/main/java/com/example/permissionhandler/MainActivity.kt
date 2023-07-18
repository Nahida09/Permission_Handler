package com.example.permissionhandler

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var permissionButton: Button
    private lateinit var permissionButtonFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionButton = findViewById<Button>(R.id.checkPermissionFromActivityButton)
        permissionButtonFragment = findViewById<Button>(R.id.checkPermissionfromFragment)

        permissionButton.setOnClickListener {
            PermissionHandler.getPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        }

        permissionButtonFragment.setOnClickListener {

            val intent = Intent(applicationContext, MyFragmentActivity::class.java)
            startActivity(intent)
           /* supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, BlankFragment())
                .commit()
            PermissionHandler.getPermission(this, Manifest.permission.CAMERA)*/
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    // Perform your tasks that require the permission here
                    showMessage("Permission Denied")
                } else {
                    // Permission denied
                    showMessage("Permission Denied")
                }
                showMessage("Location permission required!!")
            }
        }
    }
    private fun showMessage(message: String) {
        // Use either a Toast or a Snackbar to display the message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        // Or use a Snackbar instead
        // Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
}