package clss.ffied.kwest.blewallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import jnr.ffi.annotations.In;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.ObjectMapperFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;
    private Web3j web3 =null;

    TextView tv_wallet_address;
    TextView tv_balance_wei;
    TextView tv_balance_ether;

    Spinner spinner_ble;

    Button btn_2000 ;
    Button btn_3000;
    Button btn_ble;

    AccessAB accessAB_contract;
    Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_wallet_address = findViewById(R.id.tv_wallet_address);
        tv_balance_wei = findViewById(R.id.tv_balance_wei);
        tv_balance_ether = findViewById(R.id.tv_balance_ether);

        btn_2000 = findViewById(R.id.btn_2000);
        btn_3000 = findViewById(R.id.btn_3000);
        btn_ble = findViewById(R.id.btn_ble);

        spinner_ble = findViewById(R.id.spinner_ble);


        //ble addresse
        String[] ble_adresses = new String[]{"0000000000501ba0690a000000002221","5018a010203abba0690a000000002221","010203abba060708090a000000000001","0102030405060708090a000000011111","0102030405060708090a000000000001", "ffbbcc0405060708090a000003300001", "d908070605040302010d000000000022","2152734425261718195b000000000111"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ble_adresses);
        spinner_ble.setAdapter(adapter);

        //conect to node
        web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/fcbf73400bbb48b28291758dd4e2b8f5"));

        //check permission during runtime to access download folder where wallet file is located
        checkPermission();


        //load walletfile from download folder , create credentials with password and walletfile
        try {
            credentials = WalletUtils.loadCredentials("123456","/storage/emulated/0/Download/UTC--2020-11-25T11-00-58.548865400Z--3806fff1ee6d556e7835713e6a977e2080321616.json" );
            tv_wallet_address.setText(credentials.getAddress());
            tv_balance_wei.setText(balance("GWEI")+" Gwei");
            tv_balance_ether.setText(balance("ETHER")+" Ether");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //load Smart Contract
        try {
            accessAB_contract = AccessAB.load("0xdf24542177e1e86e016fea56bca8002597147d1e", web3, credentials ,new DefaultGasProvider());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        btn_2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "buying Access A for 2000 wei", Toast.LENGTH_SHORT).show();
                accessAB_contract.addAdress(spinner_ble.getSelectedItem().toString(),BigInteger.valueOf(2000L)).sendAsync();
            }
        });

        btn_3000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "buying Access B for 3000 wei", Toast.LENGTH_SHORT).show();
                accessAB_contract.addAdress(spinner_ble.getSelectedItem().toString(),BigInteger.valueOf(3000L)).sendAsync();
            }
        });

        btn_ble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BLE_Broadcast.class);
                intent.putExtra("key", spinner_ble.getSelectedItem().toString() );
                startActivity(intent);
            }
        });
    }


    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Permission already granted",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission();
            Toast.makeText(this, "Request permission method",Toast.LENGTH_SHORT).show();
        }
    }

    private  String balance(String currency_unit) throws ExecutionException, InterruptedException {
        EthGetBalance ethGetBalance = web3
                .ethGetBalance("0x3806fff1ee6d556e7835713e6a977e2080321616", DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();

        BigInteger wei = ethGetBalance.getBalance();
        BigDecimal ether_unit = Convert.fromWei(wei.toString(), Convert.Unit.fromString(currency_unit));
        return ether_unit.toString();
    }

    //transaction from private key account to private key account
/*    private void sendEther(){
        try{
            Credentials credentials = WalletUtils.loadCredentials("123456", "/storage/emulated/0/Download/UTC--2020-11-25T11-00-58.548865400Z--3806fff1ee6d556e7835713e6a977e2080321616.json");
            TransactionReceipt receipt = Transfer.sendFunds(web3,credentials,"0x59bfE14B8bBc6A3D9cb76cF7a1403807Aa59165a",new BigDecimal(1), Convert.Unit.ETHER).sendAsync().get();
            Toast.makeText(this, "Transaction complete: " +receipt.getTransactionHash(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(this, "send Ether error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }*/

}