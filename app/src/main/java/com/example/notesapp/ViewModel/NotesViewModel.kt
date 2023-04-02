package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.Database.DatabaseNotes
import com.example.notesapp.EntityModel.Notes
import com.example.notesapp.Repository.NotesRepository
import com.example.notesapp.Ui.Fragments.EditNoteFragmentArgs

class NotesViewModel(application: Application) :AndroidViewModel(application){

    val repository:NotesRepository

    init {
        val dao=DatabaseNotes.getDatabaseINstance(application).myNotesDao()
        repository=NotesRepository(dao)
    }

    fun addNotes (notes: Notes){
        repository.insertNotes(notes)
    }
    fun getNotes():LiveData<List<Notes>> = repository.getallNotes()

    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes()
    fun getMediumNotes():LiveData<List<Notes>> = repository.getMediumNotes()
    fun getLowNotes():LiveData<List<Notes>> = repository.getLowNotes()


    fun deleteNotes(Not: EditNoteFragmentArgs, id: Int){
        repository.deleteNotes(id)
    }
    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }


}