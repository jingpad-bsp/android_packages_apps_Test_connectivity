/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.android_scripting.jsonrpc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.codec.binary.Base64Codec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Point;
import android.location.Address;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.RttManager.RttCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiActivityEnergyInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiScanner.ScanData;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.telecom.AudioState;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SmsMessage;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.SubscriptionInfo;
import android.util.DisplayMetrics;
import android.util.SparseArray;

import com.googlecode.android_scripting.ConvertUtils;
import com.googlecode.android_scripting.Log;
import com.googlecode.android_scripting.event.Event;

public class JsonBuilder {

    @SuppressWarnings("unchecked")
    public static Object build(Object data) throws JSONException {
        if (data == null) {
            return JSONObject.NULL;
        }
        if (data instanceof Integer) {
            return data;
        }
        if (data instanceof Float) {
            return data;
        }
        if (data instanceof Double) {
            return data;
        }
        if (data instanceof Long) {
            return data;
        }
        if (data instanceof String) {
            return data;
        }
        if (data instanceof Boolean) {
            return data;
        }
        if (data instanceof JSONObject) {
            return data;
        }
        if (data instanceof JSONArray) {
            return data;
        }
        if (data instanceof Set<?>) {
            List<Object> items = new ArrayList<Object>((Set<?>) data);
            return buildJsonList(items);
        }
        if (data instanceof Collection<?>) {
            List<Object> items = new ArrayList<Object>((Collection<?>) data);
            return buildJsonList(items);
        }
        if (data instanceof List<?>) {
            return buildJsonList((List<?>) data);
        }
        if (data instanceof Address) {
            return buildJsonAddress((Address) data);
        }
        if (data instanceof AudioState) {
            return buildJsonAudioState((AudioState) data);
        }
        if (data instanceof Location) {
            return buildJsonLocation((Location) data);
        }
        if (data instanceof Bundle) {
            return buildJsonBundle((Bundle) data);
        }
        if (data instanceof Intent) {
            return buildJsonIntent((Intent) data);
        }
        if (data instanceof Event) {
            return buildJsonEvent((Event) data);
        }
        if (data instanceof Map<?, ?>) {
            // TODO(damonkohler): I would like to make this a checked cast if
            // possible.
            return buildJsonMap((Map<String, ?>) data);
        }
        if (data instanceof ParcelUuid) {
            return data.toString();
        }
        if (data instanceof ScanResult) {
            return buildJsonScanResult((ScanResult) data);
        }
        if (data instanceof ScanData) {
            return buildJsonScanData((ScanData) data);
        }
        if (data instanceof android.bluetooth.le.ScanResult) {
            return buildJsonBleScanResult((android.bluetooth.le.ScanResult) data);
        }
        if (data instanceof AdvertiseSettings) {
            return buildJsonBleAdvertiseSettings((AdvertiseSettings) data);
        }
        if (data instanceof BluetoothGattService) {
            return buildJsonBluetoothGattService((BluetoothGattService) data);
        }
        if (data instanceof BluetoothGattCharacteristic) {
            return buildJsonBluetoothGattCharacteristic((BluetoothGattCharacteristic) data);
        }
        if (data instanceof BluetoothGattDescriptor) {
            return buildJsonBluetoothGattDescriptor((BluetoothGattDescriptor) data);
        }
        if (data instanceof BluetoothDevice) {
            return buildJsonBluetoothDevice((BluetoothDevice) data);
        }
        if (data instanceof CellLocation) {
            return buildJsonCellLocation((CellLocation) data);
        }
        if (data instanceof WifiInfo) {
            return buildJsonWifiInfo((WifiInfo) data);
        }
        if (data instanceof NeighboringCellInfo) {
            return buildNeighboringCellInfo((NeighboringCellInfo) data);
        }
        if (data instanceof NetworkInfo) {
            return buildNetworkInfo((NetworkInfo) data);
        }
        if (data instanceof InetSocketAddress) {
            return buildInetSocketAddress((InetSocketAddress) data);
        }
        if (data instanceof InetAddress) {
            return buildInetAddress((InetAddress) data);
        }
        if (data instanceof Point) {
            return buildPoint((Point) data);
        }

        if (data instanceof SmsMessage) {
            return buildSmsMessage((SmsMessage) data);
        }
        if (data instanceof PhoneAccount) {
            return buildPhoneAccount((PhoneAccount) data);
        }
        if (data instanceof PhoneAccountHandle) {
            return buildPhoneAccountHandle((PhoneAccountHandle) data);
        }
        if (data instanceof SubscriptionInfo) {
            return buildSubscriptionInfoRecord((SubscriptionInfo) data);
        }
        if (data instanceof DisplayMetrics) {
            return buildDisplayMetrics((DisplayMetrics) data);
        }
        if (data instanceof RttCapabilities) {
            return buildRttCapabilities((RttCapabilities) data);
        }
        if (data instanceof WifiActivityEnergyInfo) {
            return buildWifiActivityEnergyInfo((WifiActivityEnergyInfo) data);
        }
        if (data instanceof WifiConfiguration) {
            return buildWifiConfiguration((WifiConfiguration) data);
        }
        if (data instanceof WifiP2pDevice) {
            return buildWifiP2pDevice((WifiP2pDevice) data);
        }
        if (data instanceof WifiP2pInfo) {
            return buildWifiP2pInfo((WifiP2pInfo) data);
        }
        if (data instanceof WifiP2pGroup) {
            return buildWifiP2pGroup((WifiP2pGroup) data);
        }
        if (data instanceof byte[]) {
            return Base64Codec.encodeBase64((byte[]) data);
        }
        if (data instanceof Object[]) {
            return buildJSONArray((Object[]) data);
        }

        return data.toString();
        // throw new JSONException("Failed to build JSON result. " +
        // data.getClass().getName());
    }

