package com.game.java.collections;

class CustomEntry<K,V>{
    K key;
    V value;
    public CustomEntry(K key,V value){
        this.key = key;
        this.value = value;
    }
    CustomEntry next;
}
class CustomMap<K,V>{
    CustomEntry[] hashTable;
    int capacity;
    CustomMap(int capacity){
        this.capacity = capacity;
        hashTable = new CustomEntry[capacity];
    }
    public void put(K key,V value){
        if(key == null) return;
        int hash = hashCode(key);

        CustomEntry<K,V> newEntry = new CustomEntry<>(key,value);

        //now check for the table contents
        if(hashTable[hash] == null){
            //insert the newEntry to the table
            hashTable[hash] = newEntry;
        }else{
            //collision detected
            //check for the end of the linked list
            CustomEntry current = hashTable[hash];
            CustomEntry previous = null;

            while(current!=null){
                if(current.key.equals(key)){
                    if(previous == null){
                        newEntry.next = current.next;
                        hashTable[hash]=newEntry;
                        return;
                    }
                }else{
                    newEntry.next = current.next;
                    previous.next=newEntry;
                    return;
                }
                previous=current;
                current=current.next;
            }
            previous.next = newEntry;
        }
    }
    public V get(K key){
        int hash = hashCode(key);
        if(hashTable[hash]==null) return null;
        else{
            CustomEntry<K,V> temp = hashTable[hash];
            while(temp!=null){
                if(temp.key.equals(key)) return temp.value;
                temp = temp.next;
            }
        }
        return null;
    }
    public int hashCode(K key){
        //hashcode function
        return key.hashCode();
    }
    public boolean remove(K key){
        int hash = hashCode(key);
        if(hashTable[hash] == null) return false;
        else{
            CustomEntry<K,V> previous = null;
            CustomEntry<K,V> current = hashTable[hash];
            while(current!=null){
                if(current.key.equals(key)){
                    if(previous == null){
                        hashTable[hash] = hashTable[hash].next;
                        return true;
                    }
                }else{
                    previous.next=current.next;
                    return true;
                }
                previous.next =current;
                current = current.next;
            }
        }
        return false;
    }
}
/**
 * Hello world!
 *
 */
public class CustomMapDemo
{
    public static void main( String[] args )
    {
        CustomMap<Integer,Integer> map = new CustomMap<>(5);
        map.put(1,10);
        map.put(2,20);

        System.out.println(map.get(1));
        System.out.println(map.get(2));

        map.put(1,100);
        System.out.println(map.get(1));

        map.remove(2);
        System.out.println(map.get(2));
    }
}
