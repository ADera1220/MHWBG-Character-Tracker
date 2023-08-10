package ca.adera1220.mhwbgcharactertracker

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class CharListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {

        return inflater.inflate(R.layout.char_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).popCharList()
        (activity as MainActivity).createCharEventListener((activity as MainActivity).db)

        (activity as MainActivity).charSheetAdapter.onCharSheetClick = { charSheet, position ->
            (activity as MainActivity).alertAction = AlertAction.UPDATE
            (activity as MainActivity).currentChar = charSheet
            (activity as MainActivity).currentCharPos = position

            (activity as MainActivity).supportFragmentManager
                .commit {
                    replace<CharSheetFragment>(R.id.Fragment_Container)
                }
        }

        var createNewCharacterButton: View? = getView()?.findViewById(R.id.Character_Create_Button)
        createNewCharacterButton?.setOnClickListener {
            (activity as MainActivity).alertAction = AlertAction.ADD
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharCreateFragment>(R.id.Fragment_Container)
                }
        }
    }
}