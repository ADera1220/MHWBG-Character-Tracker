package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlin.random.Random


class CharCreateFragment: Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
        ): View? {

        return inflater.inflate(R.layout.char_create_fragment, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerNameEditText: EditText? = getView()?.findViewById(R.id.Player_Name_EditText)
        val charNameEditText: EditText? = getView()?.findViewById(R.id.Character_Name_EditText)
        val gameNameEditText: EditText? = getView()?.findViewById(R.id.Game_Name_EditText)
        val palicoNameEditText: EditText? = getView()?.findViewById(R.id.Palico_Name_EditText)
        val weaponTypeSpinner: Spinner? = getView()?.findViewById(R.id.Weapon_Type_Spinner)
        val saveButton: View? = getView()?.findViewById(R.id.Char_Save_Button)

        weaponTypeSpinner?.selectedItem
        
        saveButton?.setOnClickListener {
            var newChar = CharSheet(
                generateID(),
                playerNameEditText?.text.toString(),
                charNameEditText?.text.toString(),
                gameNameEditText?.text.toString(),
                palicoNameEditText?.text.toString(),
                weaponTypeSpinner?.selectedItem.toString()
            )
            Log.i("CCFrag", weaponTypeSpinner?.prompt.toString())


            (activity as MainActivity).currentChar = newChar
            (activity as MainActivity).addCharSheet(newChar)
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharSheetFragment>(R.id.Fragment_Container)
                }
        }
        var exitButton: View? = getView()?.findViewById(R.id.Exit_Button)
        exitButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharListFragment>(R.id.Fragment_Container)
                }
        }

    }

    // Generates a Random ID that has the time of creation and a random 3 digit Int, to ensure they are unique
    private fun generateID(): String {
        return "T" + System.currentTimeMillis().toString() + "C" + Random.nextInt(100, 999)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}


