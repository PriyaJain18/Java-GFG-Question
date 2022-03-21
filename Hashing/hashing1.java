import java.util.ArrayList;
import java.util.LinkedList;

class Chaining{

    int bucket ;     //length of bucket or hash-table
    ArrayList<LinkedList<Integer>> table;     //hash-tables

    void myHash(int b){
        bucket = b;

        //creating hash-table : 
        table = new ArrayList<LinkedList<Integer>>();

        //initializing each block of hash-table with Linked-List
        for(int i=0;i<b;i++){
            table.add(new LinkedList<Integer>());
        }
    }
    void insert(int key){
        int hash = key%bucket;
        table.get(hash).add(key);

    }
    boolean search(int key){
        int hash = key%bucket;
        return table.get(hash).contains(key);

    }
    void remove(int key){
        int hash = key%bucket;
        table.get(hash).remove((Integer) key); //type-casted to Integer so that .remove(Object) works not .remove(index)      
    }
}

class ClosedHashing{
  
    int bucket,size,table[]; //note : we have used fixed -size array here

    ClosedHashing(int bucket){
        this.bucket = bucket;
        size= 0;
        // int[] table = new int[bucket];

        for(int i=0;i<bucket;i++){
            table[i] = -1;       //represents empty cell/cell with no key
        }   
    }
    int hash(int key){
        return key % bucket;
    }

    //LINEAR PROBING :  //Assume -> -1 means empty space , -2 means deleted-key space

    boolean insertLP(int key){
        if(size == bucket){    //when bucket is full ,no space to insert 
            return false;
        }
        int i =  hash(key);
        while( table[i]!=-1 && table[i]!=-2 && table[i]!=key ){ //empty space =-1, deleted key-space =-2 ,3rd case -> key already present 
            i = (i+1) % bucket;
        }
        if(table[i] == key){
            System.out.println("Key already present in the bucket");
            return false;
        }else{
            table[i] = key;
            size++;
            System.out.println("Key inserted at index: "+i); 
            return true;
        }
    }

    boolean eraseLP(int key){   //Note: we donot stop at some deleted-key space as some-key-deletion might have took place after insertion of the key required to get deleted here
        int hash = hash(key);
        int i = hash;
        while(table[i]!=-1){  //jabtak empty space tak nhi pahuch jate we need to search the key to delete it 

            if(table[i]==key){   //key found then delete it 
                table[i] = -2;
                return true;
            }
            i = (i+1) % bucket;
            if(i == hash){      //written at last cuz if we write it at first then initial i would b considered and no loop would run
                return false;      //as we reached where we started and didn't find the key yet 
            }
        }
        return false; 
    }

    boolean searchLP(int key){
        int hash = hash(key);
        int i = hash; 
        while(table[i] != -1){
            if(table[i] == key){
                return true;
            }
            i = (i+1) % bucket;
            if(i==hash){ //circular loops complete by reaching same index, i.e hash
                return false;
            }
        }
        return false;
    }

    //DOUBLE HASHING : 

    void insertDH(int key,int x){ 
        int probe = hash(key);
        int offset = x - (key%x);
        
        if(table[probe] == -1){
            table[probe] = key;
            return;
        }
        int hash= probe;
        int i = 1;
        while(table[probe] != -1){   
            if(probe == hash){ //circular complete
                System.out.println("TABLE FULL");
                return;     
            }
            probe = (probe + i*offset) % bucket; 
            i++;    
        }
        table[probe] = key;
        System.out.println(key + " Inserted !");
        return;
    }
    void removeDH(int key){}

    boolean searchDH(int key){ return false;}
}

public class hashing1 {

    public static void main(String[] args) {

        Chaining chaining = new Chaining();
        chaining.myHash(7);
     
        chaining.insert(10);
        chaining.insert(13);
        chaining.search(10);
        chaining.insert(64);
        chaining.remove(10);
        chaining.insert(23);
        chaining.search(10);

        ClosedHashing ch = new ClosedHashing(10);   
        
        ch.insertLP(30);
        ch.insertLP(23);
        ch.insertLP(56);
        ch.searchLP(23);
        ch.insertLP(77);
        ch.eraseLP(23);
        ch.insertLP(94);
        ch.searchLP(23);
    }
}

/*

# HASHING : 

//(1) OPEN HASHING / CHAINING 
//(2) CLOSED HASHING /OPEN ADDRESSING : 

//note  : i -> collision no. like 1,2,3,4...
# 1. Linear Probing  :  hash(key,i) = (h(key) + i) % m   ;where h(key) = key % m   ; CONS -> Linear clusters

# 2. Quadratic Probing :  hash(key,i) = (h(key) + (i^2)) % m ;where h(key) = key % m 
  PROS  -> No linear clustering ,CONS -> Quadratic Clustering ; Works only when ALPHA(α) < 0.5 And m is prime

# 3.  Double Hashing : hash(key,i) = (h1(key) + i*h2(key)) % m ;where h1(key) = key % m
 EXAMPLE : m=7 , h1 = key%7  , h2 = 6 - (key%6) ; H2 should never return 0;m and h2 are relaively prime
 PROS -> uniform distribution; always find empty slots ; No clustering 

# DATASTRUCTURES THAT USE HASHING : 

// HashSet [only keys]=> {isEmpty ,  size , add [if key already present doesnot insert it again -> i.e. Unique values] ,remove ,contains }  - >O[1]  ,  clear, remove, 
// HashMap [keys and values] [Unordered/diff order] => put(key,val) , hm.put(x,hm.getOrDefault(x,0)+1) [increase value if the key-value pair already exists , 0 ->means default value/no value provided]
, size, remove('keyname') -> returns key's value,get('key'), containsKey('keyname') ,containsValue('val')
    -> O[1] most of the operations of HashMap , hashmap -> doesnt print-in/keep order of insertion of elements -> to maintain order-> LinkedHashMap data-Structure 
    // 1 key -> 1 time = uniquesness of keys ,  multiple keys can have same value . 
    // 1 null key can exist , multiple null values can exist
*/