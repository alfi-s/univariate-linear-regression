import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Plot {

    XYChart chart;

    public Plot(String title, String xAxis, String yAxis, List<List<Double>> data) {

        chart = new XYChartBuilder()
                        .width(1000)
                        .height(600)
                        .title(title)
                        .xAxisTitle(xAxis)
                        .yAxisTitle(yAxis)
                        .build();

        XYSeries raw = chart.addSeries("raw", data.get(0), data.get(1));
        raw.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);

        List<List<Double>> plotPoints = Data.plotFunction(0, 10, .5, (x)->0);

        XYSeries plt = chart.addSeries("plot", plotPoints.get(0), plotPoints.get(1));
        plt.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        plt.setShowInLegend(false);
        plt.setMarker(SeriesMarkers.NONE);

        SwingUtilities.invokeLater(() -> {

                // Create and set up the window.
                JFrame frame = new JFrame(title);
                frame.setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // chart
                JPanel chartPanel = new XChartPanel<>(chart);
                frame.add(chartPanel, BorderLayout.CENTER);

                // Display the window.
                frame.pack();
                frame.setVisible(true);
        });

    }

    public void updatePlot(HypothesisFunction h_x) {
        List<List<Double>> plotPoints = Data.plotFunction(0,10, .5, h_x);
        chart.updateXYSeries("plot",plotPoints.get(0), plotPoints.get(1), null);
    }

}

