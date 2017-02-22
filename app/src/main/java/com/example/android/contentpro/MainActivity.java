package com.example.android.contentpro;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.contentpro.DataModel.BookAdapter;
import com.example.android.contentpro.DataTable.ShopDbHelper;
import com.example.android.contentpro.DataTable.ShopTable;

public class MainActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {
    private ShopDbHelper mDbHelper;
    private static final int  EVENT_LOADER=0;
    BookAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContentLIst.class);
                startActivity(intent);

            }
        });
        mDbHelper =new ShopDbHelper(this);

        ListView listView=(ListView) findViewById(R.id.listView);
        mCursorAdapter =new BookAdapter(this,null);
        listView.setAdapter(mCursorAdapter);

        getLoaderManager().initLoader(EVENT_LOADER,null,this);


    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection={  ShopTable.EventEntry._ID,
                ShopTable.EventEntry.COLUMN_BOOK,
                ShopTable.EventEntry.COLUMN_STORE,
        };
        return new CursorLoader(this, ShopTable.EventEntry.CONTENT_URI,projection,null,null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);

    }

}
