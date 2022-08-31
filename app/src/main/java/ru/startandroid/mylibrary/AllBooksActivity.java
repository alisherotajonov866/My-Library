package ru.startandroid.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView allBooksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        allBooksRecView = findViewById(R.id.allBooksRecView);
    }
}