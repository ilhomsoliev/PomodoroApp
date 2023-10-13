package com.ilhomsoliev.pomodoroapp.data.local

import androidx.annotation.NonNull

// @Entity(primaryKeys = ["title", "archived"])
class Label(
    //  @ColumnInfo(defaultValue = "")
    @NonNull
    var title: String,

    // @ColumnInfo(defaultValue = "0")
    @NonNull
    var colorId: Int
) {

    // @ColumnInfo(defaultValue = "0")
    @NonNull
    var order: Int = 0

    // @ColumnInfo(defaultValue = "0")
    @NonNull
    var archived: Boolean = false
}