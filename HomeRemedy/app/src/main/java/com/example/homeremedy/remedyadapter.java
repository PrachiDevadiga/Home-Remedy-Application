package com.example.homeremedy;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class remedyadapter extends RecyclerView.Adapter<remedyadapter.MyViewHolder> {
    List<remedies> remedyList;

    public remedyadapter(List<remedies> remedyList){
        this.remedyList=remedyList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        remedies remedy=remedyList.get(position);
        holder.myProjTxt.setText(remedy.getMyProj());
        holder.remedyTxt.setText(remedy.getRemedy());
        holder.descriptionTxt.setText(remedy.getDescription());
        holder.img1.setImageResource(remedy.getImageResource());

        boolean isExpand=remedyList.get(position).isExpand();
        holder.expandLayout.setVisibility(isExpand ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return remedyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myProjTxt,remedyTxt,descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandLayout;
        CircleImageView img1;
        public MyViewHolder(View itemView){
            super(itemView);

            myProjTxt=itemView.findViewById(R.id.text);
            remedyTxt=itemView.findViewById(R.id.text2);
            descriptionTxt=itemView.findViewById(R.id.textView3);

            linearLayout=itemView.findViewById(R.id.linear);
            expandLayout=itemView.findViewById(R.id.expand);
            img1 = itemView.findViewById(R.id.img1);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    remedies remedy=remedyList.get(getAdapterPosition());
                    remedy.setExpand(!remedy.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }


    }

}

