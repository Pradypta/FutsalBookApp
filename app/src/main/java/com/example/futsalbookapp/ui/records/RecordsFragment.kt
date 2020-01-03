package com.example.futsalbookapp.ui.records

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.futsalbookapp.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.fragment_records.*

class RecordsFragment : Fragment() {

    private lateinit var recordsViewModel: RecordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recordsViewModel =
            ViewModelProviders.of(this).get(RecordsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_records, container, false)
//        val textView: TextView = root.findViewById(R.id.text_slideshow)
        recordsViewModel.text.observe(this, Observer {
            //            textView.text = it
        })
        return root

    }



}


