package net.iqbalfauzan.myindi.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;
import com.karan.churi.PermissionManager.PermissionManager;

import net.iqbalfauzan.myindi.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class FragmentScanner extends Fragment implements ZXingScannerView.ResultHandler {
    public static FragmentScanner newInstance() {
        return new FragmentScanner();
    }
    private ZXingScannerView mScannerView;
    PermissionManager permissionManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scanner, container, false);
        permissionManager = new PermissionManager() {};
        permissionManager.checkAndRequestPermissions(getActivity());
        mScannerView = new ZXingScannerView(getActivity());
        return mScannerView;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();

        mScannerView.resumeCameraPreview(this);
    }
}
