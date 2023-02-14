package com.example.memefy.ui.meme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memefy.Model.Getmemes.Meme
import com.example.memefy.Model.Getmemes.MemesApi
import com.example.memefy.Model.Getmemes.MemesApiImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MemeViewModel @Inject constructor(private val memeApi:MemesApi) : ViewModel() {

    private val _memes: MutableLiveData<Meme> = MutableLiveData()
    val memes: LiveData<Meme> get() = _memes

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _memes.value = memeApi.getMemes()
        }
    }
}