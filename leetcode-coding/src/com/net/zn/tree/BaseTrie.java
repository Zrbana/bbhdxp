package com.net.zn.tree;

public interface BaseTrie {
    /**
     * 插入字符串
     *
     * @param word
     */
    void insert(String word);

    /**
     * 删除指定字符串
     * @param word
     */
    void delete(String word);

    /**
     * 查找指定字符串
     * @param word
     */
    boolean find(String word);
}
