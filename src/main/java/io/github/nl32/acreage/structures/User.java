package io.github.nl32.acreage.structures;

import java.util.HashMap;
import java.util.UUID;

public class User {
	public UUID id;
	public HashMap<UUID,Group> groups;
	public String chatMode;
	public User(UUID playerId){
		id = playerId;
		groups = new HashMap<>();
		chatMode = "global";
	}
}
