package com.jelly.thor.app1;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.Log;

import com.google.zxing.Result;
import com.jelly.thor.zxing.CaptureActivity;

public class MainActivity extends CaptureActivity {



    @Override
    protected void myHandleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        Log.d("123===", rawResult.toString());
        Log.d("123===", rawResult.getText());

        //继续扫描
        restartPreviewAndDecode();
    }

    /**
     * 关闭闪光灯（手电筒）
     */
    private void offFlash(){
        Camera camera = getCameraManager().getOpenCamera().getCamera();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
    }

    /**
     * 开启闪光灯（手电筒）
     */
    public void openFlash(){
        Camera camera = getCameraManager().getOpenCamera().getCamera();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
    }

}
