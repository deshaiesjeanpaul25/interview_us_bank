package com.deshaies.interview_us_bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshaies.interview_us_bank.adapters.DataAdapter
import com.deshaies.interview_us_bank.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataAdapter: DataAdapter
    private lateinit var dataViewModel: DataViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        dataAdapter = DataAdapter()
        recyclerView.adapter = dataAdapter

        dataViewModel.data.observe(this) { data ->
            progressBar.visibility = View.GONE
            dataAdapter.updateData(data)
        }

        dataViewModel.error.observe(this) { error ->
            progressBar.visibility = View.GONE
        }

        progressBar.visibility = View.VISIBLE
        dataViewModel.fetchData()
    }
}