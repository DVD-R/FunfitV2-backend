package com.funfit.usjr.thesis.backend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.dto.RequestCapture;
import com.funfit.usjr.thesis.backend.dto.ResponseTerritory;

@Transactional
public interface CaptureTerritoryService {
	public List<ResponseTerritory> captureTerritory(RequestCapture requestCapture);
}
