package com.example.lucdtph31250_asm1

import android.os.Parcel
import android.os.Parcelable

class Product(
     val id: Int,
    val name: String,
    val image: Int,
    val price: Double,
    val quantity: Int,
    val description: String,
    val rating: Float,
    val favorite: Boolean

) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"",
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString()?:"",
        parcel.readFloat(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeDouble(price)
        parcel.writeInt(quantity)
        parcel.writeString(description)
        parcel.writeFloat(rating)
        parcel.writeByte(if (favorite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}