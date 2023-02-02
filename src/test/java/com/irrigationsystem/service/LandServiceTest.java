package com.irrigationsystem.service;

import com.irrigationsystem.dao.LandRepository;
import com.irrigationsystem.model.Irrigation;
import com.irrigationsystem.model.Plot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LandServiceTest {

    private static final Integer  PLOT_ID = 1;
    @Mock
    private Plot requestPlot;
    @Mock
    private Plot responsePlot;
    @Mock
    private Plot persistedPlot;
    @Mock
    private Irrigation requestIrrigation;
    @Mock
    private Irrigation persistedIrrigation;
    @Mock
    private LandRepository landRepository;
    @InjectMocks
    private LandService landService;
    @Test
    void addPlot() {
        when(landRepository.save(requestPlot)).thenReturn(responsePlot);

        Plot persistedPlot = landService.addPlot(requestPlot);

        assertNotNull(persistedPlot);
        assertEquals(persistedPlot, responsePlot);

        verify(landRepository).save(requestPlot);
    }

    @Test
    void getAllPlots() {
        when(landRepository.findAll()).thenReturn(Collections.singletonList(responsePlot));

        List<Plot> plots = landService.getAllPlots();

        assertNotNull(plots);
        assertEquals(1, plots.size());

        verify(landRepository).findAll();
    }

    @Test
    void getPlotById() {
        when(landRepository.findById(PLOT_ID)).thenReturn(Optional.of(responsePlot));

        Plot plot = landService.getPlotById(PLOT_ID);

        assertNotNull(plot);
        assertEquals(plot, responsePlot);

        verify(landRepository).findById(PLOT_ID);
    }

    @Test
    void updatePlot() {
        when(landRepository.findById(PLOT_ID)).thenReturn(Optional.of(persistedPlot));
        when(requestPlot.getAreaInAcre()).thenReturn(2);
        when(requestPlot.getTimeSlot()).thenReturn(LocalTime.parse("10:50:00"));
        when(requestPlot.getIrrigation()).thenReturn(requestIrrigation);
        when(requestIrrigation.getWaterPerAcre()).thenReturn(3000l);
        when(requestIrrigation.getMinutesPerAcre()).thenReturn(40l);
        when(persistedPlot.getIrrigation()).thenReturn(persistedIrrigation);
        when(landRepository.save(persistedPlot)).thenReturn(responsePlot);

        Plot plot = landService.updatePlot(PLOT_ID, requestPlot);

        assertNotNull(plot);
        assertEquals(plot, responsePlot);

        verify(landRepository).findById(PLOT_ID);
        verify(landRepository).save(persistedPlot);
    }

    @Test
    void deletePlotById() {
        landService.deletePlotById(PLOT_ID);

        verify(landRepository).deleteById(PLOT_ID);

    }
}