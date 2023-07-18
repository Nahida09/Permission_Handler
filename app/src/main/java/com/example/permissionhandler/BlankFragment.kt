package com.example.permissionhandler

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BlankFragment : Fragment() {
    private lateinit var checkPermissionFromActivityButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermissionFromActivityButton = view.findViewById<Button>(R.id.checkPermissionFromActivityButton)
        checkPermissionFromActivityButton.setOnClickListener {
            PermissionHandler.getPermission(activity as AppCompatActivity, Manifest.permission.CAMERA)
        }
    }
}