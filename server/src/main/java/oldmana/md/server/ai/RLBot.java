package oldmana.md.server.ai;

import oldmana.md.server.Player;

public class RLBot extends PlayerAI {
    public RLBot(Player player) {
        super(player);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doAction() {
        // Send current state to Python RL agent
        // Wait for action
        // Execute action in Java game
    }

    @Override
    public double getWinThreat(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWinThreat'");
    }

    @Override
    public double getRentThreat(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRentThreat'");
    }
}
