package com.irrigationsystem.controller;

import com.irrigationsystem.model.Plot;
import com.irrigationsystem.service.LandService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LandControllerTest {

    private static final Integer PLOT_ID             = 1;
    private static final String UPDATE_PLOT_RESPONSE = "Plot updated Successfully";
    private static final String DELETE_PLOT_RESPONSE = "Plot deleted Successfully";
    @Mock
    private LandService    landService;
    @Mock
    private Plot           requestPlot;
    @Mock
    private Plot           responsePlot;
    @InjectMocks
    private LandController landController;

    @Test
    void addPlot() {
        when(landService.addPlot(requestPlot)).thenReturn(responsePlot);

        Plot persistedPlot = landController.addPlot(requestPlot).getBody();

        assertNotNull(persistedPlot);
        assertEquals(persistedPlot, responsePlot);

        verify(landService).addPlot(requestPlot);
    }

    @Test
    void updatePlot() {
        when(landService.updatePlot(PLOT_ID, requestPlot)).thenReturn(responsePlot);

        String response = landController.updatePlot(PLOT_ID, requestPlot).getBody();

        assertNotNull(response);
        assertEquals(response, UPDATE_PLOT_RESPONSE);

        verify(landService).updatePlot(PLOT_ID, requestPlot);

    }

    @Test
    void getAllPlots() {
        when(landService.getAllPlots()).thenReturn(Collections.singletonList(responsePlot));

        List<Plot> plots = landController.getAllPlots();

        assertNotNull(plots);
        assertEquals(1, plots.size());

        verify(landService).getAllPlots();

    }

    @Test
    void getPlotById() {
        when(landService.getPlotById(PLOT_ID)).thenReturn(responsePlot);

        Plot plot = landController.getPlotById(PLOT_ID).getBody();

        assertNotNull(plot);
        assertEquals(responsePlot, plot);

        verify(landService).getPlotById(PLOT_ID);
    }

    @Test
    void deletePlotById() {

        String response = landController.deletePlotById(PLOT_ID).getBody();

        assertNotNull(response);
        assertEquals(DELETE_PLOT_RESPONSE, response);

        verify(landService).deletePlotById(PLOT_ID);
    }
}
