package edu.wccnet.amiller.recycleview
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.wccnet.amiller.recycleview.R
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // Companion object to make variables static. I presume this is what you wanted for EC
    companion object {
        private val titles = arrayOf("Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight")
        private val details = arrayOf("Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details")

        private val images = intArrayOf(R.drawable.android_image_1,
            R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8)

        // For the sake of if each array has different lengths
        private val randomTIndex = IntArray(titles.size) { Random.nextInt(0, titles.size - 1) }
        private val randomDIndex = IntArray(details.size) { Random.nextInt(0, details.size - 1) }
        private val randomIIndex = IntArray(images.size) { Random.nextInt(0, images.size - 1) }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int):
            ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = titles[randomTIndex[i]]
        viewHolder.itemDetail.text = details[randomDIndex[i]]
        viewHolder.itemImage.setImageResource(images[randomIIndex[i]])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}