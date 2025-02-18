package com.example.simbaseapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlanAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PlanAdapter(emptyList()) { selectedPlan ->
            Toast.makeText(
                this@MainActivity,
                "Selected Plan: ${selectedPlan.name}",
                Toast.LENGTH_LONG
            ).show()
        }
        recyclerView.adapter = adapter




        fetchDataPlans()
    }

    private fun fetchDataPlans() {
        
        val apiKey = "Bearer live-92TBE4KQBb2c64-89AMc5QqH6cqtNRwzqYG0ji6mLn0PNKnpkdFY7br9c3VcR08J0" // Replace with your Simbase API key

        RetrofitClient.instance.getPlans(apiKey).enqueue(object : Callback<List<DataPlan>> {
            override fun onResponse(call: Call<List<DataPlan>>, response: Response<List<DataPlan>>) {
                if (response.isSuccessful) {
                    val dataPlans = response.body()
                    Log.d("API_RESPONSE", "Success: $dataPlans")
                } else {
                    Log.e("API_ERROR", "Failed: ${response.code()} - ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<DataPlan>>, t: Throwable) {
                Log.e("API_ERROR", "Network Failure: ${t.message}")
            }
        })

    }
}
