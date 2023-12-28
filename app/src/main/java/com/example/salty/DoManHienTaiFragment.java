package com.example.salty;

import android.os.Bundle;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoManHienTaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoManHienTaiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DoManHienTaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoManHienTaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DoManHienTaiFragment newInstance(String param1, String param2) {
        DoManHienTaiFragment fragment = new DoManHienTaiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_do_man_hien_tai, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Hiển thị nút quay lại
            // Hoặc
            // actionBar.setDisplayHomeAsUpEnabled(false); // Ẩn nút quay lại
        }


        Button vitri = view.findViewById(R.id.ViTri);
        vitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.vitri_menu, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Xử lý sự kiện khi item được chọn
                        switch (item.getTitle().toString()) {
                            case "An Giang":
                                // Code xử lý khi menu item AnGiang được chọn
                                // Ví dụ:
                                Toast.makeText(requireContext(), "An Giang được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Bạc Liêu":
                                // Code xử lý khi menu item BacLieu được chọn
                                Toast.makeText(requireContext(), "Bạc Liêu được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Bến Tre":
                                // Code xử lý khi menu item BenTre được chọn
                                Toast.makeText(requireContext(), "Bến Tre được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Cà Mau":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cà Mau được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
            }
        });

        Button cuasong = view.findViewById(R.id.CuaSong);
        cuasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.bentre_cuasong, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Xử lý sự kiện khi item được chọn
                        switch (item.getTitle().toString()) {
                            case "Cửa Ba Lai":
                                // Code xử lý khi menu item AnGiang được chọn
                                // Ví dụ:
                                Toast.makeText(requireContext(), "Cửa Ba Lai được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Cửa Cổ Chiên":
                                // Code xử lý khi menu item BacLieu được chọn
                                Toast.makeText(requireContext(), "Cửa Cổ Chiên được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Cửa Đại":
                                // Code xử lý khi menu item BenTre được chọn
                                Toast.makeText(requireContext(), "Cửa Đại được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "Cửa Hàm Luông":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cửa Hàm Luông được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
            }
        });

        Button thoigiandubao = view.findViewById(R.id.ThoiGianDuBao);
        thoigiandubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.thoigiandubao, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Xử lý sự kiện khi item được chọn
                        switch (item.getTitle().toString()) {
                            case "1 tuần tới":
                                // Code xử lý khi menu item AnGiang được chọn
                                // Ví dụ:
                                Toast.makeText(requireContext(), "1 tuần tới được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "2 tuần tới":
                                // Code xử lý khi menu item BacLieu được chọn
                                Toast.makeText(requireContext(), "2 tuần tới được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "1 tháng tới":
                                // Code xử lý khi menu item BenTre được chọn
                                Toast.makeText(requireContext(), "1 tháng tới được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            case "3 tháng tới":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "3 tháng tới được chọn", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
            }
        });

        Button quaylai = view.findViewById(R.id.DoManHienTai_QuayLai);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DoManFragment(), false);
            }
        });

        return view;
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}