package com.example.android.contentpro.DataTable;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Android on 2/21/2017.
 */

public class ShopTable implements BaseColumns {
    public static final String SHOP_AUTHORITY="com.example.android.Shop";
    public static final String SHOP_EVENTS = "events";
    public static final Uri SHOP_CONTENT_URI = Uri.parse("content://" + SHOP_AUTHORITY);

    public static final class  EventEntry{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(SHOP_CONTENT_URI,SHOP_EVENTS);

        public final static String TABLE_NAME = "store";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_BOOK= "book";
        public final static String COLUMN_STORE= "store";
    }

}
