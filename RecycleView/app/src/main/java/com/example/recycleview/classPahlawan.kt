package com.example.recycleview

import android.os.Parcel
import android.os.Parcelable

import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

//berisi untuk properti yang ditampilkan pada recyclerView
//tambahkan @Parcelize

@Parcelize
data class classPahlawan(
    val nama : String,
    val desk : String,
    val img  : Int
) : Parcelable
