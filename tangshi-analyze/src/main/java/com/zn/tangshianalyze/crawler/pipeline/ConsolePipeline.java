package com.zn.tangshianalyze.crawler.pipeline;

import com.zn.tangshianalyze.crawler.common.DataSet;
import org.springframework.stereotype.Component;


/**
 * Author: yuisma
 * Created: 2020/02/15
 */
@Component
public class ConsolePipeline implements Pipeline {
    
    @Override
    public void process(DataSet dataSet) {
        System.out.println(dataSet.getData());
    }
}
