package clss.ffied.kwest.blewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.BeaconTransmitter;
public class BLE_Broadcast extends AppCompatActivity {

    Button btn_backwallet;
    BeaconTransmitter beaconTransmitter;
    String ble_address;
    TextView tv_ble_address;
    String id1;
    String id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l_e__broadcast);

        tv_ble_address = findViewById(R.id.tv_broadcast_ble_address);

        Bundle bundle = getIntent().getExtras();
        ble_address = bundle.getString("key");
        tv_ble_address.setText(ble_address);

        id1 = ble_address.substring(0,20);
        id2 = ble_address.substring(20,32);

        Beacon beacon = new Beacon.Builder()
                .setId1(id1)
                .setId2(id2)
                .setManufacturer(0x0075) // Radius Networks.  Change this for other beacon layouts
                .setTxPower(-59)
                .build();

        // Layout for UID Beacon
        BeaconParser beaconParser = new BeaconParser()
                .setBeaconLayout("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19");
        beaconTransmitter = new BeaconTransmitter(getApplicationContext(), beaconParser);
        beaconTransmitter.startAdvertising(beacon, new AdvertiseCallback() {

        });

        btn_backwallet = findViewById(R.id.btn_backwallet);
        btn_backwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beaconTransmitter.stopAdvertising();
                Intent intent = new Intent(BLE_Broadcast.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        beaconTransmitter.stopAdvertising();
        Intent intent = new Intent(BLE_Broadcast.this,MainActivity.class);
        startActivity(intent);
    }
}