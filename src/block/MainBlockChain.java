package block;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class MainBlockChain {
	public static ArrayList<BlockChain> blockchain = new ArrayList<BlockChain>(); 
	
public static void main(String[] args) {
	
	blockchain.add(new BlockChain("first block", "0"));
	blockchain.add(new BlockChain("second block",blockchain.get(blockchain.size()-1).hash)); 
	blockchain.add(new BlockChain("third block",blockchain.get(blockchain.size()-1).hash));
	
	String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
	System.out.println(blockchainJson);
	
	/*// print all hashes.
		BlockChain genesisBlock = new BlockChain("First Block","0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		BlockChain secondBlock = new BlockChain("second block",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		BlockChain thirdBlock = new BlockChain("third block",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		*/
	}
public static Boolean isChainValid() {
	BlockChain currentBlock; 
	BlockChain previousBlock;
	
	//loop through blockchain to check hashes:
	for(int i=1; i < blockchain.size(); i++) {
		currentBlock = blockchain.get(i);
		previousBlock = blockchain.get(i-1);
		//compare registered hash and calculated hash:
		if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
			System.out.println("Current Hashes not equal");			
			return false;
		}
		//compare previous hash and registered previous hash
		if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
			System.out.println("Previous Hashes not equal");
			return false;
		}
	}
	return true;
}

}
