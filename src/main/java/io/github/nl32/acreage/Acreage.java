package io.github.nl32.acreage;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.github.nl32.acreage.commands.Command;
import io.github.nl32.acreage.commands.Town;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;

public class Acreage implements ModInitializer {
	private static Acreage acreage;
	public TownManager townManager;
	@Override
	public void onInitialize(ModContainer mod) {
		townManager = new TownManager();
		CommandRegistrationCallback.EVENT.register(Acreage::registerCommands);
		acreage=this;
	}

	public static Acreage getMod(){
		return acreage;
	}

	public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext buildContext, CommandManager.RegistrationEnvironment registrationEnvironment){
		LiteralCommandNode<ServerCommandSource> acreage = CommandManager
				.literal("acreage")
				.build();
		LiteralCommandNode<ServerCommandSource> alias = CommandManager
				.literal("ac")
				.build();
		Command[] commands = new Command[] {
				new Town()
		};
		for (Command command : commands) {
				acreage.addChild(command.getNode());
				alias.addChild(command.getNode());
		}
		dispatcher.getRoot().addChild(acreage);
		dispatcher.getRoot().addChild(alias);
	}
}
