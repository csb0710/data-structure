package hashing;

public class hashing {
	static private int TABLE_SIZE = 13;
	static String[] hash_table = new String[TABLE_SIZE];
	static Node[] linked_hash_table = new Node[TABLE_SIZE]; 
	
	static private class Node {
    	private Object data;
    	private Node next;
    	
    	
    	public Node(Object input) {
    		this.data = input;
    		this.next = null;
    	}
    	
    	public String toString() {
    		return String.valueOf(this.data);
    	}
    }
	
	static void init_table(String[] ht) {
		for(int i = 0; i < TABLE_SIZE; i++)
			ht[i] = null;
	}
	
	static int transform(String key) {
		int number = 0;
		for(int i = 0; i < key.length(); i++) {
			number = number + key.charAt(i);
		}
		return number;
	}
	
	static int hash_function(String key) {
		return transform(key) % TABLE_SIZE;
	}
	
	static int hash_function2(String key) {
		return 11 - (transform(key) % 11);
	}
	
	static void hash_chain_add(String item, Node[] ht) {
		int hash_value = hash_function(item);
		Node node = ht[hash_value];
		
		for(; true; node = node.next) {
			if((String)node.data == item) {
				System.out.println("이미 저장됨");
				return ;
			}
			if(node.next == null)
				break;
		}
		
		Node ptr = new Node(item);
		if(node != null)
			node.next = ptr;
		else
			ht[hash_value] = ptr;
	}
	
	static void hash_chain_search(String item, Node[] ht) {
		int hash_value = hash_function(item);
		Node node = ht[hash_value];
		
		for(; node != null; node = node.next) {
			if((String)node.data == item) {
				System.out.println("탐색 성공");
				return ;
			}		
		}
		
		System.out.println("탐색 실패");
	}
	
	static void hash_lp_add(String item, String[] ht) {
		int i, hash_value;
		hash_value = i = hash_function(item);
		while((ht[i] != null)) {
			if(item.equals(ht[i])) {
				System.out.println("중복");
				System.exit(1);
			}
			i = (i+1) % TABLE_SIZE;
			if(i == hash_value) {
				System.out.println("가득참");
				System.exit(1);
			}
		}
		ht[i] = item;
	}
	
	static void hash_qp_add(String item, String[] ht) {
		int i, hash_value, inc = 0;
		hash_value = i = hash_function(item);
		while((ht[i] != null)) {
			if(item.equals(ht[i])) {
				System.out.println("중복");
				System.exit(1);
			}
			i = (hash_value + inc * inc) % TABLE_SIZE;
			inc++;
			if(i == hash_value) {
				System.out.println("가득참");
				System.exit(1);
			}
		}
		ht[i] = item;
	}
	
	static void hash_dh_add(String item, String[] ht) {
		int i, hash_value, inc;
		hash_value = i = hash_function(item);
		inc = hash_function2(item);
		while((ht[i] != null)) {
			if(item.equals(ht[i])) {
				System.out.println("중복");
				System.exit(1);
			}
			i = (i + inc) % TABLE_SIZE;
			if(i == hash_value) {
				System.out.println("가득참");
				System.exit(1);
			}
		}
		ht[i] = item;
	}
	
	static void hash_lp_search(String item, String[] ht) {
		int i, hash_value;
		hash_value = i = hash_function(item);
		while((ht[i] != null)) {
			if(item.equals(ht[i])) {
				System.out.println("위치" + i);
				return ;
			}
			i = (i+1) % TABLE_SIZE;
			if(i == hash_value) {
				System.out.println("없음");
			}
		}
		System.out.println("없음");
	}
	
	static void hash_lp_print(String[] ht) {
		for(int i = 0; i < TABLE_SIZE; i++) {
			if(ht[i] != null)
				System.out.println("[" + i + "]" + ht[i]);
			else
				System.out.println("[" + i + "]");
		}
		System.out.println("--------------------------------");
	}
	
	public static void main(String[] args) {
		String[] s = {"do", "for", "if", "case", "else", "return", "function"};
		for(int i = 0; i < 7; i++) {
			hash_lp_add(s[i], hash_table);
			hash_lp_print(hash_table);
		}
		for(int i = 0; i < 7; i++) {
			hash_lp_search(s[i], hash_table);
		}
	}

}
