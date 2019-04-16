package bitflag;

public class FlagManager {

    public static final int COOL = 0;
    public static final int OLD = 2;
    public static final int HEAVY = 4;
    public static final int GREEN = 8;
    public static final int LONG = 16;

    private boolean isCool;
    private boolean isOld;
    private boolean isHeavy;
    private boolean isGreen;
    private boolean isLong;

    public void setFlags(int flag){
        this.isCool = (flag & COOL) == COOL;
        this.isOld = (flag & OLD) == OLD;
        this.isHeavy = (flag & HEAVY) == HEAVY;
        this.isGreen = (flag & GREEN) == GREEN;
        this.isLong = (flag & LONG) == LONG;
    }

    public boolean isCool() {
        return isCool;
    }

    public boolean isOld() {
        return isOld;
    }

    public boolean isHeavy() {
        return isHeavy;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public boolean isLong() {
        return isLong;
    }
}
