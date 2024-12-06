package com.example.teamproject

import Professor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.teamproject.databinding.FragmentMainBinding
import com.example.teamproject.databinding.ItemProfessorDeleteBinding

// 교수 목록을 보여주는 프래그먼트 클래스입니다.
class ProfessorListFragment : Fragment() {

    // ViewBinding을 위한 변수 선언
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!! // binding 변수는 null일 수 없으므로 안전하게 접근할 수 있도록 설정

    // ProfessorViewModel을 사용하여 데이터베이스와 상호작용
    private lateinit var professorViewModel: ProfessorViewModel

    // onCreateView: 이 프래그먼트의 UI를 생성하는 함수
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // FragmentMainBinding을 인플레이트하여 fragment_main.xml에 연결
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        // ViewModel 초기화
        professorViewModel = ViewModelProvider(this).get(ProfessorViewModel::class.java)

        // LiveData를 관찰하여 교수 목록이 변경될 때마다 UI를 업데이트
        professorViewModel.allProfessors.observe(viewLifecycleOwner) { professors ->
            // 이전에 추가된 교수 목록을 제거
            binding.professorList.removeAllViews()

            // 새로 가져온 교수 목록을 동적으로 추가
            professors.forEach { professor ->
                val professorView = createProfessorView(professor) // 교수에 대한 뷰 생성
                binding.professorList.addView(professorView) // professorList에 교수 뷰 추가
            }
        }

        return binding.root // 레이아웃을 반환
    }

    // 교수 정보를 보여주는 뷰를 생성하는 함수
    private fun createProfessorView(professor: Professor): View {
        val inflater = LayoutInflater.from(context) // LayoutInflater를 통해 뷰를 인플레이트

        // ItemProfessorDeleteBinding을 사용하여 XML 레이아웃과 연결
        val binding = ItemProfessorDeleteBinding.inflate(inflater)

        // 바인딩 객체를 사용하여 교수의 이름, 전공, 이메일을 설정
        binding.professorName.text = professor.name
        binding.professorDepartment.text = professor.field
        binding.professorEmail.text = professor.email

        // 설정된 바인딩 객체의 루트 뷰를 반환
        return binding.root
    }

    // 뷰가 파괴될 때 호출되는 메소드
    // 메모리 누수를 방지하기 위해 binding 객체를 null로 설정
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // binding 객체 해제
    }
}
