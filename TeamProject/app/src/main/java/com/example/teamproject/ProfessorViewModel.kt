package com.example.teamproject

import Professor
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// ProfessorViewModel은 교수 관련 데이터를 처리하는 ViewModel 클래스입니다.
// 이 클래스는 UI와 데이터 간의 상호작용을 관리합니다.
class ProfessorViewModel(application: Application) : AndroidViewModel(application) {

    // Repository 객체를 사용하여 데이터베이스와 상호작용
    private val repository: ProfessorRepository

    // LiveData를 통해 교수 목록을 관찰합니다.
    // 이 LiveData는 UI에서 교수 목록의 변경 사항을 자동으로 업데이트할 수 있도록 해줍니다.
    val allProfessors: LiveData<List<Professor>>

    // ViewModel 초기화 시 호출되는 함수
    init {
        // AppDataProfessor는 Room 데이터베이스 인스턴스를 생성하고 ProfessorDao를 반환합니다.
        val professorDao = AppDataProfessor.getDatabase(application).professorDao()

        // Repository 객체 초기화
        repository = ProfessorRepository(professorDao)

        // Repository에서 제공하는 allProfessors를 가져와서 LiveData로 설정
        allProfessors = repository.allProfessors
    }

    // 교수 정보를 데이터베이스에 추가하는 함수
    // ViewModel에서 데이터베이스 작업을 비동기적으로 실행할 수 있도록 코루틴을 사용합니다.
    // 코루틴은 viewModelScope 내에서 실행됩니다.
    fun insert(professor: Professor) = viewModelScope.launch {
        // Repository의 insert 메소드를 호출하여 교수 정보를 추가
        repository.insert(professor)
    }

    // 교수 정보를 데이터베이스에서 업데이트하는 함수
    // 코루틴을 사용하여 비동기적으로 실행되며, UI의 동작을 차단하지 않습니다.
    fun update(professor: Professor) = viewModelScope.launch {
        // Repository의 update 메소드를 호출하여 교수 정보를 업데이트
        repository.update(professor)
    }

    // 교수 정보를 데이터베이스에서 삭제하는 함수
    // 이 메소드는 비동기적으로 실행되며, UI를 차단하지 않고 삭제 작업을 처리합니다.
    fun delete(professor: Professor) = viewModelScope.launch {
        // Repository의 delete 메소드를 호출하여 교수 정보를 삭제
        repository.delete(professor)
    }
}
