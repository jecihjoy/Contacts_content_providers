
package myapps.joy.com.mycontacts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteContact extends AppCompatActivity  implements View.OnClickListener {
    TextView DC;
    EditText EN,CN,CNN,EA;
    UserDbHelper helper;
    SQLiteDatabase db;
    String searchName;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);
        DC =  (TextView) findViewById(R.id.DC);
        CN =(EditText) findViewById(R.id.CN);
        CNN =(EditText) findViewById(R.id.CNN);
        EA =(EditText) findViewById(R.id.EA);
        EN = (EditText) findViewById(R.id.EN);
        CN.setVisibility(View.GONE);
        CNN.setVisibility(View.GONE);
        EA.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
    }
    public void searchMethod2 (View v) {

        searchName = EN.getText().toString();
        helper = new UserDbHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        Cursor cursor = helper.searchInfor(searchName, db);
        if (cursor.moveToFirst()) {
            String MOBILE = cursor.getString(0);
            String EMAIL = cursor.getString(1);
            CN.setText(EMAIL);
            CN.setText(View.VISIBLE);
            CNN.setText(MOBILE);
            CNN.setVisibility(View.VISIBLE);
            EA.setText(EMAIL);
            EA.setText(View.VISIBLE);
        }
    }
    public void deleteMethod (View v){
        helper = new UserDbHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        helper.deleteInfor(searchName, db);
        Toast.makeText(getBaseContext(), "Data deleted", Toast.LENGTH_LONG).show();




        }
    }

