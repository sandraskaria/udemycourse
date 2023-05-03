package com.udemysample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.databinding.R
import com.example.databinding.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second, container, false )
        //binding.textView2.text = arguments?.getString("userInput")

        // Received using safe args
        val bundle = requireArguments()
        val args = SecondFragmentArgs.fromBundle(bundle)
        val details = "FUll Name: ${args.studentInfo.fullName} \n Address: ${args.studentInfo.address} \n Phone: ${args.studentInfo.phone}"
        binding.studentDetails.text = details

        binding.textView2.text = args.name


        return binding.root
    }

}