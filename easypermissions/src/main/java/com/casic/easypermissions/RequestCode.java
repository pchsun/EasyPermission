package com.casic.easypermissions;

/**
 * 敏感权限请求标志
 * Created by pchsun on 2018/5/17.
 */

public interface RequestCode {
    //多个权限一起
    int MULTI_PERMISSION_CODE = 100;

    //CALENDAR 日历组
    int READ_CALENDAR_CODE = 101;
    int WRITE_CALENDAR_CODE = 102;

    //CAMERA 相机拍照组
    int CAMERA_CODE = 103;

    //CONTACTS 联系人组
    int READ_CONTACTS_CODE = 104;
    int WRITE_CONTACTS_CODE = 105;
    int GET_ACCOUNTS_CODE = 106;

    //LOCATION 定位组
    int ACCESS_FINE_LOCATION_CODE = 107;
    int ACCESS_COARSE_LOCATION_CODE = 108;

    //MICROPHONE 麦克风组
    int RECORD_AUDIO_CODE = 109;

    //PHONE 组
    int READ_PHONE_STATE_CODE = 110;
    int CALL_PHONE_CODE = 111;
    int READ_CALL_LOG_CODE = 112;
    int WRITE_CALL_LOG_CODE = 113;
    int USE_SIP_CODE = 114;
    int PROCESS_OUTGOING_CALLS_CODE = 115;

    //SENSORS 传感器组
    int BODY_SENSORS_CODE = 116;

    //SMS 组
    int SEND_SMS_CODE = 117;
    int RECEIVE_SMS_CODE = 118;
    int READ_SMS_CODE = 119;
    int RECEIVE_WAP_PUSH_CODE = 120;
    int RECEIVE_MMS_CODE = 121;

    //STORAGE 存储组
    int READ_EXTERNAL_STORAGE_CODE = 122;
    int WRITE_EXTERNAL_STORAGE_CODE = 123;
}
