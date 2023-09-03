package com.curso.android.app.practica.trabajofinal

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text
    data class Usuario(val id: Int, val name: String, val email: String)

class UsuarioViewModel: ViewModel(){
        private val usuarioRepository = UserRepository()

        class UserRepository {
            fun fetchUsers(): Usuario = Usuario(0,"", "")
        }

        private val _usuarioData = MutableLiveData<List<Usuario>>()
        val usuarioData: LiveData<List<Usuario>>
            get() = _usuarioData
        init {
            _usuarioData.value = listOf(usuarioRepository.fetchUsers())
        }
    }

class MainActivity : AppCompatActivity() {

    private lateinit var usuarioViewModel: UsuarioViewModel

    private lateinit var textoUno : EditText
    private lateinit var textoDos : EditText
    private lateinit var respuesta : Text
    private var boton : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitytf)

        usuarioViewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]

        fun updateUI(users: List<Usuario>) = users

        usuarioViewModel.usuarioData.observe(this) { users -> updateUI(users) }

        textoUno = findViewById(R.id.textoUno)
        textoDos = findViewById(R.id.textoDos)
        respuesta = findViewById(R.id.respuesta)

        val editTextUno = textoUno.text.toString()
        val editTextDos = textoDos.text.toString()

        try{
            boton = if (editTextUno == editTextDos){
                val response = "Son Iguales"
                respuesta.replaceWholeText(response)
                true
            }else{
                val responseDos = "No son Iguales"
                respuesta.replaceWholeText(responseDos)
                false
            }
        }catch(e:Exception){
            println(e)
        }finally {
            println("finalizo")
        }

    }

}