    private static JSONObject buildJsonAudioState(AudioState data)
            throws JSONException {
        JSONObject state = new JSONObject();
        state.put("isMuted", data.isMuted());
        state.put("AudioRoute", AudioState.audioRouteToString(data.getRoute()));
        return state;
    }

    private static Object buildDisplayMetrics(DisplayMetrics data)
            throws JSONException {
        JSONObject dm = new JSONObject();
        dm.put("widthPixels", data.widthPixels);
        dm.put("heightPixels", data.heightPixels);
        dm.put("noncompatHeightPixels", data.noncompatHeightPixels);
        dm.put("noncompatWidthPixels", data.noncompatWidthPixels);
        return dm;
    }

    private static Object buildInetAddress(InetAddress data) {
        JSONArray address = new JSONArray();
        address.put(data.getHostName());
        address.put(data.getHostAddress());
        return address;
    }

    private static Object buildInetSocketAddress(InetSocketAddress data) {
        JSONArray address = new JSONArray();
        address.put(data.getHostName());
        address.put(data.getPort());
        return address;
    }

    private static JSONObject buildJsonAddress(Address address)
            throws JSONException {
        JSONObject result = new JSONObject();
        result.put("admin_area", address.getAdminArea());
        result.put("country_code", address.getCountryCode());
        result.put("country_name", address.getCountryName());
        result.put("feature_name", address.getFeatureName());
        result.put("phone", address.getPhone());
        result.put("locality", address.getLocality());
        result.put("postal_code", address.getPostalCode());
        result.put("sub_admin_area", address.getSubAdminArea());
        result.put("thoroughfare", address.getThoroughfare());
        result.put("url", address.getUrl());
        return result;
    }

    private static JSONArray buildJSONArray(Object[] data) throws JSONException {
        JSONArray result = new JSONArray();
        for (Object o : data) {
            result.put(build(o));
        }
        return result;
    }

