package myapps.joy.com.mycontacts;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddContact extends Activity implements View.OnClickListener{
/**
 * Created by Jecihjoy on 6/9/2016.
 */

    TextView ANC;
    EditText CN, CNN, EA;
    Button save;
    Context ct = this;
    UserDbHelper helper;
    SQLiteDatabase db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initiliase();

    }
    public void initiliase(){
        ANC = (TextView) findViewById(R.id.ANC);
        CN = (EditText)findViewById(R.id.CN);
        CNN = (EditText) findViewById(R.id.CNN);
        EA = (EditText) findViewById(R.id.EA);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);

    }

    public void saveDetails(View view){
        String name = CN.getText().toString();
        String mob = CNN.getText().toString();
        String email = EA.getText().toString();
        helper = new UserDbHelper(ct);
        db = helper.getWritableDatabase();
        helper.addInfor(name, mob, email, db);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        CNN.setVisibility(View.GONE);
        CN.setVisibility(View.GONE);
        EA.setVisibility(View.GONE);
        helper.close();
    }
    @Override
    public void onClick(View v) {
        saveDetails(v);

    }
}
