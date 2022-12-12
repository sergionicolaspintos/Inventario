package com.example.inventario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.inventario.databinding.ActivityMainBinding
import com.example.inventario.databinding.ActivityStockBinding

class Stock : AppCompatActivity() {

    private lateinit var binding: ActivityStockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btinsumos.setOnClickListener { loadFragment(Insumos())}


        val usuario = intent.getStringExtra(KEY_MESSAGE)
        binding.stockk.setText("Bienvenido $usuario")
    }
    companion object{
        const val KEY_MESSAGE = "com.example.inventario.mensaje1"
    }
    private fun loadFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.layoutFragmentContainer.id, fragment)
        fragmentTransaction.commit()
    }

}