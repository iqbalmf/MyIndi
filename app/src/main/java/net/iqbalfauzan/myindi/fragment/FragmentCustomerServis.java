package net.iqbalfauzan.myindi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.iqbalfauzan.myindi.R;

public class FragmentCustomerServis extends Fragment {
    public static FragmentCustomerServis newInstance(){
        return new FragmentCustomerServis();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_customer_servis, container, false);
        return view;
    }
}
