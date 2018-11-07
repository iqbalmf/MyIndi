package net.iqbalfauzan.myindi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.iqbalfauzan.myindi.R;

import java.util.List;

public class AdapterPromosi extends RecyclerView.Adapter<AdapterPromosi.Holder> {
    private Context context;
    private List<String> modelPromosis;

    public AdapterPromosi(Context context, List<String> modelPromosis) {
        this.context = context;
        this.modelPromosis = modelPromosis;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_promosi, parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String modelPromosi = modelPromosis.get(position);
        Log.i("ADAPTER", "onBindViewHolder: "+modelPromosi);
        Glide.with(context).load(modelPromosi).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return modelPromosis.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView gambar;
        public Holder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
        }
    }
}
