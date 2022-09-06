package ru.startandroid.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    TextView txtBookName,txtAuthorName,txtPages,txtDescription;
    Button btnAddToCurrentlyReading,btnAddToWantToRead,btnAddToAlreadyRead,btnAddToFavorite;
    ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        // TODO: get the data from recycler view in here
        Book book = new Book(1,"Ilm olish sirlari","Imom zarnujiy",150,"https://shamskitoblari.uz/image/cache/catalog/diniy%20adabiyot/ilm%20olish%20sirlari-500x750.jpg","Ilm olish tartib qoidalarini o'rgatuvchi kitob","Long description");

        setData(book);
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthorName.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages())); // int tipni String tipga o'tirib yozamiz
        txtDescription.setText(book.getLongDesc());

        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {

        txtBookName = findViewById(R.id.txtBookName);
        txtAuthorName = findViewById(R.id.txtAuthorName);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);

        bookImage = findViewById(R.id.imgBook);
    }
}