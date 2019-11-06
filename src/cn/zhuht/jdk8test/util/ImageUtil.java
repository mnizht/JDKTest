package cn.zhuht.jdk8test.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 该类是图片处理类
 *
 * @author
 */
public final class ImageUtil {
  private ImageUtil() {
  }

  /**
   * 图片格式：JPG
   */
  private static final String PICTRUE_FORMATE_JPG = "jpg";

  /**
   * 生成组合头像
   *
   * @param paths 用户图像
   */
  public static boolean getCombinationOfhead(List<String> paths, String dir, String groupId)
    throws IOException {
    // 压缩图片所有的图片生成尺寸同意的 为 50x50
    List<BufferedImage> bufferedImages = paths.stream().map(x ->
      ImageUtil.resize2(x, 50, 50, true)).collect(Collectors.toList());
    int width = 112; // 这是画板的宽高
    int height = 112; // 这是画板的高度

    // BufferedImage.TYPE_INT_RGB可以自己定义可查看API

    BufferedImage outImage = new BufferedImage(width, height,
      BufferedImage.TYPE_INT_RGB);
    // 生成画布
    Graphics g = outImage.getGraphics();
    Graphics2D g2d = (Graphics2D) g;
    // 设置背景色
    g2d.setBackground(new Color(231, 231, 231));

    // 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
    g2d.clearRect(0, 0, width, height);

    System.out.println("开始拼凑");
    // 开始拼凑 根据图片的数量判断该生成那种样式的组合头像目前为4中
    int j = 1;
    for (int i = 1; i <= bufferedImages.size(); i++) {
      if (bufferedImages.size() == 9) {
        if (i <= 3) {
          g2d.drawImage(bufferedImages.get(i - 1), 30 * i + 3 * i
            - 31, 0, null);
        } else if (i <= 6) {
          g2d.drawImage(bufferedImages.get(i - 1), 27 * j + 5 * j
            - 30, 36, null);
          j++;
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 27 * j + 5 * j - 125, 77, null);
          j++;
        }
      } else if (bufferedImages.size() == 8) {
        if (i <= 3) {
          g2d.drawImage(bufferedImages.get(i - 1), 30 * i + 3 * i
            - 31, 0, null);
        } else if (i <= 6) {
          g2d.drawImage(bufferedImages.get(i - 1), 27 * j + 5 * j
            - 30, 36, null);
          j++;
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 21 * j + 9 * j - 100, 77, null);
          j++;
        }

      } else if (bufferedImages.size() == 7) {
        if (i <= 3) {
          g2d.drawImage(bufferedImages.get(i - 1), 30 * i + 3 * i
            - 31, 0, null);
        } else if (i <= 6) {
          g2d.drawImage(bufferedImages.get(i - 1), 27 * j + 5 * j
            - 30, 36, null);
          j++;
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 3, 75, null);
        }

      } else if (bufferedImages.size() == 6) {
        if (i <= 3) {
          g2d.drawImage(bufferedImages.get(i - 1), 30 * i + 3 * i
            - 31, 10, null);
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 31 * j + 4 * j
            - 33, 60, null);
          j++;
        }
      } else if (bufferedImages.size() == 5) {
        if (i <= 3) {
          g2d.drawImage(bufferedImages.get(i - 1), 30 * i + 3 * i
            - 28, 10, null);
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 48 * j + 8 * j
            - 49, 60, null);
          j++;
        }

      } else if (bufferedImages.size() == 4) {
        if (i <= 2) {
          g2d.drawImage(bufferedImages.get(i - 1), 50 * i + 4 * i
            - 50, 4, null);
        } else {
          g2d.drawImage(bufferedImages.get(i - 1), 50 * j + 4 * j
            - 50, 58, null);
          j++;
        }
      } else if (bufferedImages.size() == 3) {
        if (i <= 1) {

          g2d.drawImage(bufferedImages.get(i - 1), 31, 4, null);

        } else {

          g2d.drawImage(bufferedImages.get(i - 1), 50 * j + 4 * j
            - 50, 58, null);

          j++;
        }

      } else if (bufferedImages.size() == 2) {

        g2d.drawImage(bufferedImages.get(i - 1), 50 * i + 4 * i - 50,
          31, null);

      } else if (bufferedImages.size() == 1) {

        g2d.drawImage(bufferedImages.get(i - 1), 31, 31, null);

      }

    }

    StringBuilder outPath = new StringBuilder().append(dir)
      .append(File.separatorChar)
      .append("groupPicture")
      .append(File.separatorChar)
      .append(groupId.substring(0, 4))
      .append(File.separatorChar)
      .append(groupId).append(".jpg");
    System.out.println("输出图片:" + outPath.toString());
    String format = "JPG";
    File file = new File(outPath.toString());
    if (!file.exists()) {
      file.mkdirs();
    }

    return ImageIO.write(outImage, format, file);
  }

  /**
   * 图片缩放
   *
   * @param filePath 图片路径
   * @param height   高度
   * @param width    宽度
   * @param bb       比例不对时是否需要补白
   */
  public static BufferedImage resize2(String filePath, int height, int width,
                                      boolean bb) {
    System.out.println("图片缩放" + filePath);
    try {
      double ratio = 0; // 缩放比例
      BufferedImage bi = null;
      if (filePath.indexOf("http") == 0) {
        bi = ImageIO.read(new URL(filePath));
      } else {
        bi = ImageIO.read(new File(filePath));
      }
      Image itemp = bi.getScaledInstance(width, height,
        Image.SCALE_SMOOTH);
      // 计算比例
      if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
        if (bi.getHeight() > bi.getWidth()) {
          ratio = (new Integer(height)).doubleValue()
            / bi.getHeight();
        } else {
          ratio = (new Integer(width)).doubleValue() / bi.getWidth();
        }
        AffineTransformOp op = new AffineTransformOp(
          AffineTransform.getScaleInstance(ratio, ratio), null);
        itemp = op.filter(bi, null);
      }
      if (bb) {
        //需要补白时，先创建一个空白图片，再把原图画在空白图片上
        BufferedImage image = new BufferedImage(width, height,
          BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        if (width == itemp.getWidth(null))
          g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
            itemp.getWidth(null), itemp.getHeight(null),
            Color.white, null);
        else
          g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
            itemp.getWidth(null), itemp.getHeight(null),
            Color.white, null);
        g.dispose();
        itemp = image;
      }
      return (BufferedImage) itemp;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}