package clss.ffied.kwest.blewallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private int STORAGE_PERMISSION_CODE = 1;
    private Web3j web3 =null;
    //0xc57667095bf50672cd850fcded4bdef3677869d5
    Able_sol_Able able_contract ;
    BContract bContract;
    Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conect to node
        web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/fcbf73400bbb48b28291758dd4e2b8f5"));
        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if (!clientVersion.hasError()) {
                Toast.makeText(this, "connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "error caught", Toast.LENGTH_SHORT).show();
        }

        //check permission during runtime to access download folder where wallet file is located
        checkPermission();


        //load walletfile from download folder , create credentials with password and walletfile

        try {
            credentials = WalletUtils.loadCredentials("123456","/storage/emulated/0/Download/UTC--2020-11-25T11-00-58.548865400Z--3806fff1ee6d556e7835713e6a977e2080321616.json" );
            //Credentials credentials1 = Credentials.create(Wallet.decrypt("123456", walletFile));
            Toast.makeText(this, "Your address is " + credentials.getAddress(), Toast.LENGTH_LONG).show();
            balance();

        }
        catch (Exception e){
            // Toast.makeText(this, "error caught no credentials", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "333"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
//0x1876929D6a901A1FE859f0C8c38805feA2BC13C8
        try {
           //able_contract =  Able_sol_Able.load("0xc57667095BF50672Cd850FcDeD4BDEF3677869D5", web3, credentials, new DefaultGasProvider());
            bContract = BContract.load("0x59bfE14B8bBc6A3D9cb76cF7a1403807Aa59165a", web3, credentials ,new DefaultGasProvider());
            Toast.makeText(this,"is valid: "+bContract.getContractAddress() , Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"is : "+bContract.addresscount().encodeFunctionCall() , Toast.LENGTH_SHORT).show();
            //bContract.addAdress("jhgj").send();
            Toast.makeText(this,"is valid: "+bContract.addresscount().sendAsync().get() , Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "address: "+ bContract.addresses(BigInteger.valueOf(0)).sendAsync().get(), Toast.LENGTH_SHORT).show();
            bContract.addAdress("AndROID on money ",BigInteger.valueOf(30000L)).sendAsync();
           // Toast.makeText(this, ".()."+bContract.addAdress("sent from Android",BigInteger.valueOf(500)).sendAsync().isDone(), Toast.LENGTH_SHORT).show();
            //bContract.addAdress("sent ",BigInteger.valueOf(500)).sendAsync();
        }catch (Exception e){
            Toast.makeText(this, e.getCause()+"\n"+e.getLocalizedMessage()+"\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        //test send ehter
        //sendEther();
        try {

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
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
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "You have already granted this permission!",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission();
            Toast.makeText(this, "request permission methtod",Toast.LENGTH_SHORT).show();
        }
    }

    private  void balance() throws ExecutionException, InterruptedException {
        EthGetBalance ethGetBalance = web3
                .ethGetBalance("0x3806fff1ee6d556e7835713e6a977e2080321616", DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();

        BigInteger wei = ethGetBalance.getBalance();
        Toast.makeText(this, "balance wei : "+wei.toString(), Toast.LENGTH_LONG).show();
    }

    private void sendEther(){
        try{
            // 0x1876929D6a901A1FE859f0C8c38805feA2BC13C8
            Credentials credentials = WalletUtils.loadCredentials("123456", "/storage/emulated/0/Download/UTC--2020-11-25T11-00-58.548865400Z--3806fff1ee6d556e7835713e6a977e2080321616.json");
            TransactionReceipt receipt = Transfer.sendFunds(web3,credentials,"0x59bfE14B8bBc6A3D9cb76cF7a1403807Aa59165a",new BigDecimal(1), Convert.Unit.ETHER).sendAsync().get();
         //   TransactionReceipt transactionReceipt = contract.someMethod( <param1>,).send();
            Toast.makeText(this, "Transaction complete: " +receipt.getTransactionHash(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(this, "send Ether error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void send_ble_address(String ble_add) throws Exception {
        able_contract.addAdress(ble_add).send();
    }

    private void diesdas () throws ExecutionException, InterruptedException {
        List inputParams = new ArrayList();
        List outputParams = new ArrayList();
        Function function = new Function("addAdress", inputParams, outputParams);
        String encodedFunction = FunctionEncoder.encode(function);
    //    We can then initialize our Transaction with necessary gas (used to execute of the Transaction) and nonce parameters:

        BigInteger nonce = BigInteger.valueOf(100);
        BigInteger gasprice = BigInteger.valueOf(100);
        BigInteger gaslimit = BigInteger.valueOf(100);

        Transaction transaction = Transaction
                .createFunctionCallTransaction("FROM_ADDRESS",
                        nonce, gasprice, gaslimit, "TO_ADDRESS", encodedFunction);

        EthSendTransaction transactionResponse = web3.ethSendTransaction(transaction).sendAsync().get();

    }


}