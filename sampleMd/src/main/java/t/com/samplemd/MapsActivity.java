package t.com.samplemd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import t.com.samplemd.R;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;

/**
 * Googleマップを使用したActivity
 * 参考ページ
 * https://qiita.com/outerlet/items/0d74061fa5d625a33dfb
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
	
	private GoogleMap mMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// SupportMapFragmentを取得し、マップを使用する準備ができたときに通知を受けます。
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}
	
	/**
	 *利用可能になると、マップを操作します。
	 *このコールバックは、マップを使用する準備ができたときにトリガーされます。
	 *ここで、マーカーやラインを追加したり、リスナーを追加したり、カメラを移動したりできます。 この場合、
	 *オーストラリアのシドニーの近くにマーカーを追加するだけです。
	 * Google Play開発者サービスがデバイスにインストールされていない場合、ユーザーはインストールするように求められます
	 * SupportMapFragment内にあります。 このメソッドは、ユーザーが持っている場合にのみトリガーされます
	 * Google Play開発者サービスをインストールしてアプリに戻りました。
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;
		
		/**
		 * setMapType　地図の種類を変更
		 *
		 * MAP_TYPE_NORMAL 通常
		 * MAP_TYPE_SATELLITE　衛星写真
		 * MAP_TYPE_HYBRID　衛星・地図マーカー
		 * MAP_TYPE_TERRAIN　地形図
		 */
		mMap.setMapType(MAP_TYPE_HYBRID);
		
		//シドニーにマーカーを追加してカメラを移動する
		//LatLng sydney = new LatLng(-34, 151);
		
		/**
		 * 例えば、札幌駅を中心に16倍で表示したい場合は以下のようになります。
		 *
		 * newLatLng(LatLng latLng)	任意の緯度経度を中心に表示
		 * newLatLngZoom(LatLng latLng, float zoom)	任意の緯度経度を中心に、任意の倍率で表示
		 * zoomTo(float zoom)	現在の表示位置を任意の倍率で表示
		 */
		LatLng osakaStation = new LatLng(43.068661,141.350755);
		mMap.addMarker(new MarkerOptions().position(osakaStation).title("札幌駅"));
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(osakaStation,16.0f));
	}
}
