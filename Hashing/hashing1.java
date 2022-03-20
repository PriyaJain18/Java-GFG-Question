import java.util.ArrayList;
import java.util.LinkedList;

class Chaining{

    int bucket ;     //length of bucket or hash-table
    ArrayList<LinkedList<Integer>> table;     //hash-tables

    int myHash(int b){
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
    bool search(int key){
        int hash = key%bucket;
        return table.get(hash).contains(key);

    }
    void remove(int key){
        int hash = key%bucket;
        table.get(hash).remove((Integer) key); //type-casted to Integer so that .remove(Object) works not .remove(index)      
    }
}

class ClosedHashing{
    int bucket,size;
    ClosedHashing(int bucket){
        this.bucket = bucket;
        int size= 0;
        ArrayList<Integer> table = new ArrayList<>(bucket);

        for(int i=0;i<bucket;i++){
            table.add(-1);       //represents empty cell/cell with no key
        }   
    }
    int hash(int key){
        int hash = key % bucket;
        return hash;
    }

    //LINEAR PROBING :  

    void insertLP(int key){}

    void deleteLP(int key){}

    boolean searchLP(int key){
        int hash = hash(key);
        int i = hash; 
        while(table.get(i) != -1){
            if(table.get(i) == key){
                return true;
            }
            i = (i+1) % bucket;
            if(i==h){ //circular loops complete by reaching same index, i.e hash
                return false;
            }
        }
        return false;
    }

    

    //DOUBLE HASHING : 

    void insertDH(int key,int x){ 
        int probe = hash(key);
        int offset = x - (key%x);
        
        if(table.get(probe) == -1){
            table.get(probe).add(key);
            return;
        }
        int hash= probe;
        int i = 1;
        while(table.get(probe) != -1){   
            if(probe == hash){ //circular complete
                System.out.println("TABLE FULL");
                return;     
            }
            probe = (probe + i*offset) % bucket; 
            i++;    
        }
        table.get(probe).add(key);
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

//note  : i -> collision no. like 1,2,3,4...
        LinearProbing lp = new LinearProbing(); //hash(key,i) = (h(key) + i) % m ;where h(key) = key % m

//searching cases -> when key cannot be found using LP , finds an DELETED [marked]/empty slot before finding key while finding hash+i;
//reached same cell after Circular round but could'nt find the key 
//CONS -> Linear clusters


        QuadraticProbing qp = new QuadraticProbing();    //hash(key,i) = (h(key) + (i^2)) % m ;where h(key) = key % m

//PROS  -> No linear clustering
//CONS -> Quadratic Clustering ; Works only when ALPHA(α) < 0.5 And m is prime
        DoubleHashing dh = new DoubleHashing();     //hash(key,i) = (h1(key) + i*h2(key)) % m ;where h1(key) = key % m
//EXAMPLE : m=7 , h1 = key%7  , h2 = 6 - (key%6) ; H2 should never return 0;m and h2 are relaively prime
        // PROS -> uniform distribution; always find empty slots ; No clustering 



    }
    
}
