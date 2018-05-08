package io.appium.uiautomator2.utils;

import android.support.test.uiautomator.*;

/**
 * Created by 13522 on 2018/5/8.
 */
public class MyUiWatchers {
    private static String[] PACKAGE_INSTALLERS = new String[]{"com.android.packageinstaller","com.miui.securitycenter","com.samsung.android.packageinstaller","com.lbe.security.miui"};
    private String[] labels = new String[]{"确认","确定", "安装", "下一步", "完成","允许","始终允许","继续安装","我已充分了解该风险，继续安装"};
    public void registerAutoInstallWathers(){
        Logger.debug("Registered AutoInstall watchers");
        for(final String packageName:PACKAGE_INSTALLERS){
            Logger.debug("Registered AutoInstall watchers_"+packageName);
            UiDevice.getInstance().removeWatcher("AutoInstallWatcher_"+packageName);
            UiDevice.getInstance().registerWatcher("AutoInstallWatcher_"+packageName, new UiWatcher() {
                @Override
                public boolean checkForCondition() {
                    final UiObject window=new UiObject(new UiSelector().packageName(packageName));
                    if(window.exists()){
                        for(final String lable:labels){
                            UiSelector uiSelector=new UiSelector().text(lable).enabled(true).clickable(true);
                            UiObject uiObject= null;
                            try {
                                Logger.debug("Window被找_packageName="+packageName);
                                uiObject = window.getChild(uiSelector);
                                if(uiObject!=null&&uiObject.exists()){
                                    Logger.debug("packageName="+packageName+"_按钮被找到="+lable+"_classname="+uiObject.getClassName());
                                    if((uiObject.getClassName().equals("android.widget.Button")||uiObject.getClassName().equals("android.widget.CheckBox"))&&uiObject.isClickable() && uiObject.isEnabled()){
                                        uiObject.click();
                                        Logger.debug("packageName="+packageName+"_按钮被点击="+lable);
                                    }else {
                                        Logger.debug("packageName="+packageName+"_="+uiObject.getClassName()+"_lable"+lable);
                                    }
                                }else {
                                    Logger.debug("packageName="+packageName+"_="+"_lable"+lable+"_不存在");
                                }
                            } catch (UiObjectNotFoundException e) {
                                Logger.debug("packageName="+packageName+"_UiObjectNotFoundException="+e.getMessage()+e.getStackTrace());
                                e.printStackTrace();
                            }
                        }
                    }
                    return false;
                }
            });
        }
    }
}
