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
import com.nandom.udemynavigationcomponent.databinding.FragmentEmailBinding
import com.nandom.udemynavigationcomponent.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        val name = requireArguments().getString("name")

        binding.submitButton.setOnClickListener {
            if(TextUtils.isEmpty(binding.emailEditText.text.toString())){
                Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
            }else{
                val bundle = bundleOf("name" to name, "email" to binding.emailEditText.text.toString())
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            }
        }

        return binding.root
    }
}
