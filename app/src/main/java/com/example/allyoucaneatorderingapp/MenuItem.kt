package com.example.allyoucaneatorderingapp
//import java.io.Serializable
//
//data class MenuItem(
//    val name: String,
//    val description: String,
//    val photoResId: Int,
//    val price: Double
//) : Serializable

import android.os.Parcel
import android.os.Parcelable

data class MenuItem(
    val name: String,
    val description: String,
    val photoResId: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photoResId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MenuItem> {
        override fun createFromParcel(parcel: Parcel): MenuItem {
            return MenuItem(parcel)
        }

        override fun newArray(size: Int): Array<MenuItem?> {
            return arrayOfNulls(size)
        }
    }
}
