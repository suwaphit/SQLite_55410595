package app.buusk13.sqlit_55410595;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class controlDB_595 extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "mydata595";
	private static final String TABLE_MEMBER = "members";
	private static final int DATABASE_VERSION = 1;
	

	public controlDB_595(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE  " + TABLE_MEMBER + 
				"(MemberId INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "Name TEXT(100)," + "Tel TEXT(100));");
		//CREATE TABLE member(MemberID INTEGER,name TEXT(100),TEL TEXT())
		
		Log.d("CREATE TABLE", "Create Table Successfully");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_MEMBER);
		onCreate(db);
		
	}
	public long InsertData(String strName, String strTel){
		try { //ดักDebut
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			ContentValues volues;
			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
		
	}
	//CheckData เพื่อจะไม่ให้ ID ซ้ำ
	public String[] checkData(String strMemberID){
		try {
			String arrData[] = null;
			
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*"}, "MemberID=?", new String[]{String.valueOf(strMemberID)}, null, null, null);
			if (cursor != null) {
	            if (cursor.moveToFirst()) {
	                arrData = new String[cursor.getColumnCount()];
	                arrData[0] = cursor.getString(0);
	                arrData[1] = cursor.getString(1);
	                arrData[2] = cursor.getString(2);
	            }
	        }
	        cursor.close();
	        db.close();
	        return arrData;

			
		} catch (Exception e) {
	        return null;
		}
		
	
	
	
		
		
	}
	//Select All หรือ show all Data
	public ArrayList<HashMap<String, String>> SelectAllData(){
		try {
			ArrayList<HashMap<String,String>>myArrayList =
					new ArrayList<HashMap<String,String>>();
			HashMap<String, String>map;
			
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			String strSQL = "SELECT * FROM  " + TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQL, null);
			
			if (cursor !=null) {
				if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>(); //ใส่ข้อมูลที่จะเอาลงไป
                        map.put("MemberID", cursor.getString(0)); //memberId ตือชื่อฟิวมีทั้งหมด 3 ฟิว
                        map.put("Name", cursor.getString(1));
                        map.put("Tel", cursor.getString(2));
                        myArrayList.add(map);
                    } while (cursor.moveToNext()); //เลื่อนจนกระทั่งข้อมูลนั้นเปงค่าว่าง  นั้นคือการทำ loop ด้านบน
                }
			}
            cursor.close();
            db.close();
            return myArrayList;
            
		} catch (Exception e) {
			return null;
		}
		
	}
	
	

}
