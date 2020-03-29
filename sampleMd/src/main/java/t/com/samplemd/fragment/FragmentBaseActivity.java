package t.com.samplemd.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import t.com.samplemd.R;
import t.com.samplemd.fragment.fragment.SampleFragmentA;

import static t.com.samplemd.TopMainActivity.RESULT_CODE;

public class FragmentBaseActivity extends AppCompatActivity {
	
	String TAG = "FragmentBaseActivity";
	/**
	 *　フラグメントクローズリスナ
	 */
	FragmentCloseListener fragmentCloseListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);

		//フラグメント生成
		SampleFragmentA sampleFragmentA = new SampleFragmentA();
		//フラグメントにリスナをセットする
		fragmentCloseListener = new FragmentCloseListener() {
			@Override
			public void closeFragmentNotification() {
				Log.d(TAG," closeFragmentNotification");
				setResult(RESULT_CODE);
				//自身のアクティビティを終了する
				finish();
			}
		};
		sampleFragmentA.setCleseFragmentListener(fragmentCloseListener);
		
		//getSupportFragmentManager().beginTransaction().replace(R.id.activity_fragment_start_up,sampleFragmentA).commit();
		
		//フラグメントの操作はTransactionを利用
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.base_layout,sampleFragmentA);
		transaction.commitAllowingStateLoss();
	}
	
	/**
	 * フラグメントが閉じた際に通知する
	 */
	public interface FragmentCloseListener{
		//フラグメントクローズ通知
		public void closeFragmentNotification();
	}
}
