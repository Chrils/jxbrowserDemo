package org.example.call;

import com.teamdev.jxbrowser.chromium.JSValue;
import org.example.call.java.CallJava;

public class PropSetter {

    public static void setCall(JSValue val, CallJava caller) {
        val.asObject().setProperty(caller.getAttrName(), caller);
    }

    public static void setProp(JSValue val,String attrName,Object attr) {
        val.asObject().setProperty(attrName,attr);
    }

}
