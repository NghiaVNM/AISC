package com.example.salty;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChinhSuaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChinhSuaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChinhSuaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChinhSuaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChinhSuaFragment newInstance(String param1, String param2) {
        ChinhSuaFragment fragment = new ChinhSuaFragment();
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
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_chinh_sua, container, false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true); // Hiển thị nút quay lại
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút quay lại được nhấn
                // Ví dụ: Quay lại Fragment trước đó hoặc Activity gọi Fragment này
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack(); // Quay lại Fragment trước đó
                } else {
                    requireActivity().onBackPressed(); // Quay lại Activity gọi Fragment này
                }
                actionBar.setDisplayHomeAsUpEnabled(false);
            }
        });

        Button btthem = view.findViewById(R.id.btthem);
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout xem = view.findViewById(R.id.them);
                xem.setVisibility(View.VISIBLE);
                LinearLayout xem2 = view.findViewById(R.id.them);
                xem2.setVisibility(View.GONE);
            }
        });

        Button themgiong = view.findViewById(R.id.themgiong);
        themgiong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout after = view.findViewById(R.id.after);
                after.setVisibility(View.VISIBLE);
            }
        });

        Button loai = view.findViewById(R.id.Loai);
        loai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.loai, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        loai.setText("Lúa");
                        Toast.makeText(requireContext(), "Loại lúa được chọn", Toast.LENGTH_SHORT).show();
                        // Xử lý sự kiện khi item được chọn
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        Button giong = view.findViewById(R.id.Giong);
        giong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.giong_lua, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        giong.setText("ST25");
                        Toast.makeText(requireContext(), "Loại lúa được chọn", Toast.LENGTH_SHORT).show();
                        // Xử lý sự kiện khi item được chọn
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        Button luu = view.findViewById(R.id.luu);
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("lua", Context.MODE_PRIVATE).edit();
                editor.putString("add", "yes");
                editor.apply();

                loadFragment(new TheoDoiFragment(), false);
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