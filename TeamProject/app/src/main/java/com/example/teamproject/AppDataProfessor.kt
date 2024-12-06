package com.example.teamproject

import Professor
import ProfessorDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teamproject.Professor

/**
 * Room 데이터베이스를 정의하는 클래스입니다.
 * @Database 어노테이션을 사용하여 데이터베이스의 엔티티, 버전 등을 설정합니다.
 */
@Database(entities = [Professor::class], version = 1, exportSchema = false)
abstract class AppDataProfessor : RoomDatabase() {

    // DAO를 반환하는 추상 메소드
    abstract fun professorDao(): ProfessorDao

    companion object {
        // 앱 내에서 데이터베이스 인스턴스를 하나만 생성하기 위해 싱글톤 패턴 사용
        @Volatile
        private var INSTANCE: AppDataProfessor? = null

        /**
         * 데이터베이스 인스턴스를 반환하는 함수
         * 만약 데이터베이스 인스턴스가 null이라면, 새로운 인스턴스를 생성하여 반환합니다.
         * 싱글톤 패턴을 사용하여 여러 번 생성되지 않도록 관리합니다.
         */
        fun getDatabase(context: Context): AppDataProfessor {
            // INSTANCE가 null이 아니면 기존 인스턴스를 반환
            return INSTANCE ?: synchronized(this) {
                // INSTANCE가 null이면 새롭게 데이터베이스 인스턴스를 생성
                val instance = Room.databaseBuilder(
                    context.applicationContext, // 애플리케이션의 context 사용
                    AppDataProfessor::class.java, // 데이터베이스 클래스 지정
                    "professor_database" // 데이터베이스 파일 이름
                ).build()
                // 생성된 인스턴스를 INSTANCE에 할당하여 싱글톤 보장
                INSTANCE = instance
                instance
            }
        }
    }
}
