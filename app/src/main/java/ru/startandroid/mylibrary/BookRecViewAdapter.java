package ru.startandroid.mylibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private static final String TAG = "BookRecViewAdapter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext ;

    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    // bu method bizga list_item_book.xml faylidagi dizayni qaytaradi
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // list_item_books.xml faylida yaratganlarimizni view ga LayoutInflater orqali yubordik
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);

        // bu code view ga kelgan item.xml faylidagi narsalarni qaytaradi
        // buni oldin ViewHolder dan holder obyekt olib yakunda holder ni qaytarish orqali qilgandik
        return new ViewHolder(view);
    }

    // bu method da item.xml dan kelgan view larga(textView, imageView) bizning projectimizdagi nomlar va rasmlarni arraylistdan olib ularga
    // o'zlashtiramiz
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        // holder orqali tvBookName ni tutib oldik va uning setText tiga
        // array list ning 'books' obyekti orqali kitob nomiga mos bo'lgan nomni set qilyabmiz
        holder.tvBookName.setText(books.get(position).getName());

        // endi item.xml dan default holatda kelgan imageView ga arraylist dagi image larni yuklaymiz
        // bunda bizga gradle ga github orqali qo'shgan implementation code miz yordam beradi, u
        // interdan rasmlarni biz bergan linklar orqali topib arraylistga yuboradi biz esa ularni arraylistdan item.xml ga yuklaymiz
        Glide.with(mContext)
                .asBitmap()
                // code oddiy, load - yuklamoq, arraylist ning 'books' obyketi orqali mos rasmlarni olamiz keyin
                .load(books.get(position).getImageUrl())
                // into - ichiga, holder orqali tutib olgan imgBook id li item.xml ning elementiga ularni joylaymiz
                .into(holder.imgBook);

        // bu code orqali biz cardView ustuga bosgan vaqtimiz nima bo'lishini yozishimiz mumkun.
        // biz hozircha cardView ustuga bosgan vaqti mos kitob nomini qaytarish bilan kifoyalanamiz.
        holder.imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, books.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    // ViewHolder deb nomlangan class yaratdik va u RecyclerView.ViewHolder dan meros oldi
    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView allBooksItemCardVIew;
        private ImageView imgBook;
        private TextView tvBookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            allBooksItemCardVIew = itemView.findViewById(R.id.allBooksItemCardView);
            imgBook = itemView.findViewById(R.id.imgBook);
            tvBookName = itemView.findViewById(R.id.tvBookName);
        }
    }
}
