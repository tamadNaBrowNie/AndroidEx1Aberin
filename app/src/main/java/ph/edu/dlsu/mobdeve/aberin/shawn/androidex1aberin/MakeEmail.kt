package ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin.databinding.MakeEmailBinding as MakeEmail


class MakeEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.make_email)
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE)
        var editor = sharedPreference?.edit()
        val binding = MakeEmail.inflate(layoutInflater)
        var data = intent.data as EmailData
        binding.apply {
            receiver.setText(data.receiver)
            topic.setText( data.subj)
            msg.setText(data.body)
            
            Send.setOnClickListener {
                data = EmailData(receiver.text.toString(),topic.text.toString(),msg.text.toString(), false)
                editor?.putString("$receiver.text",data.toString())
                editor?.commit()
            }
            Discard.setOnClickListener {
                startActivity(Intent(this@MakeEmail, MainActivity::class.java))
            }
        }
    }
    override fun onBackPressed() {
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE)
        val binding = MakeEmail.inflate(layoutInflater)
        var editor = sharedPreference?.edit()
        super.onBackPressed()
        var data:EmailData = EmailData(binding.receiver.text.toString(),binding.topic.text.toString(),binding.msg.text.toString(), true)
        editor?.putString("$binding.receiver.text",data.toString())
        editor?.commit()
    }
}