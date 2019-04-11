package com.example.dimov.seilineshto;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    public ArrayList<Item> allItems;
    private Context mContext;
   //private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private String queryUri = Contract.CONTENT_URI.toString();
    private static final String[] projection = new String[]{Contract.CONTENT_PATH};
    private String selectionClause = null;
    private String selectionArgs[] = null;
    private String sortOrder = "ASC";

    String word = "";
    int id=-1;
    Cursor cursor;

    public RecyclerViewAdapter(Context mContext, ArrayList<Item> allItems) {
        this.mContext = mContext;
        this.allItems = allItems;
        cursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.Name.setText(allItems.get(i).getName());
        viewHolder.Date.setText(allItems.get(i).getDate());
        viewHolder.Score.setText(allItems.get(i).getScore());
        viewHolder.show();
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Score;
        Button deleteButton;
        TextView Date;
        ConstraintLayout listItemLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.itemName);
            Date = itemView.findViewById(R.id.date);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            listItemLayout = itemView.findViewById(R.id.listItem_layout);
            Score = itemView.findViewById(R.id.score);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    int listSize = allItems.size();
                    selectionArgs = new String[]{allItems.get(position).getDate()};
                    mContext.getContentResolver().delete(Contract.CONTENT_URI, Contract.CONTENT_PATH, selectionArgs);
                    allItems.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, listSize);
                }
            });


        }



        public void show(){
            Name.setVisibility(View.VISIBLE);
            Date.setVisibility(View.VISIBLE);
            deleteButton.setVisibility(View.VISIBLE);
            listItemLayout.setVisibility(View.VISIBLE);
            Score.setVisibility(View.VISIBLE);
        }

    }
    public void updateAllViews(){
        notifyItemRangeChanged(0, getItemCount());
    }


}
