package oldmana.md.server.ai;

import oldmana.md.server.Player;
import oldmana.md.server.state.ActionState;

public class RLBot extends PlayerAI {

    public RLBot(Player player) {
        super(player);
    }

    @Override
    public void doAction() {
        // 1. Grab the current game state
        ActionState state = getServer().getGameState().getActionState();

        // 2. For now, just log it to check we have access
        System.out.println("RLBot sees state: " + state);

        // 3. Pick a dummy action (like ending the turn)
        getPlayer().endTurn();
    }

    @Override
    public double getWinThreat(Player player) {
        return 0;
    }

    @Override
    public double getRentThreat(Player player) {
        return 0;
    }
}
