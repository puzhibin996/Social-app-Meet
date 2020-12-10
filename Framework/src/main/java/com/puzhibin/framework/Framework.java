package com.puzhibin.framework;

/**
 * <p>Class: com.puzhibin.framework.Framework</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/9/15:07
 */


public class Framework {
    public volatile static Framework sFramework;
    private Framework(){}

    public static Framework getInstance(){
        if (sFramework == null) {
            synchronized (Framework.class) {
                if (sFramework == null) {
                    sFramework=new Framework();
                }
            }
        }
        return sFramework;
    }
}
