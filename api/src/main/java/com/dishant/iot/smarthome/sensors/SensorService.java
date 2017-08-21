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
package com.dishant.iot.smarthome.sensors;

public interface SensorService {
    class NoSuchSensorOrActuatorException extends Exception {
        private static final long serialVersionUID = 2612352095893222404L;
    };

    /**
     * @return current sensor value
     */
    Object getSensorValue(String sensorName) throws NoSuchSensorOrActuatorException;

    /**
     * 
     * @param actuatorName
     * @param value
     * @throws NoSuchSensorOrActuatorException
     */
    void setActuatorValue(String actuatorName, Object value) throws NoSuchSensorOrActuatorException;

    /**
     * 
     * @param listener
     */
    void addSensorChangedListener(SensorChangedListener listener);

    /**
     * 
     * @param listener
     */
    void removeSensorChangedListener(SensorChangedListener listener);

    void activate();

    void deactivate();
}