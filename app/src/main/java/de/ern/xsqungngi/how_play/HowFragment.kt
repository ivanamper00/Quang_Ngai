package de.ern.xsqungngi.how_play

import de.ern.xsqungngi.R
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.FragmentHowBinding

class HowFragment: BaseFragment<FragmentHowBinding>(R.layout.fragment_how) {

    override val binding: FragmentHowBinding by viewBinding(FragmentHowBinding::bind)

    override fun setupViews() {

    }

    override fun viewModelObservers() {
    }

    override val TAG: String = "How to play"
}