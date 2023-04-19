package ca.adera1220.mhwbgcharactertracker

import com.google.firebase.database.Exclude


data class CharSheet(
    val id: String = "",
    val playerName: String = "",
    val characterName: String = "",
    val campaignName: String = "",
    val palicoName: String = "",
    val weaponType: String = "",
    val potionCount: String = "0",
    val dayCount: String = "0",
    val weaponList: Map<String, Boolean> = mapOf<String, Boolean>(
        "" to false
    ),
    val helmList: Map<String, Boolean> = mapOf<String, Boolean>(
        "" to false
    ),
    val chestList: Map<String, Boolean> = mapOf<String, Boolean>(
        "" to false
    ),
    val legsList: Map<String, Boolean> = mapOf<String, Boolean>(
        "" to false
    ),
    val materialsList: Map<String, Int> = mapOf<String, Int>(
        "" to 0
    ),
    val MonsterPartsList: Map<String, Int> = mapOf<String, Int>(
        "" to 0
    ),
    val QuestList: Map<String, Int> = mapOf<String, Int>(
        "" to 0
    )
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "playerName" to playerName,
            "characterName" to characterName,
            "campaignName" to campaignName,
            "palicoName" to palicoName,
            "weaponType" to weaponType,
            "potionCount" to potionCount,
            "dayCount" to dayCount,
            "weaponList" to weaponList,
            "helmList" to helmList,
            "chestList" to chestList,
            "legsList" to legsList,
            "materialsList" to materialsList,
            "MonsterPartsList" to MonsterPartsList,
            "QuestList" to QuestList
        )
    }
}

