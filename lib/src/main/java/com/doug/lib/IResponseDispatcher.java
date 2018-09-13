package com.doug.lib;

/**
 * Created by wesine on 2018/9/13.
 */

public interface IResponseDispatcher {
    /**
     * 连接成功
     */
    void onConnected(ResponseDelivery delivery);

    /**
     * 连接失败
     *
     * @param cause 失败原因
     */
    void onConnectError(Throwable cause, ResponseDelivery delivery);

    /**
     * 连接断开
     */
    void onDisconnected(ResponseDelivery delivery);

    /**
     * 接收到消息
     *
     * @param message 接收到的消息
     * @param delivery 消息发射器
     */
    void onMessageResponse(Response message, ResponseDelivery delivery);

    /**
     * 消息发送失败或接受到错误消息等等
     */
    void onSendMessageError(ErrorResponse error, ResponseDelivery delivery);
}
