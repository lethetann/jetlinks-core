package org.jetlinks.core.message.codec;


import org.jetlinks.core.device.DeviceOperator;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 消息编解码上下文
 * @author zhouhao
 * @since 1.0.0
 */
public interface MessageCodecContext {

    /**
     * 获取当前上下文中到设备操作接口,
     * 在tcp,http等场景下,此接口可能返回{@code null}
     *
     * @return DeviceOperator
     */
    @Nullable
    DeviceOperator getDevice();

    /**
     * 同{@link this#getDevice()},只是返回结果是Mono,不会为null.
     *
     * @return Mono<DeviceOperator>
     * @since 1.1.2
     */
    default Mono<DeviceOperator> getDeviceAsync() {
        return Mono.justOrEmpty(getDevice());
    }

    /**
     * 获取指定设备的操作接口.
     * 如果设备不存在,则为{@link Mono#empty()},可以通过{@link Mono#switchIfEmpty(Mono)}进行处理.
     *
     * @param deviceId 设备ID
     * @return Mono<DeviceOperator>
     * @since 1.1.2
     */
    default Mono<DeviceOperator> getDevice(String deviceId) {
        return Mono.empty();
    }
}
