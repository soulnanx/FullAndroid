package com.hive.fullandroid.ui.counter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hive.fullandroid.R
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {

    private val viewModel : CounterActivityViewModel by lazy {
        ViewModelProviders.of(this).get(CounterActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        init()
    }

    private fun init(){
        setEvents()
        setValues()
    }

    private fun setValues() {
        viewModel.getInitialCounter().observe(
            this@CounterActivity,
            Observer { currentCounter ->
                txt_counter.text = currentCounter.toString()
        })
    }

    private fun setEvents(){
        btn_add.setOnClickListener {
            viewModel.incrementCounter()
        }
    }
}