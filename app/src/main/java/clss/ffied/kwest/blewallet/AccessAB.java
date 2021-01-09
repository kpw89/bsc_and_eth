package clss.ffied.kwest.blewallet;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class AccessAB extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516105b13803806105b183398101604081905261002f91610054565b600280546001600160a01b0319166001600160a01b0392909216919091179055610082565b600060208284031215610065578081fd5b81516001600160a01b038116811461007b578182fd5b9392505050565b610520806100916000396000f3fe60806040526004361061004a5760003560e01c80632774000e1461004f57806359a4bd3b146100855780636c4e51e3146100a7578063af805b65146100c7578063b88dddd9146100dc575b600080fd5b34801561005b57600080fd5b5061006f61006a366004610401565b6100f1565b60405161007c9190610419565b60405180910390f35b34801561009157600080fd5b5061009a61019d565b60405161007c919061046c565b3480156100b357600080fd5b5061006f6100c2366004610401565b6101a3565b6100da6100d5366004610360565b6101b3565b005b3480156100e857600080fd5b5061009a6102c1565b6003818154811061010157600080fd5b90600052602060002001600091509050805461011c90610499565b80601f016020809104026020016040519081016040528092919081815260200182805461014890610499565b80156101955780601f1061016a57610100808354040283529160200191610195565b820191906000526020600020905b81548152906001019060200180831161017857829003601f168201915b505050505081565b60005481565b6004818154811061010157600080fd5b346107d0141561021e57600380546001810182556000919091528151610200917fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b019060208401906102c7565b5060016000808282546102139190610475565b909155506102849050565b34610bb814156102845760048054600181018255600091909152815161026b917f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b019060208401906102c7565b50600180600082825461027e9190610475565b90915550505b6002546040516001600160a01b03909116903480156108fc02916000818181858888f193505050501580156102bd573d6000803e3d6000fd5b5050565b60015481565b8280546102d390610499565b90600052602060002090601f0160209004810192826102f5576000855561033b565b82601f1061030e57805160ff191683800117855561033b565b8280016001018555821561033b579182015b8281111561033b578251825591602001919060010190610320565b5061034792915061034b565b5090565b5b80821115610347576000815560010161034c565b60006020808385031215610372578182fd5b823567ffffffffffffffff80821115610389578384fd5b818501915085601f83011261039c578384fd5b8135818111156103ae576103ae6104d4565b604051601f8201601f19168101850183811182821017156103d1576103d16104d4565b60405281815283820185018810156103e7578586fd5b818585018683013790810190930193909352509392505050565b600060208284031215610412578081fd5b5035919050565b6000602080835283518082850152825b8181101561044557858101830151858201604001528201610429565b818111156104565783604083870101525b50601f01601f1916929092016040019392505050565b90815260200190565b6000821982111561049457634e487b7160e01b81526011600452602481fd5b500190565b6002810460018216806104ad57607f821691505b602082108114156104ce57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea264697066735822122012bf5e5598bbfda13fe7a6b7a9bd34969802c92d2bdd789e199c7debb54fa87764736f6c63430008000033";

    public static final String FUNC_ADDADRESS = "addAdress";

    public static final String FUNC_BLE_ADDRESSES_A = "ble_addresses_a";

    public static final String FUNC_BLE_ADDRESSES_B = "ble_addresses_b";

    public static final String FUNC_COUNT_A = "count_a";

    public static final String FUNC_COUNT_B = "count_b";

    @Deprecated
    protected AccessAB(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AccessAB(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AccessAB(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AccessAB(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addAdress(String ble_add, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ADDADRESS, 
                Arrays.<Type>asList(new Utf8String(ble_add)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> ble_addresses_a(BigInteger param0) {
        final Function function = new Function(FUNC_BLE_ADDRESSES_A, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ble_addresses_b(BigInteger param0) {
        final Function function = new Function(FUNC_BLE_ADDRESSES_B, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> count_a() {
        final Function function = new Function(FUNC_COUNT_A, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> count_b() {
        final Function function = new Function(FUNC_COUNT_B, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static AccessAB load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccessAB(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AccessAB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccessAB(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AccessAB load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AccessAB(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AccessAB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AccessAB(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AccessAB> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _wallet_reciever)));
        return deployRemoteCall(AccessAB.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<AccessAB> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _wallet_reciever)));
        return deployRemoteCall(AccessAB.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AccessAB> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _wallet_reciever)));
        return deployRemoteCall(AccessAB.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AccessAB> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _wallet_reciever)));
        return deployRemoteCall(AccessAB.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
