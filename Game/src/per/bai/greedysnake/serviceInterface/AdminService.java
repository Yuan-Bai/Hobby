package per.bai.greedysnake.serviceInterface;

import per.bai.greedysnake.Gutil.GetAdmin;
import per.bai.greedysnake.Gutil.GetScore;

import java.util.Vector;

public interface AdminService {
    boolean login(GetAdmin getAdmin);
    boolean register(GetAdmin getAdmin);
    Vector<Vector> showRank(GetScore gs);
    void storage(GetAdmin getAdmin);
}
