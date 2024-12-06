package com.example.teamproject

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.teamproject.databinding.FragmentMainBinding
import com.google.android.material.navigation.NavigationView

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMainBinding.bind(view)

        // 메뉴 버튼 클릭 시 드로어 열기
        binding.menuButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }

        // 네비게이션 뷰 설정
        val navigationView: NavigationView = binding.navigationView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_main_to_prof_create -> {
                    // 교수 정보 추가 클릭 시 이동
                    findNavController().navigate(R.id.action_main_to_prof_create)
                }
                R.id.action_main_to_prof_update -> {
                    // 교수 정보 수정 클릭 시 이동
                    findNavController().navigate(R.id.action_main_to_prof_update)
                }
                R.id.action_main_to_prof_delete -> {
                    // 교수 정보 삭제 클릭 시 이동
                    findNavController().navigate(R.id.action_main_to_prof_delete)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
