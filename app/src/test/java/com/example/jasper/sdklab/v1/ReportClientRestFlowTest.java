package com.example.jasper.sdklab.v1;

import com.example.jasper.sdklab.v1.common.RestCall;
import com.example.jasper.sdklab.v1.server.ServerConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConnection;
import com.jaspersoft.android.sdk.client.oxm.report.ReportParameter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileDescriptor;
import java.util.Collection;


/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ReportClientRestFlowTest {
    @Mock
    String reportUri;
    @Mock
    String userId;
    @Mock
    String organization;
    @Mock
    String baseUrl;
    @Mock
    String password;
    @Mock
    FileDescriptor target;
    @Mock
    Collection<ReportParameter> params;
    @Mock
    ExportPageRange pageRange;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        ServerConfiguration serverConfiguration = ServerConfiguration.newInstance()
                .withBaseUrl(baseUrl)
                .withUserId(userId)
                .withOrganization(organization)
                .withPassword(password);

        ServerConnection serverConnection = ServerConnection.connect(serverConfiguration).asBlocking();

        ReportExecutionConfiguration configuration =
                ReportExecutionConfiguration.asyncConfiguration(reportUri);
        configuration.addReportParameters(params);

        ReportExecutionSession session = ReportExecutionSession
                .createSession(serverConnection, configuration);
        ReportExecutionTask executionTask = session.requestReportClient();
        ReportClient reportClient = executionTask.asBlocking();

        TotalPagesRequestTask pagesRequestTask = reportClient.requestTotalPages();
        int totalPages = pagesRequestTask.asBlocking();

        ReportExportConfiguration reportExportConfiguration = ReportExportConfiguration.asPDF(configuration);
        RestCall<ExportResult> pageExportRequestTask = reportClient.requestExport(pageRange);
        ExportResult exportResult = pageExportRequestTask.asBlocking();
    }
}
