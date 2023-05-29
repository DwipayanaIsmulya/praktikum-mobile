package com.UTS.utsdwii.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UTS.utsdwii.HewanAdapter
import com.UTS.utsdwii.R
import com.UTS.utsdwii.listHewan

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalFragment : Fragment() {
    private lateinit var adapter: HewanAdapter
    private lateinit var recycleView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val grid = GridLayoutManager(context, 2)
        recycleView = view.findViewById(R.id.list_hewan_view)
        recycleView.layoutManager = grid
//        recycleView.hasFixedSize(true)
        adapter = HewanAdapter(listHewan)
        recycleView.adapter = adapter
    }


}