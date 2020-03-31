package com.zn.tangshianalyze.crawler.pipeline;

import com.zn.tangshianalyze.analyze.entity.PoetryInfo;
import com.zn.tangshianalyze.crawler.common.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


/**
 * Author: yuisma
 * Created: 2020/02/15
 */
@Component
public class DatabasePipeline implements Pipeline {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void process(DataSet dataSet) {
        Optional<PoetryInfo> optional = convert(dataSet);
        if (optional.isPresent()) {
            PoetryInfo poetryInfo = optional.get();
            String sql = "insert into poetry_info (meta_id, meta_url, meta_create,author_name, author_dynasty, content_title, content_body) values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    poetryInfo.getMetaId(),
                    poetryInfo.getMetaUrl(),
                    poetryInfo.getMetaCreate(),
                    poetryInfo.getAuthorName(),
                    poetryInfo.getAuthorDynasty(),
                    poetryInfo.getContentTitle(),
                    poetryInfo.getContentBody()
            );
        }
    }
    
    
    private Optional<PoetryInfo> convert(DataSet dataSet) {
        if (dataSet.getData().isEmpty()) {
            return Optional.empty();
        } else {
            PoetryInfo poetryInfo = new PoetryInfo();
            poetryInfo.setMetaId(UUID.randomUUID().toString().replace("-", ""));
            poetryInfo.setMetaUrl((String) dataSet.getData("url"));
            poetryInfo.setMetaCreate(LocalDateTime.now());
            poetryInfo.setAuthorDynasty((String) dataSet.getData("dynasty"));
            poetryInfo.setAuthorName((String) dataSet.getData("author"));
            poetryInfo.setContentTitle((String) dataSet.getData("title"));
            poetryInfo.setContentBody((String) dataSet.getData("content"));
            return Optional.of(poetryInfo);
        }
    }
}
