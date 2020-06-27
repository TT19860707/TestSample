package t.com.samplemd;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONObject;

public class GsonSampleActivity extends AppCompatActivity {
	
	static public void main(String...aergs){
		
		String s =  "{'名前':'山田太郎','年齢':'30'}";
		try {
			Gson gson = new Gson();
			gson.toJson(s);

		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
