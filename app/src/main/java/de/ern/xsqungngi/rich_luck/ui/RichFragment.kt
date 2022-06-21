package de.ern.xsqungngi.rich_luck.ui

import androidx.recyclerview.widget.LinearLayoutManager
import de.ern.xsqungngi.Data
import de.ern.xsqungngi.R
import de.ern.xsqungngi.base.BaseFragment
import de.ern.xsqungngi.binding.viewBinding
import de.ern.xsqungngi.databinding.FragmentRichBinding
import de.ern.xsqungngi.rich_luck.RichController

class RichFragment: BaseFragment<FragmentRichBinding>(R.layout.fragment_rich),
RichController.Listener {

    override val binding by viewBinding(FragmentRichBinding::bind)

    private val controller by lazy {
        RichController(this)
    }

    override fun setupViews() {
        with(binding){
            recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recycler.setController(controller)
            controller.data = Data.rich
        }
    }

    override fun viewModelObservers() {

    }

    override fun onItemSelected() {

    }

    override val TAG: String = ""

}