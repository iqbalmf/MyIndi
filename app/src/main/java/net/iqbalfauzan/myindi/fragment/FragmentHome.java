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

import net.iqbalfauzan.myindi.Model.ModelHome;
import net.iqbalfauzan.myindi.Model.Promo;
import net.iqbalfauzan.myindi.R;
import net.iqbalfauzan.myindi.adapter.AdapterHomeItem;
import net.iqbalfauzan.myindi.adapter.AdapterPromosi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentHome extends Fragment {
    public static FragmentHome newInstance() {
        return new FragmentHome();
    }
    @BindView(R.id.list_item)RecyclerView list_item;
    @BindView(R.id.list_promo)RecyclerView list_promo;
    List<ModelHome> modelHomes;
    List<String> modelPromosis;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        list_item.setHasFixedSize(true);
        list_item.setLayoutManager(new LinearLayoutManager(getActivity()));
        list_promo.setHasFixedSize(true);
        list_promo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        modelHomes = new ArrayList<>();
        modelPromosis = new ArrayList<>();
        modelPromosis.add("https://1.bp.blogspot.com/-1HFxRTuebRo/V5NnRarF5qI/AAAAAAAAA5U/uMx8SkCB54gOe6fI4ej5jsGfNQ5IYhNDQCLcB/s1600/pengertian-promosi.jpg");
        modelPromosis.add("https://1.bp.blogspot.com/-1B78cJE3q6c/V6AowdtSLBI/AAAAAAAAAPc/h6GDdamwEs0EQQu53C593ZsK3HrFr7SuwCLcB/s1600/promotions-a-prix-fou.jpg");
        AdapterPromosi adapterPromosi = new AdapterPromosi(getActivity(), modelPromosis);
        list_promo.setAdapter(adapterPromosi);
        adapterPromosi.notifyDataSetChanged();
        item();
        return view;
    }
    private void item(){
        for (int i=0;i<5;i++){
            ModelHome modelHome = new ModelHome();
            modelHome.setText("Ajak Temanmu Gabung dapatkan voucher menarik!");
            modelHome.setText("Share lewat social mediamu, dapatkan voucher menarik!");
            modelHome.setText("Ajak Temanmu Gabung dapatkan voucher menarik!");
            modelHome.setText("Share lewat social mediamu, dapatkan voucher menarik!");
            modelHomes.add(modelHome);
        }
        AdapterHomeItem adapter = new AdapterHomeItem(getActivity(), modelHomes);
        list_item.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
