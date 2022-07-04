package ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin.databinding.ItememailBinding

class EmailAdapter(private val iList: List<EmailData>, val listener: (data: EmailData) -> Unit) :
    RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    inner class ViewHolder(item: ItememailBinding) : RecyclerView.ViewHolder(item.root) {
        private val to = item.receiver
        private val draft = item.draft
        private val subj = item.topic
        private val body = item.msg
        private val root = item.root
        internal fun binder(data: EmailData) {
            draft.isGone = data.isDraft
            to.text = data.receiver
            subj.text = data.subj
            body.text = data.body
            root.setOnClickListener {
                listener(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItememailBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binder(this.iList[position])
    }

    override fun getItemCount() = iList.size
}