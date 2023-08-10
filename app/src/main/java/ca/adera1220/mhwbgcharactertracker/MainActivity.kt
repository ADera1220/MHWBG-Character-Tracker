package ca.adera1220.mhwbgcharactertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var charList: RecyclerView
    private lateinit var inventoryList: RecyclerView
    private lateinit var materialsList: RecyclerView
    private lateinit var charSheetList: MutableList<CharSheet>

    lateinit var charSheetAdapter: CharSheetAdapter
    lateinit var inventoryAdapter: InventoryAdapter
    lateinit var materialAdapter: MaterialAdapter

    lateinit var db: DatabaseReference
    lateinit var createNewCharacterButton: Button
    lateinit var currentChar: CharSheet
    lateinit var listType: String
    lateinit var alertAction: AlertAction
    var currentCharPos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        db = Firebase.database.reference

        charSheetList = mutableListOf<CharSheet>()
        charSheetAdapter = CharSheetAdapter(charSheetList)
    }

    fun getCharList(): MutableList<CharSheet> {
        return charSheetList
    }

    fun popCharList() {
        charList = findViewById(R.id.Character_List_RecyclerView)
        charList?.layoutManager = LinearLayoutManager(this)
        charList?.adapter = charSheetAdapter
    }

    fun popInventoryList() {
        var currentCharIndex = charSheetList.indexOf(currentChar)

        when(listType) {
            "weapon" -> {
                inventoryAdapter = InventoryAdapter(selectWeaponList(charSheetList[currentCharIndex]))
            }
            "helm" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[currentCharIndex].helmList)
            }
            "chest" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[currentCharIndex].chestList)
            }
            "legs" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[currentCharIndex].legsList)
            }
        }

        inventoryList = findViewById(R.id.Inventory_List_RecyclerView)
        inventoryList?.layoutManager = LinearLayoutManager(this)
        inventoryList?.adapter = inventoryAdapter

    }

    fun selectWeaponList(charSheet: CharSheet): MutableMap<String, Boolean>{
        when(charSheet.weaponType) {
            "Bow" -> return charSheet.bowList
            "Charge Blade" -> return charSheet.chargeBladeList
            "Dual Blades" -> return charSheet.dualBladeList
            "Great Sword" -> return charSheet.greatSwordList
            "Gunlance" -> return charSheet.gunlanceList
            "Hammer" -> return charSheet.hammerList
            "Heavy Bow Gun" -> return charSheet.heavyBowGunList
            "Hunting Horn" -> return charSheet.huntingHornList
            "Insect Glaive" -> return charSheet.insectGlaiveList
            "Lance" -> return charSheet.lanceList
            "Light Bow Gun" -> return charSheet.lightBowGunList
            "Long Sword" -> return charSheet.longSwordList
            "Switch Axe" -> return charSheet.switchAxeList
            "Sword & Shield" -> return charSheet.swordShieldList
            else -> return charSheet.bowList
        }
    }

    fun popMaterialList() {
        var currentCharIndex = charSheetList.indexOf(currentChar)

        when(listType) {
            "materials" -> {
                materialAdapter = MaterialAdapter(charSheetList[currentCharIndex].materialsList)
            }
            "monsters" -> {
                materialAdapter = MaterialAdapter(charSheetList[currentCharIndex].monsterPartsList)
            }
            "quests" -> {
                materialAdapter = MaterialAdapter(charSheetList[currentCharIndex].questList)
            }
        }

        materialsList = findViewById(R.id.Material_List_RecyclerView)
        materialsList?.layoutManager = LinearLayoutManager(this)
        materialsList?.adapter = materialAdapter
    }

    fun addCharSheet(charSheet: CharSheet) {
        db
            .child("CharSheets")
            .child(charSheet.id)
            .setValue(charSheet)
    }

    fun updateTask(charSheet: CharSheet?) {
        db
            .child("CharSheets")
            .child(charSheet?.id.toString())
            .setValue(charSheet)
    }
/*
    fun onCheckboxClicked(view: View) {
        var itemNameTextView = findViewById<TextView>(R.id.item_Name_TextView)
        var checkbox = findViewById<CheckBox>(R.id.In_Inventory_CheckBox)
        when(listType) {
            "weapon" -> {
                when(currentChar.weaponType) {
                    "Bow" -> {
                        for (item in currentChar.bowList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Charge Blade" -> {
                        for (item in currentChar.chargeBladeList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Dual Blades" -> {
                        for (item in currentChar.dualBladeList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Great Sword" -> {
                        for (item in currentChar.greatSwordList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Gunlance" -> {
                        for (item in currentChar.gunlanceList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Hammer" -> {
                        for (item in currentChar.hammerList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Heavy Bow Gun" -> {
                        for (item in currentChar.heavyBowGunList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Hunting Horn" -> {
                        for (item in currentChar.huntingHornList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Insect Glaive" -> {
                        for (item in currentChar.insectGlaiveList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Lance" -> {
                        for (item in currentChar.lanceList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Light Bow Gun" -> {
                        for (item in currentChar.lightBowGunList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Long Sword" -> {
                        for (item in currentChar.longSwordList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Switch Axe" -> {
                        for (item in currentChar.switchAxeList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    "Sword & Shield" -> {
                        for (item in currentChar.swordShieldList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                    else -> {
                        for (item in currentChar.bowList) {
                            if(item.key == itemNameTextView.text) {
                                item.equals(checkbox.isChecked)
                            }
                        }
                    }
                }
            }
            "helm" -> {
                for (item in currentChar.helmList) {
                    if(item.key == itemNameTextView.text) {
                        item.equals(checkbox.isChecked)
                    }
                }
            }
            "chest" -> {
                for (item in currentChar.chestList) {
                    if(item.key == itemNameTextView.text) {
                        item.equals(checkbox.isChecked)
                    }
                }
            }
            "legs" -> {
                for (item in currentChar.legsList) {
                    if(item.key == itemNameTextView.text) {
                        item.equals(checkbox.isChecked)
                    }
                }
            }
        }
    }
*/
    fun createCharEventListener(dbReference: DatabaseReference) {
        val charListListener = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                charSheetList.clear()
                val charSheetDB = dataSnapshot.child("CharSheets").children

                for(charSheet in charSheetDB) {
                    var newCharSheet = charSheet.getValue(CharSheet::class.java)

                    if(charSheet != null) {
                        charSheetList.add(newCharSheet!!)
                        charSheetAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("CharSheetError", "CharSheetLoad: Cancelled", databaseError.toException())
            }
        }

        dbReference.addValueEventListener(charListListener)
    }
}