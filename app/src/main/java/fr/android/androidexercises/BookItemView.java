package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.android.androidexercises.Book;
import fr.android.androidexercises.R;

public class BookItemView extends LinearLayout {

    private TextView nameTextView, priceTextView;

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

    }

    public void bindView(Book book) {
        // TODO setText()
        this.nameTextView.setText(book.getTitle());
        this.priceTextView.setText(book.getPrice() + '€');
    }
}