package com.oakil.fooddeliveryapplication.ui.features.auth.SignUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oakil.fooddeliveryapplication.Data.FoodApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(val foodApi: FoodApi) : ViewModel(){

    private val _uiState = MutableStateFlow<SignUpEvent>(SignUpEvent.Nothing)
    val uiState = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<SignUpNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()


    fun onNameChange(name:String){
        _name.value = name
    }

    fun onEmailChange(email: String){
        _email.value = email
    }

    fun onPasswordChange(password: String){
        _password.value = password
    }

    fun onSignUpClick(){
        viewModelScope.launch{
            _uiState.value = SignUpEvent.Loading
            delay(2000)
            _uiState.value = SignUpEvent.Success
            _navigationEvent.tryEmit(SignUpNavigationEvent.NavigationToHome)
        }
    }


    sealed class SignUpNavigationEvent{
        object NavigationToLogin : SignUpNavigationEvent()
        object NavigationToHome : SignUpNavigationEvent()
    }

    sealed class SignUpEvent{
        object Nothing : SignUpEvent()
        object Loading : SignUpEvent()
        object Error : SignUpEvent()
        object Success : SignUpEvent()
    }

}