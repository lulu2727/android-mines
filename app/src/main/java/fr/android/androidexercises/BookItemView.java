package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.android.androidexercises.Book;
import fr.android.androidexercises.R;

public class BookItemView extends LinearLayout {

    private TextView nameTextView, priceTextView;

    private ImageView bookImageView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // TODO findViewById()
        this.nameTextView = (TextView) findViewById(R.id.nameTextView);
        this.priceTextView = (TextView) findViewById(R.id.priceTextView);
        this.bookImageView = (ImageView) findViewById(R.id.bookImageView);

    }

    public void bindView(Book book) {
        // TODO setText()
        this.nameTextView.setText(book.getTitle());
        this.priceTextView.setText(book.getPrice() + '€');

        Glide.with(this.getContext())
                .load(book.getCover())
                .into(bookImageView);
    }
}