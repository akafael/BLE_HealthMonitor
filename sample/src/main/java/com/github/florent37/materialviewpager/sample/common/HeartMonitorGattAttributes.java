package com.github.florent37.materialviewpager.sample.common;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by rafael on 3/14/15.
 */
public class HeartMonitorGattAttributes {

    private static HashMap<String, String> attributes = new HashMap();
    public static String PPG_MEASUREMENT = "0000fff6-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static String SIMPLE_PROFILE_SERVICE = "0000fff0-0000-1000-8000-00805f9b34fb";

    static {
        // Sample Services.
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Geiger Counter Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service");
        // Sample Characteristics.
        attributes.put(PPG_MEASUREMENT, "PPG Measurement");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}

