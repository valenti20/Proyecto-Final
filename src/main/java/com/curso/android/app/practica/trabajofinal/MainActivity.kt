package com.curso.android.app.practica.trabajofinal

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var textoUno : EditText
    private lateinit var textoDos : EditText
    private lateinit var respuesta : Text
    private var boton : Boolean = false

    override fun toString():String{
        return "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitytf)

        textoUno = findViewById(R.id.textoUno)
        textoDos = findViewById(R.id.textoDos)
        respuesta = findViewById(R.id.respuesta)

        val editTextUno = textoUno.text.toString()
        val editTextDos = textoDos.text.toString()

        boton = if (editTextUno == editTextDos){
            val response = "Son Iguales"
            respuesta.replaceWholeText(response)
            true
        }else{
            val responseDos = "No son Iguales"
            respuesta.replaceWholeText(responseDos)
            false
        }
    }

}