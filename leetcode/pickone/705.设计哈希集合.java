/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
// class MyHashSet {
//     boolean[] hash;

//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         hash = new boolean[1000001];
//     }
    
//     public void add(int key) {
//         hash[key] = true;
//     }
    
//     public void remove(int key) {
//         hash[key] = false;
//     }
    
//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//         return hash[key];
//     }
// }


class MyHashSet {
    int[] hash;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hash = new int[40000];
    }
    
    public void add(int key) {
        int bucketId = key / 32;
        int loc = key % 32;
        setVal(bucketId, loc, true);
    }
    
    public void remove(int key) {
        int bucketId = key / 32;
        int loc = key % 32;
        setVal(bucketId, loc, false);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketId = key / 32;
        int loc = key % 32;
        return getVal(bucketId, loc);
    }

    private void setVal(int bucketId, int loc, boolean val){
        if(val){
            int u = hash[bucketId] | (1 << loc);
            hash[bucketId] = u;
        }else{
            int u = hash[bucketId] & ~(1 << loc);
            hash[bucketId] = u;
        }
    }

    private boolean getVal(int bucketId, int loc){
        return (hash[bucketId] >> loc & 1) == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

