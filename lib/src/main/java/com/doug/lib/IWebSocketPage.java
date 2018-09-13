package com.doug.lib;

/**
 * Created by wesine on 2018/9/13.
 */

public interface IWebSocketPage extends SocketListener {

    /**
     * WebSocketService 绑定成功回调
     */
    void onServiceBindSuccess();

    /**
     * 通过 WebSocketService 发送数据
     *
     * @param text 需要发送的文本数据
     */
    void sendText(String text);

    /**
     * 重新连接，内部已经做了自动重连机制，一般不需要使用此方法
     */
    void reconnect();
}
