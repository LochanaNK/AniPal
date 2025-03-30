package com.example.anipal


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var animeAdapter: AnimeAdapter
    private val animeList = mutableListOf<AnimeModel>()
    private var selectedGenres :String? = null
    private var selectedYear :String? = null
    private var selectedMood :String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val startYear = 1990
        val endYear = LocalDate.now().year

        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        val genreView = view.findViewById<AutoCompleteTextView>(R.id.genre_view)
        val yearView = view.findViewById<AutoCompleteTextView>(R.id.year_view)
        val profile = view.findViewById<ImageView>(R.id.profile)
        val menu = view.findViewById<ImageView>(R.id.menu)


        val genres = listOf("Action","Adventure","Comedy","Slice of life","Seinen","Romance","Sci-fi","Fantasy")
        val years = (startYear..endYear).toList().map { it.toString() }
        val adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,genres)
        val adapter2 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,years)

        genreView.setAdapter(adapter1)
        yearView.setAdapter(adapter2)

        profile.setOnClickListener {
            val intent = Intent(activity, Profile::class.java)
            startActivity(intent)
        }

        genreView.setOnClickListener{
            genreView.setDropDownHeight(400)
            genreView.showDropDown()
        }
        yearView.setOnClickListener{
            yearView.setDropDownHeight(400)
            yearView.showDropDown()
        }

        genreView.setOnItemClickListener{_,_,position,_ ->
            selectedGenres = genres[position]
            filterAnime()
        }
        yearView.setOnItemClickListener{_,_,position,_ ->
            selectedYear = years[position]
            filterAnime()
        }

        val moodButtons = listOf(
            view.findViewById<FrameLayout>(R.id.mood1),
            view.findViewById<FrameLayout>(R.id.mood2),
            view.findViewById<FrameLayout>(R.id.mood3),
            view.findViewById<FrameLayout>(R.id.mood4),
            view.findViewById<FrameLayout>(R.id.mood5),
            view.findViewById<FrameLayout>(R.id.mood6),
            view.findViewById<FrameLayout>(R.id.mood7),
            view.findViewById<FrameLayout>(R.id.mood8)
        )

        moodButtons.forEach { moodButton ->
            moodButton.setOnClickListener {
                val moodText = moodButton.findViewById<TextView>(when(moodButton.id){
                    R.id.mood1 -> R.id.mood_text1
                    R.id.mood2 -> R.id.mood_text2
                    R.id.mood3 -> R.id.mood_text3
                    R.id.mood4 -> R.id.mood_text4
                    R.id.mood5 -> R.id.mood_text5
                    R.id.mood6 -> R.id.mood_text6
                    R.id.mood7 -> R.id.mood_text7
                    R.id.mood8 -> R.id.mood_text8

                    else->throw IllegalArgumentException("Unknown mood button ID")
                })
                selectedMood = moodText.text.toString()
                filterAnime()
            }
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        loadAnimeData()

        animeAdapter = AnimeAdapter(animeList)
        recyclerView.adapter = animeAdapter

        return view
    }

    private fun loadAnimeData() {

        animeList.add(AnimeModel("One Punch Man",R.drawable.one_punch_man,"⭐4.9","Action","2015","Epic"))
        animeList.add(AnimeModel("Gintama", R.drawable.gintama, "⭐4.9", "Comedy", "2005", "Bored"))
        animeList.add(AnimeModel("Solo Leveling", R.drawable.solo_leveling, "⭐4.7", "Action", "2024", "Epic"))
        animeList.add(AnimeModel("Goblin Slayer", R.drawable.goblin_slayer, "⭐4.6", "Action", "2018", "Epic"))
        animeList.add(AnimeModel("One Piece", R.drawable.one_piece, "⭐5.0", "Adventure", "1999", "Nostalgic"))
        animeList.add(AnimeModel("Jo Jo's Bizarre Adventures", R.drawable.jojos_bizzare_adventures, "⭐4.8", "Adventure", "1989", "Nostalgic"))
        animeList.add(AnimeModel("Apothecari Diaries", R.drawable.apothecari_diaries, "⭐4.8", "Fantasy", "2022", "Happy"))
        animeList.add(AnimeModel("Frieren", R.drawable.frieren, "⭐4.8", "Fantasy", "2023", "Stressed"))
        animeList.add(AnimeModel("Monster", R.drawable.monster, "⭐4.9", "Seinen", "2004", "Energetic"))
        animeList.add(AnimeModel("Fena The Pirate Princess", R.drawable.fena_pirate_princess, "⭐4.5", "Adventure", "2021", "Stressed"))
        animeList.add(AnimeModel("Hell's Paradise", R.drawable.hells_paradise, "⭐4.7", "Action", "2023", "Bored"))
        animeList.add(AnimeModel("Kaiju No 8", R.drawable.kaiju_no_8, "⭐4.8", "Action", "2021", "Bored"))
        animeList.add(AnimeModel("My Hero Academia", R.drawable.my_hero_academia, "⭐4.8", "Action", "2016", "Happy"))
        animeList.add(AnimeModel("Neir Automata", R.drawable.nier_automata, "⭐4.7", "Sci-Fi", "2023", "Happy"))
        animeList.add(AnimeModel("Trigun", R.drawable.trigun, "⭐4.7", "Action", "1998", "Nostalgic"))
        animeList.add(AnimeModel("Dandadan", R.drawable.dandadan, "⭐4.6", "Action", "2022", "Sad"))
        animeList.add(AnimeModel("Dr.Stone", R.drawable.dr_stone, "⭐4.8", "Sci-Fi", "2019", "Sad"))
        animeList.add(AnimeModel("Trigun Stampede", R.drawable.trigun_stampede, "⭐4.5", "Action", "2023", "Happy"))
        animeList.add(AnimeModel("Violet Evergarden", R.drawable.violet_evergarden, "⭐4.9", "Drama", "2018", "Sad"))
        animeList.add(AnimeModel("Hyouka", R.drawable.hyouka, "⭐4.8", "Slice Of Life", "2012", "Romantic"))
        animeList.add(AnimeModel("Demon Slayer", R.drawable.demon_slayer, "⭐5.0", "Action", "2019", "Bored"))
        animeList.add(AnimeModel("Tamako Market", R.drawable.tamako_market, "⭐4.6", "Slice of Life", "2013", "Romantic"))
        animeList.add(AnimeModel("My Dress Up Darling", R.drawable.my_dress_up_darling, "⭐4.8", "Romance", "2022", "Romantic"))
        animeList.add(AnimeModel("Eighty Six", R.drawable.eighty_six, "⭐4.8", "Action", "2021", "Energetic"))
        animeList.add(AnimeModel("Record Of Ragnarok", R.drawable.record_of_ragnarok, "⭐4.7", "Action", "2021", "Bored"))
        animeList.add(AnimeModel("Kabaneri In The Iron Fortress", R.drawable.kabaneri_in_the_iron_fortress, "⭐4.7", "Action", "2016", "Epic"))
        animeList.add(AnimeModel("Vinland Saga", R.drawable.vinland_saga, "⭐4.8", "Seinen", "2019", "Epic"))
        animeList.add(AnimeModel("Cyberpunk Edgerunners", R.drawable.cyberpunk_edgerunners, "⭐4.8", "Sci-Fi", "2022", "Energetic"))
        animeList.add(AnimeModel("Eminence In The Shadow", R.drawable.the_eminence_in_shadow, "⭐4.6", "Action", "2022", "Bored"))
        animeList.add(AnimeModel("Jobless Reincarnation", R.drawable.jobless_reincarnation, "⭐4.8", "Fantasy", "2021", "Sad"))
        animeList.add(AnimeModel("Spy x Family", R.drawable.spy_family, "⭐4.9", "Comedy", "2022", "Sad"))

    }

    private fun filterAnime() {
        val filteredList = animeList.filter { anime ->
            animeMatchesCriteria(anime)
        }
        animeAdapter = AnimeAdapter(filteredList)
        recyclerView.adapter = animeAdapter
    }

    private fun animeMatchesCriteria(anime: AnimeModel): Boolean {
        val matchesGenre = selectedGenres?.let { anime.genre == it } ?: true
        val matchesYear = selectedYear?.let { anime.year == it } ?: true
        val matchesMood = selectedMood?.let { anime.mood == it } ?: true

        return matchesGenre && matchesYear && matchesMood
    }

}
