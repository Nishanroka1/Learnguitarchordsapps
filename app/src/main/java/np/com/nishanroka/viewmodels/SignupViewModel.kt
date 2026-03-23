package np.com.nishanroka.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SignupUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

class SignupViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    private val _uiState = MutableStateFlow(SignupUiState())
    val uiState: StateFlow<SignupUiState> = _uiState.asStateFlow()

    fun onEmailChange(newValue: String) {
        email = newValue
    }

    fun onPasswordChange(newValue: String) {
        password = newValue
    }

    fun onConfirmPasswordChange(newValue: String) {
        confirmPassword = newValue
    }

    fun signup() {
        if (password != confirmPassword) {
            _uiState.value = SignupUiState(error = "Passwords do not match")
            return
        }
        
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = SignupUiState(error = "Please fill all fields")
            return
        }

        // Simulate signup logic
        _uiState.value = SignupUiState(isLoading = true)
        // In a real app, you'd call a repository here
        _uiState.value = SignupUiState(isSuccess = true)
    }
    
    fun resetError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
