package per.bai.greedysnake.windows;

import per.bai.greedysnake.Gutil.GetScore;
import per.bai.greedysnake.serviceImp.AdminServiceImp;
import per.bai.greedysnake.serviceInterface.AdminService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Vector;

public class AdmInformation extends JFrame {
    GetScore getScore = new GetScore();
    AllHandler ah = new AllHandler(this,getScore);


    JPanel jPanelNorth = new JPanel();
    JTable adinfo;
    JButton backBut;
    JButton nextPage;
    JButton previousPage;

    public AdmInformation(){
        super("排名");
        super.setSize(600,400);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        //
        backBut = new JButton("返回");
        nextPage = new JButton("下一页");
        previousPage = new JButton("上一页");
        //
        backBut.setPreferredSize(new Dimension(150,28));
        nextPage.setPreferredSize(new Dimension(150,28));
        previousPage.setPreferredSize(new Dimension(150,28));
        //
        backBut.addMouseListener(ah);
        nextPage.addMouseListener(ah);
        previousPage.addMouseListener(ah);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        jPanelNorth.add(backBut);
        jPanelNorth.add(previousPage);
        jPanelNorth.add(nextPage);
        container.add(jPanelNorth,BorderLayout.NORTH);
        //
        this.AdInforLayout();
        //jScrollPane.add(adinfo);
        adinfo.setEnabled(false);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    Vector<String> columns = new Vector<>();
    Vector<Vector> data = new Vector<>();
    AdminService adi = new AdminServiceImp();
    DefaultTableModel atm = new DefaultTableModel();
    public void AdInforLayout(){
        columns.add("user");
        columns.add("id");
        columns.add("score");
        update();
        JTableHeader jTableHeader = adinfo.getTableHeader();
        jTableHeader.setFont(new Font(null, Font.BOLD,20));
        //滚动
        JScrollPane jScrollPane = new JScrollPane(adinfo);
        super.add(jScrollPane);
    }

    public void update(){
        data = adi.showRank(getScore);
        atm.setDataVector(data,columns);
        adinfo = new JTable(atm);
        adinfo.setFont(new Font(null,Font.BOLD,15));
    }
}
