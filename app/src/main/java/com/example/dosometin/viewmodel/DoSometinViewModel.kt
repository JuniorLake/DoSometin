package com.example.dosometin.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dosometin.model.Activity
import com.example.dosometin.repository.Repository
import com.example.dosometin.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoSometinViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var isLoading by mutableStateOf(true)
    var getData by mutableStateOf(Activity(0f,"","","",0,0f,"",""))

    private suspend fun getData(
        type: String?,
        participants: String?,
        accessibility: String?
    ): Resource<Activity> {
        return repository
            .getResponse(
                type = convertStrings(type),
                participants = convertStrings(participants),
                accessibility = convertStrings(accessibility)
            )
    }

    fun getResponse(type: String,participants: String,accessibility: String,context: Context? = null){
        viewModelScope.launch {
            isLoading = true
            val result = getData(type,participants,accessibility)

            if(result is Resource.Success){
                getData = result.data!!
                /*
                if(context != null){
                    Toast.makeText(context ,"Fetching data success: ${getData.activity}", Toast.LENGTH_SHORT).show()
                }

                Log.d("Testing","Success")
                */
                isLoading = false
            }
            else if (result is Resource.Error){
                /*
                if(context != null){
                    //Toast.makeText(context,"Error : ${result.message}", Toast.LENGTH_SHORT).show()
                }
                */
                Log.d("Testing","Error : ${result.message}")
            }
        }
    }

    private fun convertStrings(string: String?): String? {
        var correctString:String? = null
        when(string){
            "Education" -> correctString = "education"
            "Recreational" -> correctString = "recreational"
            "Social" -> correctString = "social"
            "Diy" -> correctString = "diy"
            "Charity" -> correctString = "charity"
            "Cooking" -> correctString = "cooking"
            "Relaxation" -> correctString = "relaxation"
            "Music" -> correctString = "music"
            "Busywork" -> correctString = "busywork"
            "1" -> correctString = "1"
            "2" -> correctString = "2"
            "3" -> correctString = "3"
            "0%" -> correctString = "0.0"
            "10%" -> correctString = "0.1"
            "20%" -> correctString = "0.2"
            "30%" -> correctString = "0.3"
            "40%" -> correctString = "0.4"
            "50%" -> correctString = "0.5"
            "60%" -> correctString = "0.6"
            "70%" -> correctString = "0.7"
            "80%" -> correctString = "0.8"
            "90%" -> correctString = "0.9"
            "100%" -> correctString = "1.0"
            "Random" -> correctString = null
            else -> null
        }
        return correctString
    }
}