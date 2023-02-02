package com.irrigationsystem.service;

import com.irrigationsystem.dao.LandRepository;
import com.irrigationsystem.model.Irrigation;
import com.irrigationsystem.model.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LandService {

    @Autowired
    private LandRepository landRepository;

    public Plot addPlot(final Plot plot) {
        return landRepository.save(plot);
    }

    public List<Plot> getAllPlots() {
        return landRepository.findAll();
    }

    public Plot getPlotById(final int plotId) {
        return Optional
                .ofNullable(landRepository.findById(plotId))
                .orElseThrow(RuntimeException::new)
                .get();
    }

    public Plot updatePlot(final int plotId,final Plot plot) {
        return Optional
                .ofNullable(landRepository.findById(plotId))
                .orElseThrow(RuntimeException::new)
                .map(persistedPlot -> asUpdatedPlot(persistedPlot, plot))
                .map(landRepository::save)
                .get();
    }

    public void deletePlotById(final int plotId) {
        landRepository.deleteById(plotId);
    }

    private Plot asUpdatedPlot(final Plot persistedPlot, final Plot plot) {
        persistedPlot.setAreaInAcre(plot.getAreaInAcre());
        persistedPlot.setTimeSlot(plot.getTimeSlot());
        persistedPlot.setIrrigation(asIrrigation(persistedPlot, plot.getIrrigation()));
        return persistedPlot;
    }

    private Irrigation asIrrigation(final Plot persistedPlot, final Irrigation irrigation) {
        persistedPlot.getIrrigation().setWaterPerAcre(irrigation.getWaterPerAcre());
        persistedPlot.getIrrigation().setMinutesPerAcre(irrigation.getMinutesPerAcre());
        return persistedPlot.getIrrigation();
    }
}
