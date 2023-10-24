package com.github.vinizaan.fastcalculation

//é uma sub activity praticamente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.github.vinizaan.fastcalculation.Extras.EXTRA_SETTINGS
import com.github.vinizaan.fastcalculation.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding
    private lateinit var settings: Settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        settings = it.getParcelable(EXTRA_SETTINGS)?: Settings()

        }
        setHasOptionsMenu(true)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        "${getString(R.string.welcome)},${settings.playerName}!".also {
            fragmentWelcomeBinding.welcomeTv.text = it
        }
        fragmentWelcomeBinding.welcomeTv.text= "Welcome, ${settings.playerName}!"
        fragmentWelcomeBinding.playerBt.setOnClickListener{
            (context as OnPlayGame).onPlayGame()
        }
        return fragmentWelcomeBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(settings: Settings) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_SETTINGS, settings)

                }
            }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.restartGameMi).isVisible=false
    }
}