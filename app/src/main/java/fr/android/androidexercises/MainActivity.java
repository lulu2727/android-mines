package fr.android.androidexercises;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements ListFragment.OnSelectBookListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.leftContainerFrameLayout, new ListFragment(), ListFragment.class.getSimpleName())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rightContainerFrameLayout, new BookDetailsFragment(), BookDetailsFragment.class.getSimpleName())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, new ListFragment(), ListFragment.class.getSimpleName())
                    .commit();
        }
//
    }

    @Override
    public void onSelectBook(Book book) {

        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        Fragment fragment = new BookDetailsFragment();
        fragment.setArguments(bundle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rightContainerFrameLayout, fragment, BookDetailsFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, fragment, BookDetailsFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }

    }
}
