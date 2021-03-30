package com.pe.relari.helloandroidstudio.business.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pe.relari.helloandroidstudio.R
import com.pe.relari.helloandroidstudio.business.model.entity.EmployeeEntity
import kotlinx.android.synthetic.main.item_employee.view.*

private const val IMAGE_MALE: String = "https://cdn.icon-icons.com/icons2/1465/PNG/512/154manofficeworker2_100459.png"
private const val IMAGE_FEMALE: String = "https://cdn.icon-icons.com/icons2/1465/PNG/512/156womanofficeworker2_100687.png"
class EmployeeAdapter(
    context: Context,
    private val employees: List<EmployeeEntity>) : ArrayAdapter<EmployeeEntity>(context, 0, employees) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false)

        val employee = employees[position]

        layout.tvName.text = employee.name
        layout.tvPosition.text = employee.position
        layout.tvSalary.text = employee.salary.toString()

//        if (employee.sex == "M") {
//            layout.imageView.setImageURI(Uri.parse(IMAGE_MALE))
//        } else {
//            layout.imageView.setImageURI(Uri.parse(IMAGE_FEMALE))
//        }

        return layout
    }
}