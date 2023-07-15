package com.example.twofragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

interface SecondFragmentCallback {
    void clearEditText();
}

public class FragmentSecond extends Fragment {
    private TextView dataTextView;
    private Button clearButton;

    private SecondFragmentCallback secondFragmentCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondFragmentCallback = (SecondFragmentCallback) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataTextView = view.findViewById(R.id.receivedDataTextView);
        clearButton = view.findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondFragmentCallback != null) {
                    secondFragmentCallback.clearEditText();
                }
            }
        });
    }

    void displayData(String data) {
        dataTextView.setText(data);
    }
}
