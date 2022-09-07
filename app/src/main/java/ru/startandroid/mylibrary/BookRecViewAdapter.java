package ru.startandroid.mylibrary;

import static ru.startandroid.mylibrary.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        holder.txtBookName.setText(books.get(position).getName());

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
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // oldin bu yerda toast message bor edi, endi kitobning ustuga bosganda xabar emas uni malumotlarini ko'rishimiz mumkun bo'ladi
                Intent intent = new Intent(mContext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());

        // bu kod orqali expanded id li relativelayout ning bizga ko'rinishi yoki ko'rinmaslikini belgishamiz mumkun shart berish orqali
        if (books.get(position).isExpanded()){

            //
            TransitionManager.beginDelayedTransition(holder.parent);

            // agar shart bajarilsa 2-relativeLayout foydalanuvchiga ko'rinadi
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }

        // aks holda 2-relativeLayout yopiladi va ArrowDown Visible bo'ladi
        else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
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

        private CardView parent;
        private ImageView imgBook;
        private TextView txtBookName;

        private ImageView downArrow,upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor,txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.BookName);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDescription);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    Book book = books.get(getAdapterPosition());
                    // setExpanded ga avvalki holatiga teskari bo'lgan holat set qilinadi
                 book.setExpanded(!book.isExpanded());

                 // faqat bitta malumot o'zgarsa bo'ldi bizga, shuning uchun Item dan foydalandik
                    // ko'p malumot o'zgargan bo'lsa arraylist da, unda boshqasidan foydalanar edik
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    Book book = books.get(getAdapterPosition());
                    // setExpanded ga avvalki holatiga teskari bo'lgan holatga set qilinadi
                   book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
