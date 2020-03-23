package com.Yimm.TangShiAnalyse.analyse.entity;

import lombok.Data;

/**
 * @ClassName Poetry
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/23 22:35
 */

@Data
public class PoetryInfo {
    /*标题*/
    private String title;
    /*作者朝代*/
    private String dynasty;
    /*作者*/
    private String author;
    /*正文*/
    private String content;
}
