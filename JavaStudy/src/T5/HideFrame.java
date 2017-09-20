package T5;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.Timer;

public class HideFrame extends JFrame implements ActionListener{
    private Rectangle rect;
    private int frameLeft;// ��������Ļ��ߵľ���
    private int frameRight;// ��������Ļ�ұߵľ��룻
    private int frameTop;// ��������Ļ�����ľ���
    private int frameWidth; // ����Ŀ�
    private int frameHeight;    // ����ĸ�

    private int screenXX;// ��Ļ�Ŀ�ȣ�
    private Point point;    // ����ڴ����λ��

    private Timer timer = new Timer(10, this);
    private int xx, yy;
    private boolean isDraging = false;

    public HideFrame(){
        timer.start();
        setTitle("��������Ļ��Ե������ʾ");
        setSize(400, 300);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                isDraging = false;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDraging) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    setLocation(left + e.getX() - xx, top + e.getY() - yy);
                    repaint();
                }
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent arg0) {
        frameLeft = getLocationOnScreen().x;
        frameTop = getLocationOnScreen().y;
        frameWidth = getWidth();
        frameHeight = getHeight();
        screenXX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        frameRight =screenXX- frameLeft - frameWidth;

        // ��ȡ�������*
        rect = new Rectangle(0, 0, frameWidth, frameHeight);
        // ��ȡ����ڴ����λ��
        point =getMousePosition();

        if (frameLeft < 0 && isPtInRect(rect, point)) {
            setLocation(0, frameTop); // ��������ߣ����ָ������ʾ���壻
        } else if (frameLeft > -5 && frameLeft < 5 && !(isPtInRect(rect, point))) {
            setLocation(frameLeft - frameWidth + 1, frameTop); // �����Ƶ���߱�Ե���ص���ߣ�
        } else if ((frameTop < 0 && frameLeft < 0) && isPtInRect(rect, point)) {// ���������Ͻǣ�
            setLocation(0, 0);// ���������ˣ����ָ�������ʾ��4��
        } else if ((frameTop > -5 && frameTop < 5) && (frameLeft > -5 && frameLeft < 5) && !(isPtInRect(rect, point))) {
            // ��������ϱ߿�����Ļ�Ķ��˵ľ���С��5ʱ ��
            // ������겻�ٴ����Ͻ��������ص���Ļ�Ķ���
            setLocation(frameLeft - frameWidth + 1, 1);
        } else if ((frameTop < 0) && isPtInRect(rect, point)) {
            setLocation(frameLeft, 0);// ���������ˣ����ָ�������ʾ��4��
        } else if (frameTop > -5 && frameTop < 5 && !(isPtInRect(rect, point))) {
            // ��������ϱ߿�����Ļ�Ķ��˵ľ���С��5ʱ ��
            // ������겻�ٴ����Ͻ��������ص���Ļ�Ķ���
            setLocation(frameLeft, 1 - frameHeight);
        } else if (frameRight < 0 && isPtInRect(rect, point)) {
            setLocation(screenXX - frameWidth + 1, frameTop);// �������ұߣ����ָ������ʾ��
        } else if (frameRight > -5 && frameRight < 5 && !(isPtInRect(rect, point))) {
            setLocation(screenXX - 1, frameTop); // �����Ƶ���Ļ�ұ߱�Ե���ص��ұߣ�
        } else if (frameRight < 0 && frameTop < 0 && isPtInRect(rect, point)) {// ���������Ͻǣ�
            setLocation(screenXX - frameWidth + 1, 0);// �������ұߣ����ָ������ʾ��
        } else if ((frameRight > -5 && frameRight < 5) && (frameTop > -5 && frameTop < 5) && !(isPtInRect(rect, point))) {
            setLocation(screenXX - 1, 1); // �����Ƶ���Ļ�ұ߱�Ե���ص��ұߣ�
        }
    }

    /**
     * ����Ƿ��ھ��ο���
     * @param rect
     * @param point
     * @return
     */
    public boolean isPtInRect(Rectangle rect, Point point) {
        if (rect != null && point != null) {
            int x0 = rect.x;
            int y0 = rect.y;
            int x1 = rect.width;
            int y1 = rect.height;
            int x = point.x;
            int y = point.y;

            return x >= x0 && x < x1 && y >= y0 && y < y1;
        }
        return false;
    }
    public static void main(String[] args){
        HideFrame frame = new HideFrame();
    }
}
