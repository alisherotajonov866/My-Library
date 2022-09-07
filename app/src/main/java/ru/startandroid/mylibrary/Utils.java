package ru.startandroid.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance ;

    private static ArrayList<Book> allBooks ;
    private static ArrayList<Book> alreadyReadBooks ;
    private static ArrayList<Book> wantToReadBooks ;
    private static ArrayList<Book> currentlyReadingBooks ;
    private static ArrayList<Book> favoriteBooks ;

    //
    private Utils() {

        //
        if (allBooks == null){
            allBooks = new ArrayList<>();
            initData();
        }

        if (alreadyReadBooks == null){
            alreadyReadBooks = new ArrayList<>();

        }

        if (wantToReadBooks == null){
            wantToReadBooks = new ArrayList<>();

        }

        if (currentlyReadingBooks == null){
            currentlyReadingBooks = new ArrayList<>();

        }

        if (favoriteBooks == null){
            favoriteBooks = new ArrayList<>();

        }
    }

    //
    private void initData() {
        //TODO: add initial data

        allBooks.add(new Book(1,"Ilm olish sirlari","Imom zarnujiy",150,"https://shamskitoblari.uz/image/cache/catalog/diniy%20adabiyot/ilm%20olish%20sirlari-500x750.jpg","Ilm olish tartib qoidalarini o'rgatuvchi kitob","Long description"));
        allBooks.add(new Book(2,"Baxtiyor oila","Shayx Muhammad Sodiq",330,"https://hilolnashr.uz/image/cache/catalog/Baxtiyor_oila_front-500x750.jpg","Oilalarni isloh qilish yo'llari yozilgan kitob","Long description"));

    }

    //
    public static Utils getInstance() {

        if (instance!=null){
            return instance;
        } else{
            instance = new Utils();
            return instance ;
        }
    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }


    public Book getBookById(int id){
        for (Book b : allBooks){
            if (b.getId() == id){
                return b;
            }
        }

        return null;
    }


}
