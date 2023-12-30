package com.example.salty;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GiaiPhapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiaiPhapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GiaiPhapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiaiPhapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiaiPhapFragment newInstance(String param1, String param2) {
        GiaiPhapFragment fragment = new GiaiPhapFragment();
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
        View view = inflater.inflate(R.layout.fragment_giai_phap, container, false);

        TextView ten1, ten2, ten3, ten4, ten5, ten6, ten7, ten8, ten9, ten10, ten11, ten12;
        ten1 = view.findViewById(R.id.ten1);
        ten2 = view.findViewById(R.id.ten2);
        ten3 = view.findViewById(R.id.ten3);
        ten4 = view.findViewById(R.id.ten4);
        ten5 = view.findViewById(R.id.ten5);
        ten6 = view.findViewById(R.id.ten6);
        ten7 = view.findViewById(R.id.ten7);
        ten8 = view.findViewById(R.id.ten8);
        ten9 = view.findViewById(R.id.ten9);
        ten10 = view.findViewById(R.id.ten10);
        ten11 = view.findViewById(R.id.ten11);
        ten12 = view.findViewById(R.id.ten12);

        Button gp1, gp2, gp3, gp4, gp5, gp6, gp7, gp8, gp9, gp10, gp11, gp12;
        gp1 = view.findViewById(R.id.gp1);
        gp2 = view.findViewById(R.id.gp2);
        gp3 = view.findViewById(R.id.gp3);
        gp4 = view.findViewById(R.id.gp4);
        gp5 = view.findViewById(R.id.gp5);
        gp6 = view.findViewById(R.id.gp6);
        gp7 = view.findViewById(R.id.gp7);
        gp8 = view.findViewById(R.id.gp8);
        gp9 = view.findViewById(R.id.gp9);
        gp10 = view.findViewById(R.id.gp10);
        gp11 = view.findViewById(R.id.gp11);
        gp12 = view.findViewById(R.id.gp12);

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

        gp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten2.getText()));
                editor.putString("gp", "2");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten3.getText()));
                editor.putString("gp", "3");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

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

        gp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten5.getText()));
                editor.putString("gp", "5");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten6.getText()));
                editor.putString("gp", "6");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten7.getText()));
                editor.putString("gp", "7");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten8.getText()));
                editor.putString("gp", "8");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten9.getText()));
                editor.putString("gp", "9");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

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

        gp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten11.getText()));
                editor.putString("gp", "11");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
            }
        });

        gp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("giai_phap", Context.MODE_PRIVATE).edit();
                editor.putString("ten", String.valueOf(ten12.getText()));
                editor.putString("gp", "12");
                editor.apply();

                loadFragment(new GiaiPhapChiTietFragment(), false);
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