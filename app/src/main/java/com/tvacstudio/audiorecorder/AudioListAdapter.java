package com.tvacstudio.audiorecorder;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.yashwanth.audiorecorder.R;

import java.io.File;
import java.net.URLConnection;

import static android.provider.MediaStore.AUTHORITY;
import static android.provider.Settings.Global.getString;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static androidx.core.content.ContextCompat.createDeviceProtectedStorageContext;
import static androidx.core.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.AudioViewHolder> {

    public File[] allFiles;
    private TimeAgo timeAgo;
    private String authorities ="com.tvacstudio.audiorecorder.fileprovider";
    private onItemListClick onItemListClick;
    private AudioListFragment audioListFragment;

    public AudioListAdapter(File[] allFiles, onItemListClick onItemListClick) {
        this.allFiles = allFiles;
        this.onItemListClick = onItemListClick;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        timeAgo = new TimeAgo();
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        holder.list_title.setText(allFiles[position].getName());
        holder.list_date.setText(timeAgo.getTimeAgo(allFiles[position].lastModified()));
    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView list_image;
        private TextView list_title;
        private TextView list_date;
        private ImageView list_share;



        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);
            list_image = itemView.findViewById(R.id.list_image_view);
            list_title = itemView.findViewById(R.id.list_title);
            list_date = itemView.findViewById(R.id.list_date);
            list_share=itemView.findViewById(R.id.list_share);


            list_image.setOnClickListener(this);
            list_share.setOnClickListener(this);

        }






        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.list_image_view:
            onItemListClick.onClickListener(allFiles[getAdapterPosition()], getAdapterPosition());
            break;
                case R.id.list_share:
                    onItemListClick.onClickListener1(allFiles[getAdapterPosition()], getAdapterPosition());
                    break;
            }
        }
    }

    public interface onItemListClick {
        void onClickListener(File file, int position);
        void onClickListener1(File file, int position);
    }

}
