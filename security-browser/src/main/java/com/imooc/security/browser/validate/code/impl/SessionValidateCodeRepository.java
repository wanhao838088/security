package com.imooc.security.browser.validate.code.impl;

import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.ValidateCodeException;
import com.imooc.security.core.validate.code.ValidateCodeRepository;
import com.imooc.security.core.validate.code.ValidateCodeType;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import static com.imooc.security.core.validate.code.ValidateCodeProcessor.SESSION_KEY_PREFIX;

/**
 * Created by LiuLiHao on 2019/2/17 0017 上午 11:29
 * @author : LiuLiHao
 * 描述：浏览器的短信验证码 发送和存储
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * redis保存验证码
     */
    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
        sessionStrategy.setAttribute(request, ValidateCodeType.SMS.getParamNameOnValidate(), code);
    }

    /**
     * 获取redis中的验证码
     */
    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        return (ValidateCode) sessionStrategy.getAttribute(request, ValidateCodeType.SMS.getParamNameOnValidate());
    }


    /**
     * 删除redis中的验证码
     */
    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        sessionStrategy.removeAttribute(request,ValidateCodeType.SMS.getParamNameOnValidate());
    }

    /**
     * 构建保存在redis中的key
     * @param request
     * @param type
     * @return
     */
    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" + type.toString().toLowerCase() + ":" + deviceId;
    }
    /**
     * 构建验证码放入session时的key
     *
     * @param request
     * @return
     */
    private String getSessionKey(ServletWebRequest request) {
        return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }


}
