package com.example.jasper.sdklab;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.jasper.sdklab.v1.ExportPageRange;
import com.example.jasper.sdklab.v1.ParcelFileExportResult;
import com.example.jasper.sdklab.v1.ReportClient;
import com.example.jasper.sdklab.v1.report.ReportExecutionConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import rx.functions.Action1;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Action1<Throwable> errorHandler = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error occured");
            builder.setMessage(throwable.getMessage());
            builder.create().show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        webView = (WebView) findViewById(R.id.webView);

        ServerConfiguration serverConfiguration = ServerConfiguration.newInstance()
                .withBaseUrl("http://192.168.88.55:8085/jasperserver-pro-61")
                .withOrganization("")
                .withPassword("superuser")
                .withPassword("superuser");

        String reportUri = "/public/Samples/Reports/AllAccounts";
        ReportExecutionConfiguration reportConfiguration =
                ReportExecutionConfiguration.newInstance(reportUri);

        ExportPageRange range = ExportPageRange.createForSinglePage(5);
        ReportClient reportClient = ReportClient.create(serverConfiguration, reportConfiguration);
        reportClient.requestExport(range).asAsync().subscribe(new Action1<ParcelFileExportResult>() {
            @Override
            public void call(ParcelFileExportResult export) {
                StringExportResult exportResult = new StringExportResult(export);
                webView.loadDataWithBaseURL(null, exportResult.getExport(), "text/html", "utf-8", null);
            }
        }, errorHandler);
    }
}
