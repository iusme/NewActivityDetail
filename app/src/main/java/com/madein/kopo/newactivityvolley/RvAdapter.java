package com.madein.kopo.newactivityvolley;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DataModel> dataModelArrayList;
    private Context context;

    public RvAdapter(Context context, ArrayList<DataModel> dataModelArrayList){

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_one_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RvAdapter.MyViewHolder holder, final int position) {

        holder.name.setText(dataModelArrayList.get(position).getName());
        holder.country.setText(dataModelArrayList.get(position).getCountry());
        holder.city.setText(dataModelArrayList.get(position).getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ActivityTwo.class);

                // passing data to the second activity
                intent.putExtra("Title", dataModelArrayList.get(position).getName());
                intent.putExtra("Description", dataModelArrayList.get(position).getCountry());
                intent.putExtra("Category", dataModelArrayList.get(position).getCity());
                intent.putExtra("Image", dataModelArrayList.get(position).getImgURL());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView country, name, city;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.country);
            name = (TextView) itemView.findViewById(R.id.name);
            city = (TextView) itemView.findViewById(R.id.city);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
