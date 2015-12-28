package com.luteng.lesson1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //TODO:找到 TextView
        //String s =
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //修改内容的时候；
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.fragment_tv);
        String text = getArguments().getString("text");
        textView.setText(text);
    }

    public static BlankFragment newInstance(String text){
        Bundle args = new Bundle();
        BlankFragment fragment = new BlankFragment();
        args.putString("text",text);
        fragment.setArguments(args);
        return fragment;
    }


}
