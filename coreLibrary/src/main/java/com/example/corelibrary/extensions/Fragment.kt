package com.example.corelibrary.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String) {
    Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
}