package ca.adera1220.mhwbgcharactertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var charList: RecyclerView
    private lateinit var charSheetList: MutableList<CharSheet>
    lateinit var charSheetAdapter: CharSheetAdapter
    lateinit var createNewCharacterButton: Button
    lateinit var currentChar: CharSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    fun popWeaponsList() {

    }

    fun popHelmList() {

    }

    fun popChestList() {

    }

    fun popLegsList() {

    }

    fun popMaterialsList() {

    }

    fun popMonsterPartsList() {

    }

    fun popQuestList() {

    }
}