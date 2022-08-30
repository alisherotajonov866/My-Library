package ru.startandroid.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks,btnCurrentlyReading,btnAlready,btnWantRead,btnFavourite,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlready = findViewById(R.id.btnAlreadyReadBook);
        btnWantRead = findViewById(R.id.btnWantToRead);
        btnFavourite = findViewById(R.id.btnFavorite);
        btnAbout = findViewById(R.id.btnAbout);
    }
}