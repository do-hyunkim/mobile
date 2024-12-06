package com.example.teamproject

import Professor
import ProfessorDao
import androidx.lifecycle.LiveData

// ProfessorRepository는 데이터베이스에 대한 CRUD 연산을 처리하는 클래스입니다.
// 이 클래스는 `ProfessorDao`를 통해 데이터베이스와 상호작용합니다.
class ProfessorRepository(private val professorDao: ProfessorDao) {

    // LiveData를 사용하여 모든 교수 데이터를 관찰합니다.
    // `professorDao.getAllProfessors()`는 데이터베이스에서 모든 교수 정보를 반환하며, LiveData를 사용하여
    // UI에서 데이터 변경을 자동으로 감지하고 업데이트할 수 있습니다.
    val allProfessors: LiveData<List<Professor>> = professorDao.getAllProfessors()

    // 새로운 교수 정보를 데이터베이스에 삽입하는 함수
    // suspend 함수로 정의되어 있으므로, 이 함수는 코루틴 내에서 호출되어야 합니다.
    // 교수 정보가 성공적으로 삽입되면, 데이터베이스에 반영됩니다.
    suspend fun insert(professor: Professor) {
        professorDao.insert(professor)  // ProfessorDao의 insert 메소드를 호출하여 데이터베이스에 교수 정보를 삽입합니다.
    }

    // 교수 정보를 업데이트하는 함수
    // `update()`는 데이터베이스 내의 기존 교수 정보를 수정합니다.
    // 이 메소드는 `suspend`로 선언되어 있어 비동기적으로 실행되며, 코루틴 내에서 호출됩니다.
    suspend fun update(professor: Professor) {
        professorDao.update(professor)  // ProfessorDao의 update 메소드를 호출하여 데이터베이스에서 교수 정보를 업데이트합니다.
    }

    // 교수 정보를 데이터베이스에서 삭제하는 함수
    // 이 함수는 특정 교수 객체를 데이터베이스에서 삭제합니다.
    // 역시 `suspend` 함수로 정의되어 있어 코루틴 내에서 비동기적으로 실행됩니다.
    suspend fun delete(professor: Professor) {
        professorDao.delete(professor)  // ProfessorDao의 delete 메소드를 호출하여 교수 정보를 데이터베이스에서 삭제합니다.
    }
}
