package tech.medina.androiddemo.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import tech.medina.androiddemo.R
import tech.medina.androiddemo.databinding.CustomViewLayoutBinding

class CustomView @JvmOverloads constructor(
    context: Context,
    val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private lateinit var binding: CustomViewLayoutBinding

    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this, true)
        binding = CustomViewLayoutBinding.bind(this)
        attrs?.let {
            initAttributes(it)
        }
    }

    private fun initAttributes(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(
            attributes,
            R.styleable.CustomView, 0, 0
        )
        val titleId = typedArray.getResourceId(R.styleable.CustomView_cv_title, -1)
        if (titleId != -1) binding.title.text = context.getString(titleId)
        typedArray.getString(R.styleable.CustomView_cv_title)?.let {
            binding.title.text = it
        }
        val valueId = typedArray.getResourceId(R.styleable.CustomView_cv_value, -1)
        if (valueId != -1) binding.value.text = context.getString(valueId)
        typedArray.getString(R.styleable.CustomView_cv_value)?.let {
            binding.value.text = it
        }
        val unitsId = typedArray.getResourceId(R.styleable.CustomView_cv_units, -1)
        if (unitsId != -1) binding.units.text = context.getString(unitsId)
        typedArray.getString(R.styleable.CustomView_cv_units)?.let {
            binding.units.text = it
        }
        val dateId = typedArray.getResourceId(R.styleable.CustomView_cv_date, -1)
        if (dateId != -1) binding.date.text = context.getString(dateId)
        typedArray.getString(R.styleable.CustomView_cv_date)?.let {
            binding.date.text = it
        }
        val iconId = typedArray.getResourceId(R.styleable.CustomView_cv_icon, -1)
        if (iconId != -1) binding.icon.setImageResource(iconId)
        val lockVisible = typedArray.getBoolean(R.styleable.CustomView_cv_lock_visible, false)
        binding.lock.isVisible = lockVisible
        typedArray.recycle()
    }

}