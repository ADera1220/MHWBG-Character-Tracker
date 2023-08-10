package ca.adera1220.mhwbgcharactertracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InventoryAdapter(private val dataSet: MutableMap<String, Boolean>):
    RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
          val frame: FrameLayout
          val itemName: TextView
          val inInventory: CheckBox

          init {
              frame = view.findViewById(R.id.Inventory_List_Item_Frame_Layout)
              itemName = view.findViewById(R.id.item_Name_TextView)
              inInventory = view.findViewById(R.id.In_Inventory_CheckBox)


          }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): InventoryAdapter.ViewHolder {
            val view = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.inventory_list_item_layout, viewGroup, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: InventoryAdapter.ViewHolder, position: Int) {

            var names: List<String> = dataSet.keys.toList()
            var isChecked: List<Boolean> = dataSet.values.toList()

            holder.inInventory.setOnClickListener {
                for (item in dataSet) {
                    if(item.key == holder.itemName.text) {
                        dataSet[item.key] = holder.inInventory.isChecked
                    }
                }
            }

            holder.itemName.text = names[position]
            holder.inInventory.isChecked = isChecked[position]
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }
}