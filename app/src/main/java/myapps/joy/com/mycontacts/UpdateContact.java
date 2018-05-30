package myapps.joy.com.mycontacts;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateContact extends Activity implements View.OnClickListener {
    TextView UC;
    EditText EN,CN,CNN,EA;
    Context ct=this;
    UserDbHelper helper;
    SQLiteDatabase db;
    String searchName;
    Button search;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contacts);
        EN = (EditText) findViewById(R.id.EN);
        UC = (TextView) findViewById(R.id.UC);
        CN =  (EditText) findViewById (R.id.CN);
        CNN = (EditText) findViewById(R.id.CNN);
        EA = (EditText) findViewById(R.id.EA);
        CN.setVisibility(View.GONE);
        CNN.setVisibility(View.GONE);
        EA.setVisibility(View.GONE);
        UC.setVisibility(View.GONE);
        update.setVisibility(View.GONE);
        //CN.setVisibility(View.GONE);
        update= (Button) findViewById(R.id.update);
        update.setOnClickListener(this);
        search= (Button) findViewById(R.id.search);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
    public void searchMethod(View v){
        //switch (v.getId()) {
            //case R.id.search:
                searchName = EN.getText().toString();
                helper = new UserDbHelper(getApplicationContext());
                db = helper.getReadableDatabase();
                Cursor cursor = helper.searchInfor(searchName, db);
                if (cursor.moveToFirst()) {
                    String MOBILE = cursor.getString(1);
                    String EMAIL = cursor.getString(2);
                    String NAME = cursor.getString(0);
                    CN.setText(NAME);
                    CNN.setText(MOBILE);
                    EA.setText(EMAIL);
                    CN.setText(View.VISIBLE);
                    CNN.setText(View.VISIBLE);
                    EA.setText(View.VISIBLE);
                    UC.setVisibility(View.VISIBLE);
                    update.setVisibility(View.VISIBLE);
                }//break;

    }
    public void updateMethod (View v) {
        helper = new UserDbHelper(getApplicationContext());
        db = helper.getWritableDatabase();
        //String name,mob,email;
        String name = CN.getText().toString();
        String mob = CN.getText().toString();
        String email = CN.getText().toString();
        int count = helper.updateInfor(searchName,name,mob,email, db);
        Toast.makeText(getApplicationContext(),count +" contact updated", Toast.LENGTH_LONG).show();
        finish();
    }

}
