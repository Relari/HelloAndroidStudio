package com.pe.relari.helloandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.pe.relari.helloandroidstudio.business.util.GenderFilter
import com.pe.relari.helloandroidstudio.business.model.entity.EmployeeEntity
import com.pe.relari.helloandroidstudio.config.DatabaseConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPosition = findViewById<TextView>(R.id.txtPosition)
        val txtGender = findViewById<Spinner>(R.id.txtGender)
        val txtSalary = findViewById<TextView>(R.id.txtSalary)

        val genderCode = GenderFilter().findBy(txtGender.selectedItem.toString())

        val database = DatabaseConfig.getDataBase(this)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val employeeEntity =
                EmployeeEntity(
                    txtName.text.toString(),
                    genderCode,
                    txtPosition.text.toString(),
                    txtSalary.text.toString().toDouble(),
                    true
                )

            CoroutineScope(Dispatchers.IO).launch {
                database.employeeDao().insert(employeeEntity)
            }

        }

    }

}
