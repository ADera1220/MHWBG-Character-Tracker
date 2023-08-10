package ca.adera1220.mhwbgcharactertracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class CharListItemAdapter(private val dataSet: List<CharSheet>):
    RecyclerView.Adapter<CharListItemAdapter.ViewHolder>() {

        var onCharSheetClick: ((CharSheet, position: Int) -> Unit)? = null

        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val frame: FrameLayout
            val playerName: TextView
            val charName: TextView
            val weaponType: TextView
            val palicoName: TextView
            val campaignName: TextView

            init {
                frame = view.findViewById(R.id.Character_List_Item_Frame_Layout)
                playerName = view.findViewById(R.id.Player_Name_TextView)
                charName = view.findViewById(R.id.Character_Name_TextView)
                weaponType = view.findViewById(R.id.Weapon_Type_TextView)
                palicoName = view.findViewById(R.id.Palico_Name_TextView)
                campaignName = view.findViewById(R.id.Campaign_Name_TextView)

                view.setOnClickListener {
                    onCharSheetClick?.invoke(dataSet[adapterPosition], adapterPosition)
                }
            }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.character_list_item_layout, viewGroup, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.charName.text = dataSet[position].characterName
            holder.playerName.text = dataSet[position].playerName
            holder.campaignName.text = dataSet[position].campaignName
            holder.weaponType.text = dataSet[position].weaponType
            holder.palicoName.text = dataSet[position].palicoName
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }
}
