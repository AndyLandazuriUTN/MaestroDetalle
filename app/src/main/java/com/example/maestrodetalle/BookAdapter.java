package com.example.maestrodetalle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> books;

    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.tvTitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
