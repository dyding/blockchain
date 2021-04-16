package entity;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transaction;

public class Block implements Serializable{

	/**
	 * ����ṹ
	 *
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * ����������(����߶�)
	 */
	private int index;
	/**
	 * ��ǰ�����hashֵ,����Ψһ��ʶ
	 */
	private String hash;
	/**
	 * ǰһ�������hashֵ
	 */
	private String previousHash;
	/**
	 * ���������ʱ���
	 */
	private long timestamp;
	/**
	 * ������֤����������ȷhashֵ�Ĵ���
	 */
	private int nonce;
	/**
	 * ��ǰ����洢��ҵ�����ݼ��ϣ�����ת�˽�����Ϣ��Ʊ����Ϣ����ͬ��Ϣ�ȣ�
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
