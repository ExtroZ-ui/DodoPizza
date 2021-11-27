package com.example.dodopizza.ui.notifications

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.R
import com.example.dodopizza.net.ApiRet
import com.example.dodopizza.net.MyRetrofit
import com.example.dodopizza.net.Quotes
import retrofit2.Response
import javax.security.auth.callback.Callback

class NotificationsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications,container,false)
        val retrofit = MyRetrofit().getRetrofit().create(ApiRet::class.java)
        val call: retrofit2.Call<Quotes> = retrofit.getQuote()
        call.enqueue(object: retrofit2.Callback<Quotes>{
            override fun onResponse(call: retrofit2.Call<Quotes>, response: Response<Quotes>) {
                response.body()?.let { root.findViewById<RecyclerView>(R.id.rec_quotes).adapter = QuoteAdapter(requireContext(), it.data) }
            }

            override fun onFailure(call: retrofit2.Call<Quotes>, t: Throwable) {

            }


        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}