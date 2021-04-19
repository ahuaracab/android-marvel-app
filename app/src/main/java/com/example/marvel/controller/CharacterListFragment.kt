package com.example.marvel.controller

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.adapter.RVCharacterAdapter
import com.example.marvel.data.ClientConfig
import com.example.marvel.data.MarvelApiService
import com.example.marvel.databinding.FragmentCharacterListBinding
import com.example.marvel.model.Character
import com.example.marvel.model.CharacterData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater)
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
                        showCharacters(response.body()?.results?.characters)
                    }
                }

                override fun onFailure(call: Call<CharacterData>, t: Throwable) {

                }
            })
        }
    }

    private fun showCharacters(characters: List<Character>?) {
        characters?.let {
            val adapter = RVCharacterAdapter(it){
                val intent = Intent(context, ComicActivity::class.java)
                intent.putExtra("VARIABLE_ID", it)
                startActivity(intent)
            }

            binding.rvCharacterList.adapter = adapter

            binding.rvCharacterList.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}




