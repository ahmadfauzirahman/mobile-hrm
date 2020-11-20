package ci.ahmadfauzirahman.hrm.Activity.ModulAbsensi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class AbsenScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.v("TAG", rawResult.getText()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString());
        System.out.println("Json Object " + rawResult.getText());
    }
}
