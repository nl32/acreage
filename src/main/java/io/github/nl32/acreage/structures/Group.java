package io.github.nl32.acreage.structures;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Group {
	private String name;
	public UUID groupId;
	public HashMap<Role, List<User>> users;
	public Group(String name, UUID id){
		this.name = name;
		groupId = id;
		users = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public UUID getGroupId() {
		return groupId;
	}

}
