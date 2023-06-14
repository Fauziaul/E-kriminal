package org.d3if0097.pt2.ui.lapor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0097.pt2.databinding.FragmentAspirasiBinding
import org.d3if0097.pt2.databinding.FragmentLaporBinding

class LaporFragment : Fragment() {
    private lateinit var binding : FragmentLaporBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaporBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
}