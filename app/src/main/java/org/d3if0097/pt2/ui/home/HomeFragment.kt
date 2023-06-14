package org.d3if0097.pt2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3if0097.pt2.LoginActivity
import org.d3if0097.pt2.R
import org.d3if0097.pt2.RegisterActivity
import org.d3if0097.pt2.databinding.FragmentAspirasiBinding
import org.d3if0097.pt2.databinding.FragmentHomeBinding
import org.d3if0097.pt2.databinding.FragmentLaporBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvLabelName
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLapor.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_navigation_home_to_laporFragment
            )
        }
        binding.btnAspirasi.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_navigation_home_to_aspirasiFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        fun newInstance() = HomeFragment()
    }
}