package io.github.nl32.acreage;

import io.github.nl32.acreage.structures.Group;

import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Stream;

public class TownManager {
	HashMap<UUID, Group> towns;
	public TownManager(){
		towns = new HashMap<>();
	}

	public Group getById(UUID id){
		return towns.get(id);
	}
	public void addGroup(String name){
		UUID _id = UUID.randomUUID();
		towns.put(_id,new Group(name,_id));
	}
	public Stream<Group> groupStream(){
		return towns.values().stream();
	}
}
