package com.example.twofragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val clearDataButton: Button by lazy { requireActivity().findViewById(R.id.btnClearData) }
    private val userNameFromFirstFragment: TextView by lazy { requireActivity().findViewById(R.id.tvName) }
    private val userSecondNameFromFirstFragment: TextView by lazy { requireActivity().findViewById(R.id.tvSecondName) }
    private val userMailFromFirstFragment: TextView by lazy { requireActivity().findViewById(R.id.tvMail) }

    companion object {
        fun getNewInstance(args: Bundle?) : SecondFragment {
            val secondFragment = SecondFragment()
            secondFragment.arguments = args
            return secondFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userNameFromFirstFragment.text = getDataFromBundle(BUNDLE_KEY_NAME)
        userSecondNameFromFirstFragment.text = getDataFromBundle(BUNDLE_KEY_SECOND_NAME)
        userMailFromFirstFragment.text = getDataFromBundle(BUNDLE_KEY_MAIL)

        clearDataButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
        }
    }

    private fun getDataFromBundle(key: String) : String? {
        return this.arguments?.getString(key)
    }
}