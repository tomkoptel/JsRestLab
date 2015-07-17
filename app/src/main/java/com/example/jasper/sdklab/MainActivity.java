package com.example.jasper.sdklab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jasper.sdklab.v1.ExportPageRange;
import com.example.jasper.sdklab.v1.ReportClient;
import com.example.jasper.sdklab.v1.ReportExecutionConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConfiguration;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ServerConfiguration serverConfiguration = ServerConfiguration.newInstance()
                .withBaseUrl("http://192.168.88.55:8085/jasperserver-pro-61")
                .withOrganization("")
                .withPassword("superuser")
                .withPassword("superuser");


        String reportUri = "/public/Samples/Reports/AllAccounts";
        ReportExecutionConfiguration reportConfiguration =
                ReportExecutionConfiguration.asyncConfiguration(reportUri);


        ExportPageRange range = ExportPageRange.createForSinglePage(5);
        ReportClient reportClient = ReportClient.create(serverConfiguration, reportConfiguration);
        reportClient.requestExport(range).asAsync().subscribe();




    }
}
