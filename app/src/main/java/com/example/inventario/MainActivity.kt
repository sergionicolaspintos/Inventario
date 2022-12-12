package com.example.inventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.inventario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),LoginInventarioFragment.MessageListener {

    private lateinit var binding: ActivityMainBinding

    /**
     * inflamos esta funcion para acceder a las vistas
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment()//por medio de este cargo el fragmento
    }
    /**
     * esta funcion nos permite llamar al fragment desde el activity
     */
    private fun loadFragment(){
       val loginInventarioFragment = LoginInventarioFragment()

       val fragmentTransaction = supportFragmentManager.beginTransaction()
       fragmentTransaction.replace(binding.layoutFragmentContainer.id,loginInventarioFragment)
        fragmentTransaction.commit()
    }

    private fun Stock(mensaje:String){
        val intent = Intent(this, Stock::class.java)
            .apply { putExtra(Stock.KEY_MESSAGE,mensaje) }
        startActivity(intent)
    }

    override fun onSendMessage(msg: String) {
        Stock(msg)
    }
}