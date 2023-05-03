package com.udemysample.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentInfo(val fullName: String, val address: String, val phone: Int): Parcelable