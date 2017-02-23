package companies.zalando;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BattleShips {

    public String solution(int N, String S, String T) {

        Map<String, Integer> ships = new HashMap<>();
        for (String area : S.split(",")) {
            ships.put(area, getShipSize(area));
        }

        int numberOfSunkenShips = 0;
        Set<String> hittedShips = new HashSet<>();
        for (String hit : T.split(" ")) {
            for (Map.Entry<String, Integer> ship : ships.entrySet()) {
                if (isHit(hit, ship)) {
                    int size = ship.getValue() - 1;
                    ship.setValue(size);
                    if (size == 0) {
                        numberOfSunkenShips++;
                        hittedShips.remove(ship.getKey());
                    } else {
                        hittedShips.add(ship.getKey());
                    }
                    break;
                }
            }
        }

        return String.format("%s,%s", numberOfSunkenShips, hittedShips.size());
    }

    private boolean isHit(String hit, Map.Entry<String, Integer> ship) {
        String[] coordinates = ship.getKey().split(" ");

        String topLeft = coordinates[0];
        String bottomRight = coordinates[1];

        return hit.equals(topLeft) || hit.equals(bottomRight) ||
                topLeft.charAt(0) - hit.charAt(0) >= 0 && bottomRight.charAt(0) - hit.charAt(0) <= 0 ||
                topLeft.charAt(1) - hit.charAt(1) <= 0 && bottomRight.charAt(1) - hit.charAt(1) >= 0;
    }

    private int getShipSize(String area) {
        String[] coordinates = area.split(" ");

        String topLeft = coordinates[0];
        String bottomRight = coordinates[1];

        if (topLeft.equals(bottomRight)) {
            return 1;
        } else if (topLeft.charAt(0) != bottomRight.charAt(0) &&
                topLeft.charAt(1) != bottomRight.charAt(1)) {
            return 4;
        } else if (topLeft.charAt(1) == bottomRight.charAt(1)) {
            return Math.abs((int) topLeft.charAt(0) - (int) bottomRight.charAt(0)) + 1;
        } else {
            return Math.abs((int) topLeft.toLowerCase().charAt(1) - (int) bottomRight.toLowerCase().charAt(1)) + 1;
        }
    }
}
