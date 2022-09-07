package ru.startandroid.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView allBooksRecView;

    private BookRecViewAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        allBooksRecView = findViewById(R.id.allBooksRecView);

        adapter = new BookRecViewAdapter(this);

        // All Books Activity ga adapter ni set qildik
        allBooksRecView.setAdapter(adapter);

        // CardView lar qanday chiqishini ko'rsatamiz bunda bizga GridLayoutManager yordam beradi <- bu o'zgartirildi LinerLayoutManager ga
        allBooksRecView.setLayoutManager(new LinearLayoutManager(this));

        // Bu yerda eng muhim ishlardan biri bo'ldi chunki, malumotlar shu yerda kiritiladi
        // malumotlar arraylist yordamida 'Book" classiga qo'shiladi, keyin boshqa class lardan yena shu "Book" class iga murojat qilib
        // kitob malumotlarini olishimiz mumkun.

        /*

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1,"Ilm olish sirlari","Imom zarnujiy",150,"https://shamskitoblari.uz/image/cache/catalog/diniy%20adabiyot/ilm%20olish%20sirlari-500x750.jpg","Ilm olish tartib qoidalarini o'rgatuvchi kitob","Long description"));
        books.add(new Book(2,"Baxtiyor oila","Shayx Muhammad Sodiq",330,"https://hilolnashr.uz/image/cache/catalog/Baxtiyor_oila_front-500x750.jpg","Oilalarni isloh qilish yo'llari yozilgan kitob","Long description"));

        */

        // arraylist da o'zgarishlar bo'lgan dan (Insert,Update,...) keyin adapter ga arraylist ni set qilish kerak
        adapter.setBooks(Utils.getInstance().getAllBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}