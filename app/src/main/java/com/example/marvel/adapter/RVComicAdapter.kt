import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.Items

class RVComicAdapter(
    private val comicList: List<Items>,
    function: () -> Unit
) : RecyclerView.Adapter<RVComicAdapter.ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)
        return ComicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = comicList[position]
        holder.bind(comic)
    }

    override fun getItemCount() = comicList.size

    class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comic: Items) {
            val txtComicName = itemView.findViewById<TextView>(R.id.txt_comic_name)
            val txtComicURL = itemView.findViewById<TextView>(R.id.txt_comic_url)
            txtComicName.text = comic.name
            txtComicURL.text = comic.resourceURI
        }
    }
}