import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.teamproject.databinding.FragmentMainBinding

class ProfessorListFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProfessorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        // ViewModel 초기화
        viewModel = ViewModelProvider(this).get(ProfessorViewModel::class.java)

        // LiveData 관찰
        viewModel.allProfessors.observe(viewLifecycleOwner) { professors ->
            // 기존 뷰 제거
            binding.professorList.removeAllViews()
            // 각 교수에 대한 뷰를 생성하고 추가
            for (professor in professors) {
                val professorView = createProfessorView(professor)
                binding.professorList.addView(professorView)
            }
        }

        return binding.root
    }

    // 교수 정보를 표시하는 뷰 생성 함수
    private fun createProfessorView(professor: Professor): View {
        val inflater = LayoutInflater.from(context)
        val professorItemBinding = ProfessorItemBinding.inflate(inflater)
        professorItemBinding.professorName.Text = professor.name
        professorItemBinding.professorField.Text = professor.field
        professorItemBinding.professorEmail.Text = professor.email
        // 필요에 따라 이미지나 다른 정보도 설정
        return professorItemBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

