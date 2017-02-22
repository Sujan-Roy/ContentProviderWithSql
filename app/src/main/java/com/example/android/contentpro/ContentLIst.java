package com.example.android.contentpro;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.contentpro.DataTable.ShopTable;

public class ContentLIst extends AppCompatActivity {
    EditText bookTv,storeTv;
    private Uri currentUri;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);
        bookTv= (EditText) findViewById(R.id.bookEv);
        storeTv= (EditText) findViewById(R.id.storeEv);
        btnSave= (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePet();
                finish();
            }
        });
    }
    private void savePet() {
        String eventString = bookTv.getText().toString().trim();
        String timeString = storeTv.getText().toString().trim();


        if (currentUri == null &&
                TextUtils.isEmpty(eventString) && TextUtils.isEmpty(timeString)) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(ShopTable.EventEntry.COLUMN_BOOK, eventString);
        values.put(ShopTable.EventEntry.COLUMN_STORE, timeString);

        Uri newUri = getContentResolver().insert(ShopTable.EventEntry.CONTENT_URI, values);
        if (newUri == null) {
            Toast.makeText(this, "Faied",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Success",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
