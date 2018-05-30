package myapps.joy.com.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    Button BAdd;
    Button BView;
    Button BSearch;
    Button BUpdate;
    Button BDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BAdd = (Button) findViewById(R.id.BAdd);
        BAdd.setOnClickListener(this);
        BView = (Button) findViewById(R.id.BView);
        BView.setOnClickListener(this);
        BSearch.setOnClickListener(this);
        BUpdate.setOnClickListener(this);
        BDelete.setOnClickListener(this);
        BUpdate = (Button) findViewById(R.id.BUpdate);
        BDelete = (Button) findViewById(R.id.BDelete);

    }

    //public void viewContact

       @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.BAdd:
               Intent intent = new Intent(this, AddContact.class);
               startActivity(intent);
                break;
            case R.id.BView:
                Intent intent2 = new Intent(this,DataList.class );
                startActivity(intent2);
                break;
            case R.id.BSearch:
                Intent intent3 = new Intent(this,SearchXml.class );
                startActivity(intent3);
                break;
            case R.id.BUpdate:
                Intent intent4 = new Intent(this,UpdateContact.class );
                startActivity(intent4);

                break;
            case R.id.BDelete:
                Intent intent5 = new Intent(this,DeleteContact.class );
                startActivity(intent5);
                break;


        }

    }
}
