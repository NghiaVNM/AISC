
package com.example.salty;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DuBaoDoManFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DuBaoDoManFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String _vitri = "";
    private String _cuasong = "";
    private String _tram = "";
    private String _thoigian = "";

    public DuBaoDoManFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DuBaoDoManFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DuBaoDoManFragment newInstance(String param1, String param2) {
        DuBaoDoManFragment fragment = new DuBaoDoManFragment();
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
        View view = inflater.inflate(R.layout.fragment_du_bao_do_man, container, false);

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
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Bạc Liêu":
                                // Code xử lý khi menu item BacLieu được chọn
                                Toast.makeText(requireContext(), "Bạc Liêu được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);

                                return true;
                            case "Bến Tre":
                                // Code xử lý khi menu item BenTre được chọn
                                Toast.makeText(requireContext(), "Bến Tre được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Cà Mau":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cà Mau được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Cần Thơ":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cần Thơ được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Đồng Tháp":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Đồng Tháp được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Hậu Giang":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Hậu Giang được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Kiên Giang":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Kiên Giang được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Long An":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Long An được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Sóc Trăng":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Sóc Trăng được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Tền Giang":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Tền Giang được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Trà Vinh":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Trà Vinh được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
                                return true;
                            case "Vĩnh Long":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Vĩnh Long được chọn", Toast.LENGTH_SHORT).show();
                                _vitri = item.getTitle().toString();
                                vitri.setText(_vitri);
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

                if(_vitri == "") {
                    Toast.makeText(requireContext(), "Hãy chọn vị trí", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if (!_vitri.equals("Bến Tre")) {
                    Toast.makeText(requireContext(), "Rất tiếc. Hiện tại chỉ hỗ trợ vị trí Bến Tre", Toast.LENGTH_SHORT).show();
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.bentre_cuasong, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Xử lý sự kiện khi item được chọn
                        _cuasong = item.getTitle().toString();
                        switch (item.getTitle().toString()) {
                            case "Ba Lai":
                                // Code xử lý khi menu item AnGiang được chọn
                                // Ví dụ:
                                Toast.makeText(requireContext(), "Cửa Ba Lai được chọn", Toast.LENGTH_SHORT).show();
                                cuasong.setText(_cuasong);
                                return true;
                            case "Cổ Chiên":
                                // Code xử lý khi menu item BacLieu được chọn
                                Toast.makeText(requireContext(), "Cửa Cổ Chiên được chọn", Toast.LENGTH_SHORT).show();
                                cuasong.setText(_cuasong);
                                return true;
                            case "Cửa Đại":
                                // Code xử lý khi menu item BenTre được chọn
                                Toast.makeText(requireContext(), "Cửa Đại được chọn", Toast.LENGTH_SHORT).show();
                                cuasong.setText(_cuasong);
                                return true;
                            case "Hàm Luông":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cửa Hàm Luông được chọn", Toast.LENGTH_SHORT).show();
                                cuasong.setText(_cuasong);
                                return true;
                            case "An Hóa":
                                // Code xử lý khi menu item CaMau được chọn
                                Toast.makeText(requireContext(), "Cửa An Hóa được chọn", Toast.LENGTH_SHORT).show();
                                cuasong.setText(_cuasong);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();


            }
        });

        Button tram = view.findViewById(R.id.Tram);
        tram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (_cuasong.equals("")) {
                    Toast.makeText(requireContext(), "Hãy chọn cửa sông: ", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                switch (_cuasong) {
                    case "An Hóa":
                        Toast.makeText(requireContext(), "Menu An Hoa", Toast.LENGTH_SHORT).show();
                        popupMenu.getMenuInflater().inflate(R.menu.tram_anhoa, popupMenu.getMenu());
                        // Xử lý sự kiện khi một item trong PopupMenu được chọn
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                _tram = item.getTitle().toString();
                                switch (item.getTitle().toString()) {
                                    case "Giao Hòa":
                                        // Code xử lý khi menu item AnGiang được chọn
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Giao Hòa được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                        return;

                    case "Ba Lai":
                        popupMenu.getMenuInflater().inflate(R.menu.tram_balai, popupMenu.getMenu());
                        // Xử lý sự kiện khi một item trong PopupMenu được chọn
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                switch (item.getTitle().toString()) {
                                    case "Long Hòa":
                                        // Ví dụ:

                                        _tram = item.getTitle().toString();
                                        tram.setText(_tram);
                                        Toast.makeText(requireContext(), "Trạm Long Hòa được chọn", Toast.LENGTH_SHORT).show();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                        return;

                    case "Cổ Chiên":
                        popupMenu.getMenuInflater().inflate(R.menu.tram_cochien, popupMenu.getMenu());
                        // Xử lý sự kiện khi một item trong PopupMenu được chọn
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                _tram = item.getTitle().toString();
                                switch (item.getTitle().toString()) {
                                    case "Bến Trại":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Bến Trại được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Hương Mỹ":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Hương Mỹ được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Thành Thới":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Thành Thới được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                        return;

                    case "Cửa Đại":
                        popupMenu.getMenuInflater().inflate(R.menu.tram_cuadai, popupMenu.getMenu());
                        // Xử lý sự kiện khi một item trong PopupMenu được chọn
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                _tram = item.getTitle().toString();
                                switch (item.getTitle().toString()) {
                                    case "Bình Đại":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Bình Đại được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Lộc Thuận":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Lộc Thuận được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Giao Long":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Giao Long được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                        return;

                    case "Hàm Luông":
                        popupMenu.getMenuInflater().inflate(R.menu.tram_hamluong, popupMenu.getMenu());
                        // Xử lý sự kiện khi một item trong PopupMenu được chọn
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                _tram = item.getTitle().toString();
                                switch (item.getTitle().toString()) {
                                    case "An Thuận":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm An Thuận được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Phú Khánh":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Phú Khánh được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Sơn Đốc":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Sơn Đốc được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Mỹ Hóa":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Mỹ Hóa được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    case "Vàm Mơn":
                                        // Ví dụ:
                                        Toast.makeText(requireContext(), "Trạm Vàm Mơn được chọn", Toast.LENGTH_SHORT).show();
                                        tram.setText(_tram);
                                        _tram = item.getTitle().toString();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popupMenu.show();
                        return;

                }



            }
        });

        Button thoigian = view.findViewById(R.id.DuBao);
        thoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(_tram == "") {
                    Toast.makeText(requireContext(), "Hãy chọn trạm", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(requireContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.thoi_gian, popupMenu.getMenu());

                // Xử lý sự kiện khi một item trong PopupMenu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Xử lý sự kiện khi item được chọn

                        switch (item.getTitle().toString()) {
                            case "1 tuần tới":
                                // Code xử lý khi menu item AnGiang được chọn
                                // Ví dụ:
                                _thoigian = item.getTitle().toString();
                                thoigian.setText(_thoigian);
                                return true;
                            case "2 tuần tới":
                                // Code xử lý khi menu item BacLieu được chọn
                                _thoigian = item.getTitle().toString();
                                thoigian.setText(_thoigian);
                                return true;
                            case "1 tháng tới":
                                // Code xử lý khi menu item BenTre được chọn
                                _thoigian = item.getTitle().toString();
                                thoigian.setText(_thoigian);
                                return true;
                            case "3 tháng tới":
                                // Code xử lý khi menu item CaMau được chọn
                                _thoigian = item.getTitle().toString();
                                thoigian.setText(_thoigian);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
            }
        });

        Button xemdubao = view.findViewById(R.id.XemDuBao);
        xemdubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_vitri == "" || _cuasong == "" || _tram == "" || _thoigian == "") {
                    Toast.makeText(
                            requireContext(),
                            "Hãy chọn đầy đủ thông tin",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                LinearLayout xem = view.findViewById(R.id.xem);
                xem.setVisibility(View.VISIBLE);

                TextView mantram = view.findViewById(R.id.mantram);
                mantram.setText(_tram);

                TextView mancuasong = view.findViewById(R.id.mancuasong);
                mancuasong.setText("(" + _cuasong + ")");

                TextView mancua = view.findViewById(R.id.mancua);
                mancua.setText(getCua(_cuasong));

                TextView mandoman = view.findViewById(R.id.mandoman);

                String[] curentDate = date2week();
                if (_thoigian.equals("1 tuần tới")) {
                    curentDate = date1week();
                }

                if (_thoigian.equals("2 tuần tới")) {
                    curentDate = date2week();
                }

                if (_thoigian.equals("1 tháng tới")) {
                    curentDate = date1month();
                }

                if (_thoigian.equals("3 tháng tới")) {
                    curentDate = date3month();
                }


                String p = getPath(_tram);
                getDoMan(
                        p,
                        curentDate[0],
                        curentDate[1],
                        curentDate[2],
                        new DoManHienTaiFragment.OnGetDataListener() {
                            @Override
                            public void onSuccess(String salinity) {
                                Toast.makeText(requireContext(), salinity, Toast.LENGTH_SHORT)
                                        .show();
                                float homnay = Float.parseFloat(salinity);
                                if (homnay <= 0) {
                                    mandoman.setText("0");
                                    return;
                                }
                                if (salinity.length() >= 4) {
                                    // Lấy 4 ký tự đầu tiên từ chuỗi
                                    salinity = salinity.substring(0, 4);
                                }
                                mandoman.setText(salinity);

                                String[] priDate = dateCurrent();
                                getDoMan(
                                        p,
                                        priDate[0],
                                        priDate[1],
                                        priDate[2],
                                        new DoManHienTaiFragment.OnGetDataListener() {
                                            @Override
                                            public void onSuccess(String salinity) {
                                                float homqua = Float.parseFloat(salinity);
                                                Drawable drawable;
                                                if (homnay <= homqua) {
                                                    drawable =
                                                            getResources().getDrawable(R.drawable.baseline_keyboard_double_arrow_down_24);
                                                } else {
                                                    drawable =
                                                            getResources().getDrawable(R.drawable.baseline_keyboard_double_arrow_up_24);
                                                }
                                                mandoman.setCompoundDrawablesWithIntrinsicBounds(
                                                        null,
                                                        null,
                                                        drawable,
                                                        null
                                                );
                                            }

                                            @Override
                                            public void onFailed(String errorMessage) {

                                            }
                                        }
                                );
                            }

                            @Override
                            public void onFailed(String errorMessage) {

                            }
                        }
                );
            }
        });

        TextView bt = view.findViewById(R.id.xemthem);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new GiaiPhapFragment(), false);
            }
        });

        TextView ten1 = view.findViewById(R.id.ten1);
        Button gp1 = view.findViewById(R.id.gp1);
        gp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten1.getText()));
                editor.putString("gp", "1");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        TextView ten4 = view.findViewById(R.id.ten4);
        Button gp4 = view.findViewById(R.id.gp4);
        gp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten4.getText()));
                editor.putString("gp", "4");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        TextView ten10 = view.findViewById(R.id.ten10);
        Button gp10 = view.findViewById(R.id.gp10);
        gp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten10.getText()));
                editor.putString("gp", "10");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });
        return view;
    }

    private String getCua(String cuasong) {
        switch (cuasong) {
            case "Ba Lai":
                return "55 km";
            case "Cửa Đại":
                return "90 km";
            case "An Hóa":
                return "56 km";
            case "Hàm Luông":
                return "70 km";
            case "Cổ Chiên":
                return "82 km";
        }
        return "";
    }

    private String getPath(String tram) {
        switch (tram) {
            case "Long Hòa":
                return "/bentre/balai/longhoa";
            case "Bình Đại":
                return "/bentre/cuadai/binhdai";
            case "Lộc Thuận":
                return "/bentre/cuadai/locthuan";
            case "Giao Long":
                return "/bentre/cuadai/giaolong";
            case "Giao Hòa":
                return "/bentre/anhoa/giaohoa";
            case "An Thuận":
                return "/bentre/hamluong/anthuan";
            case "Phú Khánh":
                return "/bentre/hamluong/phukhanh";
            case "Sơn Đốc":
                return "/bentre/hamluong/sondoc";
            case "Mỹ Hóa":
                return "/bentre/hamluong/myhoa";
            case "Vàm Mơn":
                return "/bentre/hamluong/vammon";
            case "Bến Trại":
                return "/bentre/cochien/bentrai";
            case "Hương Mỹ":
                return "/bentre/cochien/huongmy";
            case "Thành Thới":
                return "/bentre/cochien/thanhthoi";
        }
        return "";
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

    private void getDoMan(String pathdb, String date, String month, String year, final DoManHienTaiFragment.OnGetDataListener listener) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(pathdb);
        Query query = databaseReference.orderByChild("Year").equalTo(year);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String salinity = "";
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String snapshotMonth = snapshot.child("Month").getValue(String.class);
                        String snapshotDate = snapshot.child("Date").getValue(String.class);
                        if (snapshotMonth.equals(month) && snapshotDate.equals(date)) {
                            salinity = snapshot.child("Salinity").getValue(String.class);
                            Log.d("FirebaseQuery", "Found: " + salinity);
                            break;
                        }
                    }
                } else {
                    Log.d("FirebaseQuery", "Không tìm thấy");
                }
                listener.onSuccess(salinity); // Trả về salinity nếu tìm thấy
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("FirebaseQuery", "Error: " + databaseError.getMessage());
                listener.onFailed(databaseError.getMessage()); // Trả về thông báo lỗi nếu có
            }
        });
    }

    public interface OnGetDataListener {
        void onSuccess(String salinity);

        void onFailed(String errorMessage);
    }


    public String[] dateCurrent() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Lấy ngày, tháng, năm của ngày hiện tại
        String currentDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String currentMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String currentYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hiện tại
        return new String[]{currentDay, currentMonth, currentYear};
    }

    public String[] dateYesterday() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Trừ đi 1 ngày để lấy ngày hôm qua
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        // Lấy ngày, tháng, năm của ngày hôm qua
        String yesterdayDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String yesterdayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String yesterdayYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hôm qua
        return new String[]{yesterdayDay, yesterdayMonth, yesterdayYear};
    }

    public String[] date1week() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Trừ đi 1 ngày để lấy ngày hôm qua
        calendar.add(Calendar.DAY_OF_MONTH, 7);

        // Lấy ngày, tháng, năm của ngày hôm qua
        String yesterdayDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String yesterdayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String yesterdayYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hôm qua
        return new String[]{yesterdayDay, yesterdayMonth, yesterdayYear};
    }

    public String[] date2week() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Trừ đi 1 ngày để lấy ngày hôm qua
        calendar.add(Calendar.DAY_OF_MONTH, 14);

        // Lấy ngày, tháng, năm của ngày hôm qua
        String yesterdayDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String yesterdayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String yesterdayYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hôm qua
        return new String[]{yesterdayDay, yesterdayMonth, yesterdayYear};
    }

    public String[] date1month() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Trừ đi 1 ngày để lấy ngày hôm qua
        calendar.add(Calendar.DAY_OF_MONTH, 30);

        // Lấy ngày, tháng, năm của ngày hôm qua
        String yesterdayDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String yesterdayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String yesterdayYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hôm qua
        return new String[]{yesterdayDay, yesterdayMonth, yesterdayYear};
    }

    public String[] date3month() {
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();

        // Trừ đi 1 ngày để lấy ngày hôm qua
        calendar.add(Calendar.DAY_OF_MONTH, 90);

        // Lấy ngày, tháng, năm của ngày hôm qua
        String yesterdayDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String yesterdayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Tháng được đếm từ 0, cộng thêm 1
        String yesterdayYear = String.valueOf(calendar.get(Calendar.YEAR));

        // Trả về một mảng chứa ngày, tháng, năm của ngày hôm qua
        return new String[]{yesterdayDay, yesterdayMonth, yesterdayYear};
    }
}