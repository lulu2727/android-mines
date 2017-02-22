package fr.android.androidexercises;

import android.os.Bundle;
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

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, new ListFragment(), ListFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    public void onSelectBook() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new BookDetailsFragment(), BookDetailsFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }
}
