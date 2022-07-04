package ph.edu.dlsu.mobdeve.aberin.shawn.androidex1aberin

data class EmailData(val receiver:String, val subj:String, val body:String, val isDraft:Boolean){
    override fun toString(): String {
        return "EmailData('$receiver','$subj','$body',$isDraft)"
    }
}
