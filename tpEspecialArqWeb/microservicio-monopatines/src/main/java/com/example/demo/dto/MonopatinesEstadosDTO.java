package com.example.demo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MonopatinesEstadosDTO{
    public long currentlyInUse;
    public long currentlyUnderMaintenance;
    
	public MonopatinesEstadosDTO(long currentlyInUse, long currentlyUnderMaintenance) {
		this.currentlyInUse = currentlyInUse;
		this.currentlyUnderMaintenance = currentlyUnderMaintenance;
	}

	public long getCurrentlyInUse() {
		return currentlyInUse;
	}

	public void setCurrentlyInUse(long currentlyInUse) {
		this.currentlyInUse = currentlyInUse;
	}

	public long getCurrentlyUnderMaintenance() {
		return currentlyUnderMaintenance;
	}

	public void setCurrentlyUnderMaintenance(long currentlyUnderMaintenance) {
		this.currentlyUnderMaintenance = currentlyUnderMaintenance;
	}
    
    
}
