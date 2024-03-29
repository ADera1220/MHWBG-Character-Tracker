package ca.adera1220.mhwbgcharactertracker

import android.util.Log
import com.google.firebase.database.Exclude



data class CharSheet(
    val id: String = "",
    val playerName: String = "",
    val characterName: String = "",
    val campaignName: String = "",
    val palicoName: String = "",
    val weaponType: String = "",
    var potionCount: Int = 0,
    var dayCount: Int = 0,
    val bowList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Hunter\'s Bow" to false,
        "2 Hunter\'s Stoutbow" to false,
        "2 Steel Bow" to false,
        "3 Alloy Bow" to false,
        "3 Blazing Bow" to false,
        "3 Blooming Arch" to false,
        "3 Diablos Bow" to false,
        "3 Hunter\'s Proudbow" to false,
        "3 Kulu Arrow" to false,
        "3 Pulsar Bow" to false,
        "4 Anja Arch" to false,
        "4 Archer\'s Dance" to false,
        "4 Datura String" to false,
        "4 Diablos Coilbender" to false,
        "4 Flying Kadachi Strike" to false,
        "4 Icesteel Bow" to false,
        "4 Nergal Whisper" to false,
        "5 Daora\'s Sagittarii" to false,
        "5 Doom\'s Shaft" to false
    ),
    val chargeBladeList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Strongarm" to false,
        "2 Hard Bone Strongarm" to false,
        "2 Elite Commission Axe" to false,
        "3 Chrome Guardian" to false,
        "3 Diablos Wall" to false,
        "3 Jagras Strongarm" to false,
        "3 Mighty Strongarm" to false,
        "3 Mudslide Blade" to false,
        "3 Pulsar Strongarm" to false,
        "4 Daora\'s Casca" to false,
        "4 Diablos Tyrannis" to false,
        "4 Jagras Escudo" to false,
        "4 Jyura Depth" to false,
        "4 Kadachi Kaina" to false,
        "4 Nergal Lacerator" to false,
        "5 Daora\'s Thwartoise" to false,
        "5 Devistation\'s Thorns" to false
    ),
    val dualBladeList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Hatchets" to false,
        "2 Dual Slicers" to false,
        "2 Wild Hatchets" to false,
        "3 Blazing Hatchets" to false,
        "3 Chrome Slicers" to false,
        "3 Diablos Hatchets" to false,
        "3 Madness Pangas" to false,
        "3 Pulsar Hatchets" to false,
        "3 Rending Beaks" to false,
        "3 Strong Hatchets" to false,
        "4 Anja Cyclone" to false,
        "4 Arcanaria" to false,
        "4 Diablos Clubs" to false,
        "4 Jyura Hatchets" to false,
        "4 Kadachi Claws" to false,
        "4 Nergal Gouge" to false,
        "4 Twin Nails" to false,
        "5 Decimation Claws" to false,
        "5 Fire and Ice" to false
    ),
    val greatSwordList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Blade" to false,
        "2 Bone Slasher" to false,
        "2 Buster Blade" to false,
        "3 Blooming Blade" to false,
        "3 Carapace Buster" to false,
        "3 Chrome Razor" to false,
        "3 Flame Blade" to false,
        "3 Giant Jawblade" to false,
        "3 Jagras Blade" to false,
        "4 Barroth Shredder" to false,
        "4 Datura Blaze" to false,
        "4 Icesteel Edge" to false,
        "4 Jagras Hacker" to false,
        "4 Nergal Judicator" to false,
        "4 Red Wing" to false,
        "5 Daora\'s Decimator" to false,
        "5 Pergation\'s Atrocity" to false
    ),
    val gunlanceList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Gunlance" to false,
        "2 Bone Cannon" to false,
        "2 Steel Gunlance" to false,
        "3 Carapace Cannon" to false,
        "3 Chrome Gunlance" to false,
        "3 Great Bone Gunlance" to false,
        "3 Jagras Gunlance" to false,
        "3 Madness Gunlance" to false,
        "3 Rath Gunlance" to false,
        "3 Barroth Blaster" to false,
        "4 Glutton Gunlance" to false,
        "4 Icesteel Gunlance" to false,
        "4 Jyura Buster" to false,
        "4 Nergal Ram" to false,
        "4 Red Rook" to false,
        "5 Daora\'s Brigia" to false,
        "5 Eradication Flame" to false
    ),
    val hammerList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Bludgeon" to false,
        "2 Fossil Bludgeon" to false,
        "2 Iron Demon" to false,
        "3 Blazing Hammer" to false,
        "3 Blooming Hammer" to false,
        "3 Carapace Sledge" to false,
        "3 Diablos Sledge" to false,
        "3 Grand Rock" to false,
        "3 Iron Arch Demon" to false,
        "3 Kulu Beak" to false,
        "4 Anja Striker" to false,
        "4 Barroth Breaker" to false,
        "4 Buon Fiore" to false,
        "4 Crushing Beak" to false,
        "4 Diablos Shatterer" to false,
        "4 Icesteel Hammer" to false,
        "4 Nergal Crusher" to false,
        "5 Daora\'s Colossus" to false,
        "5 Obliteration\'s Footfall" to false
    ),
    val heavyBowGunList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Shooter" to false,
        "2 Heavy Shooter" to false,
        "2 Steel Assault" to false,
        "3 Blooming Shooter" to false,
        "3 Chrome Assault" to false,
        "3 Diablos Shooter" to false,
        "3 Jagras Assault" to false,
        "3 Power Shooter" to false,
        "3 Pulsar Shooter" to false,
        "4 Datura Blaster" to false,
        "4 Dual Threat" to false,
        "4 Jagras Cannon" to false,
        "4 Kadachi Lion" to false,
        "4 Nergal Roar" to false,
        "4 Teostra\'s Artillery" to false,
        "5 Destruction\'s Fusillade" to false,
        "5 Teostra\'s Flames" to false
    ),
    val huntingHornList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Horn" to false,
        "2 Great Bagpipe" to false,
        "2 Hard Bone Horn" to false,
        "3 Aqua Bagpipe" to false,
        "3 Blazing Horn" to false,
        "3 Blooming Horn" to false,
        "3 Fortissimo" to false,
        "3 Heavy Bone Horn" to false,
        "3 Thunder Gaida" to false,
        "4 Anja Barone" to false,
        "4 Datura Horn" to false,
        "4 Lightning Drum" to false,
        "4 Water Tamtam" to false,
        "4 Nergal Groove" to false,
        "4 Teostra\'s Tiple" to false,
        "5 Desolation\'s Overture" to false,
        "5 Teostra\'s Orphee" to false
    ),
    val insectGlaiveList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Rod" to false,
        "2 Hard Bone Rod" to false,
        "2 Steel Blade" to false,
        "3 Aerial Magus" to false,
        "3 Blooming Glaive" to false,
        "3 Chrome Blade" to false,
        "3 Diablos Rod" to false,
        "3 Flame Glaive" to false,
        "3 Flammenkafer" to false,
        "3 Kulu Blade" to false,
        "4 Daora\'s Entom" to false,
        "4 Datura Blade" to false,
        "4 Gnashing Flamm" to false,
        "4 Nergal Reaper" to false,
        "4 Rathmaul" to false,
        "4 Tyrannis Glaive" to false,
        "4 Ya-Ku Wrath" to false,
        "5 Catastrophe\'s Light" to false,
        "5 Daora\'s Tethidine" to false
    ),
    val lanceList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Lance" to false,
        "2 Hard Bone Lance" to false,
        "2 Steel Lance" to false,
        "3 Aqua Horn" to false,
        "3 Carapace Lance" to false,
        "3 Chrome Lance" to false,
        "3 Flame Lance" to false,
        "3 Heavy Bone Lance" to false,
        "3 Kulu Duda" to false,
        "3 Thunder Lance" to false,
        "4 Barroth Stinger" to false,
        "4 Dancing Duval" to false,
        "4 Icesteel Spear" to false,
        "4 Lightning Spire" to false,
        "4 Nergal Impaler" to false,
        "4 Red Tail" to false,
        "4 Water Spike" to false,
        "5 Daora\'s Fang" to false,
        "5 Perdition\'s Hand" to false
    ),
    val lightBowGunList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Hunter\'s Rifle" to false,
        "2 Hight Chain Blitz" to false,
        "2 Power Rifle" to false,
        "3 Carapace Rifle" to false,
        "3 Cross Blitz" to false,
        "3 Flame Blitz" to false,
        "3 Jagras Blitz" to false,
        "3 Madness Rifle" to false,
        "3 Sniper Shot" to false,
        "4 Barroth Shot" to false,
        "4 Icesteel Wasp" to false,
        "4 Jagras Fire" to false,
        "4 Jyura Bullet" to false,
        "4 Nergal Spitter" to false,
        "4 Rathbuster" to false,
        "5 Cataclysm\'s Trigger" to false,
        "5 Daora\'s Hornet" to false
    ),
    val longSwordList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Shotel" to false,
        "2 Hard Bone Shotel" to false,
        "2 Iron Grace" to false,
        "3 Blazing Shotel" to false,
        "3 Bone Reaper" to false,
        "3 First Dance" to false,
        "3 Iron Gospel" to false,
        "3 Jyura Shotel" to false,
        "3 Pulsar Shotel" to false,
        "3 Wyvern Blade \"Fall\"" to false,
        "4 Anja Scimitar" to false,
        "4 Dipterus" to false,
        "4 Imperial Saber" to false,
        "4 Kadachi Fang" to false,
        "4 Last Dance" to false,
        "4 Nergal Reaver" to false,
        "4 Wyvern Blade \"Blood\"" to false,
        "5 Extermination\'s Edge" to false,
        "5 Imperial Shimmer" to false
    ),
    val switchAxeList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Axe" to false,
        "2 Bone Smasher" to false,
        "2 Improved Steel Axe" to false,
        "3 Carapace Axe" to false,
        "3 Diablos Axe" to false,
        "3 Flammenbeil" to false,
        "3 Perfected Alloy Axe" to false,
        "3 Power Smasher" to false,
        "3 Rathalos Axe" to false,
        "4 Axe Semper Tyrannis" to false,
        "4 Barroth Grinder" to false,
        "4 Gnashing Flammenbeil" to false,
        "4 Nergal Gash" to false,
        "4 Rathbringer Axe" to false,
        "4 Teostra\'s Arx" to false,
        "5 Dying Light" to false,
        "5 Teostra\'s Castle" to false
    ),
    val swordShieldList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "1 Bone Kukri" to false,
        "2 Chief Kukri" to false,
        "2 Steel Knife" to false,
        "3 Blooming Knife" to false,
        "3 Carapace Edge" to false,
        "3 Chrome Slicer" to false,
        "3 Flame Knife" to false,
        "3 Grand Barong" to false,
        "3 Jagras Edge" to false,
        "4 Barroth Club" to false,
        "4 Datura Blossom" to false,
        "4 Heat Edge" to false,
        "4 Jagras Garrotte" to false,
        "4 Nergal Jack" to false,
        "4 Teostra\'s Spada" to false,
        "5 Eradication Vanguard" to false,
        "5 Teostra\'s Emblem" to false
    ),
    val helmList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "Alloy Helm" to false,
        "Bone Helm" to false,
        "Anja Helm" to false,
        "Barroth Helm" to false,
        "Jagras Helm" to false,
        "Jyura Helm" to false,
        "Kadachi Helm" to false,
        "Kulu Headpiece" to false,
        "Pukei Hood" to false,
        "Diablos Helm" to false,
        "Diablos Nero Helm" to false,
        "Rathalos Helm" to false,
        "Rath Soul Helm" to false,
        "Kushala Glare" to false,
        "Nergigante Helm" to false,
        "Kaiser Crown" to false
    ),
    val chestList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "Alloy Mail" to false,
        "Bone Mail" to false,
        "Anja Mail" to false,
        "Barroth Mail" to false,
        "Jagras Mail" to false,
        "Jyura Mail" to false,
        "Kadachi Mail" to false,
        "Kulu Mail" to false,
        "Pukei Mail" to false,
        "Diablos Mail" to false,
        "Diablos Nero Mail" to false,
        "Rathalos Mail" to false,
        "Rath Soul Mail" to false,
        "Kushala Cista" to false,
        "Nergigante Mail" to false,
        "Kaiser Mail" to false
    ),
    val legsList: MutableMap<String, Boolean> = mutableMapOf<String, Boolean>(
        "Alloy Greaves" to false,
        "Bone Greaves" to false,
        "Anja Greaves" to false,
        "Barroth Greaves" to false,
        "Jagras Greaves" to false,
        "Jyura Greaves" to false,
        "Kadachi Greaves" to false,
        "Kulu Greaves" to false,
        "Pukei Greaves" to false,
        "Diablos Greaves" to false,
        "Diablos Nero Greaves" to false,
        "Rathalos Greaves" to false,
        "Rath Soul Greaves" to false,
        "Kushala Crus" to false,
        "Nergigante Greaves" to false,
        "Kaiser Greaves" to false
    ),
    val materialsList: MutableMap<String, Int> = mutableMapOf<String, Int>(
        "Anjanath Fang" to 0,
        "Anjanath Nosebone" to 0,
        "Anjanath Pelt" to 0,
        "Anjanath Scale" to 0,
        "Anjanath Tail" to 0,
        "Azure Rath Carapace" to 0,
        "Azure Rath Marrow" to 0,
        "Azure Rath Plate" to 0,
        "Azure Rath Scale" to 0,
        "Azure Rath Tail" to 0,
        "Azure Rath Wing" to 0,
        "Azure Rath Wingtalon" to 0,
        "Barroth Carapace" to 0,
        "Barroth Claw" to 0,
        "Barroth Ridge" to 0,
        "Barroth Shell" to 0,
        "Black Diab Carapace" to 0,
        "Black Diab Ridge" to 0,
        "Daora Carapace" to 0,
        "Daora Claw" to 0,
        "Daora Dragon Scale" to 0,
        "Daora Gem" to 0,
        "Daora Horn" to 0,
        "Daora Tail" to 0,
        "Daora Webbing" to 0,
        "Diablos Carapace" to 0,
        "Diablos Fang" to 0,
        "Diablos Ridge" to 0,
        "Diablos Shell" to 0,
        "Great Jagras Claw" to 0,
        "Great Jagras Hide" to 0,
        "Great Jagras Mane" to 0,
        "Great Jagras Scale" to 0,
        "Jyuratodas Carapace" to 0,
        "Jyuratodas Fang" to 0,
        "Jyuratodas Fin" to 0,
        "Jyuratodas Scale" to 0,
        "Jyuratodas Shell" to 0,
        "Kadachi Claw" to 0,
        "Kadachi Electrode" to 0,
        "Kadachi Membrane" to 0,
        "Kadachi Pelt" to 0,
        "Kadachi Scale" to 0,
        "Kulu-Ya-Ku Beak" to 0,
        "Kulu-Ya-Ku Hide" to 0,
        "Kulu-Ya-Ku Plume" to 0,
        "Kulu-Ya-Ku Scale" to 0,
        "Nerg Carapace" to 0,
        "Nerg Gem" to 0,
        "Nerg Horn" to 0,
        "Nerg Regrowth Plate" to 0,
        "Nerg Tail" to 0,
        "Nerg Talon" to 0,
        "Pukei Carapace" to 0,
        "Pukei Quill" to 0,
        "Pukei Scale" to 0,
        "Pukei Sac" to 0,
        "Pukei Tail" to 0,
        "Pukei Wing" to 0,
        "Rathalos Carapace" to 0,
        "Rathalos Marrow" to 0,
        "Rathalos Medulla" to 0,
        "Rathalos Plate" to 0,
        "Rathalos Scale" to 0,
        "Rathalos Shell" to 0,
        "Rathalos Tail" to 0,
        "Rathalos Webbing" to 0,
        "Rathalos Wing" to 0,
        "Rathalos Wingtalon" to 0,
        "Teostra Carapace" to 0,
        "Teostra Claw" to 0,
        "Teostra Gem" to 0,
        "Teostra Horn" to 0,
        "Teostra Mane" to 0,
        "Teostra Powder" to 0,
        "Teostra Tail" to 0,
        "Teostra Webbing" to 0
    ),
    val monsterPartsList: MutableMap<String, Int> = mutableMapOf<String, Int>(
        "Ancient Bone" to 0,
        "Aqua Sac" to 0,
        "Bird Wyvern Gem" to 0,
        "Black Spiral Horn" to 0,
        "Blos Medulla" to 0,
        "Boulder Bone" to 0,
        "Carablite Ore" to 0,
        "Coral Crystal" to 0,
        "Dragonite Ore" to 0,
        "Dragonvein Crystal" to 0,
        "Earth Crystal" to 0,
        "Elder Dragon Blood" to 0,
        "Elder Dragon Bone" to 0,
        "Electrode" to 0,
        "Electro Sac" to 0,
        "Fertile Mud" to 0,
        "Firecell Stone" to 0,
        "Fire Dragon Scale" to 0,
        "Flame Sac" to 0,
        "Fucium Ore" to 0,
        "Gajau Scale" to 0,
        "Immortal Dragonscale" to 0,
        "Inferno Sac" to 0,
        "Majestic Horn" to 0,
        "Malachite Ore" to 0,
        "Monster Bone Large" to 0,
        "Monster Bone Medium" to 0,
        "Monster Bone Small" to 0,
        "Monster Hardbone" to 0,
        "Monster Keenbone" to 0,
        "Novacrystal" to 0,
        "Piercing Claw" to 0,
        "Poison Sac" to 0,
        "Quality Bone" to 0,
        "Sharp Claw" to 0,
        "Thunder Sac" to 0,
        "Toxin Sac" to 0,
        "Twisted Horn" to 0,
        "Warm Pelt" to 0,
        "Wingdrake Hide" to 0,
        "Wyvern Gem" to 0
    ),
    val questList: MutableMap<String, Int> = mutableMapOf<String, Int>(
        "Barroth*" to 0,
        "Barroth**" to 0,
        "Barroth***" to 0,
        "Great Jagras*" to 0,
        "Great Jagras**" to 0,
        "Great Jagras***" to 0,
        "Kulu-Ya-Ku*" to 0,
        "Kulu-Ya-Ku**" to 0,
        "Kulu-Ya-Ku***" to 0,
        "Pukei-Pukei*" to 0,
        "Pukei-Pukei**" to 0,
        "Pukei-Pukei***" to 0,
        "Tobi-Kadachi*" to 0,
        "Tobi-Kadachi**" to 0,
        "Tobi-Kadachi***" to 0,
        "Anjanath*" to 0,
        "Anjanath**" to 0,
        "Anjanath***" to 0,
        "Jyuratodus*" to 0,
        "Jyuratodus**" to 0,
        "Jyuratodus***" to 0,
        "Azure Rathalos*" to 0,
        "Azure Rathalos**" to 0,
        "Azure Rathalos****" to 0,
        "Black Diablos*" to 0,
        "Black Diablos**" to 0,
        "Black Diablos****" to 0,
        "Diablos*" to 0,
        "Diablos**" to 0,
        "Diablos****" to 0,
        "Rathalos*" to 0,
        "Rathalos**" to 0,
        "Rathalos****" to 0,
        "Kushala Daora*" to 0,
        "Kushala Daora**" to 0,
        "Kushala Daora*****" to 0,
        "Nergigante*" to 0,
        "Nergigante**" to 0,
        "Nergigante*****" to 0,
        "Teostra*" to 0,
        "Teostra**" to 0,
        "Teostra*****" to 0
    )
){
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
            "bowList" to bowList,
            "chargeBladeList" to chargeBladeList,
            "dualBladeList" to dualBladeList,
            "greatSwordList" to greatSwordList,
            "gunlanceList" to gunlanceList,
            "hammerList" to hammerList,
            "heavyBowGunList" to heavyBowGunList,
            "huntingHornList" to huntingHornList,
            "insectGlaiveList" to insectGlaiveList,
            "lanceList" to lanceList,
            "lightBowGunList" to lightBowGunList,
            "longSwordList" to longSwordList,
            "switchAxeList" to switchAxeList,
            "swordShieldList" to swordShieldList,
            "helmList" to helmList,
            "chestList" to chestList,
            "legsList" to legsList,
            "materialsList" to materialsList,
            "MonsterPartsList" to monsterPartsList,
            "QuestList" to questList
        )
    }
}

