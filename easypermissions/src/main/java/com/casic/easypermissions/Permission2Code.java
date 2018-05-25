package com.casic.easypermissions;

/**

 * Created by pchsun on 2018/5/18.
 */

public class Permission2Code {

    /**
     * 通过权限名称获取RequestCode
     * 根据APP所需权限适当添加
     * @param permission
     * @return
     */
    public static int getRequestCode(String permission) {
        switch (permission) {
            //CALENDAR 日历组
            case DangerousPermissions.READ_CALENDAR:
                return RequestCode.READ_CALENDAR_CODE;
            case DangerousPermissions.WRITE_CALENDAR:
                return RequestCode.WRITE_CALENDAR_CODE;

            //CAMERA 相机拍照组
            case DangerousPermissions.CAMERA:
                return RequestCode.CAMERA_CODE;

            //CONTACTS 联系人组
            case DangerousPermissions.READ_CONTACTS:
                return RequestCode.READ_CONTACTS_CODE;
            case DangerousPermissions.WRITE_CONTACTS:
                return RequestCode.WRITE_CONTACTS_CODE;
            case DangerousPermissions.GET_ACCOUNTS:
                return RequestCode.GET_ACCOUNTS_CODE;

            //LOCATION 定位组
            case DangerousPermissions.ACCESS_COARSE_LOCATION:
                return RequestCode.ACCESS_COARSE_LOCATION_CODE;
            case DangerousPermissions.ACCESS_FINE_LOCATION:
                return RequestCode.ACCESS_FINE_LOCATION_CODE;

            //MICROPHONE 麦克风组
            case DangerousPermissions.RECORD_AUDIO:
                return RequestCode.RECORD_AUDIO_CODE;

            //PHONE 组
            case DangerousPermissions.READ_PHONE_STATE:
                return RequestCode.READ_PHONE_STATE_CODE;
            case DangerousPermissions.CALL_PHONE:
                return RequestCode.CALL_PHONE_CODE;
            case DangerousPermissions.READ_CALL_LOG:
                return RequestCode.READ_CALL_LOG_CODE;
            case DangerousPermissions.WRITE_CALL_LOG:
                return RequestCode.WRITE_CALL_LOG_CODE;
            case DangerousPermissions.USE_SIP:
                return RequestCode.USE_SIP_CODE;
            case DangerousPermissions.PROCESS_OUTGOING_CALLS:
                return RequestCode.PROCESS_OUTGOING_CALLS_CODE;

            //SENSORS 传感器组
            case DangerousPermissions.BODY_SENSORS:
                return RequestCode.BODY_SENSORS_CODE;

            //SMS 组
            case DangerousPermissions.SEND_SMS:
                return RequestCode.SEND_SMS_CODE;
            case DangerousPermissions.RECEIVE_SMS:
                return RequestCode.RECEIVE_SMS_CODE;
            case DangerousPermissions.READ_SMS:
                return RequestCode.READ_SMS_CODE;
            case DangerousPermissions.RECEIVE_WAP_PUSH:
                return RequestCode.RECEIVE_WAP_PUSH_CODE;
            case DangerousPermissions.RECEIVE_MMS:
                return RequestCode.RECEIVE_MMS_CODE;

            //STORAGE 存储组
            case DangerousPermissions.READ_EXTERNAL_STORAGE:
                return RequestCode.READ_EXTERNAL_STORAGE_CODE;
            case DangerousPermissions.WRITE_EXTERNAL_STORAGE:
                return RequestCode.WRITE_EXTERNAL_STORAGE_CODE;
            default:
                return 0;
        }
    }
}
