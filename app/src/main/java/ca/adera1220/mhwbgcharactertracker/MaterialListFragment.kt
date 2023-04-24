package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MaterialListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {

        return inflater.inflate(R.layout.material_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).popMaterialList()

        var materialSaveButton: View? = getView()?.findViewById(R.id.Material_Save_Button)

        materialSaveButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharSheetFragment>(R.id.Fragment_Container)
                }
        }
    }

}