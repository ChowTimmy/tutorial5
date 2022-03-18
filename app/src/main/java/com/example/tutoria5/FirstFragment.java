package com.example.tutoria5;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    DatapassLitener mCallback;
    public interface DatapassLitener{
        public void passDatafromFirst2Second(String data);
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try{
            mCallback = (DatapassLitener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement DataPassListener");
        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        String strtext = getArguments().getString("key");
        TextView t = view.findViewById(R.id.firstfragment);
        t.setText(strtext);

        Button passDataButton = view.findViewById(R.id.passDataButton);
        passDataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.passDataButton){
                    mCallback.passDatafromFirst2Second("louis;s123456;male;hk");
                    Log.d("Louis","passDataButton clicked");
                }
            }

        });
        return view;
    }
}