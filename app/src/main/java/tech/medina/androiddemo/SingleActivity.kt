package tech.medina.androiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.medina.androiddemo.databinding.FragmentRecyclerviewBinding
import kotlin.random.Random

class SingleActivity : AppCompatActivity() {

    private val itemAdapter by lazy {
        ItemAdapter()
    }
    lateinit var binding: FragmentRecyclerviewBinding

    private val itemList: MutableList<ListItem> by lazy {
        mutableListOf(
            ListItem(Utils.colorList[0], Utils.iconList[0]),
            ListItem(Utils.colorList[1], Utils.iconList[1]),
            ListItem(Utils.colorList[4], Utils.iconList[2])
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent?.let {
            val layoutId = it.getIntExtra("layout_id", -1)
            if (layoutId == R.layout.fragment_recyclerview) {
                binding = FragmentRecyclerviewBinding.inflate(layoutInflater)
                setContentView(binding.root)
                setupButton()
                setupRecyclerView()
            } else {
                setContentView(layoutId)
            }
        }
    }

    private fun setupButton() {
        binding.fab.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        val randomColorIndex = Random.nextInt(0, Utils.colorList.lastIndex)
        val randomIconIndex = Random.nextInt(0, Utils.iconList.lastIndex)
        itemList.add(ListItem(Utils.colorList[randomColorIndex], Utils.iconList[randomIconIndex]))
        itemAdapter.submitList(itemList)
        itemAdapter.notifyItemInserted(itemList.lastIndex)
        binding.recyclerview.scrollToPosition(itemList.lastIndex)
        //this.
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = itemAdapter.apply {
            submitList(itemList)
        }
    }

    data class ListItem(
        val color: Int,
        val icon: Int
    )

}