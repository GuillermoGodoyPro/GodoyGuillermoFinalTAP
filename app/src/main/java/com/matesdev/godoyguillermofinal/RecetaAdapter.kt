package com.matesdev.godoyguillermofinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class RecetaAdapter(val context: Context) : ListAdapter<Receta, RecetaAdapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: ((Receta) -> Unit)

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val name: TextView = view.findViewById(R.id.tvNombreReceta)
        private val nation: TextView = view.findViewById(R.id.tvPaisOrigen)
        private val difficulty: TextView = view.findViewById(R.id.tvDificultad)
        //private val imageView: ImageView = view.findViewById(R.id.imgReceta)

        /*
        private val ingredients = view.findViewById(R.id.tvIngredientes)
        private val description = view.findViewById(R.id.tvDescripcion)
        */

        fun bind (receta: Receta){
            name.text = receta.nombreReceta
            nation.text = "Origen: " + receta.nacion.toString()
            difficulty.text ="Dificultad: " + receta.dificultad.toString()

           // Glide.with(context).load(receta.image).into(imageView)


            view.setOnClickListener {
                onItemClickListener(receta)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recetas_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaAdapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }


    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

    }
}