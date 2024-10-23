package com.Tank;
import java.io.*;
import java.util.Vector;


/**
 * 该类用于记录相关信息
 */
public class Recorder {
    //定义变量记录用户击中的坦克数量
    private static int desAiTank=0;
    //定义IO对象,用于写数据到文件中
    private static BufferedWriter bw=null;
    private static BufferedReader br=null;
    //定义一个Vector 指向Panel里面的aiTanks
    private static Vector<AiTank> aiTanks=null;
    //定义一个保存Node的 Vector
    private static Vector<Node> nodes=new Vector<>();


    //文件名
    private static String recordFile= System.getProperty("user.dir")+"/myRecord.txt";

    //通过set方法来得到Panel里的aiTanks
    public static void setAiTanks(Vector<AiTank> aiTanks) {
        Recorder.aiTanks = aiTanks;
    }

    public static int getDesAiTank() {
        return desAiTank;
    }

    public static void setDesAiTank(int desAiTank) {
        Recorder.desAiTank = desAiTank;
    }

    /**
     * 当击毁一个坦克时就desAiTank++
     */
    public static void addDesAiTank(){
        Recorder.desAiTank++;
    }

    /**
     * 用于读取文件信息，恢复坦克位置
     * 在继续上局游戏时调用该方法
     */
    public static Vector<Node> getNodes(){
        File file=new File(recordFile);
        if(file.exists()&&file.length()!=0) { //先判断文件是否存在，且是否有内容
            try {
                br = new BufferedReader(new FileReader(recordFile));
                desAiTank = Integer.parseInt(br.readLine());
                //循环读取文件生成nodes集合
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] loction = line.split(" ");
                    Node node = new Node(Integer.parseInt(loction[0]),
                            Integer.parseInt(loction[1]), Integer.parseInt(loction[2]));
                    nodes.add(node);
                }
                return nodes;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }else{
            return null;
        }
    }

    /**
     *游戏退出时将desAiTank 保存到recordFile
     */
    public static void keepRecord() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(desAiTank + "\r\n"); //每写一个换行
            bw.flush(); //刷新缓冲区，不然写不进去数据
            //遍历人机坦克，根据情况保存
            for (int i = 0; i < aiTanks.size(); i++) {
                AiTank aiTank = aiTanks.get(i);
                if (aiTank.alive) {
                    String record = aiTank.getX() + " " + aiTank.getY() + " " + aiTank.getDirect();
                    bw.write(record + "\r\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void clean(){
        try {
            // 创建FileWriter对象
            FileWriter writer = new FileWriter(recordFile);

            // 将文件内容替换为空字符串
            writer.write("");

            // 刷新缓冲区和关闭文件
             writer.flush();
             writer.close();

            //System.out.println("文件中的信息已成功清空。");
        } catch (IOException e) {
            System.out.println("清空文件信息时发生错误：" + e.getMessage());
        }finally {

      }
    }


}
