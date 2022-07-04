package ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin.databinding.EmailViewBinding

class EmailViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_view)
        val binding = EmailViewBinding.inflate(layoutInflater)
        val data = intent.data as EmailData
        binding.apply {
            receiver.text = data.receiver
            topic.text= data.subj
            msg.text = data.body
        }
    }
}