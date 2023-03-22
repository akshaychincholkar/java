package com.game.java.collections;

class MyEntry<K,V>{
    K key;
    V value;
    MyEntry<K,V> next;
}
class MyMap<K,V>{
    private MyEntry<K,V>[] table;
    private int capacity;

    MyMap(int capacity){
        this.capacity = capacity;
        table = new MyEntry[capacity];
    }

    public boolean put(K key,V value){
        if(key == null) return false;

        // get the hash value
        int hash = hashCode(key);
        MyEntry<K,V> newEntry = new MyEntry<>();
        newEntry.key = key;
        newEntry.value = value;

        if(table[hash] == null){
            table[hash] = newEntry;
            return true;
        }else{
            MyEntry previous = null;
            MyEntry current = table[hash];

            while(current!=null){
                if(current.key.equals(key)){
                    if(previous==null){
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return true;
                    }else{
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
            return true;
        }
    }

    public V get(K key){
        if(key == null) return null;
        int hash = hashCode(key);
        if(table[hash] == null) return null;
        else{
            MyEntry<K,V> current=table[hash];
            while (current != null){
                if(current.key.equals(key)){
                    return current.value;
                }
                current = current.next;
            }
        }
        return null;
    }

    public V remove(K key){
        if(key == null) return null;
        int hash = hashCode(key);

        if(table[hash] == null ) return null;
        else{
            MyEntry<K,V> current = table[hash];
            MyEntry<K,V> previous = null;
            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){
                        V value = table[hash].value;
                        table[hash] = table[hash].next;
                        return value;
                    }else{
                        previous.next = current.next;
                        return current.value;
                    }
                }
                previous = current;
                current = current.next;
            }
        }
        return null;
    }
    private int hashCode(K key) {
        return key.hashCode()%capacity;
    }
    public void display(){
        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                MyEntry<K,V> entry = table[i];
                while(entry!=null){
                    System.out.println("Key: "+entry.key+" Value: "+ entry.value);
                    entry = entry.next;
                }
            }
        }
    }
}
public class MyMapDemo {
    public static void main(String[] args) {
        MyMap<Integer,Integer> map = new MyMap<>(2);
        map.put(1,10);
        map.put(2,20);

        map.display();
        System.out.println("------------------");
        map.put(3,30);
        map.put(4,40);

        map.display();
        System.out.println("-----------------");
        map.remove(3);
        map.display();
    }
}
