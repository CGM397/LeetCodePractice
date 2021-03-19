package Q1601TO1650.number1603;

/**
 * @author: Bright Chan
 * @date: 2021/3/19 17:40
 * @description: 设计
 */
public class ParkingSystem {

    private int big, medium, small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
            else return false;
        }
        else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
            else return false;
        }
        else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
            else return false;
        }
        return false;
    }
}
