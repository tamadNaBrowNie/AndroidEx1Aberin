package ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val pref = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val saves = pref?.all
        val arr:ArrayList<Pair<String,Any?>> = arrayListOf()
        val emails = arrayListOf<EmailData>()
        for(entry in saves!!.entries)
        {
            val data = Pair(entry.key,entry.value)
            arr.add(data)
        }
        for( email in arr){
            val str = email.second as String
            val rec = str.substringBefore(',')
            val sub = str.substringAfter(',')
            val subj = str.substringBefore(',')
            val sub2= str.substringAfter(',')
            val msg = str.substringBefore(',')
            val boolean = str.substringAfter(',').toBoolean()
            emails.add(EmailData(rec,subj,msg,boolean))
        }
        val adapter = EmailAdapter(emails){
            val bundle = bundleOf(Pair("email",it))
            if(it.isDraft){
                startActivity(Intent(this,MakeEmail::class.java).putExtras(bundle))
            }else{
                startActivity(Intent(this,EmailViewer::class.java).putExtras(bundle))
            }
        }

        binding.apply {
            rvEmail.adapter = adapter

        }
    }
}