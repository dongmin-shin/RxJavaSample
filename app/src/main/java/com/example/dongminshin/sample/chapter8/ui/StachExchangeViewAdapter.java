package com.example.dongminshin.sample.chapter8.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongminshin.rxjavasample.R;
import com.example.dongminshin.sample.chapter8.models.stackexchange.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DongMinShin on 16. 6. 1..
 */
public class StachExchangeViewAdapter extends RecyclerView.Adapter<StachExchangeViewAdapter.ViewHolder> {

    private List<User> userList = new ArrayList<>();

    public StachExchangeViewAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void updateUserList(List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stack_exchange_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.name.setText(user.getDisplayName());
        holder.city.setText(user.getLocation());
        holder.reputation.setText(String.valueOf(user.getReputation()));

        ImageLoader.getInstance().displayImage(user.getProfileImage(), holder.profileImage);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final View itemView;

        @BindView(R.id.stack_exchange_card_view_name)
        TextView name;

        @BindView(R.id.stack_exchange_card_view_city)
        TextView city;

        @BindView(R.id.stack_exchange_card_view_reputition)
        TextView reputation;

        @BindView(R.id.stack_exchange_card_view_profile)
        ImageView profileImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }

}
