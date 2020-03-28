package com.net.zn.tree;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/28 13:35
 */


public class Trie implements BaseTrie
{

    //创建一个根节点
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    @Override
    public void insert(String word) {
        //先创建一个根节点
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            char currentChar = word.charAt(i);
            //如果当前这个字符不存在就添加一个新的节点
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            //如果当前这个字符已经存在，取出即可
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    @Override
    public void delete(String word) {

    }

    @Override
    public boolean find(String word) {
        return false;
    }
}


 class TrieNode{
    //数组存放26个字母
    private TrieNode[] links;
    private final  int R = 26;

    //指定节点是对应键的结尾还是只是键前缀
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[R];
    }


     /**
      * 判断是否包含某个字符
      * @param c
      * @return
      */
    public boolean containsKey(char c){
        return links[c-'a'] !=null;
    }

     /**
      * 将字符c 添加到树中
      * @param c
      * @param node
      */
    public void put(char c,TrieNode node){
        links[c-'a'] = node;
    }
    //得到某个节点
     public TrieNode get(char c){
        return links[c-'a'];
     }
     //设置为键结尾
     public void setEnd(){
        isEnd=  true;
     }
     //判断是否是结尾
     public boolean isEnd(){
        return isEnd;
     }
}