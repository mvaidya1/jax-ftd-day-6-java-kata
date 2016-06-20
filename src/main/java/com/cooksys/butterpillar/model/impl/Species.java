package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies{

	private String name;
	private IGrowthModel growthModel;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}

	@Override
	public IGrowthModel getGrowthModel() {
		// TODO Auto-generated method stub
		return growthModel;
	}

	@Override
	public void setGrowthModel(IGrowthModel growthModel) {
		// TODO Auto-generated method stub
		this.growthModel = growthModel;
		
	}

	@Override
	public ICatterfly createCatterfly(double wingspan, double weight) {
		// TODO Auto-generated method stub
		ICatterfly c = new Catterfly();
		c.setWeight(weight);
		c.setWingspan(wingspan);
		return c;
	}

	@Override
	public IButterpillar createButterpillar(double length, double leavesEaten) {
		// TODO Auto-generated method stub
		IButterpillar b = new Butterpillar();
		b.setLeavesEaten(leavesEaten);
		b.setLength(length);
		return b;
	}

	@Override
	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly [] catterflies = new ICatterfly[butterpillars.length];
		
		for (int i = 0; i < butterpillars.length; i++){
			catterflies[i] = growthModel.butterpillarToCatterfly(butterpillars[i]);
		}
		
		return catterflies;
		// TODO Auto-generated method stub
		
	}

	@Override
	public IButterpillar[] convert(ICatterfly[] catterflies) {
		// TODO Auto-generated method stub
		IButterpillar[] butterpillars = new IButterpillar[catterflies.length];
		
		for (int i = 0; i <catterflies.length; i++){
			butterpillars[i] = growthModel.catterflyToButterpillar(catterflies[i]);
		}
		
		return butterpillars;
	}
	

}
