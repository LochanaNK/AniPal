package com.example.anipal


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import java.time.LocalDate

class CategoriesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val startYear = 1990
        val endYear = LocalDate.now().year

        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        val genreView = view.findViewById<AutoCompleteTextView>(R.id.genre_view)
        val yearView = view.findViewById<AutoCompleteTextView>(R.id.year_view)

        val genres = listOf("Action","Adventure","Comedy","Slice of life","Shounen","Seinen","Isekai","Romance")
        val years = (startYear..endYear).toList().map { it.toString() }
        val adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,genres)
        val adapter2 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,years)


        genreView.setAdapter(adapter1)
        yearView.setAdapter(adapter2)

        genreView.setOnClickListener{
            genreView.setDropDownHeight(400)
            genreView.showDropDown()
        }
        yearView.setOnClickListener{
            yearView.setDropDownHeight(400)
            yearView.showDropDown()
        }

        return view
    }
}
