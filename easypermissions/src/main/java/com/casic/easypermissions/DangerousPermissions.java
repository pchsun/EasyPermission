package com.casic.easypermissions;

/**
 * 所有敏感权限
 * Created by pchsun on 2018/5/17.
 */
public interface DangerousPermissions {
    //CALENDAR 日历组
    String READ_CALENDAR = "android.permission.READ_CALENDAR";
    String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";

    //CAMERA 相机拍照组
    String CAMERA = "android.permission.CAMERA";

    //CONTACTS 联系人组
    String READ_CONTACTS = "android.permission.READ_CONTACTS";
    String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";

    //LOCATION 定位组
    String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";

    //MICROPHONE 麦克风组
    String RECORD_AUDIO = "android.permission.RECORD_AUDIO";

    //PHONE 组
    String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    String CALL_PHONE = "android.permission.CALL_PHONE";
    String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    String USE_SIP = "android.permission.USE_SIP";
    String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";

    //SENSORS 传感器组
    String BODY_SENSORS ="android.permission.BODY_SENSORS";

    //SMS 组
    String SEND_SMS = "android.permission.SEND_SMS";
    String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    String READ_SMS = "android.permission.READ_SMS";
    String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    String RECEIVE_MMS = "android.permission.RECEIVE_MMS";

    //STORAGE 存储组
    String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
}
