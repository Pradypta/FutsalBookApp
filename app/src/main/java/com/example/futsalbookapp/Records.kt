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
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_records.*

class Records : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

//        val adapter = GroupAdapter<ViewHolder>()
//
//        adapter.add(RecItem())
//        adapter.add(RecItem())
//        adapter.add(RecItem())
//
//
//        recyclerview_records.adapter = adapter

        fetchRecords()
    }

    private fun fetchRecords() {
        val ref = FirebaseDatabase.getInstance().getReference("/booking")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach{
                    val books = it.getValue(Booking::class.java)
                    adapter.add(RecItem())
                }
                recyclerview_records.adapter = adapter

            }


            override fun onCancelled(p0: DatabaseError) {

            }



        })
    }
}
class RecItem: Item<ViewHolder>(){

    override fun bind(viewHolder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getLayout(): Int {
        return R.layout.fragment_records
    }

}




