package com.pe.relari.helloandroidstudio.business.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pe.relari.helloandroidstudio.business.model.entity.EmployeeEntity

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee")
    fun findAll(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun findById(id: Int): LiveData<EmployeeEntity>

    @Update
    fun update(employeeEntity: EmployeeEntity)

    @Insert
    fun insert(employeeEntity: EmployeeEntity)

}