    private static JSONObject buildJsonBleAdvertiseSettings(
            AdvertiseSettings advertiseSettings) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("mode", advertiseSettings.getMode());
        result.put("txPowerLevel", advertiseSettings.getTxPowerLevel());
        result.put("isConnectable", advertiseSettings.isConnectable());
        return result;
    }

    private static JSONObject buildJsonBleScanResult(
            android.bluetooth.le.ScanResult scanResult) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("rssi", scanResult.getRssi());
        result.put("timestampNanos", scanResult.getTimestampNanos());
        result.put("deviceName", scanResult.getScanRecord().getDeviceName());
        result.put("txPowerLevel", scanResult.getScanRecord().getTxPowerLevel());
        result.put("advertiseFlags", scanResult.getScanRecord()
                .getAdvertiseFlags());
        ArrayList<String> manufacturerDataList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();
        if (scanResult.getScanRecord().getManufacturerSpecificData() != null) {
            SparseArray<byte[]> manufacturerSpecificData = scanResult
                    .getScanRecord().getManufacturerSpecificData();
            for (int i = 0; i < manufacturerSpecificData.size(); i++) {
                manufacturerDataList.add(ConvertUtils
                        .convertByteArrayToString(manufacturerSpecificData
                                .valueAt(i)));
                idList.add(manufacturerSpecificData.keyAt(i));
            }
        }
        result.put("manufacturerSpecificDataList", manufacturerDataList);
        result.put("manufacturereIdList", idList);
        ArrayList<String> serviceUuidList = new ArrayList<String>();
        ArrayList<String> serviceDataList = new ArrayList<String>();
        if (scanResult.getScanRecord().getServiceData() != null) {
            Map<ParcelUuid, byte[]> serviceDataMap = scanResult.getScanRecord()
                    .getServiceData();
            for (ParcelUuid serviceUuid : serviceDataMap.keySet()) {
                serviceUuidList.add(serviceUuid.toString());
                serviceDataList.add(ConvertUtils
                        .convertByteArrayToString(serviceDataMap
                                .get(serviceUuid)));
            }
        }
        result.put("serviceUuidList", serviceUuidList);
        result.put("serviceDataList", serviceDataList);
        List<ParcelUuid> serviceUuids = scanResult.getScanRecord()
                .getServiceUuids();
        String serviceUuidsString = "";
        if (serviceUuids != null && serviceUuids.size() > 0) {
            for (ParcelUuid uuid : serviceUuids) {
                serviceUuidsString = serviceUuidsString + "," + uuid;
            }
        }
        result.put("serviceUuids", serviceUuidsString);
        result.put("scanRecord",
                build(ConvertUtils.convertByteArrayToString(scanResult
                        .getScanRecord().getBytes())));
        result.put("deviceInfo", build(scanResult.getDevice()));
        return result;
    }

    private static JSONObject buildJsonBluetoothDevice(BluetoothDevice data)
            throws JSONException {
        JSONObject deviceInfo = new JSONObject();
        deviceInfo.put("address", data.getAddress());
        deviceInfo.put("state", data.getBondState());
        deviceInfo.put("name", data.getName());
        deviceInfo.put("type", data.getType());
        return deviceInfo;
    }

    private static Object buildJsonBluetoothGattCharacteristic(
            BluetoothGattCharacteristic data) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("instanceId", data.getInstanceId());
        result.put("permissions", data.getPermissions());
        result.put("properties", data.getProperties());
        result.put("writeType", data.getWriteType());
        result.put("descriptorsList", build(data.getDescriptors()));
        result.put("uuid", data.getUuid().toString());
        result.put("value", build(data.getValue()));

        return result;
    }

    private static Object buildJsonBluetoothGattDescriptor(
            BluetoothGattDescriptor data) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("instanceId", data.getInstanceId());
        result.put("permissions", data.getPermissions());
        result.put("characteristic", data.getCharacteristic());
        result.put("uuid", data.getUuid().toString());
        result.put("value", build(data.getValue()));
        return result;
    }

    private static Object buildJsonBluetoothGattService(
            BluetoothGattService data) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("instanceId", data.getInstanceId());
        result.put("type", data.getType());
        result.put("gattCharacteristicList", build(data.getCharacteristics()));
        result.put("includedServices", build(data.getIncludedServices()));
        result.put("uuid", data.getUuid().toString());
        return result;
    }

    private static JSONObject buildJsonBundle(Bundle bundle)
            throws JSONException {
        JSONObject result = new JSONObject();
        for (String key : bundle.keySet()) {
            result.put(key, build(bundle.get(key)));
        }
        return result;
    }

    private static JSONObject buildJsonCellLocation(CellLocation cellLocation)
            throws JSONException {
        JSONObject result = new JSONObject();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation location = (GsmCellLocation) cellLocation;
            result.put("lac", location.getLac());
            result.put("cid", location.getCid());
        }
        // TODO(damonkohler): Add support for CdmaCellLocation. Not supported
        // until API level 5.
        return result;
    }

    private static JSONObject buildJsonEvent(Event event) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("name", event.getName());
        result.put("data", build(event.getData()));
        result.put("time", event.getCreationTime());
        return result;
    }

    private static JSONObject buildJsonIntent(Intent data) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("data", data.getDataString());
        result.put("type", data.getType());
        result.put("extras", build(data.getExtras()));
        result.put("categories", build(data.getCategories()));
        result.put("action", data.getAction());
        ComponentName component = data.getComponent();
        if (component != null) {
            result.put("packagename", component.getPackageName());
            result.put("classname", component.getClassName());
        }
        result.put("flags", data.getFlags());
        return result;
    }

    private static <T> JSONArray buildJsonList(final List<T> list)
            throws JSONException {
        JSONArray result = new JSONArray();
        for (T item : list) {
            result.put(build(item));
        }
        return result;
    }

    private static JSONObject buildJsonLocation(Location location)
            throws JSONException {
        JSONObject result = new JSONObject();
        result.put("altitude", location.getAltitude());
        result.put("latitude", location.getLatitude());
        result.put("longitude", location.getLongitude());
        result.put("time", location.getTime());
        result.put("accuracy", location.getAccuracy());
        result.put("speed", location.getSpeed());
        result.put("provider", location.getProvider());
        result.put("bearing", location.getBearing());
        return result;
    }

    private static JSONObject buildJsonMap(Map<String, ?> map)
            throws JSONException {
        JSONObject result = new JSONObject();
        for (Entry<String, ?> entry : map.entrySet()) {
            result.put(entry.getKey(), build(entry.getValue()));
        }
        return result;
    }

    private static JSONObject buildJsonScanResult(ScanResult scanResult)
            throws JSONException {
        JSONObject result = new JSONObject();
        result.put("BSSID", scanResult.BSSID);
        result.put("SSID", scanResult.SSID);
        result.put("frequency", scanResult.frequency);
        result.put("level", scanResult.level);
        result.put("capabilities", scanResult.capabilities);
        result.put("timestamp", scanResult.timestamp);
        // The following fields are hidden for now, uncomment when they're
        // unhidden
        // result.put("seen", scanResult.seen);
        // result.put("distanceCm", scanResult.distanceCm);
        // result.put("distanceSdCm", scanResult.distanceSdCm);
        // if (scanResult.informationElements != null){
        // JSONArray infoEles = new JSONArray();
        // for(ScanResult.InformationElement ie :
        // scanResult.informationElements) {
        // JSONObject infoEle = new JSONObject();
        // infoEle.put("id", ie.id);
        // infoEle.put("bytes", Base64Codec.encodeBase64(ie.bytes));
        // infoEles.put(infoEle);
        // }
        // result.put("InfomationElements", infoEles);
        // } else
        // result.put("InfomationElements", null);
        return result;
    }

    private static JSONObject buildJsonScanData(ScanData scanData)
            throws JSONException {
        JSONObject result = new JSONObject();
        result.put("Id", scanData.getId());
        result.put("Flags", scanData.getFlags());
        JSONArray scanResults = new JSONArray();
        for (ScanResult sr : scanData.getResults()) {
            scanResults.put(buildJsonScanResult(sr));
        }
        result.put("ScanResults", scanResults);
        return result;
    }

    private static JSONObject buildWifiActivityEnergyInfo(
            WifiActivityEnergyInfo data) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("ControllerEnergyUserd", data.getControllerEnergyUsed());
        result.put("ControllerIdleTimeMillis",
                data.getControllerIdleTimeMillis());
        result.put("ControllerRxTimeMillis", data.getControllerRxTimeMillis());
        result.put("ControllerTxTimeMillis", data.getControllerTxTimeMillis());
        result.put("StackState", data.getStackState());
        result.put("TimeStamp", data.getTimeStamp());
        return result;
    }

    private static JSONObject buildJsonWifiInfo(WifiInfo data)
            throws JSONException {
        JSONObject result = new JSONObject();
        result.put("hidden_ssid", data.getHiddenSSID());
        result.put("ip_address", data.getIpAddress());
        result.put("link_speed", data.getLinkSpeed());
        result.put("network_id", data.getNetworkId());
        result.put("rssi", data.getRssi());
        result.put("BSSID", data.getBSSID());
        result.put("mac_address", data.getMacAddress());
        result.put("SSID", data.getSSID());
        String supplicantState = "";
        switch (data.getSupplicantState()) {
            case ASSOCIATED:
                supplicantState = "associated";
                break;
            case ASSOCIATING:
                supplicantState = "associating";
                break;
            case COMPLETED:
                supplicantState = "completed";
                break;
            case DISCONNECTED:
                supplicantState = "disconnected";
                break;
            case DORMANT:
                supplicantState = "dormant";
                break;
            case FOUR_WAY_HANDSHAKE:
                supplicantState = "four_way_handshake";
                break;
            case GROUP_HANDSHAKE:
                supplicantState = "group_handshake";
                break;
            case INACTIVE:
                supplicantState = "inactive";
                break;
            case INVALID:
                supplicantState = "invalid";
                break;
            case SCANNING:
                supplicantState = "scanning";
                break;
            case UNINITIALIZED:
                supplicantState = "uninitialized";
                break;
            default:
                supplicantState = null;
        }
        result.put("supplicant_state", build(supplicantState));
        return result;
    }

    private static JSONObject buildNeighboringCellInfo(NeighboringCellInfo data)
            throws JSONException {
        // TODO(damonkohler): Additional information available at API level 5.
        JSONObject result = new JSONObject();
        result.put("cid", data.getCid());
        result.put("rssi", data.getRssi());
        return result;
    }

    private static Object buildNetworkInfo(NetworkInfo data)
            throws JSONException {
        JSONObject info = new JSONObject();
        info.put("isAvailable", data.isAvailable());
        info.put("isConnected", data.isConnected());
        info.put("isFailover", data.isFailover());
        info.put("isRoaming", data.isRoaming());
        info.put("ExtraInfo", data.getExtraInfo());
        info.put("FailedReason", data.getReason());
        info.put("TypeName", data.getTypeName());
        info.put("SubtypeName", data.getSubtypeName());
        info.put("State", data.getState().name().toString());
        return info;
    }

    private static JSONObject buildPhoneAccount(PhoneAccount data)
            throws JSONException {
        JSONObject acct = new JSONObject();
        acct.put("Address", data.getAddress().toSafeString());
        acct.put("SubscriptionAddress", data.getSubscriptionAddress()
                .toSafeString());
        acct.put("Label", data.getLabel().toString());
        acct.put("ShortDescription", data.getShortDescription().toString());
        return acct;
    }

    private static Object buildPhoneAccountHandle(PhoneAccountHandle data)
            throws JSONException {
        JSONObject msg = new JSONObject();
        msg.put("id", data.getId());
        msg.put("ComponentName", data.getComponentName().flattenToString());
        return msg;
    }

    private static Object buildSubscriptionInfoRecord(SubscriptionInfo data)
            throws JSONException {
        JSONObject msg = new JSONObject();
        msg.put("subscriptionId", data.getSubscriptionId());
        msg.put("iccId", data.getIccId());
        msg.put("simSlotIndex", data.getSimSlotIndex());
        msg.put("displayName", data.getDisplayName());
        msg.put("nameSource", data.getNameSource());
        msg.put("iconTint", data.getIconTint());
        msg.put("number", data.getNumber());
        msg.put("dataRoaming", data.getDataRoaming());
        msg.put("mcc", data.getMcc());
        msg.put("mnc", data.getMnc());
        return msg;
    }

    private static Object buildPoint(Point data) throws JSONException {
        JSONObject point = new JSONObject();
        point.put("x", data.x);
        point.put("y", data.y);
        return point;
    }

    private static Object buildRttCapabilities(RttCapabilities data)
            throws JSONException {
        JSONObject cap = new JSONObject();
        cap.put("bwSupported", data.bwSupported);
        cap.put("lciSupported", data.lciSupported);
        cap.put("lcrSupported", data.lcrSupported);
        cap.put("oneSidedRttSupported", data.oneSidedRttSupported);
        cap.put("preambleSupported", data.preambleSupported);
        cap.put("twoSided11McRttSupported", data.twoSided11McRttSupported);
        return cap;
    }

    private static Object buildSmsMessage(SmsMessage data) throws JSONException {
        JSONObject msg = new JSONObject();
        msg.put("originatingAddress", data.getOriginatingAddress());
        msg.put("messageBody", data.getMessageBody());
        return msg;
    }

    private static Object buildWifiConfiguration(WifiConfiguration data)
            throws JSONException {
        JSONObject config = new JSONObject();
        config.put("networkId", data.networkId);
        // Trim the double quotes if exist
        if (data.SSID.charAt(0) == '"'
                && data.SSID.charAt(data.SSID.length() - 1) == '"') {
            config.put("SSID", data.SSID.substring(1, data.SSID.length() - 1));
        } else {
            config.put("SSID", data.SSID);
        }
        config.put("BSSID", data.BSSID);
        config.put("priority", data.priority);
        config.put("hiddenSSID", data.hiddenSSID);
        if (data.status == WifiConfiguration.Status.CURRENT) {
            config.put("status", "CURRENT");
        } else if (data.status == WifiConfiguration.Status.DISABLED) {
            config.put("status", "DISABLED");
        } else if (data.status == WifiConfiguration.Status.ENABLED) {
            config.put("status", "ENABLED");
        } else {
            config.put("status", "UNKNOWN");
        }
        return config;
    }

    private static JSONObject buildWifiP2pDevice(WifiP2pDevice data)
            throws JSONException {
        JSONObject deviceInfo = new JSONObject();
        deviceInfo.put("Name", data.deviceName);
        deviceInfo.put("Address", data.deviceAddress);
        return deviceInfo;
    }

    private static JSONObject buildWifiP2pGroup(WifiP2pGroup data)
            throws JSONException {
        JSONObject group = new JSONObject();
        Log.d("build p2p group.");
        group.put("ClientList", build(data.getClientList()));
        group.put("Interface", data.getInterface());
        group.put("Networkname", data.getNetworkName());
        group.put("Owner", data.getOwner());
        group.put("Passphrase", data.getPassphrase());
        group.put("NetworkId", data.getNetworkId());
        return group;
    }

    private static JSONObject buildWifiP2pInfo(WifiP2pInfo data)
            throws JSONException {
        JSONObject info = new JSONObject();
        Log.d("build p2p info.");
        info.put("groupFormed", data.groupFormed);
        info.put("isGroupOwner", data.isGroupOwner);
        info.put("groupOwnerAddress", data.groupOwnerAddress);
        return info;
    }

    private JsonBuilder() {
        // This is a utility class.
    }
}
