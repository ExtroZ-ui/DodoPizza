package com.example.dodopizza.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.dodopizza.R

class DashboardFragment : Fragment() {
    lateinit var img:ImageView
    lateinit var email:TextView
    lateinit var nick:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard,container,false)
        img = root.findViewById(R.id.img_profil)
        email = root.findViewById(R.id.email)
        nick = root.findViewById(R.id.nickName)

        val imgPut = context?.getSharedPreferences("user",Context.MODE_PRIVATE)!!.getString("avatar",null)
        Glide.with(requireContext()).load(imgPut).into(img)
        email.text = context?.getSharedPreferences("user",Context.MODE_PRIVATE)!!.getString("email",null)
        nick.text = context?.getSharedPreferences("user",Context.MODE_PRIVATE)!!.getString("nickName",null)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}