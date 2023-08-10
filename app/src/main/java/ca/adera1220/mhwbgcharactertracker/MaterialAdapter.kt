package ca.adera1220.mhwbgcharactertracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaterialAdapter (private val dataSet: MutableMap<String, Int>):
    RecyclerView.Adapter<MaterialAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val frame: FrameLayout
        val itemName: TextView
        val quantityEditText: EditText
        val plusButton: Button
        val minusButton: Button

        init {
            frame = view.findViewById(R.id.Material_List_Item_Frame_Layout)
            itemName = view.findViewById(R.id.Material_Name_TextView)
            quantityEditText = view.findViewById(R.id.Quantity_EditText)
            plusButton = view.findViewById(R.id.Plus_Button)
            minusButton = view.findViewById(R.id.Minus_Button)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MaterialAdapter.ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.material_list_item_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaterialAdapter.ViewHolder, position: Int) {
        var names: List<String> = dataSet.keys.toList()
        var quantity: List<Int> = dataSet.values.toList()

        holder.plusButton.setOnClickListener {
            var itemCount = holder.quantityEditText.text.toString().toInt()

            if(itemCount >= 0) {
                itemCount = itemCount.plus(1)
                for (item in dataSet) {
                    if(item.key == holder.itemName.text) {
                        dataSet[item.key] = itemCount
                        holder.quantityEditText.setText(itemCount.toString())
                    }
                }
            }
        }

        holder.minusButton.setOnClickListener {
            var itemCount = holder.quantityEditText.text.toString().toInt()

            if(itemCount > 0) {
                itemCount = itemCount.minus(1)
                for (item in dataSet) {
                    if(item.key == holder.itemName.text) {
                        dataSet[item.key] = itemCount
                        holder.quantityEditText.setText(itemCount.toString())
                    }
                }
            } else {
                holder.quantityEditText.setText("0")
            }
        }

        holder.itemName.text = names[position]
        holder.quantityEditText.setText(quantity[position].toString())
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}