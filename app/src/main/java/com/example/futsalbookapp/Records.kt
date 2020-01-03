package com.example.futsalbookapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.futsalbookapp.models.Booking
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_records.*
import kotlinx.android.synthetic.main.fragment_records.*

class Records : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.records_layout)

        val adapter = GroupAdapter<GroupieViewHolder>()
        recyclerview_records.adapter = adapter

        adapter.add(RecItem())
        adapter.add(RecItem())

//        fetchRecords()
    }

//    private fun fetchRecords() {
//        val ref = FirebaseDatabase.getInstance().getReference("/booking")
//        ref.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                val adapter = GroupAdapter<ViewHolder>()
//                p0.children.forEach{
//                    val books = it.getValue(Booking::class.java)
//                    adapter.add(RecItem())
//                }
//                recyclerview_records.adapter = adapter
//
//            }
//
//
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//
//
//        })
//    }
}
class RecItem: Item<GroupieViewHolder>(){

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

    }

    override fun getLayout(): Int {
        return R.layout.activity_records
    }




}




