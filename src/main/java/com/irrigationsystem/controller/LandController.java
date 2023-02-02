package com.irrigationsystem.controller;

import com.irrigationsystem.model.Plot;
import com.irrigationsystem.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/land")
public class LandController {

    @Autowired
    private LandService landService;

    @PostMapping("/plot")
    public ResponseEntity<Plot> addPlot(@RequestBody Plot plot){
        return new ResponseEntity<>(landService.addPlot(plot), HttpStatus.CREATED);
    }

    @PutMapping("/plot/{plotId}")
    public ResponseEntity<String> updatePlot(@PathVariable int plotId, @RequestBody Plot plot){
        landService.updatePlot(plotId, plot);
        return new ResponseEntity<>("Plot updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/plots")
    public List<Plot> getAllPlots(){
        return landService.getAllPlots();
    }

    @GetMapping("/plot/{plotId}")
    public ResponseEntity<Plot> getPlotById(@PathVariable int plotId){
        return new ResponseEntity<>(landService.getPlotById(plotId), HttpStatus.OK);
    }

    @DeleteMapping("/plot/{plotId}")
    public ResponseEntity<String> deletePlotById(@PathVariable int plotId) {
        landService.deletePlotById(plotId);
        return new ResponseEntity<>("Plot deleted Successfully", HttpStatus.OK);
    }
}
