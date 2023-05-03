package com.udemysample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.databinding.R
import com.example.databinding.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            //val bundle = bundleOf("userInput" to binding.editTextTextPersonName2.text.toString() )

            val studentInfo = StudentInfo("Sandra Skaria", "Azhakattil", 100292939)

            val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment(studentInfo).setName(binding.editTextTextPersonName2.text.toString())
//            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            it.findNavController().navigate(action)
        }
        return binding.root
    }

}