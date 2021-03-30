package com.pe.relari.helloandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.pe.relari.helloandroidstudio.business.model.entity.EmployeeEntity
import com.pe.relari.helloandroidstudio.business.adapter.EmployeeAdapter
import com.pe.relari.helloandroidstudio.config.DatabaseConfig
import kotlinx.android.synthetic.main.activity_report.*


class Report : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        var employees: List<EmployeeEntity>

        val database = DatabaseConfig.getDataBase(this)

        database.employeeDao().findAll().observe(this, Observer {
            employees = it

            val adapter = EmployeeAdapter(this, employees)

            lvReport.adapter = adapter
        })

    }
}
