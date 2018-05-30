package myapps.joy.com.mycontacts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchXml extends AppCompatActivity  implements View.OnClickListener {
    TextView CN,CNN,EA;
    EditText EN;
    UserDbHelper helper;
    SQLiteDatabase db;
    String searchName;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_xml);
        CN =  (TextView) findViewById(R.id.CN);
        CNN =  (TextView) findViewById(R.id.CNN);
        EA =  (TextView) findViewById(R.id.EA);
        EN = (EditText) findViewById(R.id.EN);
        CNN.setVisibility(View.GONE);
        CN.setVisibility(View.GONE);
        EA.setVisibility(View.GONE);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(this);

    }

    public void searchContact (View v ) {
                searchName = EN.getText().toString();
                helper = new UserDbHelper(getApplicationContext());
                db = helper.getReadableDatabase();
                Cursor cursor = helper.searchInfor(searchName, db);
                if (cursor.moveToFirst()) {
                    String NAME = cursor.getString(0);
                    String MOBILE = cursor.getString(1);
                    String EMAIL = cursor.getString(2);
                    CN.setText(NAME);
                    CN.setVisibility(View.VISIBLE);
                    CNN.setText(MOBILE);
                    CNN.setVisibility(View.VISIBLE);
                    EA.setText(EMAIL);
                    EA.setText(View.VISIBLE);
                }


        }

    @Override
    public void onClick(View v) {
        searchContact(v);

    }
}

