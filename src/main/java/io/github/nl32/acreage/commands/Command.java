package io.github.nl32.acreage.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;

public interface Command {
	LiteralCommandNode<ServerCommandSource> getNode();
}
