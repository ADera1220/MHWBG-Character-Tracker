package ca.adera1220.mhwbgcharactertracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharSheetAdapter(private val dataSet: List<CharSheet>):
RecyclerView.Adapter<CharSheetAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val charName: TextView
        val potionCount: EditText
        val dayCount: EditText

        init {
            charName = view.findViewById(R.id.Char_Name_TextView)
            potionCount = view.findViewById(R.id.Potion_Count_EditText)
            dayCount = view.findViewById(R.id.Day_Count_EditText)


            Log.i("CHARSHEET", dataSet[position].potionCount.toString())
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.char_sheet_fragment, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.charName.text = dataSet[position].characterName
        holder.potionCount.setText(dataSet[position].potionCount)
        holder.dayCount.setText(dataSet[position].dayCount)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}