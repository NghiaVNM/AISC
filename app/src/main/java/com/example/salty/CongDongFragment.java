package com.example.salty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CongDongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CongDongFragment extends Fragment {
    private TextView textView;
    private DatabaseReference databaseReference;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CongDongFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CongDongFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CongDongFragment newInstance(String param1, String param2) {
        CongDongFragment fragment = new CongDongFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false); // Hiển thị nút quay lại
        }

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cong_dong, container, false);

        textView = view.findViewById(R.id.CongDong_view); // Ánh xạ TextView

        Button buttonLoadData = view.findViewById(R.id.LoadData);
        databaseReference = FirebaseDatabase.getInstance().getReference("/user/-NmlJNn65VSWk8vLkFjg");

        buttonLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String email = dataSnapshot.child("Email").getValue(String.class);
                            String fullName = dataSnapshot.child("Ho va ten").getValue(String.class);
                            String password = dataSnapshot.child("Password").getValue(String.class);
                            String homeTown = dataSnapshot.child("Que quan").getValue(String.class);

                            String userData = "Email: " + email + "\n" +
                                    "Full Name: " + fullName + "\n" +
                                    "Password: " + password + "\n" +
                                    "Home Town: " + homeTown;

                            if (textView != null) {
                                textView.setText(userData); // Kiểm tra textView khác null trước khi gọi setText()
                            }
                        } else {
                            if (textView != null) {
                                textView.setText("Data does not exist");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        if (textView != null) {
                            textView.setText("Error: " + databaseError.getMessage());
                        }
                    }
                });
            }
        });

        return view;
    }
}