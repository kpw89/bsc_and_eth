package clss.ffied.kwest.blewallet;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class BLContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516105e63803806105e68339818101604052602081101561003357600080fd5b5051600480546001600160a01b0319166001600160a01b03909216919091179055610583806100636000396000f3fe6080604052600436106100705760003560e01c80636c4e51e31161004e5780636c4e51e314610150578063af805b651461017a578063b88dddd914610222578063edf26d9b1461023757610070565b80632774000e1461007557806359a4bd3b146101145780636c015acf1461013b575b600080fd5b34801561008157600080fd5b5061009f6004803603602081101561009857600080fd5b503561027d565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100d95781810151838201526020016100c1565b50505050905090810190601f1680156101065780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561012057600080fd5b50610129610326565b60408051918252519081900360200190f35b34801561014757600080fd5b5061012961032c565b34801561015c57600080fd5b5061009f6004803603602081101561017357600080fd5b5035610332565b6102206004803603602081101561019057600080fd5b8101906020810181356401000000008111156101ab57600080fd5b8201836020820111156101bd57600080fd5b803590602001918460018302840111640100000000831117156101df57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610342945050505050565b005b34801561022e57600080fd5b5061012961047c565b34801561024357600080fd5b506102616004803603602081101561025a57600080fd5b5035610482565b604080516001600160a01b039092168252519081900360200190f35b6005818154811061028d57600080fd5b600091825260209182902001805460408051601f600260001961010060018716150201909416939093049283018590048502810185019091528181529350909183018282801561031e5780601f106102f35761010080835404028352916020019161031e565b820191906000526020600020905b81548152906001019060200180831161030157829003601f168201915b505050505081565b60025481565b60015481565b6006818154811061028d57600080fd5b346107d0141561039e5760058054600181018255600091909152815161038f917f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db0019060208401906104ac565b506002805460010190556103f6565b34610bb814156103f6576006805460018101825560009190915281516103eb917ff652222313e28459528d920b65115c16c04f3efc82aaedc97be59f3f377c0d3f019060208401906104ac565b506002805460010190555b60008054600181810183558280527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56390910180546001600160a01b031916331790558054810190556004546040516001600160a01b0391909116913480156108fc02929091818181858888f19350505050158015610478573d6000803e3d6000fd5b5050565b60035481565b6000818154811061049257600080fd5b6000918252602090912001546001600160a01b0316905081565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826104e25760008555610528565b82601f106104fb57805160ff1916838001178555610528565b82800160010185558215610528579182015b8281111561052857825182559160200191906001019061050d565b50610534929150610538565b5090565b5b80821115610534576000815560010161053956fea2646970667358221220752b19dbdf43c747b87d1f2f6664868ea37e57b9e168cee5e9b53dd68dc0172364736f6c63430007050033";

    public static final String FUNC_ADDADRESS = "addAdress";

    public static final String FUNC_ADDRESSCOUNT = "addresscount";

    public static final String FUNC_ADDRESSES = "addresses";

    public static final String FUNC_BLE_ADDRESSES_A = "ble_addresses_a";

    public static final String FUNC_BLE_ADDRESSES_B = "ble_addresses_b";

    public static final String FUNC_COUNT_A = "count_a";

    public static final String FUNC_COUNT_B = "count_b";

    @Deprecated
    protected BLContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BLContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BLContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BLContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addAdress(String ble_add,BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ADDADRESS, 
                Arrays.<Type>asList(new Utf8String(ble_add)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> addresscount() {
        final Function function = new Function(FUNC_ADDRESSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> addresses(BigInteger param0) {
        final Function function = new Function(FUNC_ADDRESSES, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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
    public static BLContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BLContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BLContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BLContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BLContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BLContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BLContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BLContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BLContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(BLContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<BLContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(BLContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<BLContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(BLContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<BLContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(BLContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
