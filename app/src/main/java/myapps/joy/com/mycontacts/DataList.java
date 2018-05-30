package myapps.joy.com.mycontacts;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class  DataList extends Activity {
    ListView lv;
    SQLiteDatabase db2;
    UserDbHelper helper2;
    Cursor cursor2;
    ListDataAdapter LDA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        lv = (ListView) findViewById(R.id.lv);
        helper2 = new UserDbHelper(getApplicationContext());
        db2 = helper2.getReadableDatabase();
        LDA = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        lv.setAdapter(LDA);
        cursor2 = helper2.getInfor(db2);

        if (cursor2.moveToFirst()) {
            do {
                String name, mob, email;
                name = cursor2.getString(0);
                mob = cursor2.getString(1);
                email = cursor2.getString(2);
                DataProvider Db = new DataProvider(name, mob, email);
                LDA.add(Db);

            } while (cursor2.moveToNext());
        }

    }
}