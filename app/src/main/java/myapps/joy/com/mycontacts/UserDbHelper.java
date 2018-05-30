package myapps.joy.com.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jecihjoy on 6/9/2016.
 */
public class  UserDbHelper extends SQLiteOpenHelper   {

//creating db
    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    //creating the table querry
    private static final String CREATE_QUERRY =
            "CREATE TABLE "+UserContact.NewUserInfo.TABLE_NAME+"("+
                    UserContact.NewUserInfo.USER_NAME+" TEXT,"+
                    UserContact.NewUserInfo.USER_CONTACT+" TEXT,"+
                    UserContact.NewUserInfo.USER_EMAIL+" TEXT)";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/opened...");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERRY);
        Log.e("DATABASE OPERATION","Table Created...");

    }

    public void addInfor(String name, String mob, String email, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(UserContact.NewUserInfo.USER_NAME, name);
        cv.put(UserContact.NewUserInfo.USER_CONTACT, mob);
        cv.put(UserContact.NewUserInfo.USER_EMAIL, email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME,null,cv);
        Log.e("DATABASE OPERATIONS","A contact has just been inserted,that is cool");

    }

    public Cursor getInfor(SQLiteDatabase db){
        Cursor cursor;
        String[] columns = {UserContact.NewUserInfo.USER_NAME,UserContact.NewUserInfo.USER_CONTACT,UserContact.NewUserInfo.USER_EMAIL};
        cursor = db.query(UserContact.NewUserInfo.TABLE_NAME, columns,null,null,null,null,null);
        return cursor;
    }

    public Cursor searchInfor(String user_name, SQLiteDatabase db) {
        Cursor cursor;
        String[] columns = {UserContact.NewUserInfo.USER_NAME, UserContact.NewUserInfo.USER_CONTACT, UserContact.NewUserInfo.USER_EMAIL};
        String selection = UserContact.NewUserInfo.USER_NAME + " LIKE ?";
        String[] seletion_args = {user_name};
        cursor = db.query(UserContact.NewUserInfo.TABLE_NAME, columns, selection, seletion_args, null, null, null);
        return cursor;
    }
    public void deleteInfor(String user_name, SQLiteDatabase db) {
        String selection = UserContact.NewUserInfo.USER_NAME + " LIKE ?";
        String[] seletion_args = {user_name};

        db.delete(UserContact.NewUserInfo.TABLE_NAME, selection, seletion_args);

    }

    public int updateInfor(String oldN,String newN,String newMob,String newE, SQLiteDatabase db){

        ContentValues cv = new ContentValues();
        cv.put(UserContact.NewUserInfo.USER_NAME, newN);
        cv.put(UserContact.NewUserInfo.USER_CONTACT, newMob);
        cv.put(UserContact.NewUserInfo.USER_EMAIL, newE);
        String selection = UserContact.NewUserInfo.USER_NAME + " LIKE ?";
        String[] seletion_args = {oldN};
        int count = db.update(UserContact.NewUserInfo.TABLE_NAME,cv,selection,seletion_args);
        return count;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //@Override
    //public void onClick(View v) {

   // }
}
