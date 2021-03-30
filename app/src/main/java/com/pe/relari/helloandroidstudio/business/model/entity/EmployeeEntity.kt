package com.pe.relari.helloandroidstudio.business.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "employee")
data class EmployeeEntity (
    val name: String = "",
    val sex: String = "",
    val position: String = "",
    val salary: Double = 0.0,
    val status: Boolean = true,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) : Serializable