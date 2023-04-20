package ca.adera1220.mhwbgcharactertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    private lateinit var charList: RecyclerView
    private lateinit var weaponList: RecyclerView
    private lateinit var helmList: RecyclerView
    private lateinit var chestList: RecyclerView
    private lateinit var legsList: RecyclerView
    private lateinit var materialsList: RecyclerView
    private lateinit var monsterPartsList: RecyclerView
    private lateinit var questList: RecyclerView

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

    fun popWeaponsList() {
        inventoryAdapter = InventoryAdapter(charSheetList[0].weaponList, charSheetList[0].weaponType)

        weaponList = findViewById(R.id.Inventory_List_RecyclerView)
        weaponList?.layoutManager = LinearLayoutManager(this)
        weaponList?.adapter = inventoryAdapter
    }

    fun popHelmList() {
        inventoryAdapter = InventoryAdapter(charSheetList[0].helmList, null)
        Log.i("CharSheet", "popHelmList called")

        helmList = findViewById(R.id.Inventory_List_RecyclerView)
        helmList?.layoutManager = LinearLayoutManager(this)
        helmList?.adapter = inventoryAdapter
    }

    fun popChestList() {
        inventoryAdapter = InventoryAdapter(charSheetList[0].chestList, null)
        Log.i("CharSheet", "popChestList called")

        chestList = findViewById(R.id.Inventory_List_RecyclerView)
        chestList?.layoutManager = LinearLayoutManager(this)
        chestList?.adapter = inventoryAdapter
    }

    fun popLegsList() {
        inventoryAdapter = InventoryAdapter(charSheetList[0].legsList, null)
        Log.i("CharSheet", "popLegsList called")

        legsList = findViewById(R.id.Inventory_List_RecyclerView)
        legsList?.layoutManager = LinearLayoutManager(this)
        legsList?.adapter = inventoryAdapter
    }

    fun popMaterialsList() {
        materialAdapter = MaterialAdapter(charSheetList[0].materialsList)
        Log.i("CharSheet", "popMaterialsList called")

        materialsList = findViewById(R.id.Material_List_RecyclerView)
        materialsList?.layoutManager = LinearLayoutManager(this)
        materialsList?.adapter = materialAdapter
    }

    fun popMonsterPartsList() {
        materialAdapter = MaterialAdapter(charSheetList[0].monsterPartsList)
        Log.i("CharSheet", "popMonsterPartsList called")

        monsterPartsList = findViewById(R.id.Material_List_RecyclerView)
        monsterPartsList?.layoutManager = LinearLayoutManager(this)
        monsterPartsList?.adapter = materialAdapter
    }

    fun popQuestList() {
        materialAdapter = MaterialAdapter(charSheetList[0].questList)
        Log.i("CharSheet", "popQuestList called")

        questList = findViewById(R.id.Material_List_RecyclerView)
        questList?.layoutManager = LinearLayoutManager(this)
        questList?.adapter = materialAdapter
    }
}