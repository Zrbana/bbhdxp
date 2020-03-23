package com.Yimm.TangShiAnalyse.crawier.PipeLine;

import com.Yimm.TangShiAnalyse.crawier.common.Page;

import java.util.Map;

/**
 * @ClassName Poetry
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/19 17:53
 */
public class ConsolePipeline implements Pipeline {
    @Override
    public void pipeline(final Page page) {
        Map<String,Object> data = page.getDataSet().getData();
        //存储
        System.out.println(data);
    }
}
