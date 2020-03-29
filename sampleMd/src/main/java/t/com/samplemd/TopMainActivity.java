package t.com.samplemd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import t.com.samplemd.screen.parts.ListDetail;
import t.com.samplemd.screen.parts.MyListAdapter;

public class TopMainActivity extends AppCompatActivity {
	
	private final String TAG = "TopMainActivity";
	
	//intent情報コード
	public static final int REQEST_CODE = 1;
	public static final int RESULT_CODE = 2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_main);
		
		
		//ListViewに表示するリスト項目
		ArrayList<ListDetail> detail = new ArrayList();
		String[] s = {"フラグメントサンプル","地図表示","サンプル3","サンプル3","サンプル3"
				,"サンプル3","サンプル3","サンプル3","サンプル3","サンプル3","サンプル3","サンプル3"
				,"サンプル3",};
		for(String ss : s){
			//リスト情報クラスへセット
			ListDetail listDetail = new ListDetail();
			listDetail.setName(ss);
			detail.add(listDetail);
		}

		//自作アダプターを生成
		MyListAdapter myListAdapter = new MyListAdapter(TopMainActivity.this);
		ListView listView = (ListView)findViewById(R.id.lisView);
		myListAdapter.setListDetailArrayList(detail);
		listView.setAdapter(myListAdapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d(TAG," position :"+position);
				
				switch (position){
					case 0:
						//トースト表示
						Toast.makeText(TopMainActivity.this,"Fragmentサンプルへようこそ！",Toast.LENGTH_SHORT).show();
						//フラグメントサンプル起動
						Intent intent = new Intent(getApplication(), FragmentStartUpActivity.class);
						startActivityForResult(intent,REQEST_CODE);
						break;
					case 1:
						//トースト表示
						Toast.makeText(TopMainActivity.this,"地図表示へようこそ！",Toast.LENGTH_SHORT).show();
						Intent intent1 = new Intent(getApplication(), MapsActivity.class);
						startActivityForResult(intent1,REQEST_CODE);
						break;
					case 2:
						break;
					default:
				}
			}
		});
	}
	@Override
	public void onActivityResult(int requestCode , int resultCode, Intent data){
		super.onActivityResult(requestCode,resultCode,data);
	}
}
