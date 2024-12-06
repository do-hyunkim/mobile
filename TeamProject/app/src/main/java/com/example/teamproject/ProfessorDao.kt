import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface ProfessorDao {

    // 모든 교수 목록을 반환
    @Query("SELECT * FROM professor")
    fun getAllProfessors(): List<Professor> // 또는 LiveData<List<Professor>> 로 사용 가능

    // 교수 정보 추가
    @Insert
    suspend fun insert(professor: Professor)

    // 교수 정보 업데이트
    @Update
    suspend fun update(professor: Professor)

    // 교수 정보 삭제
    @Delete
    suspend fun delete(professor: Professor)
}






