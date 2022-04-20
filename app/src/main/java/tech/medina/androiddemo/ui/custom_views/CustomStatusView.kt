package tech.medina.androiddemo.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import tech.medina.androiddemo.R
import tech.medina.androiddemo.databinding.CustomViewStatusLayoutBinding

class CustomStatusView @JvmOverloads constructor(
    context: Context,
    val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private lateinit var binding: CustomViewStatusLayoutBinding

    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.custom_view_status_layout, this, true)
        binding = CustomViewStatusLayoutBinding.bind(this)
        attrs?.let {
            initAttributes(it)
        }
    }

    private fun initAttributes(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(
            attributes,
            R.styleable.CustomStatusView, 0, 0
        )
        val valueId = typedArray.getResourceId(R.styleable.CustomStatusView_csv_value, -1)
        if (valueId != -1) binding.value.text = context.getString(valueId)
        typedArray.getString(R.styleable.CustomStatusView_csv_value)?.let {
            binding.value.text = it
        }
        val unitsId = typedArray.getResourceId(R.styleable.CustomStatusView_csv_units, -1)
        if (unitsId != -1) binding.units.text = context.getString(unitsId)
        typedArray.getString(R.styleable.CustomStatusView_csv_units)?.let {
            binding.units.text = it
        }
        val iconId = typedArray.getResourceId(R.styleable.CustomStatusView_csv_icon, -1)
        if (iconId != -1) binding.icon.setImageResource(iconId)
        typedArray.recycle()
    }

}