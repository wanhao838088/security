package com.imooc.security.core.properties;

/**
 * Created by LiuLiHao on 2019/2/17 0017 下午 04:30
 * @author : LiuLiHao
 * 描述：
 */
public class OAuth2Properties {
    private OAuth2ClientProperties[] clients = {};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
