package t.com.samplemd.screen.parts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import t.com.samplemd.R;

public class MyListAdapter extends BaseAdapter {
	Context context;
	LayoutInflater layoutInflater = null;
	ArrayList<ListDetail> listDetailArrayList;
	
	public MyListAdapter(Context context){
		this.context = context;
		this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void setListDetailArrayList(ArrayList<ListDetail> listDetailArrayList){
		this.listDetailArrayList = listDetailArrayList;
	}
	
	@Override
	public int getCount(){
		return listDetailArrayList.size();
	}
	
	@Override
	public Object getItem(int position){
		return listDetailArrayList.get(position);
	}
	
	@Override
	public long getItemId(int position){
		return listDetailArrayList.get(position).getId();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		convertView = layoutInflater.inflate(R.layout.my_list_item,parent,false);
		((TextView)convertView.findViewById(R.id.list_text)).setText(listDetailArrayList.get(position).getName());
		
		return convertView;
	}
	
}
