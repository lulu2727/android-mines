package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter {

    private final LayoutInflater inflater;
    private final List<Book> books;

    public BookRecyclerAdapter(LayoutInflater from, List<Book> books) {
        this.inflater = from;
        this.books = books;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookItemView itemView =  (BookItemView) holder.itemView;
        final Book book = books.get(position);
        itemView.bindView(book);
        itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("book", book);
                Fragment fragment = new BookDetailsFragment();
                fragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerFrameLayout, fragment, BookDetailsFragment.class.getSimpleName()).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView){
            super(itemView);
        }
//        public on

    }
}