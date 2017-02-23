package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class ListFragment extends Fragment implements BookRecyclerAdapter.OnItemClickListener {

    private final String url = "http://henri-potier.xebia.fr/";

    private RecyclerView recyclerView;

    private OnSelectBookListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (OnSelectBookListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_book, container, false);

        this.recyclerView = (RecyclerView) view.findViewById(R.id.bookListView);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // TODO create a service
        HenriPotierService service = retrofit.create(HenriPotierService.class);

        // TODO listBooks()
        Call<List<Book>> books = service.listBooks();

        // TODO enqueue call and display book title
        // TODO log books
        books.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> books = response.body();
                for(int i = 0; i < books.size(); i++){
                    Timber.i(books.get(i).getTitle() + " - " + books.get(i).getPrice());
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                // TODO déguelasse
                recyclerView.setAdapter(new BookRecyclerAdapter(LayoutInflater.from(getActivity()), books, ListFragment.this));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t.getMessage());
            }
        });

        return view;
    }

    @Override
    public void onItemClick(Book book) {
        listener.onSelectBook(book);
    }

    public interface OnSelectBookListener {
        public void onSelectBook(Book book);
    }
}
