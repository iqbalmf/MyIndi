package net.iqbalfauzan.myindi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.iqbalfauzan.myindi.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentNotif extends Fragment {
    public static FragmentNotif newInstance(){
        return new FragmentNotif();
    }
    @BindView(R.id.listNotif)
    ListView listNotif;
    List<String> notif;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notif, container, false);
        ButterKnife.bind(this, view);

        notif = new ArrayList<>();
        notif.add("Billing Receipt");
        notif.add("Installation Complete");
        notif.add("Registration Complete");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, notif);
        listNotif.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}
