package app.buusk13.sqlit_55410595;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity implements OnClickListener {
	private EditText et1,et2;
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (v == btn){
					suwaphit();
				}
				
			}
		});
		
		
	}

			private boolean suwaphit() {
				et2 = (EditText) findViewById(R.id.et2);
				et1 = (EditText) findViewById(R.id.et1);
				final AlertDialog.Builder adb = new AlertDialog.Builder(this);
				AlertDialog ad = adb.create();
				if (et2.getText().length() == 0 ){
					ad.setMessage("Please input Name");
					et2.requestFocus();
					return false;
					
				}
				if (et1.getText().length() == 0){
					ad.setMessage("Please input Tel");
					et1.requestFocus();
					return false;
				}
				controlDB_595 dbClass = new controlDB_595(this);
				long savedata = dbClass.InsertData(et2.getText().toString(), et1.getText().toString());
				if (savedata <= 0) {
					ad.setMessage("Error !!!!");
					ad.show();
					return false;
				}
				Toast.makeText(getApplicationContext(), "Add Data Successfully", Toast.LENGTH_SHORT).show();
				
				return false;
				
			}

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}

			
}
