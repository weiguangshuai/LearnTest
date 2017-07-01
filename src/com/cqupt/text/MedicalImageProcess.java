package com.cqupt.text;

/**
 * @author weigs
 * @date 2017/6/22 0022
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;

public class MedicalImageProcess extends JFrame implements ActionListener
{
    JPanel jp1,jp11,jp111,jp112,jp2,jp21,jp211,jp212,northPanel,pictPanel,pict1,pict2;
    JTabbedPane jtp;
    JButton xianxing,fanzhuan,weicaise,pinghua,ruihua,zhongzhi,erzhihua,bianyuan;
    TitledBorder titled1,titled2,titled3,titled4;
    JSlider jSlider;
    JMenuBar bar;
    JMenu fileMenu,dataMenu;
    JMenuItem openItem,exitItem,checkItem,insertItem;
    JFileChooser chooser;
    File file;
    String filename;
    Image im,tmp,tmp0;
    int i,iw,ih;
    int[] pixels;
    Border etched1,etched2;
    SoftBevelBorder softBevelBorder;
    Connection con;
    Statement stmt;
    ResultSet rs;
    String id,name,pi;
    boolean flagGray = false;
    boolean flagLoad = false;
    boolean flag=false;

    public MedicalImageProcess()
    {
        super("Java数字图像处理");

        Container contents = getContentPane();//创建一个容器，所有基本组件都放入其中

        jtp = new JTabbedPane(SwingConstants.TOP);//创建一个可以在一组组件之间切换的选项卡

        jp1 = new JPanel();
        jp11 = new JPanel();
        jp111 = new JPanel();
        jp112 = new JPanel();

        jp2 = new JPanel();
        jp21 = new JPanel();
        jp211 = new JPanel();
        jp212 = new JPanel();

        northPanel = new JPanel();
        pictPanel = new JPanel();
        pict1 = new JPanel();
        pict2 = new JPanel();

        jSlider = new JSlider(JSlider.HORIZONTAL,0,255,100);//创建一个通过移动滑块来选择值的组件

        xianxing = new JButton("线性灰度变换");
        fanzhuan = new JButton("反转灰度变换");
        weicaise = new JButton("伪彩色处理");
        pinghua = new JButton("平 滑 处 理");
        ruihua = new JButton("锐 化 处 理");
        zhongzhi = new JButton("中 值 滤 波");
        erzhihua = new JButton("二值化处理");
        bianyuan = new JButton("边 缘 检 测");

        titled1 = new TitledBorder("图像灰度化及伪彩色处理");
        titled2 = new TitledBorder("图像平滑锐化处理及其中值滤波");
        titled3 = new TitledBorder("图像二值化处理");
        titled4 = new TitledBorder("图像的Robert边缘检测");

        softBevelBorder = new SoftBevelBorder(2,Color.black,Color.white);//实现凹凸斜面

        init();

        jp111.setBorder(titled1);//设置带标题边框的边框
        jp112.setBorder(titled2);
        jp211.setBorder(titled3);
        jp212.setBorder(titled4);

        jSlider.setMajorTickSpacing(50);//设置主刻度标记间隔
        jSlider.setMinorTickSpacing(10);//设置次刻度标记间隔
        jSlider.setPaintTicks(true);//设置在滑块上绘制刻度标记
        jSlider.setPaintTrack(true);//通知是否绘制滑块
        jSlider.setPaintLabels(true);//通知是否绘制标签

        jp111.add(xianxing);
        jp111.add(fanzhuan);
        jp111.add(weicaise);
        jp112.add(pinghua);
        jp112.add(ruihua);
        jp112.add(zhongzhi);
        jp11.setLayout(new GridLayout(1,2));
        jp11.add(jp111);
        jp11.add(jp112);

        jp211.add(jSlider);
        jp211.add(erzhihua);
        jp212.add(bianyuan);
        jp21.setLayout(new GridLayout(1,2));
        jp21.add(jp211);
        jp21.add(jp212);


        jp1.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());

        pictPanel.setBorder(softBevelBorder);

        northPanel.setLayout(new BorderLayout());

        jp1.add(jp11);
        jp2.add(jp21);

        jtp.add("图 像 增 强",jp1);
        jtp.add("图 像 分 割",jp2);

        northPanel.add(jtp,BorderLayout.CENTER);
        etched1 = BorderFactory.createEtchedBorder();//创建一个具有浮雕化外观效果的边框
        etched2 = BorderFactory.createEtchedBorder();
        pictPanel.setLayout(new GridLayout(0,2));
        pict1.setBorder(etched1);
        pict2.setBorder(etched2);

        pictPanel.add(pict1);
        pictPanel.add(pict2);
        contents.add(northPanel,BorderLayout.NORTH);
        contents.add(pictPanel,BorderLayout.CENTER);

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:image");
            stmt = con.createStatement();
        }
        catch(Exception e){}

        xianxing.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jxianxing_ActionPerformed(e);
            }
        });

        fanzhuan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jfanzhuan_ActionPerformed(e);
            }
        });

        weicaise.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jweicaise_ActionPerformed(e);
            }
        });

        pinghua.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jpinghua_ActionPerformed(e);
            }
        });
        ruihua.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jruihua_ActionPerformed(e);
            }
        });

        zhongzhi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jzhongzhi_ActionPerformed(e);
            }
        });

        jSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e)
            {
                jerzhihua_ActionPerformed(e);
            }
        });

        erzhihua.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jerzhihua_ActionPerformed(e);
            }
        });

        bianyuan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jbianyuan_ActionPerformed(e);
            }
        });
    }

    public void init()
    {
        bar = new JMenuBar();//创建一个菜单栏
        setJMenuBar( bar );

        fileMenu = new JMenu("File");//创建菜单
        fileMenu.setMnemonic('F');
        openItem = new JMenuItem("Open");//菜单项
        openItem.setMnemonic('O');
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');

        dataMenu = new JMenu("Data");
        dataMenu.setMnemonic('D');
        checkItem = new JMenuItem("Check");
        checkItem.setMnemonic('C');
        insertItem = new JMenuItem("Insert");
        insertItem.setMnemonic('I');

        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        dataMenu.add(checkItem);
        dataMenu.add(insertItem);

        bar.add(fileMenu);
        bar.add(dataMenu);

        openItem.addActionListener(this);
        exitItem.addActionListener(this);
        checkItem.addActionListener(this);
        insertItem.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == openItem)
        {
            chooser = new JFileChooser("F:/");//文件选择器
            chooser.addChoosableFileFilter(new MyFileFilter("jpg;gif", "图像文件"));

            int returnVal = chooser.showOpenDialog(pictPanel);
            if(returnVal == JFileChooser.APPROVE_OPTION)//选择确认（yes、ok）后返回该值
            {
                file = chooser.getSelectedFile();//返回选中的文件
                filename = file.getPath();//将此抽象路径名转换为一个路径名字符串

                jLoad_ActionPerformed(event);
            }
        }
        else if(event.getSource() == exitItem)
        {
            int i = JOptionPane.showConfirmDialog(null,"要退出系统吗？","退出系统",2,2);

            if(i == 0)//如果用户按的是确定
            {
                try
                {
                    rs.close();    //关闭记录集
                    stmt.close(); //关闭Statement对象
                    con.close();  //关闭数据库链接
                }
                catch(Exception e6){}
                this.dispose();//释放资源
                System.exit(0);
            }
        }
        else if(event.getSource() == checkItem)
        {
            try
            {
                int rec=0;
                String s=JOptionPane.showInputDialog(null,"请输入ID");
                rs = stmt.executeQuery("SELECT ID, 姓名,图片 FROM pic");
                while (rs.next())
                {
                    id= rs.getString("ID");
                    name= rs.getString("姓名");
                    pi=rs.getString("图片");
                    if(id.equals(s.trim()))
                    {
                        filename=pi;
                        jLoad_ActionPerformed(event);
                        rec=1;
                        break;
                    }
                }
                if(rec==0)JOptionPane.showMessageDialog(null,"数据库中没有此图片");
                rs.close();
            }
            catch(Exception e2){}
        }
        else if(event.getSource() == insertItem)
        {
            try
            {
                String s1=JOptionPane.showInputDialog(null,"请输入ID");
                String s2 = JOptionPane.showInputDialog(null,"请输入姓名");
                String strInc = "INSERT INTO pic(ID,姓名,图片) Values('"+s1+"','"+s2+"','"+filename+"')";
                stmt.executeUpdate(strInc);

            }
            catch(Exception e3){}
            finally{
                JOptionPane.showMessageDialog(null,"图像已添加进数据库");
            }
        }

    }

    public void jLoad_ActionPerformed(ActionEvent e)
    {
        //利用MediaTracker跟踪图像的加载
        MediaTracker tracker = new MediaTracker(this);
        im=Toolkit.getDefaultToolkit().getImage(filename);
        tracker.addImage(im,0);//im为跟踪的图像，0为所跟踪图像标识符

        //等待图像的完全加载
        try{
            tracker.waitForID(0);//此0与上面的0对应
        }catch(InterruptedException e2){ e2.printStackTrace();}//将中断输出至标准错误流

        //获取图像的宽度iw和高度ih
        iw=im.getWidth(this);
        ih=im.getHeight(this);
        pixels=new int[iw*ih];

        try{//从im中获得图像的像素子集存储在pixels数组中
            PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
            pg.grabPixels();//请求Image开始传递像素
        }catch (InterruptedException e3) {
            e3.printStackTrace();
        }

        //将数组中的象素产生一个图像，默认使用RGB
        ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
        tmp=createImage(ip);//由指定的图像生成器ip创建一幅图像
        flagLoad = true;
        repaint();
    }

    public void jxianxing_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            //此 ColorModel 抽象类封装了将像素值转换为颜色分量（例如，红色、绿色和蓝色）和 alpha 分量的方法。
            ColorModel cm=ColorModel.getRGBdefault();//返回描述默认 RGB 值的对象
            for(i=0;i<ih*iw;i++)
            {
                int alpha=cm.getAlpha(pixels[i]);
                int red=cm.getRed(pixels[i]);
                int green=cm.getGreen(pixels[i]);
                int blue=cm.getBlue(pixels[i]);

                red=(int)(1.1*red+20);
                green=(int)(1.1*green+20);
                blue=(int)(1.1*blue+20);
                if(red>=255){red=255;}
                if(green>=255){green=255;}
                if(blue>=255){blue=255;}

                pixels[i]=alpha<<24|red<<16|green<<8|blue;
            }
            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flagGray=true;
            flag = true;
            repaint();

        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jfanzhuan_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            //此 ColorModel 抽象类封装了将像素值转换为颜色分量（例如，红色、绿色和蓝色）和 alpha 分量的方法。
            ColorModel cm=ColorModel.getRGBdefault();//返回描述默认 RGB 值的对象
            for(i=0;i<ih;i++)
            {
                for(int j=0;j<iw;j++)
                {
                    int alpha=cm.getAlpha(pixels[i*iw+j]);
                    int red=255-cm.getRed(pixels[i*iw+j]);
                    int green=255-cm.getGreen(pixels[i*iw+j]);
                    int blue=255-cm.getBlue(pixels[i*iw+j]);

                    pixels[i*iw+j]=alpha<<24|red<<16|green<<8|blue;
                }
            }
            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flagGray=true;
            flag = true;
            repaint();

        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jweicaise_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3)
            {
                e3.printStackTrace();
            }

            ColorModel cm=ColorModel.getRGBdefault();

            for(int i=0;i<ih;i++)
            {
                for(int j=0;j<iw;j++)
                {
                    int grey = pixels[i*iw+j]&0xff;
                    int alpha=cm.getAlpha(pixels[i*iw+j]);
                    int red,green ,blue ;
                    //方法（1）
   	 /*             if(grey<64)
				    {
				    	 red = 0;
				    	 green = 4 * grey;
				    	 blue = 255;
				    }
				    else if(grey<128)
				    {
				    	 red = 0;
				    	 green = 255;
				         blue = (127-grey)*4;
				    }
				    else if(grey<192)
				    {
				    	 red = (grey-128)*4;
			    		 green = 255;
			        	 blue = 0;
			    	}
			    	else
			    	{
			    		 red = 255;
			    	 	 green = (255-grey)*4;
			    	 	 blue = 0;
			        }
	*/
                    //方法（2）
	/*		   	    switch(grey/64)
				    {
			  		  	case 0:red = 0;green = 4 * green;blue = 255;break;
			  		  	case 1:red = 0;green = 255;blue = 511 - 4 * grey;break;
			 		   	case 2:red = 4 * grey - 511;green = 255;blue = 0;break;
			  		  	case 3:red = 255;green = 1023 - 4 * grey;blue = 0;break;
			 	    }
	*/
                    //		 	    pixels[i*iw+j]=alpha<<24|red<<16|green<<8|blue;

                    //方法（3）
	/*		 	   int[] colorTable = {0x000000,0x000055,0x005500,0x550000,0x3F3F3F,0x550055,0x0000FF,
			 	   0x555500,0x00FF00,0xFF0000,0x808080,0x00FFFF,0xFFFF00,0xFFFFFF,0x005555,0xFF00FF};
			 	   int newGrey = grey * 16 / 255;
			 	   pixels[i*iw+j]=alpha<<24|colorTable[newGrey];
	*/
                    //方法(4)
                    int[] colorTable = {0x000000,0x0000a8,0x00a800,0x00a8a8,0xa80000,0xa800a8,0xa85400,0xa8a8a8,
                            0x545454,0x5454fc,0x54fc54,0x54fcfc,0xfc5454,0xfc54fc,0xfcfc54,0xfcfcfc,
                            0x000000,0x141414,0x202020,0x2c2c2c,0x383838,0x444444,0x505050,0x606060,
                            0x707070,0x808080,0x909090,0xa0a0a0,0xb4b4b4,0xc8c8c8,0xe0e0e0,0xfcfcfc,
                            0x0000fc,0x4000fc,0x7c00fc,0xbc00fc,0xfc00fc,0xfc00bc,0xfc007c,0xfc0040,
                            0xfc0000,0xfc4000,0xfc7c00,0xfcbc00,0xfcfc00,0xbcfc00,0x7cfc00,0x40fc00,
                            0x00fc00,0x00fc40,0x00fc7c,0x00fcbc,0x00fcfc,0x00bcfc,0x007cfc,0x0040fc,
                            0x7c7cfc,0x9c7cfc,0xbc7cfc,0xdc7cfc,0xfc7cfc,0xfc7cdc,0xfc7cbc,0xfc7c9c,
                            0xfc7c7c,0xfc9c7c,0xfcbc7c,0xfcdc7c,0xfcfc7c,0xdcfc7c,0xbcfc7c,0x9cfc7c,
                            0x7cfc7c,0x7cfc9c,0x7cfcbc,0x7cfcdc,0x7cfcfc,0x7cdcfc,0x7cbcfc,0x7c9cfc,
                            0xb4b4fc,0xc4b4fc,0xd8b4fc,0xe8b4fc,0xfcb4fc,0xfcb4e8,0xfcb4d8,0xfcb4c4,
                            0xfcb4b4,0xfcc4b4,0xfcd8b4,0xfce8b4,0xfcfcb4,0xe8fcb4,0xd8fcb4,0xc4fcb4,
                            0xb4fcb4,0xb4fcc4,0xb4fcd8,0xb4fce8,0xb4fcfc,0xb4e8fc,0xb4d8fc,0xb4c4fc,
                            0x000070,0x1c0070,0x380070,0x540070,0x700070,0x700054,0x700038,0x70001c,
                            0x700000,0x701c00,0x703800,0x705400,0x707000,0x547000,0x387000,0x1c7000,
                            0x007000,0x00701c,0x007038,0x007054,0x007070,0x005470,0x003870,0x001c70,
                            0x383870,0x443870,0x543870,0x603870,0x703870,0x703860,0x703854,0x703844,
                            0x703838,0x704438,0x705438,0x706038,0x707038,0x607038,0x547038,0x447038,
                            0x387038,0x387044,0x387054,0x387060,0x387070,0x386070,0x385470,0x384470,
                            0x505070,0x585070,0x605070,0x685070,0x705070,0x705068,0x705060,0x705058,
                            0x705050,0x705850,0x706050,0x706850,0x707050,0x687050,0x607050,0x587050,
                            0x507050,0x507058,0x507060,0x507068,0x507070,0x506870,0x506070,0x505870,
                            0x000040,0x100040,0x200040,0x300040,0x400040,0x400030,0x400020,0x400010,
                            0x400000,0x401000,0x402000,0x403000,0x404000,0x304000,0x204000,0x104000,
                            0x004000,0x004010,0x004020,0x004030,0x004040,0x003040,0x002040,0x001040,
                            0x202040,0x282040,0x302040,0x382040,0x402040,0x402038,0x402030,0x402028,
                            0x402020,0x402820,0x403020,0x403820,0x404020,0x384020,0x304020,0x284020,
                            0x204020,0x204028,0x204030,0x204038,0x204040,0x203840,0x203040,0x202840,
                            0x2c2c40,0x302c40,0x342c40,0x3c2c40,0x402c40,0x402c3c,0x402c34,0x402c30,
                            0x402c2c,0x40302c,0x40342c,0x403c2c,0x40402c,0x3c402c,0x34402c,0x30402c,
                            0x2c402c,0x2c4030,0x2c4034,0x2c403c,0x2c4040,0x2c3c40,0x2c3440,0x2c3040,
                            0x000000,0x000000,0x000000,0x000000,0x000000,0x000000,0x000000,0x000000};
                    if(grey<16)
                    {
                        pixels[i*iw+j]=alpha<<24|colorTable[grey];
                    }
                    if(grey>=16&&grey<255)
                    {
                        pixels[i*iw+j]=alpha<<24|colorTable[30+grey/4];
                    }

                }
            }
            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag=true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jpinghua_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //对图像进行平滑化处理，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(int i=1;i<ih-1;i++)
            {
                for(int j=1;j<iw-1;j++)
                {
                    int alpha=cm.getAlpha(pixels[i*iw+j]);
                    int red=cm.getRed(pixels[i*iw+j]);
                    int green=cm.getGreen(pixels[i*iw+j]);
                    int blue=cm.getBlue(pixels[i*iw+j]);

                    //对图像进行平滑
                    int red1=cm.getRed(pixels[(i-1)*iw+j-1]);
                    int red2=cm.getRed(pixels[(i-1)*iw+j]);
                    int red3=cm.getRed(pixels[(i-1)*iw+j+1]);
                    int red4=cm.getRed(pixels[i*iw+j-1]);
                    int red6=cm.getRed(pixels[i*iw+j+1]);
                    int red7=cm.getRed(pixels[(i+1)*iw+j-1]);
                    int red8=cm.getRed(pixels[(i+1)*iw+j]);
                    int red9=cm.getRed(pixels[(i+1)*iw+j+1]);
                    int averageRed=(red1+red2+red3+red4+red6+red7+red8+red9)/8;

                    int green1=cm.getGreen(pixels[(i-1)*iw+j-1]);
                    int green2=cm.getGreen(pixels[(i-1)*iw+j]);
                    int green3=cm.getGreen(pixels[(i-1)*iw+j+1]);
                    int green4=cm.getGreen(pixels[i*iw+j-1]);
                    int green6=cm.getGreen(pixels[i*iw+j+1]);
                    int green7=cm.getGreen(pixels[(i+1)*iw+j-1]);
                    int green8=cm.getGreen(pixels[(i+1)*iw+j]);
                    int green9=cm.getGreen(pixels[(i+1)*iw+j+1]);
                    int averageGreen=(green1+green2+green3+green4+green6+green7+green8+green9)/8;

                    int blue1=cm.getBlue(pixels[(i-1)*iw+j-1]);
                    int blue2=cm.getBlue(pixels[(i-1)*iw+j]);
                    int blue3=cm.getBlue(pixels[(i-1)*iw+j+1]);
                    int blue4=cm.getBlue(pixels[i*iw+j-1]);
                    int blue6=cm.getBlue(pixels[i*iw+j+1]);
                    int blue7=cm.getBlue(pixels[(i+1)*iw+j-1]);
                    int blue8=cm.getBlue(pixels[(i+1)*iw+j]);
                    int blue9=cm.getBlue(pixels[(i+1)*iw+j+1]);
                    int averageBlue=(blue1+blue2+blue3+blue4+blue6+blue7+blue8+blue9)/8;

                    pixels[i*iw+j]=alpha<<24|averageRed<<16|averageGreen<<8|averageBlue;
                }
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag=true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jruihua_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //对图像进行尖锐化处理，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(int i=1;i<ih-1;i++)
            {
                for(int j=1;j<iw-1;j++)
                {
                    int alpha=cm.getAlpha(pixels[i*iw+j]);

                    //对图像进行尖锐化
                    int red6=cm.getRed(pixels[i*iw+j+1]);
                    int red5=cm.getRed(pixels[i*iw+j]);
                    int red8=cm.getRed(pixels[(i+1)*iw+j]);
                    int sharpRed=Math.abs(red6-red5)+Math.abs(red8-red5);

                    int green5=cm.getGreen(pixels[i*iw+j]);
                    int green6=cm.getGreen(pixels[i*iw+j+1]);
                    int green8=cm.getGreen(pixels[(i+1)*iw+j]);
                    int sharpGreen=Math.abs(green6-green5)+Math.abs(green8-green5);

                    int blue5=cm.getBlue(pixels[i*iw+j]);
                    int blue6=cm.getBlue(pixels[i*iw+j+1]);
                    int blue8=cm.getBlue(pixels[(i+1)*iw+j]);
                    int sharpBlue=Math.abs(blue6-blue5)+Math.abs(blue8-blue5);

                    if(sharpRed>255) {sharpRed=255;}
                    if(sharpGreen>255) {sharpGreen=255;}
                    if(sharpBlue>255) {sharpBlue=255;}

                    pixels[i*iw+j]=alpha<<24|sharpRed<<16|sharpGreen<<8|sharpBlue;
                }
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag=true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jzhongzhi_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //对图像进行中值滤波，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(int i=1;i<ih-1;i++)
            {
                for(int j=1;j<iw-1;j++)
                {
                    int red,green,blue;
                    int alpha=cm.getAlpha(pixels[i*iw+j]);

                    int red2=cm.getRed(pixels[(i-1)*iw+j]);
                    int red4=cm.getRed(pixels[i*iw+j-1]);
                    int red5=cm.getRed(pixels[i*iw+j]);
                    int red6=cm.getRed(pixels[i*iw+j+1]);
                    int red8=cm.getRed(pixels[(i+1)*iw+j]);

                    //水平方向进行中值滤波
                    if(red4>=red5){
                        if(red5>=red6) {red=red5;}
                        else{
                            if(red4>=red6) {red=red6;}
                            else{red=red4;}
                        }}
                    else{
                        if(red4>red6) {red=red4;}
                        else{
                            if(red5>red6) {red=red6;}
                            else{red=red5;}
                        }}

                    int green2=cm.getGreen(pixels[(i-1)*iw+j]);
                    int green4=cm.getGreen(pixels[i*iw+j-1]);
                    int green5=cm.getGreen(pixels[i*iw+j]);
                    int green6=cm.getGreen(pixels[i*iw+j+1]);
                    int green8=cm.getGreen(pixels[(i+1)*iw+j]);

                    //水平方向进行中值滤波
                    if(green4>=green5){
                        if(green5>=green6) {green=green5;}
                        else{
                            if(green4>=green6) {green=green6;}
                            else{green=green4;}
                        }}
                    else{
                        if(green4>green6) {green=green4;}
                        else{
                            if(green5>green6) {green=green6;}
                            else{green=green5;}
                        }}


                    int blue2=cm.getBlue(pixels[(i-1)*iw+j]);
                    int blue4=cm.getBlue(pixels[i*iw+j-1]);
                    int blue5=cm.getBlue(pixels[i*iw+j]);
                    int blue6=cm.getBlue(pixels[i*iw+j+1]);
                    int blue8=cm.getBlue(pixels[(i+1)*iw+j]);

                    //水平方向进行中值滤波
                    if(blue4>=blue5){
                        if(blue5>=blue6) {blue=blue5;}
                        else{
                            if(blue4>=blue6) {blue=blue6;}
                            else{blue=blue4;}
                        }}
                    else{
                        if(blue4>blue6) {blue=blue4;}
                        else{
                            if(blue5>blue6) {blue=blue6;}
                            else{blue=blue5;}
                        }}
                    pixels[i*iw+j]=alpha<<24|red<<16|green<<8|blue;
                }
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag=true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jerzhihua_ActionPerformed(ChangeEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //设定二值化的域值，默认值为100
            int grey=jSlider.getValue();

            //对图像进行二值化处理，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(int i=0;i<iw*ih;i++)
            {
                int red,green,blue;
                int alpha=cm.getAlpha(pixels[i]);
                if(cm.getRed(pixels[i])>grey)
                {
                    red = 255;
                }else{ red=0;}

                if(cm.getGreen(pixels[i])>grey)
                {
                    green=255;
                }else{green=0;}

                if(cm.getBlue(pixels[i])>grey)
                {
                    blue=255;
                }else{blue=0;}

                pixels[i]=alpha<<24|red<<16|green<<8|blue;
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag = true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jerzhihua_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //设定二值化的域值，默认值为100
            int grey=100;
            Object tmpGrey="100";
            String s=JOptionPane.showInputDialog(null,"输入二值化的域值（0-255）：",tmpGrey);

            if(s!=null)
            {
                grey=Integer.parseInt(s);
            }
            if(grey>255)
            {
                grey=255;
            }else if(grey<0)
            {
                grey=0;
            }
            //对图像进行二值化处理，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(int i=0;i<iw*ih;i++)
            {
                int red,green,blue;
                int alpha=cm.getAlpha(pixels[i]);
                if(cm.getRed(pixels[i])>grey)
                {
                    red = 255;
                }else{ red=0;}

                if(cm.getGreen(pixels[i])>grey)
                {
                    green=255;
                }else{green=0;}

                if(cm.getBlue(pixels[i])>grey)
                {
                    blue=255;
                }else{blue=0;}

                pixels[i]=alpha<<24|red<<16|green<<8|blue;
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag = true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jbianyuan_ActionPerformed(ActionEvent e)
    {
        if(flagLoad)
        {
            try{
                PixelGrabber pg=new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch (InterruptedException e3) {
                e3.printStackTrace();
            }

            //对图像进行边缘提取，Alpha值保持不变
            ColorModel cm=ColorModel.getRGBdefault();
            for(i=1;i<ih-1;i++)
            {
                for(int j=1;j<iw-1;j++)
                {
                    //对图像进行边缘提取
                    int alpha=cm.getAlpha(pixels[i*iw+j]);
                    int red5=cm.getRed(pixels[i*iw+j]);
                    int red6=cm.getRed(pixels[i*iw+j+1]);
                    int red8=cm.getRed(pixels[(i+1)*iw+j]);
                    int red9=cm.getRed(pixels[(i+1)*iw+j+1]);

                    int robertRed=Math.max(Math.abs(red5-red9),Math.abs(red8-red6));

                    int green5=cm.getGreen(pixels[i*iw+j]);
                    int green6=cm.getGreen(pixels[i*iw+j+1]);
                    int green8=cm.getGreen(pixels[(i+1)*iw+j]);
                    int green9=cm.getGreen(pixels[(i+1)*iw+j+1]);

                    int robertGreen=Math.max(Math.abs(green5-green9),Math.abs(green8-green6));

                    int blue5=cm.getBlue(pixels[i*iw+j]);
                    int blue6=cm.getBlue(pixels[i*iw+j+1]);
                    int blue8=cm.getBlue(pixels[(i+1)*iw+j]);
                    int blue9=cm.getBlue(pixels[(i+1)*iw+j+1]);

                    int robertBlue=Math.max(Math.abs(blue5-blue9),Math.abs(blue8-blue6));

                    pixels[i*iw+j]=alpha<<24|robertRed<<16|robertGreen<<8|robertBlue;
                }
            }

            //将数组中的象素产生一个图像
            ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
            tmp0=createImage(ip);
            flag = true;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"请先打开一幅图片!",
                    "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void paint(Graphics g)
    {
        if(flagLoad)
        {
            g.drawImage(tmp,9,171,this);
        }
        if(flagLoad&&flag)
        {
            g.drawImage(tmp0,9+pict1.getWidth(),171,this);
        }
    }

    public static void main(String[] args)
    {
        MedicalImageProcess mig = new MedicalImageProcess();
        mig.setLocation(30,30);
        mig.setSize(964,708);

        mig.setVisible(true);
    }
}
