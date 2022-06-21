package de.ern.xsqungngi.about

import de.ern.xsqungngi.R
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.FragmentAboutBinding

class AboutFragment: BaseFragment<FragmentAboutBinding>(R.layout.fragment_about) {

    override val binding: FragmentAboutBinding by viewBinding(FragmentAboutBinding::bind)

    override val TAG: String = "Về chúng tôi"

    override fun setupViews() {
    }

    override fun viewModelObservers() {
    }
}