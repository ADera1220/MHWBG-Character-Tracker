package ca.adera1220.mhwbgcharactertracker

data class CharSheet(
    val id: String = "",
    val playerName: String = "",
    val characterName: String = "",
    val campaignName: String = "",
    val palicoName: String = "",
    val weaponType: String = "",
    val potionCount: String = "0",
    val dayCount: String = "0",
    val weaponList: Map<String, Boolean> = mapOf(

    ),
    val helmList: Map<String, Boolean> = mapOf(

    ),
    val chestList: Map<String, Boolean> = mapOf(

    ),
    val legsList: Map<String, Boolean> = mapOf(

    ),
    val materialsList: Map<String, Int> = mapOf(

    ),
    val MonsterPartsList: Map<String, Int> = mapOf(

    ),
    val QuestList: Map<String, Boolean> = mapOf(

    ),
)
