package entity;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transaction;

public class Block implements Serializable{

	/**
	 * 区块结构
	 *
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * 区块索引号(区块高度)
	 */
	private int index;
	/**
	 * 当前区块的hash值,区块唯一标识
	 */
	private String hash;
	/**
	 * 前一个区块的hash值
	 */
	private String previousHash;
	/**
	 * 生成区块的时间戳
	 */
	private long timestamp;
	/**
	 * 工作量证明，计算正确hash值的次数
	 */
	private int nonce;
	/**
	 * 当前区块存储的业务数据集合（例如转账交易信息、票据信息、合同信息等）
	 */
	private List<Transaction> transactions;
  
	public void setIndex(int index){
		index = this.index;
	}
	public int getIndex(){
		return index;
	}
	public void setHash(String hash){
		hash = this.hash;
	}
	public String getHash(){
		return hash;
	}
	public void setPreviousHash(String previousHash){
		previousHash = this.previousHash;
	}
	public String getPreviousHash(){
		return previousHash;
	}
	public void setNonce(int nonce){
		nonce = this.nonce;
	}
	public int getNonce(){
		return nonce;
	}
	public void setTimestamp(long timestamp){
		timestamp = this.timestamp;
	}
	public long getTimesstamp(){
		return timestamp;
	}
	public void setTransactions(List<Transaction> transactions){
		transactions = this.transactions;
	}
	public List<Transaction> getTransactions(){
		return transactions;
	}

}
