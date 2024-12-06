class ProfessorRepository(private val professorDao: ProfessorDao) {
    val allProfessors: LiveData<List<Professor>> = professorDao.getAllProfessors()

    suspend fun insert(professor: Professor) {
        professorDao.insert(professor)
    }

    suspend fun update(professor: Professor) {
        professorDao.update(professor)
    }

    suspend fun delete(professor: Professor) {
        professorDao.delete(professor)
    }
}
