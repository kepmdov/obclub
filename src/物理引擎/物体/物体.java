package 物理引擎.物体;

public class 物体 {
    private int 重量;
    private 位置 位置;
    private int 能量;
    private 速度 速度;
    private 速度 加速度;

    class 速度{
        方向 方向;
        float 速度;
    }

    class 位置{
        int x;
        int y;
        int z;
        方向 方向;
    }

    class 方向{
        int x_c;
        int y_c;
    }

    public int get重量() {
        return 重量;
    }

    public void set重量(int 重量) {
        this.重量 = 重量;
    }

    public 物体.位置 get位置() {
        return 位置;
    }

    public void set位置(物体.位置 位置) {
        this.位置 = 位置;
    }

    public int get能量() {
        return 能量;
    }

    public void set能量(int 能量) {
        this.能量 = 能量;
    }

    public 物体.速度 get速度() {
        return 速度;
    }

    public void set速度(物体.速度 速度) {
        this.速度 = 速度;
    }

    public 物体.速度 get加速度() {
        return 加速度;
    }

    public void set加速度(物体.速度 加速度) {
        this.加速度 = 加速度;
    }

}
