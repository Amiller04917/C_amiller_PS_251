package edu.wccnet.amiller.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.amiller.coroutine.databinding.ActivityMainBinding;
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        private var data: Data = Data()
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ActivityMainBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(data.getList())
        binding.recyclerView.adapter = adapter
    }

    fun onSaveClick(view: View) {
        coroutineScope.launch(Dispatchers.Main) {
            adapter = RecyclerAdapter(performTask(binding.nameText.text.toString()).await())
            binding.recyclerView.adapter = adapter
        }
    }


    suspend fun performTask(nameText: String): Deferred<Array<Pair<String, Long>>> =
        coroutineScope.async(Dispatchers.Main) {
            val del: Long =  Random.nextLong(1000, 9000)
            delay(del)
            data.addList(Pair<String, Long>(nameText, del))
            return@async data.getList()
        }
}