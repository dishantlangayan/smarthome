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
 * DataServiceToken is an receipt returned by the {@link DataTransport} after
 * the publishing of a message. Such receipt can be used to track and compare
 * subsequence message confirmation callbacks.
 */
public class DataTransportToken {
    private int messageId;
    private String sessionId;

    public DataTransportToken(int messageId, String sessionId) {
        super();
        this.messageId = messageId;
        this.sessionId = sessionId;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + messageId;
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataTransportToken other = (DataTransportToken) obj;
        if (messageId != other.messageId)
            return false;
        if (sessionId == null) {
            if (other.sessionId != null)
                return false;
        } else if (!sessionId.equals(other.sessionId))
            return false;
        return true;
    }
}
