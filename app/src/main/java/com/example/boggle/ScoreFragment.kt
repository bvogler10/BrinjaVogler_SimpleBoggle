package com.example.boggle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.boggle.databinding.FragmentScoreBinding


class ScoreFragment: Fragment() {
    interface ScoreFragmentListener{
        fun newGameClicked()
    }
    private var listener: ScoreFragmentListener? = null

    private var _binding: FragmentScoreBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScoreBinding.inflate(inflater, container, false)
        binding.newGame.setOnClickListener {
            binding.score.text = "0"
            listener?.newGameClicked()
        }
        return binding.root
    }

    fun letterScore(word: CharSequence) {
        Log.d("FRAGMENT_COMM", "submit clicked")
        binding.score.text = "1000"
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ScoreFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement NewGameListener")
        }
        Log.d("FragmentLifecycle", "ScoreFragment attached")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentLifecycle", "ScoreFragment detached")
    }
}