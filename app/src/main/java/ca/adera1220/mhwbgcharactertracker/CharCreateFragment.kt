package ca.adera1220.mhwbgcharactertracker

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class CharCreateFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
        ): View? {

        return inflater.inflate(R.layout.char_create_fragment, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var saveButton: View? = getView()?.findViewById(R.id.Char_Save_Button)
        saveButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharSheetFragment>(R.id.Fragment_Container)
                }
        }
        var exitButton: View? = getView()?.findViewById(R.id.Exit_Button)
        exitButton?.setOnClickListener {
            (activity as MainActivity)
                .supportFragmentManager
                .commit {
                    replace<CharListFragment>(R.id.Fragment_Container)
                }
        }

    }
}

