package org.d3if0097.pt2.ui.aspirasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0097.pt2.databinding.FragmentAspirasiBinding

class AspirasiFragment : Fragment() {
    private lateinit var binding : FragmentAspirasiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAspirasiBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
}