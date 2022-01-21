package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.exception.*;

import java.util.*;

public class PlayroomBaseClient implements IPlayroom {

	private List<Toy> toyList;

	public PlayroomBaseClient(List<Toy> toyList) {
		this.toyList = toyList;
		if (toyList == null) {
			throw new InitializationException();
		}
	}

	@Override
	public List<Toy> getAllToys() {
		return toyList;
	}

	@Override
	public List<Toy> getToysByParameter(String parameter, String value) {
		if (parameter == null || value == null || value.isEmpty()){
			throw new GetToysByParameterException();
		}
		if ("id".equals(parameter)) {
			try {
				toyList.removeIf(toy -> (toy.getId() != Long.valueOf(value)));
			} catch (NumberFormatException e) {
				throw new GetToysByParameterException();
			}
		}
		if ("toyName".equals(parameter)) {
			toyList.removeIf(toy -> (!toy.getToyName().equals(value)));
		}
		if (toyList.isEmpty()) {
			throw new GetToysByParameterException();
		}
		toyList.removeIf(toy -> !toy.toString().contains(value));

		return toyList;
	}

	@Override
	public boolean addToy(Toy toy) {
		if (toy == null) {
			throw new AddToyException();
		}
		return toyList.add(toy);
	}

	@Override
	public boolean removeToy(Toy toy) {
		if (toy == null) {
			throw new RemoveToyException();
		}
		return toyList.remove(toy);
	}

	@Override
	public boolean updateToy(Long id, Toy toy) {
		if (id == null || toy == null) {
			throw new UpdateToyException();
		}
		for (Toy replaceableToy : toyList) {
			if (Objects.equals(replaceableToy.getId(), toy.getId())){
				toyList.set(toyList.indexOf(replaceableToy), toy);
			}
		}
		if (toyList.contains(toy)){
			return true;
		} else {
			throw new UpdateToyException();
		}
	}
}
