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
public class Able_sol_Able extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516104cf3803806104cf8339818101604052602081101561003357600080fd5b5051600280546001600160a01b0319166001600160a01b0390921691909117905561046c806100636000396000f3fe60806040526004361061003f5760003560e01c80636c015acf146100445780638ae27d341461006b578063af805b651461010a578063edf26d9b146101b2575b600080fd5b34801561005057600080fd5b506100596101f8565b60408051918252519081900360200190f35b34801561007757600080fd5b506100956004803603602081101561008e57600080fd5b50356101fe565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100cf5781810151838201526020016100b7565b50505050905090810190601f1680156100fc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101b06004803603602081101561012057600080fd5b81019060208101813564010000000081111561013b57600080fd5b82018360208201111561014d57600080fd5b8035906020019184600183028401116401000000008311171561016f57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506102a7945050505050565b005b3480156101be57600080fd5b506101dc600480360360208110156101d557600080fd5b503561036b565b604080516001600160a01b039092168252519081900360200190f35b60015481565b6003818154811061020e57600080fd5b600091825260209182902001805460408051601f600260001961010060018716150201909416939093049283018590048502810185019091528181529350909183018282801561029f5780601f106102745761010080835404028352916020019161029f565b820191906000526020600020905b81548152906001019060200180831161028257829003601f168201915b505050505081565b60008054600181810183557f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56390910180546001600160a01b031916331790556003805491820181559091528151610325917fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01906020840190610395565b5060018054810190556002546040516001600160a01b03909116903480156108fc02916000818181858888f19350505050158015610367573d6000803e3d6000fd5b5050565b6000818154811061037b57600080fd5b6000918252602090912001546001600160a01b0316905081565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826103cb5760008555610411565b82601f106103e457805160ff1916838001178555610411565b82800160010185558215610411579182015b828111156104115782518255916020019190600101906103f6565b5061041d929150610421565b5090565b5b8082111561041d576000815560010161042256fea264697066735822122032b4cb8d19780399000c6b30fec2792854dfecbeb7eb3556f057b728ee28492a64736f6c63430007050033";

    public static final String FUNC_ADDADRESS = "addAdress";

    public static final String FUNC_ADDRESSCOUNT = "addresscount";

    public static final String FUNC_ADDRESSES = "addresses";

    public static final String FUNC_BLE_ADDRESSES = "ble_addresses";

    @Deprecated
    protected Able_sol_Able(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Able_sol_Able(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Able_sol_Able(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Able_sol_Able(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addAdress(String ble_add) {
        final Function function = new Function(
                FUNC_ADDADRESS, 
                Arrays.<Type>asList(new Utf8String(ble_add)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<String> ble_addresses(BigInteger param0) {
        final Function function = new Function(FUNC_BLE_ADDRESSES, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Able_sol_Able load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Able_sol_Able(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Able_sol_Able load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Able_sol_Able(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Able_sol_Able load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Able_sol_Able(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Able_sol_Able load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Able_sol_Able(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Able_sol_Able> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(Able_sol_Able.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Able_sol_Able> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(Able_sol_Able.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Able_sol_Able> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(Able_sol_Able.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Able_sol_Able> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _wallet_reciever) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, _wallet_reciever)));
        return deployRemoteCall(Able_sol_Able.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
