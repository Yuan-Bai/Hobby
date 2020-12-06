public class Whichis {
    YuanBai yuanBai;
    public Whichis(Character c) {
        if (c instanceof YuanBai) {
            yuanBai = (YuanBai) c;
            this.Return();
        }
    }
    public YuanBai Return(){
        return yuanBai;
    }
}
