package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        var weaponListButton: View? = getView()?.findViewById(R.id.Weapon_Button)
        var helmListButton: View? = getView()?.findViewById(R.id.Helm_Button)
        var chestListButton: View? = getView()?.findViewById(R.id.Chest_Button)
        var legsListButton: View? = getView()?.findViewById(R.id.Legs_Button)
        var materialsListButton: View? = getView()?.findViewById(R.id.Bone_Ore_Hide_Other_Button)
        var monsterPartsListButton: View? = getView()?.findViewById(R.id.Monster_Parts_Button)
        var questListButton: View? = getView()?.findViewById(R.id.Quests_Button)
        var exitButton: View? = getView()?.findViewById(R.id.Exit_Button)

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
    }

    // Generates a Random ID that has the time of creation and a random 3 digit Int, to ensure they are unique
    private fun generateID(): String {
        return "T" + System.currentTimeMillis().toString() + "C" + Random.nextInt(100, 999)
    }
}