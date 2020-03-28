package t.com.samplemd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import t.com.samplemd.R;
import t.com.samplemd.fragment.FragmentBaseActivity;
import t.com.samplemd.fragment.SampleFragmentA;

import static t.com.samplemd.TopMainActivity.REQEST_CODE;
import static t.com.samplemd.TopMainActivity.RESULT_CODE;

public class FragmentStartUpActivity extends AppCompatActivity {
	
	String TAG = "FragmentStartUpActivity";
	/**
	 * 各ボタン生成
	 */
	//フラグメントA起動ボタン
	Button fragmentAbutton;
	//地図起動ボタン
	Button mapButton;
	//戻るボタン
	Button backKeyButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_start_up);
		
		//FragmentAボタンの生成
		fragmentAbutton = findViewById(R.id.fragment_A_button);
		fragmentAbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//フラグメントAを表示
				Log.d(TAG," fragmentAbutton -> onClick");
				
				//フラグメントベースアクティビティを起動
				Intent intent = new Intent(getApplication(), FragmentBaseActivity.class);
				startActivityForResult(intent,REQEST_CODE);
			}
		});
		
		//地図ボタンの生成
		mapButton = findViewById(R.id.map_fragment_button);
		mapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Mapアクティビティを起動
				Intent intent = new Intent(getApplication(),MapsActivity.class);
				startActivityForResult(intent,REQEST_CODE);
			}
		});
		
		//戻るボタン生成
		backKeyButton = findViewById(R.id.back_button);
		backKeyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//トップ画面へ戻る
				setResult(RESULT_CODE);
				//アクティビティ終了
				finish();
			}
		});

	}
	
	@Override
	public void onActivityResult(int requestCode , int resultCode, Intent data){
		super.onActivityResult(requestCode,resultCode,data);
	}
	
}
