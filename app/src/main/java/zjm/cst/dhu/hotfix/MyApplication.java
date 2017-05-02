package zjm.cst.dhu.hotfix;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import java.io.File;
import java.io.IOException;

import zjm.cst.dhu.hotfix.utils.HotFix;
import zjm.cst.dhu.hotfix.utils.Utils;

/**
 * Created by zjm on 2017/4/27.
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //加载hack.AntilazyLoad包
        //在私有目录下创建hack_dex.jar
        File dexPath = new File(getDir("dex", Context.MODE_PRIVATE), "hack_dex.jar");
        try {
            Utils.prepareDex(this.getApplicationContext(), dexPath, "hack_dex.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HotFix.patch(this, dexPath.getAbsolutePath(), "zjm.cst.dhu.hotfix.hack.AntilazyLoad");

//        //加载patch补丁包
        //在私有目录下创建patch_dex.jar
        dexPath = new File(getDir("dex", Context.MODE_PRIVATE), "patch_dex.jar");
        try {
            Utils.prepareDex(this.getApplicationContext(), dexPath, "patch_dex.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HotFix.patch(this, dexPath.getAbsolutePath(), "zjm.cst.dhu.hotfix.TestActivity");
    }
}
