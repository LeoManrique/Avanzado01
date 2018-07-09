package com.example.leonardo.avanzado01.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leonardo.avanzado01.R;

import static android.support.constraint.Constraints.TAG;


public class HomeFragment extends Fragment {
    private TextView bienvenido;
    private SharedPreferences sharedPreferences;
    String nombre;
    String bienvenida;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());;
        //sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        TextView bienvenido = getView().findViewById(R.id.bienvenido);
        nombre = sharedPreferences.getString("firstName", "");
        String bienvenida = "Bienvenido "+nombre;
        bienvenido.setText(bienvenida);


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onCreateView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onCreateView");
    }

}
