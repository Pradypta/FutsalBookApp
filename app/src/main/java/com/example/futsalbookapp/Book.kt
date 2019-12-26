package com.example.futsalbookapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.futsalbookapp.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.view.View
import kotlinx.android.synthetic.main.activity_book.*
import java.util.*

class Book : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)

    lateinit var option : Spinner
    lateinit var option2 : Spinner
    lateinit var result : TextView


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val options = arrayListOf("1 Jam", "2 Jam", "3 Jam")
        val options2 = arrayListOf("Lapangan 1", "Lapangan 2", "Lapangan 3")


        option = findViewById(R.id.spinner) as Spinner
        option2 = findViewById(R.id.spinner2) as Spinner
        result = findViewById(R.id.txt_result) as TextView


        option.adapter = ArrayAdapter<String>(this,R.layout.color_spinner_layout,options)
        option2.adapter = ArrayAdapter<String>(this,R.layout.color_spinner_layout,options2)

        option.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Pick the duration"
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                result.text = options.get(position)
            }
        }
        option2.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Pick the field"
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                result.text = options.get(position)
            }
        }
        btn_date.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                btn_date.setText(""+mDay+"/"+mMonth+"/"+mYear)
            }, year,month,day)
            dpd.show()
            }

        btn_hour.setOnClickListener{
            val timeSetListener = TimePickerDialog.OnTimeSetListener{view: TimePicker?, hour: Int, minute: Int ->
                c.set(Calendar.HOUR_OF_DAY, hour)
                c.set(Calendar.MINUTE,minute)
                btn_hour.text = SimpleDateFormat("HH:mm").format(c.time)
            }
            TimePickerDialog(this, timeSetListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),true).show()
        }
    }


    fun saveUser(view:android.view.View){

        val uid = FirebaseAuth.getInstance().uid
        val username = FirebaseAuth.getInstance().currentUser?.email
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid.toString(), username.toString())

        ref.setValue(user)
    }
}
