package com.example.vehiculeapp.vehicleList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vehiculeapp.R
import com.example.vehiculeapp.api.ApiService
import com.example.vehiculeapp.model.ApiResponse
import kotlinx.android.synthetic.main.fragment_vehicle_list.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class VehicleListFragment : Fragment() {

    private var viewAdapter = VehicleListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vehicle_list_id.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

        val call = getApiService().listVehicle
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                response.body()?.vehicleList?.let {
                    viewAdapter.setVehicleList(it.response)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }
        })
    }

    fun getApiService(): ApiService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client =
            OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit: Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("http://api.kinomap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VehicleListFragment()
    }
}