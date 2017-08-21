/**
 * Copyright 2017 Dishant Langayan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dishant.iot.smarthome.data;

import com.dishant.iot.smarthome.SmarthomeConnectException;
import com.dishant.iot.smarthome.SmarthomeException;
import com.dishant.iot.smarthome.SmarthomeNotConnectedException;
import com.dishant.iot.smarthome.SmarthomeRuntimeException;
import com.dishant.iot.smarthome.SmarthomeTimeoutException;

/**
 * The DataTransport provides the ability of connecting to a remote broker,
 * publish messages, subscribe to topics, receive messages on the subscribed
 * topics, and disconnect from the remote message broker.
 */
public interface DataTransport {
    /**
     * Connects to the remote broker. This method will block until the connection is
     * established or a timeout occurs. The actual configuration needed to establish
     * a connection is protocol specific (e.g. MQTT).
     * 
     * @throws SmarthomeRuntimeException
     * @throws SmarthomeConnectException
     */
    public void connect() throws SmarthomeRuntimeException, SmarthomeConnectException;

    /**
     * Returns true if the {@link DataTransport} is currently connected to the
     * remote server.
     */
    public boolean isConnected();

    public String getBrokerUrl();

    public String getUsername();

    public String getClientId();

    /**
     * Disconnects from the broker. This method will block, up to the specified
     * duration, allowing the protocol implementation to complete delivery of
     * in-flight messages before actually disconnecting from the broker.
     * 
     * @param quiesceTimeout
     *            - timeout that will be used before forcing a disconnect
     */
    public void disconnect(long quiesceTimeout);

    /**
     * Subscribes to a topic on the broker. This method MAY block until the
     * underlying protocol message (e.g. the MQTT SUBSCRIBE message) is acknowledged
     * by the broker or a timeout occurs. This message is idempotent so the caller
     * may safely retry subscribing. The timeout interval used by the service is
     * configurable through the configuration files.
     * 
     * @param topic
     * @param qos
     * @throws SmarthomeTimeoutException
     * @throws SmarthomeException
     * @throws SmarthomeNotConnectedException
     */
    public void subscribe(String topic, int qos)
            throws SmarthomeTimeoutException, SmarthomeException, SmarthomeNotConnectedException;

    /**
     * Unsubscribes to a topic on the broker. This method MAY block until the
     * underlying protocol message (e.g. the MQTT UNSUBSCRIBE message) is
     * acknowledged by the broker or a timeout occurs. The timeout interval used by
     * the service is configurable through configuration file.
     * 
     * @param topic
     * @throws SmarthomeTimeoutException
     * @throws SmarthomeException
     * @throws SmarthomeNotConnectedException
     */
    public void unsubscribe(String topic)
            throws SmarthomeTimeoutException, SmarthomeException, SmarthomeNotConnectedException;

    /**
     * Enqueues a message for publishing with the underlying transport
     * implementation. An active connection to the remote server is required.
     * 
     * @param topic
     * @param payload
     * @param qos
     * @param retain
     * @return
     * @throws SmarthomeException
     * @throws SmarthomeNotConnectedException
     */
    public DataTransportToken publish(String topic, byte[] payload, int qos, boolean retain)
            throws SmarthomeException, SmarthomeNotConnectedException;
}
