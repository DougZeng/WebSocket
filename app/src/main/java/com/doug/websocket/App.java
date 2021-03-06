package com.doug.websocket;

import android.app.Application;
import android.content.Intent;

import com.doug.lib.WebSocketService;
import com.doug.lib.WebSocketSetting;

/**
 * Created by wesine on 2018/9/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //配置 WebSocket，必须在 WebSocket 服务启动前设置
        WebSocketSetting.setConnectUrl("Your WebSocket connect url");//必选
        WebSocketSetting.setResponseProcessDelivery(new AppResponseDispatcher());
        WebSocketSetting.setReconnectWithNetworkChanged(true);

        //启动 WebSocket 服务
        startService(new Intent(this, WebSocketService.class));
    }
}
