package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MaterialListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {

        return inflater.inflate(R.layout.inventory_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when ((activity as MainActivity).listType) {
            "materials" -> (activity as MainActivity).popMaterialsList()
            "monsters" -> (activity as MainActivity).popMonsterPartsList()
            "quests" -> (activity as MainActivity).popQuestList()
        }

        var inventorySaveButton: View? = getView()?.findViewById(R.id.Inventory_Save_Button)

        inventorySaveButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharSheetFragment>(R.id.Fragment_Container)
                }
        }
    }
}