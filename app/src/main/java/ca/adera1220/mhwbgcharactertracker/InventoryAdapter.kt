package ca.adera1220.mhwbgcharactertracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InventoryAdapter(private val dataSet: Map<String, Boolean>, private val weaponType: String?):
    RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

        var dataSetStart: Int = 0
        var dataSetEnd: Int = 249

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

            if(weaponType != null) {
                holder.itemName.text = names[position + dataSetStart]
                holder.inInventory.isChecked = isChecked[position + dataSetStart]
            } else {
                holder.itemName.text = names[position]
                holder.inInventory.isChecked = isChecked[position]
            }
        }

        override fun getItemCount(): Int {
            var size: Int = 0

            when(weaponType) {
                "Bow" -> {
                    dataSetStart = 0
                    dataSetEnd = 19
                    size = dataSetEnd - dataSetStart
                }
                "Charge Blade" -> {
                    dataSetStart = 19
                    dataSetEnd = 36
                    size = dataSetEnd - dataSetStart
                }
                "Dual Blades" -> {
                    dataSetStart = 36
                    dataSetEnd = 55
                    size = dataSetEnd - dataSetStart
                }
                "Great Sword" -> {
                    dataSetStart = 55
                    dataSetEnd = 72
                    size = dataSetEnd - dataSetStart
                }
                "Gunlance" -> {
                    dataSetStart = 72
                    dataSetEnd = 89
                    size = dataSetEnd - dataSetStart
                }
                "Hammer" -> {
                    dataSetStart = 89
                    dataSetEnd = 108
                    size = dataSetEnd - dataSetStart
                }
                "Heavy Bow Gun" -> {
                    dataSetStart = 108
                    dataSetEnd = 125
                    size = dataSetEnd - dataSetStart
                }
                "Hunting Horn" -> {
                    dataSetStart = 125
                    dataSetEnd = 142
                    size = dataSetEnd - dataSetStart
                }
                "Insect Glaive" -> {
                    dataSetStart = 142
                    dataSetEnd = 161
                    size = dataSetEnd - dataSetStart
                }
                "Lance" -> {
                    dataSetStart = 161
                    dataSetEnd = 180
                    size = dataSetEnd - dataSetStart
                }
                "Light Bow Gun" -> {
                    dataSetStart = 180
                    dataSetEnd = 196
                    size = dataSetEnd - dataSetStart
                }
                "Long Sword" -> {
                    dataSetStart = 197
                    dataSetEnd = 216
                    size = dataSetEnd - dataSetStart
                }
                "Switch Axe" -> {
                    dataSetStart = 216
                    dataSetEnd = 233
                    size = dataSetEnd - dataSetStart
                }
                "Sword &amp; Shield" -> {
                    dataSetStart = 233
                    dataSetEnd = 250
                    size = dataSetEnd - dataSetStart
                }
                else -> {
                    size = dataSet.size
                }
            }

            return size
        }
}