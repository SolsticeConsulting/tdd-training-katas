package chartsmart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.approvaltests.awt.AwtApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@EnabledOnOs(OS.MAC)
@UseReporter(QuietReporter.class)
class ChartSmartTest {

  @Test
  void testMainWindow() {
    ChartSmart chartSmart = new ChartSmart();
    AwtApprovals.verify(chartSmart);
  }

  @Test
  void testBarChartWindow() {
    ChartWindow chartSmart = new ChartWindow();
    chartSmart.iniDS(406, "rpfll", true);
    AwtApprovals.verify(chartSmart);
    assertEquals("Bar Chart - Single Mode", chartSmart.getTitle());
  }

  @Test
  void testPieChartWindow() {
    ChartWindow chartSmart = new ChartWindow();
    chartSmart.iniDS(323, "rpfll", true);
    AwtApprovals.verify(chartSmart);
    assertEquals("Pie Chart - Single Mode", chartSmart.getTitle());
  }

  @Test
  void testBarChartSmallWindow() {
    ChartWindow chartSmart = new ChartWindow();
    chartSmart.iniDS(406, "shareddisplay", true);
    AwtApprovals.verify(chartSmart);
    assertEquals("Bar Chart - Compare Mode", chartSmart.getTitle());
  }

  @Test
  void testPieChartSmallWindow() {
    ChartWindow chartSmart = new ChartWindow();
    chartSmart.iniDS(323, "shareddisplay", true);
    AwtApprovals.verify(chartSmart);
    assertEquals("Pie Chart - Compare Mode", chartSmart.getTitle());
  }
}
