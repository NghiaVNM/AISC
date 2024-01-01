package com.example.salty;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CongViecFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CongViecFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CongViecFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CongViecFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CongViecFragment newInstance(String param1, String param2) {
        CongViecFragment fragment = new CongViecFragment();
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
        View view = inflater.inflate(R.layout.fragment_cong_viec, container, false);

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

        Button pt = view.findViewById(R.id.pt);

        CheckBox cb1 = view.findViewById(R.id.checkBox1);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb2 = view.findViewById(R.id.checkBox2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb3 = view.findViewById(R.id.checkBox3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb4 = view.findViewById(R.id.checkBox4);
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb5 = view.findViewById(R.id.checkBox5);
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb6 = view.findViewById(R.id.checkBox6);
        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb7 = view.findViewById(R.id.checkBox7);
        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });

        CheckBox cb8 = view.findViewById(R.id.checkBox8);
        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now += 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                } else {
                    Float now = Float.parseFloat(pt.getText().toString()
                            .substring(0, pt.getText().toString().length() - 2));

                    now -= 12.5f;
                    pt.setText(String.valueOf(now) + " %");
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}