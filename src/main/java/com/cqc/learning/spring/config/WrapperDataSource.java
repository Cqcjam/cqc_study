/**
 * @author wb.ruiyuejian
 * @date 2019/12/5 10:44
 */

package com.cqc.learning.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mysql 数据源包装类
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class WrapperDataSource {

    private String url;

    private String username;

    private String password;

}
