package com.example.memefy.ui.meme

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.memefy.MainActivity
import com.example.memefy.Model.Getmemes.MySharedPref
import com.example.memefy.R
import com.example.memefy.databinding.FragmentMemeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemeFragment : Fragment(R.layout.fragment_meme) {
    private var _binding: FragmentMemeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MemeViewModel by viewModels()
    var smIg = mutableListOf<String>()
    var i: String = ""
    var j: String = ""
    var num1 = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMemeBinding.bind(view)
        var pref = MySharedPref(requireContext())
        viewModel.memes.observe(viewLifecycleOwner) { meme ->

            binding.subreddit.text = meme.title
            binding.memeimg.load(meme.url)

            binding.btAdd.setOnClickListener {

                j = meme.url.toString()
                i = meme.title.toString()

                num1 = num1 + 1
                pref.save(num1.toString())
                var MA = activity as MainActivity
                MA.n()
                Log.d("sss", pref.getnum().toString())
            }
            binding.btSkip.setOnClickListener {
                viewModel.loadPostsFromApi()
                binding.subreddit.text = meme.title
                binding.memeimg.load(meme.url)

            }
//            binding.btFav.setOnClickListener {
//                pref.saveUsername(i)
//                pref.saveUrl(j)
//                val action = MemeFragmentDirections.actionMemeFragmentToQueryFragment()
//            findNavController().navigate(action)
//            }
//        }
            Log.d("photo", pref.geturl().toString())

        }
    }




        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    }
