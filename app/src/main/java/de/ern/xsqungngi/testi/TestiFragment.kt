package de.ern.xsqungngi.testi

import androidx.recyclerview.widget.LinearLayoutManager
import de.ern.xsqungngi.R
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.FragmentTestiBinding

class TestiFragment: BaseFragment<FragmentTestiBinding>(R.layout.fragment_testi) {

    override val binding: FragmentTestiBinding by viewBinding(FragmentTestiBinding::bind)

    override val TAG: String = "Lời chứng thực"

    override fun setupViews() {
        with(binding){
            testiRecycler.layoutManager = LinearLayoutManager(requireContext())
            testiRecycler.adapter = TestiAdapter()
        }
    }

    override fun viewModelObservers() {
    }
}