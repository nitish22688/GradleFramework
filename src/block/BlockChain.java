package block;

import java.util.Date;

public class BlockChain {
	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private long timeStamp;
	
	public BlockChain(String Data,String timeStamp)
	{
		this.data=data;
		this.previousHash=previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}
}

