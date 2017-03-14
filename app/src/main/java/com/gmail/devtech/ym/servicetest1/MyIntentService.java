package com.gmail.devtech.ym.servicetest1;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    final static String TAG = "ServiceTest1";
    private final static int WC= LinearLayout.LayoutParams.WRAP_CONTENT;
    private TextView textView;


    public MyIntentService() {
        super(TAG);
    }



    @Override
    protected void onHandleIntent(Intent intent) {

            //電話情報の受信開始
            TelephonyManager telManager=(TelephonyManager)
                    getSystemService(Context.TELEPHONY_SERVICE);
            telManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CELL_LOCATION);

/*
            Thread.sleep(5000);

            Intent broadcastIntent = new Intent();
            broadcastIntent.putExtra(
                    "message", "Hello, BroadCast!");
            broadcastIntent.setAction("MY_ACTION");
            getBaseContext().sendBroadcast(broadcastIntent);
*/


    }

    //電話情報を受信するためのリスナー
    public PhoneStateListener phoneStateListener=new PhoneStateListener() {
        /*//電話コール状態の変化時に呼ばれる
        @Override
        public void onCallStateChanged(int state, String number) {
            String str="電話コール状態:";
            if (state==TelephonyManager.CALL_STATE_RINGING) str+="電話着信";
            if (state==TelephonyManager.CALL_STATE_OFFHOOK) str+="通話開始";
            if (state==TelephonyManager.CALL_STATE_IDLE)    str+="電話終了";
            str+=" "+number;
            textView.setText(textView.getText()+"\n"+str);
        }

        //サービス状態の変化時に呼ばれる
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            String str="サービス状態:";
            int state=serviceState.getState();
            if (state==ServiceState.STATE_EMERGENCY_ONLY) str+="エマージェンシーのみ";
            if (state==ServiceState.STATE_IN_SERVICE)     str+="サービス内";
            if (state==ServiceState.STATE_OUT_OF_SERVICE) str+="サービス外";
            if (state==ServiceState.STATE_POWER_OFF)      str+="電源オフ";
            textView.setText(textView.getText()+"\n"+str);
            super.onServiceStateChanged(serviceState);
        }

        //通信強度の変化時に呼ばれる
        @Override
        public void onSignalStrengthChanged(int asu) {
            String str="通信強度:"+String.valueOf(-113+2*asu)+"dBm";
            textView.setText(textView.getText()+"\n"+str);
        }
*/
        //基地局の変化時に呼ばれる
        @Override
        public void onCellLocationChanged(CellLocation location) {
//            String str="";
            //GSMの基地局情報
            if (location instanceof GsmCellLocation) {
                GsmCellLocation loc=(GsmCellLocation)location;
//                str+="CID:"+loc.getCid()+"\n";
//                str+="LAC:"+loc.getLac()+"\n";
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra(
                        "message", "CID:"+loc.getCid());
                broadcastIntent.setAction("MY_ACTION");
                getBaseContext().sendBroadcast(broadcastIntent);

            }
        }
    };


}