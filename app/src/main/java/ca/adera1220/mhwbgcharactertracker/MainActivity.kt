package ca.adera1220.mhwbgcharactertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    private lateinit var charList: RecyclerView
    private lateinit var inventoryList: RecyclerView
    private lateinit var materialsList: RecyclerView

    private lateinit var charSheetList: MutableList<CharSheet>

    lateinit var charSheetAdapter: CharSheetAdapter
    lateinit var inventoryAdapter: InventoryAdapter
    lateinit var materialAdapter: MaterialAdapter

    lateinit var createNewCharacterButton: Button
    lateinit var currentChar: CharSheet
    lateinit var listType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        charSheetList = mutableListOf<CharSheet>(
            CharSheet("1", "Adam", "Phoenix", "JAM-01", "Simba","Bow"),
            CharSheet("2", "Myke", "MYKE", "JAM-01", "Paws","Great Sword"),
            CharSheet("3", "Jenna", "Yumiko", "JAM-01", "Meowster","Hunting Horn"),
            CharSheet("4", "Will", "Dark", "JAM-01", "Shasta","Dual Blades"),
            CharSheet("5", "Chris", "Chrystalizer", "JAM-01", "Luna","LongSword")
        )
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
        when(listType) {
            "weapon" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[0].weaponList, charSheetList[0].weaponType)
            }
            "helm" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[0].helmList, null)
            }
            "chest" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[0].chestList, null)
            }
            "legs" -> {
                inventoryAdapter = InventoryAdapter(charSheetList[0].legsList, null)
            }
        }

        inventoryList = findViewById(R.id.Inventory_List_RecyclerView)
        inventoryList?.layoutManager = LinearLayoutManager(this)
        inventoryList?.adapter = inventoryAdapter

    }

    fun popMaterialList() {
        when(listType) {
            "materials" -> {
                materialAdapter = MaterialAdapter(charSheetList[0].materialsList)
            }
            "monsters" -> {
                materialAdapter = MaterialAdapter(charSheetList[0].monsterPartsList)
            }
            "quests" -> {
                materialAdapter = MaterialAdapter(charSheetList[0].questList)
            }
        }

        materialsList = findViewById(R.id.Material_List_RecyclerView)
        materialsList?.layoutManager = LinearLayoutManager(this)
        materialsList?.adapter = materialAdapter
    }
}