import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.teamproject.Professor

@Dao
interface ProfessorDao {

    // 모든 교수 목록을 반환
    @Query("SELECT * FROM professor")
    fun getAllProfessors(): LiveData<List<Professor>> // 교수 목록을 반환하는 메소드

    // 교수 정보 추가
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(professor: Professor) // 반환값이 없으므로 Unit으로 처리
 // 교수 추가

    // 교수 정보 업데이트
    @Update
    suspend fun update(professor: Professor) // 교수 정보 수정

    // 교수 정보 삭제
    @Delete
    suspend fun delete(professor: Professor) // 교수 삭제
}
