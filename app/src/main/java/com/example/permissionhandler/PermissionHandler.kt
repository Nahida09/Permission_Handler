package com.example.permissionhandler

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

object PermissionHandler {

    private val PERMISSION_REQUEST_CODE = 1

    fun getPermission(activity: AppCompatActivity,permissions:String) {
        if (isPermissionGranted(activity,permissions)) {

            // Permission already granted, proceed with location-related functionality
            // ...
           // Toast.makeText(this,)
            //Toast.makeText(, PERMISSION_DENIED_TOAST_MESSAGE, Toast.LENGTH_SHORT).show()
        } else {
            // Request location permission
            requestPermission(activity,permissions)
        }
       Log.d("TAG","sahjssdsdjDENIE")
    }

    private fun isPermissionGranted(activity: AppCompatActivity,permissions:String): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            permissions
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(activity: AppCompatActivity,permissions:String) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(permissions),
            PERMISSION_REQUEST_CODE
        )

    }


    fun onRequestPermissionsResult(requestCode: Int, permissions:String, grantResults: IntArray,activity: AppCompatActivity) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    // Perform your location-related tasks here
                    if ((ContextCompat.checkSelfPermission(
                            activity,
                            permissions
                        ) == PackageManager.PERMISSION_GRANTED)
                    ) {
                        Log.d("TAG","Permission Granted")

                    }
                } else {
                    Log.d("TAG","Permission Denied")

                }
            }
        }
    }

}
