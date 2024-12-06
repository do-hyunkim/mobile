import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "professor")  // 테이블 이름을 "professor"로 설정
data class Professor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val department: String,
    val email: String
)

