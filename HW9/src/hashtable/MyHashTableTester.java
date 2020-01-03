package hashtable;

class MyHashTableTester<K, V> 
{
	
// Driver method to test MyHashTable class 
    public static void main(String[] args) 
    { 
        MyHashTable<String, Integer> map = new MyHashTable<>(); 
        map.add("Harry",1 ); 
        map.add("Nina",2 ); 
        map.add("Harry",4 ); 
        map.add("Tony",5 ); 
        System.out.println(map.size()); 
        System.out.println(map.remove("Harry")); 
        System.out.println(map.remove("Harry")); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 
    } 
}