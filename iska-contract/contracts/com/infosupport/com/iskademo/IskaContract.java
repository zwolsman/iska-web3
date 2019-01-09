package com.infosupport.com.iskademo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
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
 * <p>Generated with web3j version 4.0.1.
 */
public class IskaContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610182806100206000396000f3fe608060405234801561001057600080fd5b5060043610610052577c0100000000000000000000000000000000000000000000000000000000600035046328839949811461005757806355e4741d14610071575b600080fd5b61005f610090565b60408051918252519081900360200190f35b61008e6004803603602081101561008757600080fd5b50356100a3565b005b3360009081526020819052604090205490565b33600081815260208190526040902054821161010a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260258152602001806101326025913960400191505060405180910390fd5b73ffffffffffffffffffffffffffffffffffffffff1660009081526020819052604090205556fe4a65206b616e206765656e206c6167657265206b6d207374616e6420646f6f72676576656ea165627a7a723058202b0ad73d472d99c33a1faf9abb7942c12185f3650f619386836ea8f8fe4bf94d0029";

    public static final String FUNC_GETKMSTAND = "getKmStand";

    public static final String FUNC_UPDATEKMSTAND = "updateKmStand";

    @Deprecated
    protected IskaContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IskaContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IskaContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IskaContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getKmStand() {
        final Function function = new Function(FUNC_GETKMSTAND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> updateKmStand(BigInteger n) {
        final Function function = new Function(
                FUNC_UPDATEKMSTAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(n)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IskaContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IskaContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IskaContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IskaContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IskaContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IskaContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IskaContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IskaContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IskaContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IskaContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IskaContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IskaContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IskaContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IskaContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IskaContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IskaContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
