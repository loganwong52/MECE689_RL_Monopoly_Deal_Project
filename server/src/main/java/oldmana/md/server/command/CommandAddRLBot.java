package oldmana.md.server.command;

import oldmana.md.server.ChatColor;
import oldmana.md.server.CommandSender;
import oldmana.md.server.Player;
import oldmana.md.server.ai.RLBot;
import oldmana.md.server.card.collection.deck.VanillaDeck;
import oldmana.md.server.event.player.PlayerJoinedEvent;

public class CommandAddRLBot extends Command {
    private int nextBotID = 1;

    public CommandAddRLBot() {
        super("addrlbot", true);
        setUsage("/addrlbot <Name>",
                "Name (Optional): The name of the RL bot");
        setDescription("Add an RL-controlled bot into the game.");
    }

    @Override
    public void executeCommand(CommandSender sender, String[] args) {
        Player bot = new Player(args.length > 0 ? getFullStringArgument(args, 0) : "RLBot " + nextBotID++);
        bot.setAI(new RLBot(bot)); // This is the key change - use RLBot instead of default AI
        getServer().addPlayer(bot);
        getServer().getEventManager().callEvent(new PlayerJoinedEvent(bot));
        sender.sendMessage("Created RL bot '" + bot.getName() + "' (ID: " + bot.getID() + ")", true);
        if (!(getServer().getDeck().getDeckStack() instanceof VanillaDeck)) {
            sender.sendMessage(ChatColor.PREFIX_ALERT + "Warning: Bots may not function well with custom decks.");
        }
    }
}