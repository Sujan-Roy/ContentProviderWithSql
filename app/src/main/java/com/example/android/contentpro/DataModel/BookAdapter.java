package com.example.android.contentpro.DataModel;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.contentpro.DataTable.ShopTable;
import com.example.android.contentpro.R;

/**
 * Created by Android on 2/21/2017.
 */

public class BookAdapter extends CursorAdapter {
    public BookAdapter(Context context, Cursor cursor) {
        super(context, cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list,parent,false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView event = (TextView) view.findViewById(R.id.nameTv);
        TextView time= (TextView) view.findViewById(R.id.storeTv);

        int eventColumn = cursor.getColumnIndex(ShopTable.EventEntry.COLUMN_BOOK);
        int timeColoumn= cursor.getColumnIndex(ShopTable.EventEntry.COLUMN_STORE);
        String eventDesc=cursor.getString(eventColumn);
        String timeDesc=cursor.getString(timeColoumn);

        event.setText(eventDesc);
        time.setText(timeDesc);

    }
}
