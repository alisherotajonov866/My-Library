package ru.startandroid.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    TextView txtBookName,txtAuthorName,txtPages,txtLongDescription;
    Button btnAddToCurrentlyReading,btnAddToWantToRead,btnAddToAlreadyRead,btnAddToFavorite;
    ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        String longDescription = "Your long book description is a synopsis.  When writing this description, think like a buyer, and not like the author. You must become a master at both show and tell. Show enough to paint the picture, and tell enough to get them interested in what happens next.Any specific highlights should immediately jump off the page" ;

        // TODO: get the data from recycler view in here
        Book book = new Book(1,"Ilm olish sirlari","Imom zarnujiy",150,"https://shamskitoblari.uz/image/cache/catalog/diniy%20adabiyot/ilm%20olish%20sirlari-500x750.jpg","Ilm olish tartib qoidalarini o'rgatuvchi kitob",longDescription);

        setData(book);
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthorName.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages())); // int tipni String tipga o'tirib yozamiz
        txtLongDescription.setText(book.getLongDesc());

        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {

        txtBookName = findViewById(R.id.txtBookName);
        txtAuthorName = findViewById(R.id.txtAuthorName);
        txtPages = findViewById(R.id.txtPages);
        txtLongDescription = findViewById(R.id.txtLongDescription);

        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);

        bookImage = findViewById(R.id.imgBook);
    }
}