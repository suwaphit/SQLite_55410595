package app.buusk13.sqlit_55410595;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowData extends Activity {
	private ListView ListView;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		ListView = (ListView) findViewById(R.id.listView1);		
		controlDB_595 controlDB_595 = new controlDB_595(this);
		ArrayList<HashMap<String, String>>arrayList = controlDB_595
				.SelectAllData(); //นำดาต้าเบสเข้ามาใส่
		
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(ShowData.this, arrayList, 
				R.layout.show_item, new String[]{"MemberID","Name","Tel"},
				new int[]{R.id.ColMemberID,R.id.ColName,R.id.ColTel});
		
		ListView.setAdapter(adapter);
		
		
		
		
		
		
	}

}
