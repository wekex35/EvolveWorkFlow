package com.alitersolutions.evolveworkflow.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface Constants {
    public static final String APIROUTE = "/";
    public static final String BASEURL = "baseurl";
    public static final String DEVICE_NAME = "device_name";
    public static final String EMPTY = "empty";
    public static final String EVOLVEUSERROlE = "user_role";
    public static final String EVOLVEUSRID = "EvolveUsr_ID";
    public static final String EVOLVEUSRNAME = "EvolveUsr_Name";
    public static final String FAILURE = "failure";
//    public static final String FOR_SET_TAG = TIME_FORMAT.format(Calendar.getInstance().getTime());
    public static final DateFormat FOR_TAG_FORMAT = new SimpleDateFormat("ddMMyyyyHHmmss");
    public static final String INDTENTDATA = "indtentdata";
    public static final String ITEMINFO = "iteminfo";
    public static final String KEY_ID = "id";
    public static final String KEY_JSONVIEW = "jsonview";
    public static final String KEY_LAYOUT_NAME = "layout_name";
    public static final String KEY_NAME = "name";
    public static final String LEFT_MARGIN = "leftmargin";
    public static final String LOCATIONINFO = "locationinfo";
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_TOAST = 5;
    public static final int MESSAGE_WRITE = 3;
    public static final String NOTAVAILABLE = "notavailable";
    public static final String TAG = "evolveyork";
//    public static final String TIME = TIME_FORMAT.format(Calendar.getInstance().getTime());
    public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    public static final String TOAST = "toast";
    public static final String TOKEN = "userlogindetails";
    public static final String TOP_MARGIN = "topmargin";
    public static final String USERID = "userId";
    public static final String USERLOGINDETAILS = "userlogindetails";
    public static final String VIEW_HEIGHT = "height";
    public static final String VIEW_ROTATION = "rotation";
    public static final String VIEW_WIDTH = "width";
    public static final String str = "\r\n";
}
