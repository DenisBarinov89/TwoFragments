package com.example.twofragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val toSecondFragmentButton: Button by lazy { requireActivity().findViewById(R.id.btnToSecondFragment) }
    private val userName: EditText by lazy { requireActivity().findViewById(R.id.etName) }
    private val userSecondName: EditText by lazy { requireActivity().findViewById(R.id.etSecondName) }
    private val userMail: EditText by lazy { requireActivity().findViewById(R.id.etMail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toSecondFragmentButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY_NAME, userName.editableText.toString())
            bundle.putString(BUNDLE_KEY_SECOND_NAME, userSecondName.editableText.toString())
            bundle.putString(BUNDLE_KEY_MAIL, userMail.editableText.toString())
            parentFragmentManager.beginTransaction().replace(R.id.container, SecondFragment.getNewInstance(bundle)).commit()
        }
    }
}