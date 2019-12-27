package com.pullein.divider.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pullein.divider.R;

import java.util.Arrays;
import java.util.List;

/**
 * RecyclerView Item Decoration<br>
 * describe ：表格布局适配器
 *
 * @author xugang
 * @date 2019/12/27
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private List<String> mData;

    public GridAdapter(Context context) {
        this.mData = Arrays.asList(context.getResources().getStringArray(R.array.grid_data));
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
