package bridge.domain;

import bridge.validation.BridgeGameValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int currPosition = 0;
    private List<String> bridgeCurrStatus = new ArrayList<>();

    public List<String> getBridgeCurrStatus() {
        return bridgeCurrStatus;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String movingCommand, List<String> bridge) {
        String currBox = bridge.get(currPosition);

        addOWhenEqual(movingCommand, currBox);
        addXWhenUnequal(movingCommand, currBox);

        return bridgeCurrStatus;
    }

    public void addOWhenEqual(String movingCommand, String currBox) {
        if (movingCommand.equals(currBox)) {
            currPosition++;
            bridgeCurrStatus.add("O");
        }

        BridgeGameValidation bridgeGameValidation = new BridgeGameValidation();
        bridgeGameValidation.validateMoveWhenAvailable(movingCommand, currBox, bridgeCurrStatus);
    }

    public void addXWhenUnequal(String movingCommand, String currBox) {
        if (! movingCommand.equals(currBox)) {
            bridgeCurrStatus.add("X");
        }

        BridgeGameValidation bridgeGameValidation = new BridgeGameValidation();
        bridgeGameValidation.validateNotMoveWhenUnavailable(movingCommand, currBox, bridgeCurrStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
