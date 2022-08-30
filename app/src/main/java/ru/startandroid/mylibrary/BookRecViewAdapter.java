package ru.startandroid.mylibrary;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookRecViewAdapter {

    // ViewHolder deb nomlangan class yaratdik va u RecyclerView.ViewHolder dan meros oldi
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
