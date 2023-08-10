package ca.adera1220.mhwbgcharactertracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaterialAdapter (private val dataSet: MutableMap<String, Int>):
    RecyclerView.Adapter<MaterialAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val frame: FrameLayout
        val itemName: TextView
        val quantity: EditText

        init {
            frame = view.findViewById(R.id.Material_List_Item_Frame_Layout)
            itemName = view.findViewById(R.id.Material_Name_TextView)
            quantity = view.findViewById(R.id.Quantity_EditText)


            var plusButton: View? = view.findViewById(R.id.Plus_Button)
            var minusButton: View? = view.findViewById(R.id.Minus_Button)
            var quantityEditText: EditText? = view.findViewById(R.id.Quantity_EditText)

            plusButton?.setOnClickListener {
                var itemCount = quantityEditText?.text?.toString()?.toInt()

                if(itemCount!! >= 0) {
                    itemCount = itemCount?.plus(1)
                    quantityEditText?.setText(itemCount.toString())
                }
            }

            minusButton?.setOnClickListener {
                var itemCount = quantityEditText?.text?.toString()?.toInt()

                if(itemCount!! > 0) {
                    itemCount = itemCount?.minus(1)
                    quantityEditText?.setText(itemCount.toString())
                }
            }
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

        holder.itemName.text = names[position]
        holder.quantity.setText(quantity[position].toString())
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}