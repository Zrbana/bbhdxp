package com.net.zn.tree.example;

import java.util.*;

/**
 * @ClassName Main
 * @Description
 * @Author yuisama
 * @Date 2020/3/28 14:09
 */


public class Main {
    /**
     * 字符的压缩编码
     * 方法一：将列表中的存入Set集合中，遍历每个字符串的后缀，如果集合中有这个后缀，就把他删除
     * 集合中剩余的字符个数就是最终的结果
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words){

        Map<TrieNode, Integer> map = new HashMap<>();
        TrieNode node = new TrieNode();

        //将字符数组中的每个字符串逆序插入
        for(int i =0 ;i<words.length;i++){
            String subStr = words[i];
            TrieNode cur = node;
            for(int j=subStr.length()-1;j>=0;j--){
                char ch = subStr.charAt(j);
               cur = cur.insert(ch);
            }
            //将节点，i 存入HashMap中
            map.put(cur,i);
        }

        //遍历HashMap
        int ans = 0;
        for (TrieNode nodes: map.keySet()) {
            if (nodes.count == 0) {
                ans += words[map.get(nodes)].length() + 1;
            }
        }
        return ans;


    }

    class TrieNode{
        //数组存放字符
        TrieNode[] list;
        //计数该叶子节点有多少个节点
        int count;
        public TrieNode(){
            list = new TrieNode[26];
        }

        /**
         * 向字典树中插入字符
         * @param c
         */
        public TrieNode insert(char c){
            TrieNode node = new TrieNode();
            //如果当前字典树中不存在这个字符，就插入它，并且让计数器的值+1
            if(list[c-'a']==null){
                list[c-'a']=node;
                count++;
            }
            //如果存在，就返回这个节点
            return list[c-'a'];
        }
    }
}
