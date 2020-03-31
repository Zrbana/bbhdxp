package com.zn.tangshianalyze.crawler.pipeline;

import com.zn.tangshianalyze.crawler.common.DataSet;


/**
 * Author: yuisma
 * Created: 2020/02/11
 */
public interface Pipeline {
    
    void process(DataSet dataSet);
}
