package info.preva1l.fadah.commands.subcommands;

import info.preva1l.fadah.Fadah;
import info.preva1l.fadah.config.Lang;
import info.preva1l.fadah.guis.CollectionBoxMenu;
import info.preva1l.fadah.utils.commands.SubCommand;
import info.preva1l.fadah.utils.commands.SubCommandArgs;
import info.preva1l.fadah.utils.commands.SubCommandArguments;
import org.jetbrains.annotations.NotNull;

public class CollectionBoxSubCommand extends SubCommand {
    public CollectionBoxSubCommand(Fadah plugin) {
        super(plugin);
    }

    @SubCommandArgs(name = "collectionbox", aliases = {"collection-box", "redeem"}, permission = "fadah.collection-box", description = "View your Collection Box!")
    public void execute(@NotNull SubCommandArguments command) {
        if (!Fadah.getINSTANCE().getConfigFile().getBoolean("enabled")) {
            command.sender().sendMessage(Lang.PREFIX.toFormattedString() + Lang.AUCTION_DISABLED.toFormattedString());
            return;
        }
        assert command.getPlayer() != null;
        new CollectionBoxMenu(command.getPlayer(), 0).open(command.getPlayer());
    }
}
