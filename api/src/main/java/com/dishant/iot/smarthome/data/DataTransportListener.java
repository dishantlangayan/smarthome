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

/**
 * Listener interface to be implemented by Smarthome publishers that needs to be
 * notified of events in the {@link DataTransport}. All registered listeners are
 * called synchronously by the {@link DataTransport} at the occurrence of the
 * event. It expected that implementers of this interface do NOT perform long
 * running tasks in the implementation of this interface.
 */
public interface DataTransportListener {
    /**
     * Notifies the listener of the establishment of the new connection with the
     * remote server.
     */
    public void onConnectionEstablished();

    /**
     * Notifies the listener that the connection to the remote server is about to be
     * terminated.
     */
    public void onDisconnecting();

    /**
     * Notifies the listener that the connection to the remote server has been
     * terminated.
     */
    public void onDisconnected();

    /**
     * Notifies the listener that the connection to the remote server has been lost.
     */
    public void onConnectionLost(Throwable cause);

    /**
     * Notifies the listener that a new message has been received from the remote
     * server.
     */
    public void onMessageArrived(String topic, byte[] payload, int qos, boolean retained);

    /**
     * Notifies the listener that a message has been confirmed by the remote server.
     * 
     * @param messageId
     *            the id of message that has been confirmed
     * @param topic
     *            the topic on which the message was published
     */
    public void onMessageConfirmed(int messageId, String topic);
}
