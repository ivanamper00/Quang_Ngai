package de.ern.xsqungngi.terms

import androidx.recyclerview.widget.LinearLayoutManager
import de.ern.xsqungngi.R
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.FragmentTermsBinding

class TermsFragment: BaseFragment<FragmentTermsBinding>(R.layout.fragment_terms) {

    override val binding: FragmentTermsBinding by viewBinding(FragmentTermsBinding::bind)

    override fun setupViews() {
        with(binding){
            termsRecycler.layoutManager = LinearLayoutManager(requireContext())
            termsRecycler.adapter = TermsAdapter()
        }
    }

    override fun viewModelObservers() {

    }

    override val TAG: String = "Terms & Cond."
}