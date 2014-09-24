package app.buusk13.sqlit_55410595;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	  SQLiteDatabase db;
	  private Button btninsert,btnshow;
	  
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        controlDB_595 controlDB_595 = new controlDB_595(this);
        controlDB_595.getWritableDatabase();
        
        btninsert = (Button) findViewById(R.id.btninsert);
        btnshow = (Button) findViewById(R.id.show);
        
        btninsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ªÿË¡Insert
				Intent insert = new Intent(getApplicationContext(), AddActivity.class);
				startActivity(insert);
			}
		});
        
        btnshow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ªÿË¡ show
				Intent show = new Intent(getApplicationContext(),ShowData.class);
				startActivity(show);
				
			}
		});
        
     
        
        
        
    }
}
