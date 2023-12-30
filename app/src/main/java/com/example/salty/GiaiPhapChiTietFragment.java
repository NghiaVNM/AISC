package com.example.salty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.net.URI;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GiaiPhapChiTietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiaiPhapChiTietFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private DatabaseReference databaseReference;

    public GiaiPhapChiTietFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiaiPhapChiTietFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiaiPhapChiTietFragment newInstance(String param1, String param2) {
        GiaiPhapChiTietFragment fragment = new GiaiPhapChiTietFragment();
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
        View view = inflater.inflate(R.layout.fragment_giai_phap_chi_tiet, container, false);

        SharedPreferences prefs = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE);
        String tengp = prefs.getString("ten", "default_value");
        String hinhgp = prefs.getString("gp", "default_value");
        int _hinh = getResources().getIdentifier("giaiphap" + hinhgp, "drawable", getActivity().getPackageName());

        ImageView hinh = view.findViewById(R.id.hinh);
        hinh.setImageResource(_hinh);

        TextView ten = view.findViewById(R.id.tengiaiphap);
        TextView loai = view.findViewById(R.id.loai);
        TextView chiphi = view.findViewById(R.id.chiphi);
        TextView doman = view.findViewById(R.id.doman);
        TextView cach = view.findViewById(R.id.cach);

        getId(tengp, new OnGetDataListener() {
            @Override
            public void onSuccess(String id) {
                // Sử dụng giá trị id ở đây
                // Ví dụ: Log hoặc thực hiện các thao tác khác
                Log.d("FirebaseQuery", "Received ID: " + id);
                databaseReference = FirebaseDatabase.getInstance().getReference("/giaiphap/" + id);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String _ten = dataSnapshot.child("ten").getValue(String.class);
                            String _loai = dataSnapshot.child("loai").getValue(String.class);
                            String _toithieu = dataSnapshot.child("toithieu").getValue(String.class);
                            String _toida = dataSnapshot.child("toida").getValue(String.class);
                            String _chiphi = dataSnapshot.child("chiphi").getValue(String.class);
                            String _link = dataSnapshot.child("link").getValue(String.class);
                            Integer _socach = Integer.parseInt(dataSnapshot.child("socach").getValue(String.class));
                            String[] _cach = new String[_socach + 1];
                            for (int i = 1; i <= _socach; i++) {
                                _cach[i] = dataSnapshot.child("cach/" + String.valueOf(i)).getValue(String.class);
                            }


                            if (ten != null) {
                                ten.setText(_ten);
                                loai.setText(_loai);
                                doman.setText(_toithieu + " - " + _toida);
                                chiphi.setText(_chiphi);
                                String cach_chi_tiet = "";
                                for (int i = 1; i <= _socach; i++) {
                                    cach_chi_tiet += String.valueOf(i) + ". " + _cach[i] + "\n";
                                }
                                cach.setText(cach_chi_tiet);

                                Button donvi = view.findViewById(R.id.donvi); // Thay R.id.button bằng ID của Button bạn muốn sử dụng
                                donvi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {


                                        // Địa chỉ URL bạn muốn chuyển hướng đến
                                        String url = _link; // Thay đổi URL của trang web bạn muốn mở

                                        // Tạo Intent để mở trình duyệt web
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + _link));
                                        startActivity(intent);;
                                    }
                                });
                            }
                        } else {
                            if (cach != null) {
                                cach.setText("Data does not exist");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        if (cach != null) {
                            cach.setText("Error: " + databaseError.getMessage());
                        }
                    }
                });
            }

            @Override
            public void onFailed(String errorMessage) {
                // Xử lý thông báo lỗi nếu có
                Log.d("FirebaseQuery", "Error: " + errorMessage);
            }
        });



        return view;
    }

    private void getId(String ten, final OnGetDataListener listener) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/giaiphap/");
        Query query = databaseReference.orderByChild("ten").equalTo(ten);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String id = "";
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        id = snapshot.getKey();
                        Log.d("FirebaseQuery", "ID của mục có 'ten' là '" + ten + "' là: " + id);
                    }
                } else {
                    Log.d("FirebaseQuery", "Không tìm thấy mục có 'ten' là '" + ten + "'");
                }
                listener.onSuccess(id); // Trả về giá trị id thông qua callback
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("FirebaseQuery", "Error: " + databaseError.getMessage());
                listener.onFailed(databaseError.getMessage()); // Trả về thông báo lỗi nếu có
            }
        });
    }

    public interface OnGetDataListener {
        void onSuccess(String id);

        void onFailed(String errorMessage);
    }
}