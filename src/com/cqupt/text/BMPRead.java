package com.cqupt.text;

import javax.swing.*;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.io.FileInputStream;

/**
 * @author weigs
 * @date 2017/6/19 0019
 */
public class BMPRead extends JFrame {
    //定义全局变量
    int nWidth;
    int nHeight;
    int nBitCount;
    int nSizeImage;
    int[] nData;
    int[] Blue;
    int[] Red;
    int[] Green;
    public Image image, img1;
    int[] GGrayData;

    public BMPRead() {
        // TODO Auto-generated constructor stub
        super("PCR电泳图像处理基础实验");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        try {
            this.getBMPImage("E:/魏广帅/生物信息/shiyan1.bmp");
            this.GGrayData = this.graytongjiData();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.image = this.getmyimage(this.nData);
        //this.img1 = this.getmyimage(this.erzhiProcess(this.nData,90));
        this.img1 = this.getGrayImage(95);
    }

    //获取待检测图像 ，数据保存在数组 nData[]，nB[] ，nG[] ，nR[]中
    public void getBMPImage(String source) throws Exception {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(source);
            int bfLen = 14;
            byte bf[] = new byte[bfLen];
            fs.read(bf, 0, bfLen); // 读取14字节BMP文件头
            int biLen = 40;
            byte bi[] = new byte[biLen];
            fs.read(bi, 0, biLen); // 读取40字节BMP信息头

            // 源图宽度
            nWidth = ChangeInt(bi, 7);
            // 源图高度
            nHeight = ChangeInt(bi, 11);
            // 位数
            nBitCount = (((int) bi[15] & 0xff) << 8) | (int) bi[14] & 0xff;

            // 源图大小
            nSizeImage = ChangeInt(bi, 23);
            // 对24位BMP进行解析
            if (nBitCount == 24) {
                int nPad = (nSizeImage / nHeight) - nWidth * 3;
                nData = new int[nHeight * nWidth];
                Blue = new int[nHeight * nWidth];
                Red = new int[nHeight * nWidth];
                Green = new int[nHeight * nWidth];
                byte bRGB[] = new byte[(nWidth + nPad) * 3 * nHeight];
                fs.read(bRGB, 0, (nWidth + nPad) * 3 * nHeight);
                int nIndex = 0;
                for (int j = 0; j < nHeight; j++) {
                    for (int i = 0; i < nWidth; i++) {
                        nData[nWidth * (nHeight - j - 1) + i] = (255 & 0xff) << 24
                                | (((int) bRGB[nIndex + 2] & 0xff) << 16)
                                | (((int) bRGB[nIndex + 1] & 0xff) << 8)
                                | (int) bRGB[nIndex] & 0xff;
                        Blue[nWidth * (nHeight - j - 1) + i] = (int) bRGB[nIndex] & 0xff;
                        Green[nWidth * (nHeight - j - 1) + i] = (int) bRGB[nIndex + 1] & 0xff;
                        Red[nWidth * (nHeight - j - 1) + i] = (int) bRGB[nIndex + 2] & 0xff;
                        nIndex += 3;
                    }
                    nIndex += nPad;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            if (fs != null) {
                fs.close();
            }
        }
        //   return image;
    }

    //封装byte转化为int
    public int ChangeInt(byte[] array2, int start) {

        int i = (int) ((array2[start] & 0xff) << 24)
                | ((array2[start - 1] & 0xff) << 16)
                | ((array2[start - 2] & 0xff) << 8)
                | (array2[start - 3] & 0xff);
        return i;
    }

    public int[] erzhiProcess(int[] data, int gate) {
        int k;
        int[] processData = new int[data.length];
        for (int i = 0; i < nWidth * nHeight; i++) {
            k = (int) (0.3 * Blue[i] + 0.59 * Green[i] + 0.11 * Red[i]);
            k = k > 255 ? 255 : k;
            if (k > gate)
                processData[i] = (255 << 24) | (255 << 16) | (255 << 8) | 255;
            else
                processData[i] = (255 << 24) | (0 << 16) | (0 << 8) | 0;
            System.out.println(processData[i]);

        }
        return processData;
    }

    public int[] graytongjiData() {
        int k = 0;
        GGrayData = new int[256];
        int grayData[] = new int[256];
        for (int i = 0; i < Blue.length; i++) {
            k = (int) (0.3 * Blue[i] + 0.59 * Green[i] + 0.11 * Red[i]);
            k = k > 255 ? 255 : k;
            //System.out.println(k);
            grayData[k]++;
        }
        GGrayData = grayData;
        return grayData;
    }

    public Image getmyimage(int[] data) {
        //Toolkit kit = Toolkit.getDefaultToolkit();
        //return  kit.createImage(new MemoryImageSource(nWidth, nHeight,
        // data, 0, nWidth));
        return createImage(new MemoryImageSource(nWidth, nHeight, data, 0, nWidth));
    }

    public void paint(Graphics g) {
        super.paint(g);
        g = this.getGraphics();
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, 900, 700);
        g.setColor(Color.BLUE);

        g.drawString("原始图像", 30, 50);
        g.drawImage(image, 20, 60, 300, 300, this);

        g.drawString("处理后图像", 30, 370);
        g.drawImage(img1, 20, 380, 300, 300, this);
        //**
        int x0, y0;
        x0 = 420;
        y0 = 650;

        //绘x轴
        g.drawLine(x0, y0, x0 + 550, y0);

        //绘y轴
        g.drawLine(x0, y0, x0, y0 - 600);
        g.drawString("灰度直方图", x0 + 250, y0 + 20);
        //绘灰度
        g.setColor(Color.RED);
        for (int i = 1; i < 256; i++) {
            g.drawLine(x0 + i * 2, y0, x0 + i * 2, y0 - GGrayData[i] / 50);
        }
        //*/
    }

    public Image getGrayImage(int gate) {
        int pix[] = new int[nWidth * nHeight];
        int index = 0;
        int k;
        for (int i = 0; i < nWidth * nHeight; i++) {
            k = (int) (0.3 * Blue[i] + 0.59 * Green[i] + 0.11 * Red[i]);
            k = k > 255 ? 255 : k;
            if (k > gate)
                pix[i] = (255 << 24) | (255 << 16) | (255 << 8) | 255;
            else
                pix[i] = (255 << 0) | (0 << 16) | (0 << 8) | 0;
        }
        return createImage(new MemoryImageSource(nWidth, nHeight, pix, 0, nWidth));
    }

    public static void main(String[] args) throws Exception {
        BMPRead bmpRead= new BMPRead();

    }
}

