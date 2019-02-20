package com.imooc.security.core.properties;


/**
 * Created by LiuLiHao on 2019/2/17 0017 下午 04:29
 * @author : LiuLiHao
 * 描述：
 */
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private int accessTokenValidateSeconds = 7200;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public int getAccessTokenValidateSeconds() {
        return accessTokenValidateSeconds;
    }

    public void setAccessTokenValidateSeconds(int accessTokenValidateSeconds) {
        this.accessTokenValidateSeconds = accessTokenValidateSeconds;
    }
}
