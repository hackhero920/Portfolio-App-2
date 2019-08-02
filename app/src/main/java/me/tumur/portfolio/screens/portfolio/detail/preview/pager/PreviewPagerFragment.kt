package me.tumur.portfolio.screens.portfolio.detail.preview.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import me.tumur.portfolio.R
import me.tumur.portfolio.databinding.PagerItemPreviewScreenBinding
import me.tumur.portfolio.screens.portfolio.detail.preview.PreviewFragmentViewModel
import me.tumur.portfolio.utils.constants.Constants

/**
 * An fragment that inflates a preview layout.
 */
class PreviewPagerFragment : Fragment() {

    /** VARIABLES * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /** ViewModels */

    /**
     * Returns a property delegate to access ViewModel
     * by default scoped to this Fragment:
     * Default scope may be overridden with parameter ownerProducer:
     * This property can be accessed only after
     * this Fragment is attached i.e.,after Fragment.onAttach,
     * and access prior to that will result in IllegalArgumentException.*/

    private val viewModel: PreviewPagerViewModel by viewModels()

    private val sharedViewModel: PreviewFragmentViewModel by viewModels({ requireParentFragment() })

    /** Databinding */
    private lateinit var binding: PagerItemPreviewScreenBinding

    /** INITIALIZATION * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return Return the View for the fragment's UI.
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        /** Databinding */
        binding = DataBindingUtil.inflate(inflater, R.layout.pager_item_preview_screen, container, false)
        binding.apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.model = viewModel
            this.shared = sharedViewModel
        }
        /** Set data for ViewPager adapter */
        arguments?.takeIf { it.containsKey(Constants.POSITION) }?.apply {
            viewModel.setPosition(this.getInt(Constants.POSITION))
        }

        /** Observer for welcome screen's data -----------------------------------------------------------------------*/
        val screenShotPositionObserver = Observer<Int> { position ->
            position?.let {
                viewModel.setScreenShotData(sharedViewModel.getScreenShot(it))
            }
        }
        viewModel.position.observe(viewLifecycleOwner, screenShotPositionObserver)

        return binding.root
    }
}