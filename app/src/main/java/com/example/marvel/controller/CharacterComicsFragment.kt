package com.example.marvel.controller

import RVComicAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.data.ClientConfig
import com.example.marvel.data.MarvelApiService
import com.example.marvel.databinding.FragmentCharacterComicsBinding
import com.example.marvel.model.CharacterData
import com.example.marvel.model.Items
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterComicsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterComicsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterComicsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val service = MarvelApiService(config = ClientConfig())

        CoroutineScope(Dispatchers.IO).launch {
            service.getCharacterList().enqueue(object : Callback<CharacterData> {
                // 200 - 300
                override fun onResponse(
                    call: Call<CharacterData>,
                    response: Response<CharacterData>
                ) {
                    if (response.isSuccessful) {
                        showComics(response.body()?.results?.characters?.get(1)?.comics?.items)
                    }
                }

                override fun onFailure(call: Call<CharacterData>, t: Throwable) {

                }
            })
        }
    }

    private fun showComics(comics: List<Items>?) {
        comics?.let {
            val adapter = RVComicAdapter(it) {

                val intent = Intent(context, ComicActivity::class.java)
                //intent.putExtra("VARIABLE_ID", it)
                startActivity(intent)
            }

            binding.rvCharacterComics.adapter = adapter

            binding.rvCharacterComics.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}




