package zjm.cst.dhu.hotfix.utils;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zjm on 2017/5/1.
 */

public class Utils {
    private static final int BUF_SIZE = 2048;

    //读取assets文件夹下文件并写入新路径
    public static boolean prepareDex(Context context, File dexInternalStoragePath, String dex_file) throws IOException {
        BufferedInputStream bis = null;
        OutputStream dexWriter = null;
        bis = new BufferedInputStream(context.getAssets().open(dex_file));
        dexWriter = new BufferedOutputStream(new FileOutputStream(dexInternalStoragePath));
        byte[] buf = new byte[BUF_SIZE];
        int len;
        while ((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
            dexWriter.write(buf, 0, len);
        }
        dexWriter.close();
        bis.close();
        return true;

    }
}
