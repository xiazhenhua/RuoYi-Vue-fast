package com.ruoyi.project.common;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

/**
 * 功能描述
 *
 * @author: Sherlock
 * @date: 2022年10月20日 15:31
 */
@Component
public class RestTemplateUtils {

    private static RestTemplate restTemplate;

    @Autowired(required = true)
    public void setRestTemplate(RestTemplate r) {
        RestTemplateUtils.restTemplate = r;
    }

    /**
     * 用于访问其他服务的工具方法
     * 主要用于权限验证部分
     *
     * @param url  用于访问的URL 地址
     * @param auth  用于报文头传递的验证信息
     * @param type  用于反串行化远程返回的数据结构的类型
     * @param <T> 泛型
     * @return 进行反串行化后的返回对象
     */
    public static <T> T getRestResponse(String url, String auth, Class<T> type) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        auth = StringUtils.trimToNull(auth);
        if (auth != null) {
            requestHeaders.add("Authorization", auth);
        }

        RestTemplate template = restTemplate;
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String json = response.getBody();
        T ins = JSON.parseObject(json, type);

        return ins;
    }

    /**
     * 用于POST访问其他服务的工具方法
     *
     * @param url  用于访问的URL 地址
     * @param auth  用于报文头传递的验证信息
     * @param type  用于反串行化远程返回的数据结构的类型
     * @param <T> 泛型
     * @param data 对象
     * @return 进行反串行化后的返回对象
     */
    public static <T> T postRestResponse(String url, Object data, Class<T> type, String auth) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        auth = StringUtils.trimToNull(auth);
        if (auth != null) {
            requestHeaders.add("Authorization", auth);
        }

        RestTemplate template = restTemplate;
        String requestBody = JSON.toJSONString(data);
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String json = response.getBody();
        T ins = JSON.parseObject(json, type);

        return ins;
    }
}
