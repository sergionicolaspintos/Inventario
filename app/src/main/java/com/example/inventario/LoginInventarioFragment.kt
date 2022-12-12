package com.example.inventario

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.location.GnssAntennaInfo.Listener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.getSystemService
import com.example.inventario.databinding.ActivityMainBinding.inflate
import com.example.inventario.databinding.FragmentLoginInventarioBinding

    /**
     * LoginInventarioFragment es una clase que extiende del fragment
     */
class LoginInventarioFragment : Fragment() {

    var listener : MessageListener? = null

    private var _binding : FragmentLoginInventarioBinding? = null
    private val binding get() =_binding!!

    /**
     * Declaracion de variables para usarlas en el login
     * de la aplicacion.
     */
    private var user = "nicolas"
    private var pass = "33842503"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MessageListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //super llamada a la clase padre

        }
    /**
     * inflamos esta funcion para acceder a las vistas
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginInventarioBinding.inflate(inflater,container, false)
        binding.boton1.setOnClickListener{validarIdentidad()}
        return binding.root
    }

    private fun sendMessage(){
        listener?.let {
            it.onSendMessage(binding.et1.text.toString())
        }
    }
    /**
     * con esta funcion separamos todas las vistas que tengan asociadas.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /**
     * funcion privada para validar la identidad del usuario
     */
    private fun validarIdentidad(){
        if (binding.et1.text.toString().equals(user)&& binding.et2.text.toString().equals(pass)){
            Toast.makeText(context,"Biendenido",Toast.LENGTH_LONG).show()
            sendMessage()
        }else{
            Toast.makeText(context,"Revise sus credenciales",Toast.LENGTH_LONG).show()
        }
        ocultarTeclado()
        vaciarCasilleros()
    }

    private fun vaciarCasilleros(){
        binding.et1.setText("")
        binding.et2.setText("")
        binding.et1.requestFocus()
    }

    private fun ocultarTeclado(){
        val imm : InputMethodManager = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.et1.windowToken,0)
    }
    interface MessageListener{
        fun onSendMessage(msg:String)
    }
}