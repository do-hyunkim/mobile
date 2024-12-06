package com.example.teamproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teamproject.databinding.FragmentProfInfoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class profInfo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentProfInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = "김태호"
        var degree = "공학박사"
        var univ = "KAIST"
        var field = "딥러닝"
        var email = "taeho99@hufs.ac.kr"
        var webSite = "www.kth.com"
        var lab = "공학관 101호"

        binding.professorNameTextView.text = getString(R.string.prof_name, name)
        binding.professorDegreeTextView.text = getString(R.string.prof_degree, degree)
        binding.professorUnivTextView.text = getString(R.string.prof_university, univ)
        binding.professorFieldTextView.text = getString(R.string.prof_field, field)
        binding.professorEmailTextView.text = getString(R.string.prof_email, email)
        binding.professorWebsiteTextView.text = getString(R.string.prof_website, webSite)
        binding.professorLabTextView.text = getString(R.string.prof_lab, lab)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment profInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}