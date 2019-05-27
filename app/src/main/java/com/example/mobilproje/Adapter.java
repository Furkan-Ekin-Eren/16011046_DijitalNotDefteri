package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    ArrayList<Not> mDataList;
    LayoutInflater inflater;
    Context mContext;
    VeriKaynagi vk ;

    public Adapter(Context context,ArrayList<Not> data){
        this.mContext =context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDataList=data;
        vk = new VeriKaynagi(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=inflater.inflate(R.layout.itemm,viewGroup,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Not tiklanilanCustomer=mDataList.get(i);
        myViewHolder.setData(tiklanilanCustomer,i);

      /*  myViewHolder.mCusName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent istek = new Intent(mContext,Ayrinti.class);
                istek.putExtra("aa",tiklanilanCustomer);
                mContext.startActivity(istek);
            }
        }); */

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void deleteItem(Not sil,int i){
        vk.ac();
        mDataList.remove(i);
        notifyItemRemoved(i);
        vk.notSil(sil);
        vk.kapa();
    }

    public void showItem(Not show){
        Intent istek = new Intent(mContext,not_show.class);
        istek.putExtra("title",show.getTitle());
        istek.putExtra("content",show.getContent());
        istek.putExtra("id",show.getId());
        istek.putExtra("pri",show.getPri());
        mContext.startActivity(istek);

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,content,date;
        LinearLayout line;
        int position=0;
        Not kopyanot;
        ImageView sil,prir;

        public MyViewHolder(View itemView){
            super(itemView);
            line = itemView.findViewById(R.id.Not_layout);
            title =itemView.findViewById(R.id.Not_title);
            content =itemView.findViewById(R.id.Not_content);
            date =itemView.findViewById(R.id.Not_date);
            sil = itemView.findViewById(R.id.sil_image);
            prir=itemView.findViewById(R.id.pri_image);

            sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(kopyanot,position);
                }
            });
            line.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showItem(kopyanot);
                }
            });
        }

        public void setData(Not tiklanılanNot, int i) {
            this.title.setText(tiklanılanNot.getTitle());
            this.content.setText(tiklanılanNot.getContent());
            this.date.setText(tiklanılanNot.getDate());
            this.position=i;
            if(tiklanılanNot.getPri()==1){
                prir.setVisibility(View.VISIBLE);
            }
            kopyanot = tiklanılanNot;
        }
    }

}
