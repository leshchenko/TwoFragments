package com.example.twofragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

interface FirstFragmentCallback {
    void sendDataToSecondFragment(String data);
}

public class FragmentFirst extends Fragment {

    private EditText editText;
    private FirstFragmentCallback firstFragmentCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstFragmentCallback = (FirstFragmentCallback) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.dataEditText);
        view.findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstFragmentCallback != null) {
                    firstFragmentCallback.sendDataToSecondFragment(editText.getText().toString());
                }
            }
        });
    }

    void clearEditText() {
        editText.setText(null);
    }
}
