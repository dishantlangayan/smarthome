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
package com.dishant.iot.smarthome.data.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mqtt")
public class MqttConfiguration {

    private String clientId;
    private String brokerUrl;
    private int keepAlive;
    private int timeout;
    private boolean cleanSession;
    private String username;
    private String password;
    private int defaultVersion;
    private boolean autoReconnect;
    private boolean bufferEnabled;
    private int bufferSize;
    private boolean deleteOldestMessages;
    private boolean persistBuffer;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean getCleanSession() {
        return cleanSession;
    }

    public void setCleanSession(boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDefaultVersion() {
        return defaultVersion;
    }

    public void setDefaultVersion(int defaultVersion) {
        this.defaultVersion = defaultVersion;
    }

    public boolean getAutoReconnect() {
        return autoReconnect;
    }

    public void setAutoReconnect(boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
    }

    public boolean getBufferEnabled() {
        return bufferEnabled;
    }

    public void setBufferEnabled(boolean bufferEnabled) {
        this.bufferEnabled = bufferEnabled;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public boolean getDeleteOldestMessages() {
        return deleteOldestMessages;
    }

    public void setDeleteOldestMessages(boolean deleteOldestMessages) {
        this.deleteOldestMessages = deleteOldestMessages;
    }

    public boolean getPersistBuffer() {
        return persistBuffer;
    }

    public void setPersistBuffer(boolean persistBuffer) {
        this.persistBuffer = persistBuffer;
    }
}
