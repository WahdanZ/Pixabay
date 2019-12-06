package com.wahdanz.pixabay.extensions

import android.app.Activity
import android.app.AlertDialog

fun Activity.showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    builder.dialogBuilder()
    val dialog = builder.create()

    dialog.show()
}

fun AlertDialog.Builder.positiveButton(
    text: String = "Okay",
    handleClick: (which: Int) -> Unit = {}
) {
    this.setPositiveButton(text, { dialogInterface, which -> handleClick(which) })
}

fun AlertDialog.Builder.negativeButton(
    text: String = "Cancel",
    handleClick: (which: Int) -> Unit = {}
) {
    this.setNegativeButton(text, { dialogInterface, which -> handleClick(which) })
}