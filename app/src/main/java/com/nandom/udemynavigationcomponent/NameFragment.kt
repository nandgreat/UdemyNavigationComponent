package com.nandom.udemynavigationcomponent


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.nandom.udemynavigationcomponent.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.nextButton.setOnClickListener {
            if(TextUtils.isEmpty(binding.nameEditText.text.toString())){
                Toast.makeText(context, "Please Enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val bundle = bundleOf("name" to binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment2_to_emailFragment, bundle)
            }
        }

        return binding.root
    }
}
