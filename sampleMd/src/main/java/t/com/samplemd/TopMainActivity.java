package t.com.samplemd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TopMainActivity extends AppCompatActivity {
	
	private final String TAG = "TopMainActivity";
	
	//intent情報コード
	public static final int REQEST_CODE = 1;
	public static final int RESULT_CODE = 2;
	
	/**
	 * フラグメントサンプル起動
	 */
	Button fragmentButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_main);
		
		//フラグメントサンプルボタン生成
		fragmentButton = (Button)findViewById(R.id.next_fragment_button);
		
		fragmentButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG,"fragmentButton  ->  onClick");
				//トースト表示
				Toast.makeText(TopMainActivity.this,"Fragmentサンプルへようこそ！",Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(getApplication(), FragmentStartUpActivity.class);
				startActivityForResult(intent,REQEST_CODE);
			}
		});
		
	}
	@Override
	public void onActivityResult(int requestCode , int resultCode, Intent data){
		super.onActivityResult(requestCode,resultCode,data);
	}
}
