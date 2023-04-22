package com.example.food4thought;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowpAdapter extends RecyclerView.Adapter<ShowpAdapter.ViewHolder> {


    ArrayList<Userfood> mList;
    Context context;

    public ShowpAdapter(ArrayList<Userfood> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_list,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Userfood vacancy1 = mList.get(position);
        holder.txtname.setText(vacancy1.getHotelname());
        holder.txtaddress.setText(vacancy1.getStatus());
//        holder.txtprofile.setText(vacancy1.getStatus());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,prodetails.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();

                bundle.putString("proname",vacancy1.getHotelname());
                bundle.putString("address",vacancy1.getDal());
                bundle.putString("area",vacancy1.getSabji());
                bundle.putString("contact",vacancy1.getStatus());
                bundle.putString("criteria",vacancy1.getTime());
                bundle.putString("chapati",vacancy1.getChapati());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtname,txtaddress,txtprofile;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtaddress);
//            txtprofile = itemView.findViewById(R.id.txtprofile);
            layout = itemView.findViewById(R.id.relative);

        }
    }
}
