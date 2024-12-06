import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProfessorViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProfessorRepository
    val allProfessors: LiveData<List<Professor>>

    init {
        val professorDao = AppDataProfessor.getDatabase(application).professorDao()
        repository = ProfessorRepository(professorDao)
        allProfessors = repository.allProfessors
    }

    fun insert(professor: Professor) = viewModelScope.launch {
        repository.insert(professor)
    }

    fun update(professor: Professor) = viewModelScope.launch {
        repository.update(professor)
    }

    fun delete(professor: Professor) = viewModelScope.launch {
        repository.delete(professor)
    }
}
