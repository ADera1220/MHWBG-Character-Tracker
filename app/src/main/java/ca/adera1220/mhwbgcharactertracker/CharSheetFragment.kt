package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlin.random.Random

class CharSheetFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {

        return inflater.inflate(R.layout.char_sheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var currentChar: CharSheet? = null

        // Initialize the buttons for the various lists
        var weaponListButton: View? = getView()?.findViewById(R.id.Weapon_Button)
        var helmListButton: View? = getView()?.findViewById(R.id.Helm_Button)
        var chestListButton: View? = getView()?.findViewById(R.id.Chest_Button)
        var legsListButton: View? = getView()?.findViewById(R.id.Legs_Button)
        var materialsListButton: View? = getView()?.findViewById(R.id.Bone_Ore_Hide_Other_Button)
        var monsterPartsListButton: View? = getView()?.findViewById(R.id.Monster_Parts_Button)
        var questListButton: View? = getView()?.findViewById(R.id.Quests_Button)
        var exitButton: View? = getView()?.findViewById(R.id.Exit_Button)
        var saveButton: View? = getView()?.findViewById(R.id.Save_Button)

        // Initialize TexViews and Spinners for Editing
        val charNameTextView: TextView? = getView()?.findViewById(R.id.Char_Name_TextView)
        val potionCountSpinner: Spinner? = getView()?.findViewById(R.id.Potions_Spinner)
        val dayCountSpinner: Spinner? = getView()?.findViewById(R.id.Day_Count_Spinner)

        // If the user arrives at this fragment to edit a char sheet
        if((activity as MainActivity).alertAction == AlertAction.UPDATE) {
            var charList = (activity as MainActivity).getCharList()
            for(char in charList) {
                if(char.id == (activity as MainActivity).currentChar.id) {
                    currentChar = char
                }
            }

            charNameTextView?.text = currentChar?.characterName
            potionCountSpinner?.setSelection(currentChar?.potionCount!!)
            dayCountSpinner?.setSelection(currentChar?.dayCount!! - 1)

        }

        weaponListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "weapon"
                    replace<InventoryListFragment>(R.id.Fragment_Container)
                }
        }

        helmListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "helm"
                    replace<InventoryListFragment>(R.id.Fragment_Container)
                }
        }

        chestListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "chest"
                    replace<InventoryListFragment>(R.id.Fragment_Container)
                }
        }

        legsListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "legs"
                    replace<InventoryListFragment>(R.id.Fragment_Container)
                }
        }

        materialsListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "materials"
                    replace<MaterialListFragment>(R.id.Fragment_Container)
                }
        }

        monsterPartsListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "monsters"
                    replace<MaterialListFragment>(R.id.Fragment_Container)
                }
        }

        questListButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = "quests"
                    replace<MaterialListFragment>(R.id.Fragment_Container)
                }
        }

        exitButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = ""
                    replace<CharListFragment>(R.id.Fragment_Container)
                }
        }

        saveButton?.setOnClickListener {

            when((activity as MainActivity).alertAction) {
                // Id we are creating a new task
                AlertAction.ADD -> {}
                // If we are updating an existing task
                AlertAction.UPDATE -> {}
            }

            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    (activity as MainActivity).listType = ""
                    replace<CharListFragment>(R.id.Fragment_Container)
                }
        }
    }
}