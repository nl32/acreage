package io.github.nl32.acreage.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.github.nl32.acreage.Acreage;
import io.github.nl32.acreage.TownManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import static com.mojang.brigadier.arguments.StringArgumentType.string;

public class Town implements Command {
	@Override
	public LiteralCommandNode<ServerCommandSource> getNode() {
		return CommandManager
				.literal("town").then(
					literal("list").executes(this::list)
				).then(
					literal("add").then(
							argument("name", string())
									.executes(this::add)
					)
				)
				.build();
	}
	public int list(CommandContext<ServerCommandSource> context) {
		TownManager towns = Acreage.getMod().townManager;
		StringBuilder listString = new StringBuilder();
		towns.groupStream().forEach(x -> {
			listString.append(x.getName());
			listString.append(", ");
		});
		context.getSource().sendFeedback(Text.of(listString.toString()),false);
		return 1;
	}
	public int add(CommandContext<ServerCommandSource> context) {
		TownManager townManager = Acreage.getMod().townManager;
		townManager.addGroup(context.getArgument("name",String.class));
		return 1;
	}
}
