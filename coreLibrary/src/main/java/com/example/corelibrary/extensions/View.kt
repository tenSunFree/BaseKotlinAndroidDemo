package com.example.corelibrary.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.toVisible() {
    this.visibility = VISIBLE
}

fun View.toGone() {
    this.visibility = GONE
}

fun Fragment.toast(text: CharSequence) {
    Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
}