package com.pe.relari.helloandroidstudio.business.util

import com.pe.relari.helloandroidstudio.business.model.domain.Gender
import com.pe.relari.helloandroidstudio.business.model.domain.GenderEnum

class GenderFilter {

    private fun genders(): List<Gender> {

        val genderMale = Gender(GenderEnum.M, "Male")
        val genderFemale = Gender(GenderEnum.F, "Female")

        return listOf(genderMale, genderFemale)
    }

    fun findBy(genderDescription: String): String {
        return genders()
            .filter { it.description == genderDescription }
            .map { it.code.name }
            .first()
    }

}