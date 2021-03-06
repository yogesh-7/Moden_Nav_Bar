package com.dev_yogesh.modernNavbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class UserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    companion object {
       @JvmStatic
        fun newInstance() =
            UserFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}