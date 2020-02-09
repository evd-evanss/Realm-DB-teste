package com.sayhitoiot.realmdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.appiacare.androiddiabetescare.commons.database.entity.PersonEntity
import com.sayhitoiot.realmdatabase.model.Person
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance() // opens "myrealm.realm"
        refreshDataBase()
    }

    fun onClick(view: View){
        when(view){
            btn_view -> {
                refreshDataBase()
            }
            btn_add -> {
                saveToDatabase(edt_name.text.toString().trim(),
                    parseInt(edt_age.text.toString().trim()))
                clear()
            }
            btn_update -> {
                PersonEntity.update(edt_name.text.toString().trim(), parseInt(edt_age.text.toString().trim()))

                refreshDataBase()
            }
            btn_delete -> {
                deleteFromDatabase()
                clear()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun saveToDatabase(nome: String, id: Int){
//        realm.executeTransactionAsync({ bgRealm ->
//            val user = bgRealm.createObject<Person>()
//            user.name = nome
//            user.id = id
//        }, {
//            Log.d("save", "Salvo com sucesso!")
//            refreshDataBase()
//        }, { error ->
//            Log.d("save", "Falha na transação!")
//        })
        PersonEntity.create(id, nome)
        refreshDataBase()
    }

    fun refreshDataBase(){
//        val result = realm.where<Person>()
////            .findAllAsync()
////        var log: String = ""
////        result.load()
////        result.forEach { person ->
////            log += "Nome: "+ person.name +" "
////            log += "Idade: "+ person.id +"\n"
////        }
////        Log.d("teste", result.toString())
////        log_panel.setText(log)
        var log = ""
        val user = PersonEntity.getUser()?.let {
            log += "Usuário \n"
            log += "Nome: "+ it.name + "\n"
            log += "Idade: "+ it.id + "\n"
        }

        if(user!=null){
            log_panel.setText(log)
        }
    }

    fun deleteFromDatabase(){
        PersonEntity.delete()
        refreshDataBase()
        clearPanel()
//        val persons = realm.where<Person>().contains("name", name.trim()).findAll()
//        // All changes to data must happen in a transaction
//        realm.executeTransaction { realm ->
//            // remove single match
//            //persons.deleteFirstFromRealm()
//            //persons.deleteLastFromRealm()
//            Log.d("delete", persons.toString())
//            try {
//                persons.deleteFromRealm(0)
//            }catch (e: Exception){
//                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//            }
//
//            // Delete all matches
//            //persons.deleteAllFromRealm()
//            refreshDataBase()
//
//        }

    }

    private fun clearPanel() {
        log_panel.text.clear()
    }

    fun clear(){
        edt_age.text.clear()
        edt_name.text.clear()
    }
}
