package t.com.samplemd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import t.com.samplemd.FragmentStartUpActivity;
import t.com.samplemd.R;

public class SampleFragmentA extends Fragment {
	
	/**
	 * 閉じるボタン
	 */
	Button closeButton;
	
	/**
	 * フラグメントを閉じた際の通知を行うリスナ
	 */
	FragmentBaseActivity.FragmentCloseListener fragmentCloseListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		View view = inflater.inflate(R.layout.fragment_a,container,false);
		
		closeButton = view.findViewById(R.id.close_button);
		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(fragmentCloseListener != null){
					//フラグメントベースアクティビティへ通知する
					fragmentCloseListener.closeFragmentNotification();
				}
				//フラグメントAを閉じる
				closeFragment();
			}
		});
		return view;
	}
	
	//自信のフラグメントを閉じる
	public void closeFragment(){
		getFragmentManager().beginTransaction().remove(this).commit();
	}
	
	public void setCleseFragmentListener(FragmentBaseActivity.FragmentCloseListener fragmentListener){
		fragmentCloseListener = fragmentListener;
	}
	
}
