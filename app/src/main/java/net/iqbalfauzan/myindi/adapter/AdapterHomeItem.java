package net.iqbalfauzan.myindi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.iqbalfauzan.myindi.Model.ModelHome;
import net.iqbalfauzan.myindi.R;

import java.util.List;

public class AdapterHomeItem extends RecyclerView.Adapter<AdapterHomeItem.Holder> {
    private Context context;
    private List<ModelHome>modelHomes;

    public AdapterHomeItem(Context context, List<ModelHome> modelHomes) {
        this.context = context;
        this.modelHomes = modelHomes;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        ModelHome modelHome = modelHomes.get(i);
        holder.text.setText(modelHome.getText());
    }

    @Override
    public int getItemCount() {
        return modelHomes.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
