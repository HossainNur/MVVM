package com.example.mvvmdesignproject.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmdesignproject.R;
import com.example.mvvmdesignproject.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.textView.setText(users[position].getLogin());
        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageId);
            textView= itemView.findViewById(R.id.textId);
        }
    }
}
