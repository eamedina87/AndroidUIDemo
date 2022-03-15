package tech.medina.androiddemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import tech.medina.androiddemo.databinding.ActivityButtonsBinding

class ButtonsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityButtonsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            buttonConstraint.setOnClickListener(this@ButtonsActivity)
            buttonConstraintScroll.setOnClickListener(this@ButtonsActivity)
            buttonLinearHorizontal.setOnClickListener(this@ButtonsActivity)
            buttonLinearHorizontalScroll.setOnClickListener(this@ButtonsActivity)
            buttonLinearVertical.setOnClickListener(this@ButtonsActivity)
            buttonLinearVerticalScroll.setOnClickListener(this@ButtonsActivity)
            buttonRelative.setOnClickListener(this@ButtonsActivity)
            buttonRelativeScroll.setOnClickListener(this@ButtonsActivity)
            buttonRecyclerview.setOnClickListener(this@ButtonsActivity)
        }
    }

    override fun onClick(p0: View) {
        val layoutId : Int = when (p0.id) {
            R.id.button_constraint -> R.layout.fragment_constraint
            R.id.button_constraint_scroll -> R.layout.fragment_constraint_scroll
            R.id.button_linear_horizontal -> R.layout.fragment_linear_horizontal
            R.id.button_linear_horizontal_scroll -> R.layout.fragment_linear_horizontal_scroll
            R.id.button_linear_vertical -> R.layout.fragment_linear_vertical
            R.id.button_linear_vertical_scroll -> R.layout.fragment_linear_vertical_scroll
            R.id.button_relative -> R.layout.fragment_relative
            R.id.button_relative_scroll -> R.layout.fragment_relative_scroll
            R.id.button_recyclerview -> R.layout.fragment_recyclerview
            else -> -1
        }
        openSingleActivity(layoutId)
    }

    private fun openSingleActivity(layoutId: Int) {
        val intent = Intent(this, SingleActivity::class.java).apply {
            putExtra("layout_id", layoutId)
        }
        startActivity(intent)
    }

}