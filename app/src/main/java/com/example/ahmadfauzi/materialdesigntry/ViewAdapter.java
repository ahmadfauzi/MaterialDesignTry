package com.example.ahmadfauzi.materialdesigntry;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ahmad Fauzi on 9/11/2015.
 */
public class ViewAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context context;
    private ClickListener clickListener;

    public ViewAdapter (Context context, List<Information> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View view = inflater.inflate(R.layout.drawer_header, parent, false);
            HeaderHolder holder = new HeaderHolder(view);
            return holder;
        } else {
            View view = inflater.inflate(R.layout.custom_row, parent, false);
            ItemHolder holder = new ItemHolder(view);
            return holder;
        }
    }

    @Override
    public int getItemViewType(int position){
        if(position == 0){
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder){

        } else {
            ItemHolder itemHolder = (ItemHolder) holder;
            Information current = data.get(position-1);
            itemHolder.title.setText(current.title);
            itemHolder.icon.setImageResource(current.iconId);
        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        public ItemHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder{
        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
