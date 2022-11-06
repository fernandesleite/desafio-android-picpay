package com.picpay.desafio.android.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.util.ConverterUtil
import com.picpay.desafio.android.view.adapter.UserListAdapter
import com.picpay.desafio.android.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserListAdapter
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeView()
        initializeObservers()
    }

    private fun initializeView() {
        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.userListProgressBar.visibility = ConverterUtil.setVisibility(visibility = true)

    }

    private fun initializeObservers() {
        viewModel.getUsers()
        viewModel.userPresentation.observe(this) { userList ->
            binding.userListProgressBar.visibility = ConverterUtil.setVisibility(visibility = false)
            adapter.users = userList
        }

        viewModel.errorPresentation.observe(this) { errorPresentation ->
            binding.apply {
                userListProgressBar.visibility = ConverterUtil.setVisibility(visibility = false)
                recyclerView.visibility = ConverterUtil.setVisibility(visibility = false)
                Toast.makeText(
                    this@MainActivity,
                    errorPresentation.errorMessage,
                    errorPresentation.toastLength
                ).show()
            }
        }
    }
}
